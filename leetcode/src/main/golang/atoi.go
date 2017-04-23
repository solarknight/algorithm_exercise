func myAtoi(str string) int {
    if len(str) == 0 {
        return 0
    }
    idx, flag, sum := 0, int64(1), int64(0)
    for ; str[idx] == ' '; idx++ {
    }

    if str[idx] == '-' {
        flag = -1
        idx++
    } else if str[idx] == '+' {
        idx++
    }

    for ; idx < len(str); idx++ {
        t := str[idx] - '0'
        if t < 0 || t > 9 {
            break
        }
        sum = sum * 10 + int64(t)
        if sum * flag > 0x7fffffff {
            return 0x7fffffff
        } else if sum * flag < -0x80000000 {
            return -0x80000000
        }
    }
    return (int) (sum * flag)
}