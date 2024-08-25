toBinary:: Int -> String
toBinary 0 = ""
toBinary x = toBinary (div x 2) ++ show (mod x 2)
