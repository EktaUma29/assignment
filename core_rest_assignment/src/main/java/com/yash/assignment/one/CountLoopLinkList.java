package com.yash.assignment.one;

import com.yash.assignment.one.MyLinkedList.Node;

class MyLinkedList {

	public Node head;

	public static class Node {

		public Node next;

		public Object data;

		public Node(Object data) {
			this.data = data;
			next = null;
		}
	}
}

public class CountLoopLinkList {

	public int lengthOfLoop(MyLinkedList myLinkedList) {
		Node head = myLinkedList.head;
		Node slow = head;
		Node fast = head;

		boolean loop = false;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				loop = true;
				break;
			}
		}

		if (loop) {

			int length = 0;
			slow = head;

			while (fast != slow) {
				fast = fast.next;
				slow = slow.next;
			}

			do {
				fast = fast.next;
				length++;
			} while (fast != slow);

			return length;

		}

		return 0;
	}

}
