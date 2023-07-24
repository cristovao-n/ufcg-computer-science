main:: IO()
main = do
  list <- getLine:: IO String
  let parsedList = read list :: [Int]
  if length parsedList == 0 then
    putStrLn "nenhum numero foi sorteado"
  else do
    let countList = getCountList parsedList
    let toStringList = stringify countList
    mapM_ putStrLn toStringList

getCountList:: [Int] -> [(Int, Int)]
getCountList [] = []
getCountList items = [(items !! 0, countOccurrencesOfFirstItem items)] ++ getCountList (removeCountedItem items)

countOccurrencesOfFirstItem:: [Int] -> Int
countOccurrencesOfFirstItem list = length(filter (\item -> item == list !! 0) list)

removeCountedItem:: [Int] -> [Int]
removeCountedItem list = filter(\item -> item /= list !! 0) list

stringify:: [(Int, Int)] -> [String]
stringify list = map (\(item, occurrence) -> (show item) ++ " foi sorteado " ++ (show occurrence) ++ " vez(es)")  list
