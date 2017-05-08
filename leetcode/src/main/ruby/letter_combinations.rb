# @param {String} digits
# @return {String[]}
def letter_combinations(digits)
    res = []
    return res if digits.length == 0
    letters = [[" "], [""], ["a", "b", "c"], ["d", "e", "f"], ["g", "h", "i"], ["j", "k", "l"], ["m", "n", "o"], ["p", "q", "r", "s"], ["t", "u", "v"], ["w", "x", "y", "z"]]
    res << ""
    digits.each_char do |c|
       tmp = []
       letters[c.to_i].each do |l|
           res.each do |s|
               tmp << s + l
           end
       end
       res = tmp
    end
    res
end