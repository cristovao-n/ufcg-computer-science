exampleList = [1,2,3,4]

-- exampleList !! 1 = 2
getByIndex:: [t] -> Int -> t
getByIndex (h:t) 0 = h
getByIndex (h:t) index = getByIndex t (index-1)

-- head exampleList = 1
myHead:: [t] -> t
myHead (h:t) = h

-- tail exampleList = [2,3,4]
myTail:: [t] -> [t]
myTail (h: t) = t

-- last exampleList = 4
myLast:: [t] -> t
myLast (h: []) = h
myLast (h: t) = myLast t

-- length exampleList = 4
myLength:: [t] -> Int
myLength [] = 0
myLength (h: t) = 1 + myLength t

-- 4 `elem` exampleList = True
myElem:: Eq t => [t] -> t -> Bool
myElem [] t = False
myElem (h: t) element = if element == h then True
  else myElem t element

-- reverse exampleList = [4,3,2,1]
myReverse:: [t] -> [t]
myReverse [] = []
myReverse (h: t) = myReverse t ++ [h]

-- take 3 exampleList = [1,2,3]
myTake:: Int -> [t] -> [t]
myTake 0 l = []
myTake i (h:t) = [h] ++ myTake (i-1) t

-- drop 3 exampleList = [4]
myDrop:: Int -> [t] -> [t]
myDrop 0 l = l
myDrop i [] = []
myDrop i (h:t) = myDrop (i-1) t
