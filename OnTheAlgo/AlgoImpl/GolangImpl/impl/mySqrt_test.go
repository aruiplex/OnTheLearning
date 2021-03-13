package impl

import "testing"

func TestMySqrt(t *testing.T) {
	type args struct {
		x int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"第四个", args{15}, 3},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := MySqrt(tt.args.x); got != tt.want {
				t.Errorf("MySqrt() = %v, want %v", got, tt.want)
			}
		})
	}
}
