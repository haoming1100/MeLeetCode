package com.hm;

/**
 * @author Administrator
 * 问题描述:
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 */
public class AddOfTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode1Item = new ListNode(4);
        ListNode listNode1Item1 = new ListNode(3);
        listNode1Item.setNext(listNode1Item1);

        listNode1.setNext(listNode1Item);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode2Item = new ListNode(6);
        ListNode listNode2Item1 = new ListNode(4);
        listNode2Item.setNext(listNode2Item1);
        listNode2.setNext(listNode2Item);

        getSum(listNode1, listNode2);

    }

    /**
     * 官方示例
     *
     * 就像你在纸上计算两个数字的和那样，我们首先从最低有效位也就是列表 l1l1 和 l2l2 的表头开始相加。由于每位数字都应当处于 0 …9 的
     * 范围内，我们计算两个数字的和时可能会出现“溢出”。例如，5 + 7 = 125+7=12。在这种情况下，我们会将当前位的数值设置为 22，并将进位
     * carry = 1carry=1 带入下一次迭代。进位 carrycarry 必定是 00 或 11，这是因为两个数字相加（考虑到进位）可能出现的最大和为
     * 9 + 9 + 1 = 19。
     *
     * 伪代码如下：
     *
     * 将当前结点初始化为返回列表的哑结点。
     * 将进位 carrycarry 初始化为 00。
     * 将 pp 和 qq 分别初始化为列表 l1l1 和 l2l2 的头部。
     * 遍历列表 l1l1 和 l2l2 直至到达它们的尾端。
     * 将 xx 设为结点 pp 的值。如果 pp 已经到达 l1l1 的末尾，则将其值设置为 00。
     * 将 yy 设为结点 qq 的值。如果 qq 已经到达 l2l2 的末尾，则将其值设置为 00。
     * 设定 sum = x + y + carry
     * 更新进位的值，carry = sum / 10
     * 创建一个数值为 (sum mod 10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
     * 同时，将 pp 和 qq 前进到下一个结点。
     * 检查 carry = 1 是否成立，如果成立，则向返回列表追加一个含有数字 11 的新结点。
     * 返回哑结点的下一个结点。
     * 请注意，我们使用哑结点来简化代码。如果没有哑结点，则必须编写额外的条件语句来初始化表头的值。
     *
     * 请特别注意以下情况：
     *
     * 测试用例	说明
     * l1=[0,1]l1=[0,1]
     * l2=[0,1,2]l2=[0,1,2]	当一个列表比另一个列表长时。
     *
     * l1=[]l1=[]
     * l2=[0,1]l2=[0,1]	当一个列表为空时，即出现空列表。
     *
     * l1=[9,9]l1=[9,9]
     * l2=[1]l2=[1]	求和运算最后可能出现额外的进位，这一点很容易被遗忘
     *
     * 运算结果 :
     * 执行用时 : 54 ms
     * 内存消耗 : 57.2 MB
     * @param p
     * @param q
     * @return
     */
    private static ListNode getSum(ListNode p, ListNode q) {
        ListNode dummyHead = new ListNode(0);
        ListNode  curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            // 每次循环 都把 next 对象带进去,这样就构成了一个链表
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}