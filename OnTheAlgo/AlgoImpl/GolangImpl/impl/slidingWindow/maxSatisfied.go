package impl

/* MaxSatisfied
   不生气是 0

   我的思路是:
   1. 得到因为生气而丢失的顾客数组: lostCustomers
   2. 模拟每一次释放技能的收益 sum, 放到数组中 sumXlost
   3. 求出最大的一次收益 max
   4. 得到总丢失顾客数 = 不释放技能的丢失 - 通过技能赚回的顾客: sumLostCustomers -= max
   5. 得到总顾客数 sumCustcustomers
*/
func MaxSatisfied(customers []int, grumpy []int, X int) (int, int) {
	l := len(customers)
	// okCustomers := make([]int, l)
	lostCustomers := make([]int, l)
	sumXlost := make([]int, l-X+1)

	for i, v := range grumpy {
		if v == 1 {
			lostCustomers[i] = customers[i]
		}
	}
	// 把 X 格的滑窗的和按照index放入数组
	for i := 0; i < len(lostCustomers)-X+1; i++ {
		// 当前滑窗的和
		sum := 0
		for j := i; j < X+i; j++ {
			sum += lostCustomers[j]
		}
		sumXlost[i] = sum
	}
	// 使用技能
	index, max := getArrayMax(sumXlost)

	sumLostCustomers := 0
	for _, v := range lostCustomers {
		sumLostCustomers += v
	}
	sumLostCustomers -= max
	sumCustcustomers := 0
	for _, v := range customers {
		sumCustcustomers += v
	}
	return index, sumCustcustomers - sumLostCustomers
}

func getArrayMax(array []int) (int, int) {
	max := 0
	index := 0
	for i, v := range array {
		if max < v {
			max = v
			index = i
		}
	}
	return index, max
}

// 这是别的解
// 使用了正儿八经儿的滑窗
/*
滑窗内放的是丢失掉的客户
val: 没生气时的顾客.
max: 最大的滑窗 (因为生气一次性丢失掉最多的顾客).
cur: 当前滑窗内的值.
*/
func MaxSatisfiedSimple(customers []int, grumpy []int, X int) int {
	val, max, cur := 0, 0, 0
	for i := range customers {
		// 如果在第 i 位没生气
		if grumpy[i] == 0 {
			// 这一位的顾客就是有效值
			val += customers[i]
			customers[i] = 0
		}
		// 是否在第一个滑窗内, max
		if i < X {
			max += customers[i]
			cur += customers[i]
		} else {
			// 当前滑窗内的值
			cur += customers[i] - customers[i-X]
			if cur > max {
				max = cur
			}
		}
	}
	return val + max
}
