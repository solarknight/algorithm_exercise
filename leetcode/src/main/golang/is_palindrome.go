func isPalindrome(x int) bool {
    if x < 0 {
        return false
    }
    if x >= 0 && x < 10 {
        return true
    }
    if x % 10 == 0 {
        return false
    }
    rev := 0
    for ; rev < x; x /= 10 {
        rev = rev * 10 + x % 10
    }
    return x == rev || x == rev / 10
}