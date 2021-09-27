package cn.ly.problem;

/**把三个有序的单链表合成一个
 * // a:1->2->4->6->9
 *         // b:2->3->5->8
 *         // c :2->4->7->9
 *         // 1->2->2->2......
 */
public class ListMergeDemo {
    public static void main(String[] args) {

    }

    public static Node mergeTwo(Node a,Node b){
        if(a == null || b ==null){
            return a != null ?a:b;
        }

        Node head = a.val < b.val?a:b;

        Node cur1 = head == a?a:b;
        Node cur2 = head == a?b:a;

        Node pre =null;// cur1的前一个元素
        Node next = null;// cur2的后一个元素

        while(cur1 !=null && cur2 != null){

            // 第一次肯定走这里
            if(cur1.val <= cur2.val){
                pre = cur1;
                cur1 = cur1.next;
            }else{
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;

            }

        }

        pre.next = cur1 ==null?cur2:cur1;
        return a;
    }

    public static Node mergeThree(Node a,Node b,Node c){
        Node node = mergeTwo(a, b);
        Node node1 = mergeTwo(node, c);
        return node1;
    }
}


class Node{
    int val;
    Node next;
}