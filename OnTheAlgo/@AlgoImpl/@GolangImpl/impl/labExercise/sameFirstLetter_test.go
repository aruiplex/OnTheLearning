package impl

import (
	"reflect"
	"testing"
)

func Test_sameFirstLetter(t *testing.T) {
	type args struct {
		arr []string
	}
	tests := []struct {
		name string
		args args
		want map[string]string
	}{
		{"测试1", args{[]string{"alice", "bob", "apple", "banana"}}, map[string]string{"a": "alice,apple", "b": "bob,banana"}},
		{"测试1", args{[]string{"after", "all", "this", "time", "always"}}, map[string]string{"a": "after,all,always", "t": "this,time"}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := sameFirstLetter(tt.args.arr); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("sameFirstLetter() = %v, want %v", got, tt.want)
			}
		})
	}
}
