class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while(cur.next != null){
            int gcd = gcd(cur.val, cur.next.val);
            ListNode node = new ListNode(gcd);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }
        return head;
    }
    int gcd(int a, int b){
        if(b == 0)  return a;
        return gcd(b, a%b);
    }
}