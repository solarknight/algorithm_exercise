# @param {String} s
# @param {String} p
# @return {Boolean}
def is_match(s, p)
    slen, plen = s.length, p.length
    m = Array.new(slen + 1) {Array.new(plen + 1, false)}
    m[0][0] = true
    for i in 1...plen
        m[0][i + 1] = m[0][i - 1] && p[i] == '*'
    end

    for i in 0...slen
        for j in 0...plen
            m[i + 1][j + 1] = m[i][j] if p[j] == s[i] || p[j] == '.'
            if p[j] == '*'
               if p[j - 1] == s[i] || p[j - 1] == '.'
                   m[i + 1][j + 1] = m[i + 1][j - 1] || m[i + 1][j] || m[i][j + 1]
               elsif
                   m[i + 1][j + 1] = m[i + 1][j - 1]
               end
            end
        end
    end
    m[slen][plen]
end