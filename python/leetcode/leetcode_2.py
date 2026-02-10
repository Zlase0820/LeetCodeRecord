# https://leetcode.cn/problems/add-two-numbers/?envType=study-plan-v2&envId=top-100-liked

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
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = 0
        root = ListNode(0)
        temp_node = root

        while l1 != None or l2 != None or carry != 0:
            # 进位加和
            sum = carry
            if l1 != None:
                sum += l1.val
                l1 = l1.next
            if l2 != None:
                sum += l2.val
                l2 = l2.next
            
            # 判断节点
            if sum > 9:
                carry = 1
                temp_node.next = ListNode(sum - 10)
            else:
                carry = 0
                temp_node.next = ListNode(sum)
            temp_node = temp_node.next

        temp_node.next = None
        return root.next
