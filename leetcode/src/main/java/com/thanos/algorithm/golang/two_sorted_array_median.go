import "math"

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
    if len(nums1) > len(nums2) {
        return findMedianSortedArrays(nums2, nums1)
    }

    len1, len2 := len(nums1), len(nums2)
    if len1 == 0 {
        return float64(nums2[(len2 - 1) / 2] + nums2[len2 / 2]) / 2
    }

    for l, r := 0, 2 * len1; l <= r; {
        mid1 := (l + r) / 2
        mid2 := len1 + len2 - mid1
        l1, r1 := cutArray(nums1, mid1)
        l2, r2 := cutArray(nums2, mid2)

        if l1 <= r2 && l2 <= r1 {
            return float64(ifOrFail(l1 > l2, l1, l2) + ifOrFail(r1 < r2, r1, r2)) / 2
        } else if l1 > r2 {
            r = mid1 - 1
        } else {
            l = mid1 + 1
        }
    }
    return -1
}

func cutArray(nums []int, cut int) (l, r int) {
    if cut == 0 {
        l = math.MinInt32
        r = nums[cut / 2]
    } else if cut == 2 * len(nums) {
        l = nums[(cut - 1) / 2]
        r = math.MaxInt32
    } else {
        l = nums[(cut - 1) / 2]
        r = nums[cut / 2]
    }
    return
}

func ifOrFail(cond bool, val1 int, val2 int) int {
    if cond {
        return val1
    } else {
        return val2
    }
}