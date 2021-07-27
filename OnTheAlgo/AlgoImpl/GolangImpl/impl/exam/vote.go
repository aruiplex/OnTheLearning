package impl

import "sort"

/*
阿里笔试第一题
*/
func vote(arr []int) int {
	// 参与投票的人数
	nums := len(arr)
	sort.Ints(arr)
	// 投给小明的最多票数
	max := arr[nums-1]
	// 小明得到的票
	sumMing := 0
	// 每个人有多少票
	k := max
	// 投给小明的票数
	for i := 0; i < nums; i++ {
		sumMing += arr[i]
	}
	meVotes := k*nums - sumMing

	for meVotes <= sumMing {
		k++
		// 投给我的票数
		meVotes = k*nums - sumMing
	}

	return k
}
