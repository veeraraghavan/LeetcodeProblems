package LinkedList;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Add2Numbers {
    public static void main(String[] args) {

        Add2Numbers me = new Add2Numbers();
        ListNode L1 = new ListNode(2);
        L1.next = new ListNode(4);
        L1.next.next = new ListNode(3);

        ListNode L2 = new ListNode(5);
        L2.next = new ListNode(6);
        L2.next.next = new ListNode(4);

        me.addTwoNumbers(L1, L2);

    }

    // Add with Carry
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode l1Curr = l1;
        ListNode l2Curr = l2;
        int carryOn = 0;
        int  sum = 0;
        ListNode result = new ListNode(0);
        ListNode rCurr = result;

        int l1Val = 0;
        int l2Val = 0;

        while ( l1Curr != null || l2Curr != null){

            if(l1Curr !=null)l1Val = l1Curr.val;
            if(l2Curr !=null)l2Val = l2Curr.val;

            sum = l1Val + l2Val + carryOn;
            rCurr.val = sum % 10 ;
            carryOn = sum / 10;

            if (l1Curr != null) l1Curr = l1Curr.next;
            if (l2Curr != null) l2Curr = l2Curr.next;

            if ((l1Curr != null || l2Curr != null)){
                rCurr.next = new ListNode(0);
                rCurr = rCurr.next;
            }

            sum = 0;l1Val=0;l2Val=0;
        }

        if (carryOn != 0)
            rCurr.next = new ListNode(carryOn);

        return result;

    }

    // Extract the number from LL and then ADD --> Does not work for long INTs
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        long l1Val = 0; long sum;
        String Str = "";
        ListNode curr = l1;
        while (curr !=null){
            Str = Integer.toString(curr.val) + Str;
            curr = curr.next;
        }
        l1Val = Long.parseLong(Str);
        Str = "";
        curr = l2;
        while (curr !=null){
            Str = Long.toString(curr.val) + Str;
            curr = curr.next;
        }
        sum = l1Val + Long.parseLong(Str);

        Str = Long.toString(sum);

        int index = Str.length() -1;

        ListNode result = new ListNode(Integer.parseInt(Str.substring(index, index+1)));
        index--;
        curr = result;
        while (index >= 0){
            curr.next = new ListNode(Integer.parseInt(Str.substring(index, index+1)));
            curr = curr.next;
            index--;
        }

        return  result;
    }

}
