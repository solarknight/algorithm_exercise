func convert(s string, numRows int) string {
    if numRows <= 1 {
        return s
    }

    slen := len(s)
    cycle := 2 * (numRows - 1)

    sb := make([]byte, slen)
    idx := 0
    for i := 0; i < numRows; i++ {
        for j := i; j < slen; j += cycle {
            sb[idx] = s[j]
            idx++

            rj := cycle + j - 2 * i
            if i != 0 && i != numRows - 1 && rj < slen {
                sb[idx] = s[rj]
                idx++
            }
        }
    }

    return string(sb)
}
