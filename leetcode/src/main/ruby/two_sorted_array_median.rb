# @param {Integer[]} nums1
# @param {Integer[]} nums2
# @return {Float}
def find_median_sorted_arrays(nums1, nums2)
    len1, len2 = nums1.size, nums2.size
    return find_median_sorted_arrays(nums2, nums1) if len1 > len2
    return (nums2[(len2 - 1) / 2] + nums2[len2 / 2]) / 2.0 if len1 == 0

    l, r = 0, 2 * len1
    while l <= r do
        mid1 = (l + r) / 2
        mid2 = len1 + len2 - mid1

        lv1 = mid1 == 0 ? Float::MIN : nums1[(mid1 - 1) / 2]
        rv1 = mid1 == 2 * len1 ? Float::MAX : nums1[mid1 / 2]
        lv2 = mid2 == 0 ? Float::MIN : nums2[(mid2 - 1) / 2]
        rv2 = mid2 == 2 * len2 ? Float::MAX : nums2[mid2 / 2]

        if lv1 <= rv2 && lv2 <= rv1
            return ([lv1, lv2].max + [rv1, rv2].min) / 2.0
        elsif lv1 > rv2
            r = mid1 - 1
        else
            l = mid1 + 1
        end
        -1
    end

end