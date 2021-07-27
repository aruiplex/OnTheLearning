package impl

import "testing"

func TestEvenAppend(t *testing.T) {
	type args struct {
		arr []string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{"测试1", args{[]string{"a", "b", "a"}}, "a"},
		{"测试2", args{[]string{"a", "b", "b", "a", "a"}}, "ba"},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := EvenAppend(tt.args.arr); got != tt.want {
				t.Errorf("EvenAppend() = %v, want %v", got, tt.want)
			}
		})
	}
}
