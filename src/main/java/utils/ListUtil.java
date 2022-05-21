package utils;

import beans.ListNode;

public class ListUtil {
    public static ListNode createListNode(int[] nums){
        // 数组为空
        if(nums.length ==0){
            return null;
        }

        // 数组只有一个值
        if(nums.length==1){
            return new ListNode(nums[0]);
        }

        // 数组有多个值
        ListNode root = new ListNode(nums[0]);
        ListNode temp = root;
        for(int i=1;i<nums.length;i++){
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] num1 = {};
        int[] num2 = {2};
        int[] num3 = {1,2,3,4,5,6};
        ListNode node1 = ListUtil.createListNode(num1);
        ListNode node2 = ListUtil.createListNode(num2);
        ListNode node3 = ListUtil.createListNode(num3);
        System.out.println(123);
    }
}
