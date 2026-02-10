# https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked


from typing import List
from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    # 创建一个list，返回head
    def create_list(self, list_nodes: List[int]):
        if len(list_nodes) == 1:
            return(ListNode(list_nodes[0]))
        head = ListNode(list_nodes[0])
        temp_head = head
        for num in range(1,len(list_nodes)):
            temp_node = ListNode(num)
            temp_head.next = temp_node
            temp_head = temp_head.next
        return head

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        """
            先遍历中间位置，给后半段链表翻转，在重新判断即可
        """
        # 遍历所有值
        temp_head = head
        length = 0
        while temp_head != None:
            length += 1
            temp_head = temp_head.next

        # 找到后半段的head
        temp_head = head
        if length%2 == 1:
            reverse_num = int(length / 2 + 1)
        else: 
            reverse_num = int(length / 2)
        for i in range(reverse_num):
            temp_head = temp_head.next

        # 后半段的head做链表翻转
        new_head = self.reverse_list(temp_head)

        # 判断是否回文
        for i in range(int(length/2)):
            if head.val != new_head.val:
                return False
            head = head.next
            new_head = new_head.next

        return True


    def reverse_list(slef, head:Optional[ListNode]) -> Optional[ListNode]:
        if head == None or head.next == None:
            return head
        if head.next.next == None:
            first = head
            second = head.next
            first.next = None
            second.next = first
            return second

        first = head
        second = head.next
        third = second.next
        first.next = None
        while third != None:
            second.next = first
            first = second
            second = third
            third = third.next
        second.next = first
        return second

