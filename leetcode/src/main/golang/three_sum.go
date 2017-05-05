import "sort"

func threeSum(nums []int) [][]int {
    res := make([][]int, 0)
    if len(nums) < 3 {
        return res
    }
    sort.Ints(nums)

    for i := 0; i < len(nums) - 2; i++ {
        if i != 0 && nums[i] == nums[i - 1] {
            continue;
        }
        tar, j, k := -nums[i], i + 1, len(nums) - 1
        for ; j < k; {
            if nums[j] + nums[k] == tar {
                res = append(res, []int{nums[i], nums[j], nums[k]})
                j, k = j + 1, k - 1;
                for ; j < k && nums[j] == nums[j - 1]; j++ {
                }
                for ; j < k && nums[k] == nums[k + 1]; k-- {
                }
            } else if nums[j] + nums[k] < tar {
                j++
            } else {
                k--
            }
        }
    }
    return res
}