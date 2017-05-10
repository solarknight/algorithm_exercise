# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[][]}
def four_sum(nums, target)
    res = Array.new(0) {Array.new(0, 0)}
    return res if nums.length < 4
    nums.sort!
    for i in 0...nums.length - 3
        next if i != 0 && nums[i] == nums[i - 1]
        for j in i + 1...nums.length - 2
            next if j != i + 1 && nums[j] == nums[j - 1]
            tar, k, l = target - nums[i] - nums[j], j + 1, nums.length - 1
            while k < l
                if nums[k] + nums[l] == tar
                    res.push([nums[i], nums[j], nums[k], nums[l]])
                    k, l = k + 1, l - 1
                    while k < l && nums[k] == nums[k - 1]
                        k += 1
                    end
                    while k < l && nums[l] == nums[l + 1]
                        l -= 1
                    end
                elsif nums[k] + nums[l] < tar
                    k += 1
                else
                    l -= 1
                end
            end
        end
    end
    res
end