func twoSum(nums []int, target int) []int {
    m := make(map[int]int)
    for idx, v := range nums {
        if i, ok := m[target - v]; ok {
            return []int{i, idx}
        } else {
            m[v] = idx
        }
    }
    return nil
}