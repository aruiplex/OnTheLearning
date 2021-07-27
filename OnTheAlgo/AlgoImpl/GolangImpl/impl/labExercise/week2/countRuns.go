package impl

func countRuns(arr []int) int {
	if len(arr) <= 1 {
		return 0
	}

	l, r := 0, 0
	m := map[int]interface{}{}
	var empty interface{}

	for i := 0; i < len(arr)-1; i++ {
		if i == 0 {
			l, r = arr[0], arr[1]
		}
		if l == r {
			m[l] = empty
		}
		l++
		r++
	}

	return len(m)
}
