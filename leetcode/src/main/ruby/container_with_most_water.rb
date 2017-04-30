# @param {Integer[]} height
# @return {Integer}
def max_area(height)
    area, i, j = 0, 0, height.length - 1
    while i < j
        area = [area, (j - i) * [height[i], height[j]].min].max
        if height[i] < height[j]
            i += 1
        else
            j -= 1
        end
    end
    area
end