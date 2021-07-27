package impl

import "testing"

func Test_yaobaiArr(t *testing.T) {

	arr3 := []int{-1, 2, 1, 0, 1, 0}
	arr2 := []int{1, 2, 3, 2, 2, 1}
	arr0 := []int{1, 2, 3, 3, 4, 5}
	arr1 := []int{1, 2, 3, 2, 1}

	type args struct {
		arr []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"测试3", args{arr3}, 5},
		{"测试2", args{arr2}, 0},
		{"测试1", args{arr1}, 5},
		{"测试0", args{arr0}, 0},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := yaobaiArr(tt.args.arr); got != tt.want {
				t.Errorf("yaobaiArr() = %v, want %v", got, tt.want)
			}
		})
	}
}
