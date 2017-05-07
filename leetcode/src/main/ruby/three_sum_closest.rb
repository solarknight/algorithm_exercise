# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer}
def three_sum_closest(nums, target)
    return 0 if nums.length < 3
    nums.sort!
    sum, c_shift, m_shift = 0, 0, 0x7fffffff
    for i in 0...nums.length - 2
        j, k, tar = i + 1, nums.length - 1, target - nums[i]
        while j < k
            c_shift = nums[j] + nums[k] - tar
            abs = c_shift < 0 ? -c_shift : c_shift
            sum, m_shift = nums[i] + nums[j] + nums[k], abs if abs < m_shift
            if c_shift == 0
                return target
            elsif c_shift < 0
                j += 1
            else
                k -= 1
            end
        end
    end
    sum
end