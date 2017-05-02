# @param {String} s
# @return {Integer}
def roman_to_int(s)
    return 0 if s.length == 0
    sum, cur, last = 0, 0, 0
    s.each_char { |c|
        cur = convert(c)
        sum += last >= cur ? cur : cur - 2 * last
        last = cur
    }
    sum
end

def convert(c)
   case c
   when 'I'
       1
   when 'V'
       5
   when 'X'
       10
   when 'L'
       50
   when 'C'
       100
   when 'D'
       500
   when 'M'
       1000
   else
       0
   end
end