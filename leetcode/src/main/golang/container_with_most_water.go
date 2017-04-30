func maxArea(height []int) int {
    max := 0
    for i, j := 0, len(height) - 1; i < j; {
        max = iMax(max, (j - i) * iMin(height[i], height[j]));
        if height[i] < height[j] {
            i++
        } else {
            j--
        }
    }
    return max
}

func iMax(a, b int) int {
    if a > b {
        return a
    } else {
        return b
    }
}

func iMin(a, b int) int {
    if a > b {
        return b
    } else {
        return a
    }
}