# https://leetcode.cn/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=top-100-liked

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
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        if head == None or head.next == None:
            return head
        
        first = head
        second = head.next
        first.next = None
        if second.next == None:
            second.next = first
            return second

        third = second.next
        while third != None:
            second.next = first
            first = second
            second = third
            third = third.next
        return second
