# @param {String} s
# @return {Integer}
def length_of_longest_substring(s)
    m = Hash.new
    bidx, max = 0, 0

    s.each_char.with_index do |char, idx|
        if (m[char] != nil) then
            max = (idx - bidx) > max ? (idx - bidx) : max
            bidx = (m[char] + 1) > bidx ? (m[char] + 1) : bidx
        end
        m[char] = idx
    end
    max = (s.length - bidx) > max ? (s.length - bidx) : max
    max
end
