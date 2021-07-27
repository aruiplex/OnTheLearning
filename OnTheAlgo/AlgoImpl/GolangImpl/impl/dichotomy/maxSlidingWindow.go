package impl

func maxSlidingWindow(nums []int, k int) []int {
	if len(nums) == 0 {
		return []int{}
	}
	if len(nums) == 1 {
		return nums
	}
	queue := []int{}
	ans := []int{}
	for i := 0; i < len(nums); i++ {
		// 初始化, 刚开始 queue 里面没有东西
		if len(queue) == 0 {
			queue = append(queue, nums[i])
		} else {
			// 里面的元素太多了, 比滑窗大
			if len(queue) >= k { // todo 会出现一种情况: 里面的元素没有满, 并且被非最大元素替换掉很多轮了, 始终不能把最大元素挤下去
				queue = queue[1:]
			}
			// if i >= k && nums[i-k] == queue[0] {
			// 	//维护队列，保证其头元素为当前窗口最大值
			// 	queue = queue[1:]
			// }
			// 新元素比最开始的元素要大
			// if len(queue) == 0 || nums[i] > queue[0] {
			for i > 0 && (len(queue) > 0) && nums[i] > queue[len(queue)-1] {
				queue = queue[:len(queue)-1]
			}
			queue = append(queue, nums[i])
		}
		// 把 queue 第一个元素(最大的元素)放到 ans 里面
		index := i - k + 1
		if index >= 0 {
			ans = append(ans, queue[0])
		}
	}
	return ans
	// if len(nums) == 0 {
	// 	return []int{}
	// }
	// //用切片模拟一个双端队列
	// queue := []int{}
	// result := []int{}
	// for i := range nums {
	// 	for i > 0 && (len(queue) > 0) && nums[i] > queue[len(queue)-1] {
	// 		//将比当前元素小的元素祭天
	// 		queue = queue[:len(queue)-1]
	// 	}
	// 	//将当前元素放入queue中
	// 	queue = append(queue, nums[i])
	// 	if i >= k && nums[i-k] == queue[0] { // todo 如果窗口划过了这里 (超出了生命周期), 并且是 queue 的最大值, 就要被去掉
	// 		//维护队列，保证其头元素为当前窗口最大值
	// 		queue = queue[1:]
	// 	}
	// 	if i >= k-1 {
	// 		//放入结果数组
	// 		result = append(result, queue[0])
	// 	}
	// }
	// return result
}

// todo 在元素还没有满的时候, 最后加入的元素会比前面的一些元素大, 比第一个元素小
