module FS (writeToFile, readFromFile) where

import System.IO


writeToFile:: String -> String -> IO()
writeToFile filePath fileContent = do
  file <- openFile filePath WriteMode
  hPutStrLn file fileContent
  hClose file

readFromFile:: String -> IO()
readFromFile filePath = do
  file <- openFile filePath ReadMode
  content <- hGetContents file
  putStr content
  hClose file
