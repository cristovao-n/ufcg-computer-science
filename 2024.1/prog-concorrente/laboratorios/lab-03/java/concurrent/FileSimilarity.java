import java.io.*;
import java.util.*;

public class FileSimilarity {

    // Create a map to store the fingerprint for each file
    private static Map<String, List<Long>> fileFingerprints = new HashMap<>();

    public static class Similarity implements Runnable {

        private String file1;
        private String file2;

        public Similarity(String file1, String file2) {
            this.file1 = file1;
            this.file2 = file2;
        }

        @Override
        public void run() {
            try {
                List<Long> fingerprint1 = fileFingerprints.get(file1);
                List<Long> fingerprint2 = fileFingerprints.get(file2);
                float similarityScore = similarity(fingerprint1, fingerprint2);
                System.out.println("Similarity between " + file1 + " and " + file2 + ": " + (similarityScore * 100) + "%");
            } catch(Exception ex) {}

        }
    }


    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.err.println("Usage: java Sum filepath1 filepath2 filepathN");
            System.exit(1);
        }

        // Calculate the fingerprint for each file
        for (String path : args) {
            List<Long> fingerprint = fileSum(path);
            fileFingerprints.put(path, fingerprint);
        }

        System.out.println(System.currentTimeMillis());

        // Compare each pair of files
        for (int i = 0; i < args.length; i++) {
            String file1 = args[i];
            for (int j = i + 1; j < args.length; j++) {
                String file2 = args[j];
                Thread t = new Thread(new Similarity(file1, file2), file1 + file2);
                t.start();
            }
        }

        System.out.println(System.currentTimeMillis());
    }

    private static List<Long> fileSum(String filePath) throws IOException {
        File file = new File(filePath);
        List<Long> chunks = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[100];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                long sum = sum(buffer, bytesRead);
                chunks.add(sum);
            }
        }
        return chunks;
    }

    private static long sum(byte[] buffer, int length) {
        long sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Byte.toUnsignedInt(buffer[i]);
        }
        return sum;
    }

    private static float similarity(List<Long> base, List<Long> target) {
        int counter = 0;
        List<Long> targetCopy = new ArrayList<>(target);

        for (Long value : base) {
            if (targetCopy.contains(value)) {
                counter++;
                targetCopy.remove(value);
            }
        }

        return (float) counter / base.size();
    }
}
