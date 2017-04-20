# @param {String} s
# @return {String}
def longest_palindrome(s)
    return s if s.length <= 1
    t = pre_process(s)

    idx, right, m_idx = 0, 0, 0
    p = Array.new(t.length, 0)

    for i in 1...t.length - 1
        p[i] = i < right ? [p[2 * idx - i] , right - i].min : 0
        p[i] += 1 while (t[i - p[i] - 1] == t[i + p[i] + 1])
        if (i + p[i] > right)
            idx = i
            right = i + p[i]
        end
        m_idx = i if p[i] >= p[m_idx]
    end

    start = (m_idx - p[m_idx] - 1) / 2
    s[start...start + p[m_idx]]
end

def pre_process(s)
    t = Array.new(s.length * 2 + 3)
    i = -1
    t.each_with_index do |_, idx|
        t[idx] =
            if idx == 0
                '^'
            elsif idx == t.length - 1
                '$'
            elsif idx % 2 == 1
                '#'
            else
                i += 1
                s[i]
            end
    end
end