package main

func isSubsequence(s string, t string) bool {
	if len(s) > len(t) {
		return false
	}
	i := 0
	j := 0
	n := len(s)
	m := len(t)
	for i < n {
		for j < m && t[j] != s[i] {
			j++
		}
		if j >= m {
			return false
		}
		i++
		j++
	}
	return true
}
