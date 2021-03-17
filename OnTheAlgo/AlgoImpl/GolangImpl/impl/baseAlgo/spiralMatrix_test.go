package impl

import (
	"reflect"
	"testing"
)

func Test_generateMatrix(t *testing.T) {
	type args struct {
		n int
	}
	tests := []struct {
		name string
		args args
		want [][]int
	}{
		{"测试1", args{3}, [][]int{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}},
		{"测试2", args{2}, [][]int{{1, 2}, {4, 3}}},
		// {"测试2", args{1}, [][]int{{1}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := generateMatrix(tt.args.n); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("generateMatrix() = %v, want %v", got, tt.want)
			}
		})
	}
}
