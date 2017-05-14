# @param {String} s
# @return {Boolean}
def is_valid(s)
    return false if s.length & 1 == 1
    stack = []
    s.each_char { |c|
        if stack.length != 0 && stack[-1] == c
            stack = stack[0...-1]
            next
        end
        if c == '('
            stack << ')'
        elsif c == '['
            stack << ']'
        elsif c == '{'
            stack << '}'
        else
            return false
        end
    }
    return stack.length == 0
end