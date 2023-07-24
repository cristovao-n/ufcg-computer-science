-- run ghc --make hello-world to compile the code
-- run ./hello-world to run the program
main = do
  putStrLn "What's your name"
  name <- getLine
  putStrLn("Hello " ++ name)
