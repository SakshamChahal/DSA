
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    
    public static ListNode deserialize(String data) {
        data = data.replaceAll("\\[|\\]|\\s", "");
        if (data.isEmpty()) return null;

        String[] parts = data.split(",");
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        for (String part : parts) {
            current.next = new ListNode(Integer.parseInt(part));
            current = current.next;
        }

        return dummyHead.next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}

public class Main {
    public static void main(String[] args) {
       
        ListNode l1 = ListNode.deserialize("[2,4,3]");
        ListNode l2 = ListNode.deserialize("[5,6,4]");

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

       
        printList(result);  
    }

 
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }
}
