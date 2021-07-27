package impl

import "testing"

func Test_vote(t *testing.T) {
	type args struct {
		arr []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"测试1", args{[]int{1, 1, 1, 1, 5}}, 5},
		{"测试2", args{[]int{1, 2, 3, 4, 5}}, 5},
		{"测试3", args{[]int{1}}, 3},
		{"测试4", args{[]int{5, 5, 5, 5}}, 11},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := vote(tt.args.arr); got != tt.want {
				t.Errorf("vote() = %v, want %v", got, tt.want)
			}
		})
	}
}
