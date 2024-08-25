main:: IO()
main = do
  {-
    In a do block, you can parse the inpure type to a pure type using
    <- syntax. In this example the line read is IO Int and then it is
    stored as an Int in numberOfItems.

    Also, in a do block, 
    to store a standard pure returned value from a function or an attribution,
    you need to use let.
  -}
  numberOfItems <- readLn :: IO Int
  itemsList <- getItemsList numberOfItems
  let totalPrice = getTotalPrice itemsList
  print totalPrice


getItemsList:: Int -> IO [String]
{-
  This pattern matching can't be just
  getItemsList 0 = [] because it returns [String],
  mismatching the expected type of return
  which is IO [String].

  When you return something inside of a do block,
  if the function has an IO context, the type will be
  IO. For example if you return a String in a do block,
  the real return type will be IO String.
-}
getItemsList 0 = do return []
getItemsList numberOfItems = do
    {-
      I tried to use readLn function, but it expects quotes
      when you type strings in the prompt, so it failed all tests.
      The tests expected:
      pao
      sanduiche

      But readLn only works with
      "pao"
      "sanduiche"
    -}
    item <- getLine :: IO String
    remainingItems <- getItemsList (numberOfItems-1)
    {-
      The : syntax is used to build a list.
      The recursion will build
      "sanduiche" : "pao" : "suco"
      it is parsed to a list
      ["sanduiche", "pao", "suco"]
    -}
    return (item : remainingItems)


getTotalPrice:: [String] -> Int
getTotalPrice [] = 0
getTotalPrice (firstItem: remainingItems) = getPriceByItem firstItem + getTotalPrice remainingItems

getPriceByItem:: String -> Int
getPriceByItem "cafe" = 4
getPriceByItem "pao" = 2
getPriceByItem "suco" = 5
getPriceByItem "pao de queijo" = 5
getPriceByItem "sanduiche" = 3
getPriceByItem nonexistentItem = 0
