import "strings"

func longestCommonPrefix(strs []string) string {
    if len(strs) == 0 {
        return ""
    }
    tmp := strs[0]
    for i := 1; i < len(strs); i++ {
        for ; strings.Index(strs[i], tmp) != 0; {
            tmp = tmp[0:len(tmp) - 1]
        }
    }
    return tmp
}