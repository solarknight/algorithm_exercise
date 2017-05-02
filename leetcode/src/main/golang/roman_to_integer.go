func romanToInt(s string) int {
    if len(s) == 0 {
        return 0
    }
    sum, cur, last := 0, 0, 0
    for _, v := range s {
        cur = convert(v)
        if last < cur {
            sum += cur - 2 * last
        } else {
            sum += cur
        }
        last = cur
    }
    return sum
}

func convert(b rune) int {
    switch b {
      case 'I':
        return 1
      case 'V':
        return 5
      case 'X':
        return 10
      case 'L':
        return 50
      case 'C':
        return 100
      case 'D':
        return 500
      case 'M':
        return 1000
      default:
        return 0
    }
}