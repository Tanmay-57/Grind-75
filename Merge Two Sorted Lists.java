//21

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        // keeps track of the last node in the merged list. 
        //Initially, tail is set to dummyHead, indicating that 
        //the merged list is currently empty
        ListNode tail = dummyHead;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1= list1.next; // Move list1 pointer to the next node
                tail= tail.next; //// Move tail to the newly appended node
            }else{
                tail.next = list2;
                list2= list2.next;
                tail= tail.next;
            }
        }

        // Append the remaining nodes of list1 or list2 (if any)
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return dummyHead.next;

    }
