package impl

func IsMonotonic(A []int) bool {
	// 0 is decrease, 1 is increase
	sign := 0
	for i := 0; i < len(A)-1; i++ {
		if A[i+1] < A[i] {
			sign = 0
			break
		}
		if A[i+1] > A[i] {
			sign = 1
			break
		}
	}
	if sign == 0 {
		for i := 0; i < len(A)-1; i++ {
			if A[i+1] > A[i] {
				return false
			}
		}
	} else {
		for i := 0; i < len(A)-1; i++ {
			if A[i+1] < A[i] {
				return false
			}
		}
	}
	return true
}
