# @param {String[]} strs
# @return {String}
def longest_common_prefix(strs)
    return "" if strs.length == 0
    i, tmp = 1, strs[0]
    while i < strs.length
        tmp = tmp[0...-1] while strs[i].index(tmp) != 0
        i += 1
    end
    tmp
end