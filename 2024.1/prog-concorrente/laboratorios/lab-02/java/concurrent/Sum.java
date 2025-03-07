import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Semaphore;
import java.util.ArrayList;
import java.util.HashMap;

public class Sum {
    
    private static Integer total = 0;
    private static Semaphore mutex = new Semaphore(1);
    private static Semaphore multi;
    private static HashMap<Integer, ArrayList<String>> sums = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ArrayList<Thread> threads = new ArrayList<>();
        multi = new Semaphore((args.length) / 2);

        if (args.length < 1) {
            System.err.println("Usage: java Sum filepath1 filepath2 filepathN");
            System.exit(1);
        }

	    //many exceptions could be thrown here. we don't care
        for (String path : args) {
            Thread thread = new Thread(new FileSum(path), path);
            threads.add(thread);
            thread.start();
        }

        for(Thread t : threads) {
            t.join();
        }

        System.out.println("Total: " + total);
        for (Integer key : sums.keySet()) {
            if (sums.get(key).size() > 1) {
                System.out.println(key + " " + String.join(" ", sums.get(key)));
            }
        }
    }

    public static class FileSum implements Runnable {

        private final String path;
        
        public FileSum(String path) {
            this.path = path;
        }

        @Override
        public void run() {
            try {
                multi.acquire();
                sum();
                multi.release();
            } catch (Exception ex) {
            }
        }

        public void sum() throws IOException {
            Path filePath = Paths.get(path);
            if (Files.isRegularFile(filePath)) {
                FileInputStream fis = new FileInputStream(filePath.toString());
                try {
                    mutex.acquire();
                    int curSum = sum(fis);
                    total += curSum;
                    String[] fileName = filePath.toString().split("/");
                    if (sums.containsKey(curSum)) {
                        sums.get(curSum).add(fileName[fileName.length - 1]);
                    } else {
                        sums.put(curSum, new ArrayList<String>());
                        sums.get(curSum).add(fileName[fileName.length - 1]);
                    }
                    mutex.release();
                } catch(Exception e) {
                }
            } else {
                throw new RuntimeException("Non-regular file: " + path);
            }
        }

        public int sum(FileInputStream fis) throws IOException {
            int byteRead;
            int sum = 0;
            
            while ((byteRead = fis.read()) != -1) {
                sum += byteRead;
            }

            return sum;
        }

    }
}
