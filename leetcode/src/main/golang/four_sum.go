func fourSum(nums []int, target int) [][]int {
    res := make([][]int, 0)
    if len(nums) < 4 {
        return res
    }
    sort.Ints(nums)

    for i := 0; i < len(nums) - 3; i++ {
        if i != 0 && nums[i] == nums[i - 1] {
            continue;
        }
        for j := i + 1; j < len(nums) - 2; j++ {
            if j != i + 1 && nums[j] == nums[j - 1] {
                continue;
            }
            tar, k, l := target - nums[i] - nums[j], j + 1, len(nums) - 1
            for ; k < l; {
                if nums[k] + nums[l] == tar {
                    res = append(res, []int{nums[i], nums[j], nums[k], nums[l]})
                    k, l = k + 1, l - 1
                    for ; k < l && nums[k] == nums[k - 1]; {
                        k++
                    }
                    for ; k < l && nums[l] == nums[l + 1]; {
                        l--
                    }
                } else if nums[k] + nums[l] < tar {
                    k++
                } else {
                    l--
                }
            }
        }
    }
    return res
}