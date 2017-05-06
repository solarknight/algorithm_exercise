# @param {Integer[]} nums
# @return {Integer[][]}
def three_sum(nums)
    res = Array.new(0) {Array.new(0, 0)}
    return res if nums.length < 3
    nums.sort!
    for i in 0...nums.length - 2
        next if i != 0 && nums[i] == nums[i - 1]
        tar, j, k = -nums[i], i + 1, nums.length - 1
        while j < k
            if nums[j] + nums[k] == tar
                res.push([nums[i], nums[j], nums[k]])
                j, k = j + 1, k - 1
                while j < k && nums[j] == nums[j - 1]
                    j += 1
                end
                while j < k && nums[k] == nums[k + 1]
                    k -= 1
                end
            elsif nums[j] + nums[k] < tar
                j += 1
            else
                k -= 1
            end
        end
    end
    res
end