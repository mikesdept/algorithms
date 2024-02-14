package leetcode.easy;

public class MergeTwoSortedLists21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode node = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        node.next = list1 == null ? list2 : list1;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        MergeTwoSortedLists21 mergeTwoSortedLists21 = new MergeTwoSortedLists21();
        ListNode listMerge = mergeTwoSortedLists21.mergeTwoLists(list1, list2);
        while (listMerge != null) {
            System.out.println(listMerge.val);
            listMerge = listMerge.next;
        }
        // 1 1 2 3 4 4
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
