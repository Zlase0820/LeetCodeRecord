# https://leetcode.cn/problems/linked-list-cycle/description/?envType=study-plan-v2&envId=top-100-liked

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
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        """
            双指针遍历列表，一个走一步，一个走两步，如果最后都能到None则无环，若撞上则有环
        """
        if head == None:
            return False

        first = head
        second = head.next
        while first != None and second != None:
            if second == first:
                return True
            first = first.next
            if second.next != None and second.next.next != None:
                second = second.next.next
            else:
                break
        return False