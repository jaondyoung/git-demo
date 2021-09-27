package cn.ly.problem;

/**
 * 删除链表的倒数第n个节点
 * 限定语言：Kotlin、Typescript、Python、C++、Groovy、Rust、Java、Go、Scala、Javascript、Ruby、Swift、Php、Python 3
 * 给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
 * 例如，
 * 给出的链表为:1->2->3->4->5 ,n=2 .
 * 删除了链表的倒数第 n 个节点之后,链表变为.1->2-3->5
 *
 * 数据范围： 链表长度 ，链表中任意节点的值满足
 * 要求：空间复杂度 ，时间复杂度
 * 备注：
 * 题目保证  n一定是有效的
 */

/**
 * 合并几个有序列表
 * A:1->2->3->5
 * B:2->3->4->6->9
 * C:4->5->6->7->8
 * 结果：1->2->2->3->3->4->4->5->5->6->6->7->8->9
 */
public class Test8Demo {

    public static void main(String[] args) {
        //System.out.println(5-2+1);
        /*ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        System.out.println(delN(listNode1,2));*/

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        //A:1->2->3->5
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        System.out.println(a1);

        //B:2->3->4->6->9
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        ListNode b4 = new ListNode(6);
        ListNode b5 = new ListNode(9);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        System.out.println(b1);

        //ListNode tempab = mergeTwo(a1, b1);
        //1->2->2->3->3->4->5->6->9
        //C:4->5->6->7->8
        ListNode c1 = new ListNode(4);
        ListNode c2 = new ListNode(5);
        ListNode c3 = new ListNode(6);
        ListNode c4 = new ListNode(7);
        ListNode c5 = new ListNode(8);
        c1.next = c2;
        c2.next = c3;
        c3.next = c4;
        c4.next = c5;

        //System.out.println(mergeTwo(tempab, c1));
        System.out.println(mergeMuch(a1,b1,c1));
        //1->2->2->3->3->4->4->5->5->6->6->7->8->9

    }

    public static ListNode delN(ListNode head,int n){
        ListNode cur = head;
        int count = 0;
        while(cur !=null){
            count++;
            cur = cur.next;
        }

        cur = head;
        int seln = count - n +1; // 计算正向第N个
        count = 0;
        ListNode prev = null;
        while(cur !=null){
            count++;
            if(seln == count){
                prev.next = prev.next.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        return head;
    }

    public static ListNode mergeMuch(ListNode... heads){
        if(heads == null || heads.length <= 1){
            return heads == null?null:heads[0];
        }

        ListNode temp = heads[0];
        for (int i=1;i<heads.length;i++){
            temp = mergeTwo(temp,heads[i]);
        }

        return temp;
    }

    public static ListNode mergeTwo(ListNode head1,ListNode head2){
        if(head1 == null || head2 == null){
            return head1 != null?head1:head2;
        }

        ListNode head = head1.val < head2.val?head1:head2;

        ListNode cur1 = head == head1?head1:head2;
        ListNode cur2 = head == head1?head2:head1;

        ListNode prev = null;
        ListNode next = null;
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                prev = cur1;
                cur1 = cur1.next;
            }else{
                prev.next = cur2;
                prev = prev.next;
                next = cur2;
                cur2 = cur1;
                cur1 = next;
                cur1 = cur1.next;
            }
        }

        prev.next = cur1 ==null?cur2:cur1;

        return head;
    }


}

class ListNode{
    int val;
    ListNode next = null;
    public ListNode(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        String s = "";
        ListNode cur = this;
        s += cur.val;
        while(cur.next !=null){
            cur = cur.next;
            s += "->" + cur.val;
        }
        return s;
    }
}
