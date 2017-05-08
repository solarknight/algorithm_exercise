func letterCombinations(digits string) []string {
    var res []string
    if len(digits) == 0 {
        return res
    }
    letters := [][]string{[]string{" "}, []string{""}, []string{"a", "b", "c"}, []string{"d", "e", "f"}, []string{"g", "h", "i"},
     []string{"j", "k", "l"}, []string{"m", "n", "o"}, []string{"p", "q", "r", "s"}, []string{"t", "u", "v"}, []string{"w", "x", "y", "z"}}
    res = append(res, "")
    for _, c := range digits {
        t := c - '0'
        var tmp []string
        for _, r := range letters[t] {
            for _, s := range res {
                tmp = append(tmp, s + r)
            }
        }
        res = tmp
    }
    return res
}