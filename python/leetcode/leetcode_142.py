# https://leetcode.cn/problems/linked-list-cycle-ii/description/?envType=study-plan-v2&envId=top-100-liked

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
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        """
            使用数据结构：遍历一遍，使用set记录每一个节点，直到遍历到None则无环，遍历到set中存在值则为环入口
            使用算法：双指针fast和slow，假如有换，fast一定可以在第一圈内追上slow
                假设入环前长度为a，环交点距离环扣位置为b，环交点向后遍历距离为c，fast走过的圈数为n
                fast走过的距离为 a+b+n(b+c) 
                slow走过的距离为 a+b
                因为fast距离一定是slow的2倍，因此一定有 a+b+n(b+c) = 2(a+b)
                可以得到 a = c + (n-1)(b+c)
                也就是说找到快慢的交点，设置一个ptr从head向后遍历，slow会在转了(n-1)圈之后再走c的长度，与ptr在环扣相遇
        """

        first = head
        second = head
        while first != None and second != None:
            first = first.next
            if second.next != None and second.next.next != None:
                second = second.next.next
            else:
                return None
            if first == second:
                break
        
        ptr = head
        while ptr != None:
            if ptr == first:
                break
            ptr = ptr.next
            first = first.next

        return ptr
