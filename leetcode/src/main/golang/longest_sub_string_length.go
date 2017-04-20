func lengthOfLongestSubstring(s string) int {
    m := make(map[byte]int)
    pIdx, idx, max := 0, 0, 0

    for ; idx < len(s); idx++ {
        if v, ok := m[s[idx]]; ok {
            max = getMax(idx - pIdx, max)
            pIdx = getMax(v + 1, pIdx)
        }
        m[s[idx]] = idx
    }
    max = getMax(idx - pIdx, max)
    return max
}

func getMax(a, b int) int {
    if a < b {
        return b
    }
    return a
}