package impl

import (
	"reflect"
	"testing"
)

func Test_reverseBetween(t *testing.T) {
	type args struct {
		head  *ListNode
		left  int
		right int
	}
	l1 := &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, &ListNode{5, nil}}}}}
	l2 := &ListNode{1, &ListNode{4, &ListNode{3, &ListNode{2, &ListNode{5, nil}}}}}
	tests := []struct {
		name string
		args args
		want *ListNode
	}{
		{"测试1", args{l1, 2, 4}, l2},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := reverseBetween(tt.args.head, tt.args.left, tt.args.right); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("reverseBetween() = %v, want %v", got, tt.want)
			}
		})
	}
}
