-- Two Lists symmetric difference
main = do
    let s1 = [1..100]
    let s2 = [1..102]
    let d = diff s1 s2
    putStrLn $ show d

diff :: (Num a, Eq a) => [a] -> [a] -> [a]
diff f1 f2
  | length f1 > length f2 = foldl (\acc y -> if (y `elem` f2) then acc else acc ++ [y]) [] f1
  | otherwise = foldl (\acc y -> if (y `elem` f1) then acc else acc ++ [y]) [] f2
