package com.awad.anthony.demos.utils;

public class CircularLinkedList {

    private ListNode head = null;
    private ListNode tail = null;
    
    public void addListNode(ListNodeItem value) {
    	ListNode newNode = new ListNode(value);
     
        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }
     
        tail = newNode;
        tail.nextNode = head;
    }
	
    public boolean containsListNode(ListNodeItem searchValue) {
    	ListNode currentNode = head;
     
        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }
	
    
    public void deleteListNode(ListNodeItem valueToDelete) {
    	ListNode currentNode = head;
     
        if (head != null) {
            if (currentNode.value == valueToDelete) {
                head = head.nextNode;
                tail.nextNode = head;
            } else {
                do {
                	ListNode nextNode = currentNode.nextNode;
                    if (nextNode.value == valueToDelete) {
                        currentNode.nextNode = nextNode.nextNode;
                        break;
                    }
                    currentNode = currentNode.nextNode;
                } while (currentNode != head);
            }
        }
    }
    
	
/////////////////////////////////////////
//    INTERNAL MODELS
/////////////////////////////////////////
	public class ListNode {
		 
		ListNodeItem value;
		ListNode nextNode;
	 
	    public ListNode(ListNodeItem value) {
	        this.value = value;
	    }
	}
	public interface ListNodeItem{
		
	}
}
