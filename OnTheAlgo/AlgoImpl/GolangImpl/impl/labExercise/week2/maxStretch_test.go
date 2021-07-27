package impl

import "testing"

func TestMaxStretch(t *testing.T) {
	type args struct {
		arr []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"测试1", args{[]int{8, 5, 1, 2, 3, 4, 5, 10}}, 6},
		{"测试2", args{[]int{2, 7, 1, 2, 3, 7}}, 5},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := MaxStretch(tt.args.arr); got != tt.want {
				t.Errorf("MaxStretch() = %v, want %v", got, tt.want)
			}
		})
	}
}
