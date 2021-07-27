package impl

import "math"

/*

Num: the number of pi digits.

return: pi

todo: use bit operation

我是憨憨.
*/
func CalculatePi(Num int) int {

	pi_4 := 0
	for i := 0; i < Num; i++ {
		deno := 2*i - 1
		if i%2 == 0 {
			pi_4 += 1 / deno
		} else {
			pi_4 -= 1 / deno
		}
	}
	return pi_4 * 4
}

// pi launches n goroutines to compute an
// approximation of pi.
func pi(n int) float64 {
	ch := make(chan float64)
	for k := 0; k <= n; k++ {
		go term(ch, float64(k))
	}
	f := 0.0
	for k := 0; k <= n; k++ {
		f += <-ch
	}
	return f
}

func term(ch chan float64, k float64) {
	ch <- 4 * math.Pow(-1, k) / (2*k + 1)
}
