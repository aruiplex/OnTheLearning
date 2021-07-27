package impl

// todo 这道题值得优化: 每次调用就把结果缓存下来
type NumArray struct {
	array []int
}

func ConstructorNumArray(nums []int) *NumArray {
	n := new(NumArray)
	n.array = nums
	return n
}

func (this *NumArray) SumRange(i int, j int) int {
	sum := 0
	for k := i; k <= j; k++ {
		sum += this.array[k]
	}
	return sum
}

/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.SumRange(i,j);
 */
