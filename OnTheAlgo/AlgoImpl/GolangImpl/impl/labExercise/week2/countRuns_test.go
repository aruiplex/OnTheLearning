package impl

import "testing"

func Test_countRuns(t *testing.T) {
	type args struct {
		arr []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"测试1", args{[]int{1, 2, 2, 2, 3}}, 1},
		{"测试2", args{[]int{1, 1, 2, 3, 4, 5, 5}}, 2},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := countRuns(tt.args.arr); got != tt.want {
				t.Errorf("countRuns() = %v, want %v", got, tt.want)
			}
		})
	}
}
