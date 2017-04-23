# @param {Integer} x
# @return {Integer}
def reverse(x)
    r, flag = 0, 1
    x, flag = -x, -1 if x < 0
    r, x = (10 * r + x % 10), x / 10 while x != 0
    r > 0x7fffffff ? 0 : r * flag
end