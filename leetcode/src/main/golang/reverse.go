func reverse(x int) int {
    var r int64 = 0
    for lx := int64(x); lx != 0; lx /= 10 {
        r = 10 * r + lx % 10
    }

    if r > 0x7fffffff || r < -0x80000000 {
        return 0
    }
    return int(r)
}