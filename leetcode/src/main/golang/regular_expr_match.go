func isMatch(s string, p string) bool {
    slen, plen := len(s), len(p)
    m := make([][]bool, slen + 1)
    for i := 0; i < slen + 1; i++ {
        m[i] = make([]bool, plen + 1)
    }
    m[0][0] = true
    for i := 1; i < plen; i++ {
        m[0][i + 1] = m[0][i - 1] && p[i] == '*'
    }

    for i := 0; i < slen; i++ {
        for j := 0; j < plen; j++ {
            if p[j] == s[i] || p[j] == '.' {
                m[i + 1][j + 1] = m[i][j]
            }
            if p[j] == '*' {
                if p[j - 1] == s[i] || p[j - 1] == '.' {
                    m[i + 1][j + 1] = m[i + 1][j - 1] || m[i + 1][j] || m[i][j + 1]
                } else {
                    m[i + 1][j + 1] = m[i + 1][j - 1]
                }
            }
        }
    }
    return m[slen][plen]
}
