# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def two_sum(nums, target)
    m = Hash.new
    nums.each_with_index { |val, index|
       if (m[target - val] != nil) then
            return [] << m[target -val] << index
       else
           m[val] = index
       end
    }
end