# @param {String} s
# @param {Integer} num_rows
# @return {String}
def convert(s, num_rows)
    return s if num_rows == 1

    len = s.length
    cycle = 2 * (num_rows - 1)

    sb = ''
    for i in 0...num_rows
        j = i
        while j < len
            sb << s[j]
            rj = cycle + j - 2 * i
            sb << s[rj] if (i != 0 && i != num_rows - 1 && rj < len)
            j += cycle
        end
    end
    sb
end