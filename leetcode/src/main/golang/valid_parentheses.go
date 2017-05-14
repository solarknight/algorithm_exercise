func isValid(s string) bool {
    if len(s) % 2 == 1 {
        return false
    }
    var stack []rune
    for _, c := range s {
        if len(stack) != 0 && stack[len(stack) - 1] == c {
            stack = stack[0:len(stack) - 1]
            continue
        }
        if c == '(' {
            stack = append(stack, ')')
        } else if c == '[' {
            stack = append(stack, ']')
        } else if c == '{' {
            stack = append(stack, '}')
        } else {
            return false
        }
    }
    return len(stack) == 0
}