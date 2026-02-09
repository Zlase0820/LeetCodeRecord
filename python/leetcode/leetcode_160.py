# https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=study-plan-v2&envId=top-100-liked

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
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        temp_head_a,temp_head_b = headA, headB
        head_a_num,head_b_num = 0,0
        while temp_head_a != None:
            head_a_num += 1
            temp_head_a = temp_head_a.next
        while temp_head_b != None:
            head_b_num += 1
            temp_head_b = temp_head_b.next        
        
        while head_a_num!=head_b_num:
            if head_a_num > head_b_num:
                head_a_num -= 1
                headA = headA.next
            else:
                head_b_num -= 1
                headB = headB.next
        
        # 共同长度，同时测试
        while headA != None:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next

        return None
    
if __name__ == "__main__":
    print(f"this question dont have demo")