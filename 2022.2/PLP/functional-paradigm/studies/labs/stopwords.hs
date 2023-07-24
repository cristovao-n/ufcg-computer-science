main:: IO()
main = do
  sentence <- getLine :: IO String
  let sentenceWithoutStopWords = removeStopWords sentence
  putStrLn sentenceWithoutStopWords

removeStopWords:: String -> String
removeStopWords sentence = unwords (filter (\word -> length word > 3) (words sentence))
