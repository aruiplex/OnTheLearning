package impl

import (
	"reflect"
	"testing"
)

func Test_matchSwap(t *testing.T) {
	type args struct {
		arr []string
	}
	tests := []struct {
		name string
		args args
		want []string
	}{
		{"测试1", args{[]string{"apple", "avocado"}}, []string{"avocado", "apple"}},
		{"测试2", args{[]string{"ab", "ac", "ad", "ae", "af"}}, []string{"ac", "ab", "ae", "ad", "af"}},
		{"测试3", args{[]string{"ap", "bp", "cp", "aq", "cq", "bq"}}, []string{"aq", "bq", "cq", "ap", "cp", "bp"}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := matchSwap(tt.args.arr); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("matchSwap() = %v, want %v", got, tt.want)
			}
		})
	}
}
