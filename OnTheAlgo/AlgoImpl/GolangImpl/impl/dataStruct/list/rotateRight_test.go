package impl

import (
	"reflect"
	"testing"
)

func Test_rotateRight(t *testing.T) {
	head0 := &ListNode{1, &ListNode{2, nil}}
	head1 := &ListNode{0, &ListNode{4, &ListNode{5, &ListNode{1, &ListNode{2, &ListNode{3, nil}}}}}}
	head3 := &ListNode{0, &ListNode{1, &ListNode{2, nil}}}
	head4 := &ListNode{2, &ListNode{1, &ListNode{0, nil}}}
	type args struct {
		head *ListNode
		k    int
	}
	tests := []struct {
		name string
		args args
		want *ListNode
	}{
		{"测试1", args{head0, 0}, head1},
		{"测试2", args{head3, 4}, head4},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := rotateRight(tt.args.head, tt.args.k); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("rotateRight() = %v, want %v", got, tt.want)
			}
		})
	}
}
