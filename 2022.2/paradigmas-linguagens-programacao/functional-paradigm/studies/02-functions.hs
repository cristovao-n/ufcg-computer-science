import Helpers

-- type declaration of the function
-- since haskell has type inference, it's not required to create the type declaration, but it's a good practice.
add:: Int -> Int -> Int
add x y = x + y

isOdd:: Int -> Bool
isOdd x = not (x `mod` 2 == 0)

addTuples:: (Int, Int) -> (Int, Int) -> (Int, Int)
addTuples (x1, y1) (x2, y2) = (x1 + x2, y1 + y2)

whatAge:: Int -> String
whatAge 16 = "You can drive"
whatAge 18 = "You can vote"
whatAge 21 = "You're an adult"
whatAge _ = "Nothing important"

-- Recursive functions
factorial:: Int -> Int
factorial 0 = 1
factorial n = n * factorial(n - 1)

-- Guards

concept :: Float -> Char
concept n
  | n >= 9 = 'A'
  | n >= 7.5 = 'B'
  | n >= 6 = 'C'
  | n >= 4 = 'D'
  | otherwise = 'E'

-- Guards with where statement

getRoots:: Float -> Float -> Float -> [Float]
getRoots a b c
  | delta < 0 = []
  | delta == 0 = [-b/2*a]
  | otherwise = [(-b + sqrt delta )/2*a, (-b - sqrt delta)/2*a]
  where delta = b*b - 4*a*c

-- Map
times4:: Int -> Int
times4 x = x*4

listTimes4 = map times4 [1,2,3,4,5]

-- Implementing the map
-- Remember this syntax: primeNumbers2 = 3 : 5 : 7 : 11 :[]
multBy4:: [Int] -> [Int]
multBy4 [] = []
multBy4 (x:xs) = times4 x : multBy4 xs

stringEquals:: [Char] -> [Char] -> Bool
stringEquals [] [] = True
stringEquals _ _ = False
stringEquals (x:xs) (y:ys) = x == y && stringEquals xs ys


-- Passing a function to a function (functions are first-class values)
mult3By4:: (Int -> Int) -> Int
mult3By4 callback = callback 3
result = mult3By4 times4

