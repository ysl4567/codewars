module Codewars.Kata.RPG where

playerRankUp :: Integer => [Char]
playerRankUp points | points>=100 = "Well done! You have advanced to the qualifying stage. Win 2 out of your next 3 games to rank up."
                    | otherwise = "False"
