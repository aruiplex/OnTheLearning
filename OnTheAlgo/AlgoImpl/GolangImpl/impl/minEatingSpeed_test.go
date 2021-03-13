package impl

import "testing"

func TestMinEatingSpeed(t *testing.T) {
	type args struct {
		piles []int
		h     int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"测试1", args{[]int{3, 6, 7, 11}, 8}, 4},
		// {name: "测试2", want: 30, args: args{[]int{30, 11, 23, 4, 20}, 8}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := MinEatingSpeed(tt.args.piles, tt.args.h); got != tt.want {
				t.Errorf("MinEatingSpeed() = %v, want %v", got, tt.want)
			}
		})
	}
}
