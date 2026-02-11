# https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked

from typing import Optional
from typing import List

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


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        """
            双指针，第一个指针指向头，第二个指针向前走n步，第二个指针到None的时候，第一个指针刚好是需要剔除的节点
            注意边界，如果有head节点，注意返还下一个值
        """
        first = head
        second = head

        # 向后走n步
        for i in range(n):
            second = second.next
        
        # 说明second已经走到头了，该删除头或程序出错
        if second == None:
            if first == head:
                return head.next
            else:
                return None

        while second.next != None:
            first = first.next
            second = second.next

        # 去除中间节点
        first.next = first.next.next
        
        return head