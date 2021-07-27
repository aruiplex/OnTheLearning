package impl

import (
	"reflect"
	"testing"
)

func Test_deleteDuplicates(t *testing.T) {
	head0 := &ListNode{0, &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, &ListNode{5, &ListNode{6, nil}}}}}}}
	head2 := &ListNode{0, &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, &ListNode{5, &ListNode{6, nil}}}}}}}
	head1 := &ListNode{0, &ListNode{1, &ListNode{1, &ListNode{3, &ListNode{3, &ListNode{5, &ListNode{6, nil}}}}}}}
	head3 := &ListNode{0, &ListNode{1, &ListNode{3, &ListNode{5, &ListNode{6, nil}}}}}

	type args struct {
		head *ListNode
	}
	tests := []struct {
		name string
		args args
		want *ListNode
	}{
		{"测试1", args{head0}, head2},
		{"测试2", args{head1}, head3},
		{"测试3", args{&ListNode{1, &ListNode{1, &ListNode{2, nil}}}}, &ListNode{1, &ListNode{2, nil}}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := deleteDuplicates(tt.args.head); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("deleteDuplicates() = %v, want %v", got, tt.want)
			}
		})
	}
}
