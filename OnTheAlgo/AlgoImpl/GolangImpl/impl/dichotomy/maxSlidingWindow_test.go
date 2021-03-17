package impl

import (
	"reflect"
	"testing"
)

func Test_maxSlidingWindow(t *testing.T) {
	type args struct {
		nums []int
		k    int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		// {name: "测试1", args: args{[]int{7, 2, 4}, 2}, want: []int{7, 4}},
		// {name: "测试2", args: args{[]int{1}, 1}, want: []int{1}},
		// {name: "测试3", args: args{[]int{9, 11}, 2}, want: []int{11}},
		// {name: "测试4", args: args{[]int{4, -2}, 2}, want: []int{4}},
		// {name: "测试5", args: args{[]int{1, 3, -1, -3, 5, 3, 6, 7}, 3}, want: []int{3, 3, 5, 5, 6, 7}},
		// {name: "测试6", args: args{[]int{1, -1}, 1}, want: []int{1, -1}},
		{name: "测试7", args: args{[]int{1, 3, 1, 2, 0, 5}, 3}, want: []int{3, 3, 2, 5}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := maxSlidingWindow(tt.args.nums, tt.args.k); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("maxSlidingWindow() = %v, want %v", got, tt.want)
			}
		})
	}
}
