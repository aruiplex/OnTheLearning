package impl

import "testing"

func Test_partitionable(t *testing.T) {
	type args struct {
		arr []int
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{"测试1", args{[]int{1, 1, 1, 2, 1}}, true},
		{"测试2", args{[]int{2, 1, 1, 2, 1}}, false},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := partitionable(tt.args.arr); got != tt.want {
				t.Errorf("partitionable() = %v, want %v", got, tt.want)
			}
		})
	}
}
