package com.practice.scribble;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}

public class CopyRandomList {
    public static void main(String[] args) {
        CopyRandomList me = new CopyRandomList();

    }

    HashMap<Node, Node> map = new HashMap();

    public Node copyRandomList(Node head) {
//         //[[7,null],[13,0],[11,4],[10,2],[1,0]]
// //         Node result = new Node(7);
// //         result.random=null;
// //         result.next=new Node(13);
// //         result.next.random = result;
// //         result.next.next = new Node(11);

// //         result.next.next.next = new Node(10);
// //         result.next.next.next.random = result.next.next;
// //         result.next.next.next.next = new Node(1);
// //         result.next.next.next.next.random = result;
// //         result.next.next.random = result.next.next.next.next;
//         Node result=null;
//         Node temp=result;
//         Node tempInp=head;
//         boolean first=true;
//         HashMap<Integer,Node> map = new HashMap();
//         while(tempInp!=null){
//             if(result==null){
//                 result = new Node(tempInp.val);
//                 map.put(tempInp.val,result);
//                 temp=result;
//             }else{
//                 temp.next=new Node(tempInp.val);
//                 map.put(tempInp.val,temp.next);
//                 temp = temp.next;
//             }
//             tempInp = tempInp.next;
//         }

//         tempInp = head;
//         temp = result;
//         while(tempInp!=null){
//             if(tempInp.random!=null){
//                 temp.random = map.get(tempInp.random.val);
//             }else{
//                 temp.random = null;
//             }
//             tempInp = tempInp.next;
//             temp = temp.next;
//         }

//         return result;

        if (head == null)
            return null;

        if (this.map.containsKey(head))
            return this.map.get(head);


        Node node = new Node(head.val, null, null);
        this.map.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;

    }
}
