import "sort"

func threeSumClosest(nums []int, target int) int {
    if len(nums) < 3 {
        return 0
    }
    sort.Ints(nums)
    sum, curShift, minShift := 0, 0, 0x7fffffff
    for i := 0; i < len(nums) - 2; i++ {
        j, k, tar := i + 1, len(nums) - 1, target - nums[i]
        for ; j < k; {
            curShift = nums[j] + nums[k] - tar
            abs := curShift
            if abs < 0 {
                abs = -abs
            }
            if abs < minShift {
                minShift, sum = abs, nums[i] + nums[j] + nums[k]
            }
            if curShift == 0 {
                return target
            } else if curShift < 0 {
                j++
            } else {
                k--
            }
        }
    }
    return sum
}