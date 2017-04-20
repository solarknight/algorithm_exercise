func longestPalindrome(s string) string {
	if len(s) <= 1 {
		return s
	}

	t := preProcess(s)
	p := make([]int, len(t))
	idx, right, mIdx := 0, 0, 0

	for i := 1; i < len(t) - 1; i++ {
		p[i] = 0
		if i < right {
			p[i] = min(p[2 * idx - i], right - i)
		}
		for ; t[i + p[i] + 1] == t[i - p[i] -1]; {
			p[i]++
		}
		if (i + p[i]) > right {
			idx = i
			right = i + p[i]
		}
		if p[i] > p[mIdx] {
			mIdx = i
		}
	}

	start := (mIdx - p[mIdx] - 1) / 2
	return s[start:start + p[mIdx]]
}

func preProcess(s string) string {
	t := make([]byte, len(s) * 2 + 3)
	t[0] = '^'
	t[len(t) - 1] = '$'

	for i, j := 1, 0; i < len(t) - 1; i++ {
		t[i] = '#'
		if (i % 2 == 0) {
			t[i] = s[j]
			j++
		}
	}
	return string(t)
}

func min(n1, n2 int) int {
	if n1 > n2 {
		return n2
	} else {
	  	return n1
	}
}