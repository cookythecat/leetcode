package addTwoNumber; 	


class Solution {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int more = 0;
        ListNode headNew = new ListNode(0);
        ListNode currentNew = headNew;
        ListNode current1 = l1;
        ListNode current2 = l2;
        while(true){
            if(current1 == null && current2 == null){
                break;
            }else{                    
                    currentNew.next = new ListNode(0);
                    currentNew = currentNew.next;
                if(current1 == null){
                	int val2 = current2.val;
                    int valNew = (val2 + more) % 10;
                    if(val2 + more >= 10)   more = (val2 + more)/10;
                    else    more = 0;
                    currentNew.val = valNew;
                    current2 = current2.next;
                }else if(current2 == null){
                	int val1 = current1.val;
                    int valNew = (val1 + more) % 10;
                    if(val1 + more>= 10)   more = (val1 + more)/10;
                    else    more = 0;
                    currentNew.val = valNew;
                    current1 = current1.next;
                }else{
                    int val1 = current1.val;
                    int val2 = current2.val;
                    int valNew = (val1 + val2 + more) % 10;
                    if(val1 + val2 + more>= 10)   more = (val1 + val2 + more)/10;
                    else    more = 0;
                    currentNew.val = valNew;
                    current1 = current1.next;
                    current2 = current2.next;
                }
            }
        }
        if(more != 0) {
        	currentNew.next = new ListNode(more);
        }
        if(headNew != null) {
        	headNew = headNew.next;
        }
        return headNew;
    }
}