# @param {String} str
# @return {Integer}
def my_atoi(str)
    return 0 if str.length == 0
    idx, flag, sum = 0, 1, 0
    while str[idx] == ' '
        idx += 1
    end

    if str[idx] == '-'
        flag, idx = -1, idx + 1
    elsif str[idx] == '+'
        idx += 1
    end

    str[idx..-1].each_char do |char|
        case char
        when '0'; sum = sum * 10 + 0
        when '1'; sum = sum * 10 + 1
        when '2'; sum = sum * 10 + 2
        when '3'; sum = sum * 10 + 3
        when '4'; sum = sum * 10 + 4
        when '5'; sum = sum * 10 + 5
        when '6'; sum = sum * 10 + 6
        when '7'; sum = sum * 10 + 7
        when '8'; sum = sum * 10 + 8
        when '9'; sum = sum * 10 + 9
        else    ; break
        end
        return flag == 1 ? 0x7fffffff : -0x80000000 if sum > 0x7fffffff
    end
    sum * flag
end