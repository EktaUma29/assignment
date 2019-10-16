package com.yash.assignment.one;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.yash.assignment.one.MyLinkedList.Node;

public class CountLoopLinkListTest {

	CountLoopLinkList countLoopLinkList = new CountLoopLinkList();

	@Test
	public void shouldReturnZeroIfListHaveOneNumeber() {

		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.head = new Node(1);

		int actual = countLoopLinkList.lengthOfLoop(myLinkedList);

		assertEquals(0, actual);

	}

	@Test
	public void shouldReturnZeroIfListIsZero() {

		MyLinkedList myLinkedList = new MyLinkedList();

		int actual = countLoopLinkList.lengthOfLoop(myLinkedList);

		assertEquals(0, actual);

	}

	@Test
	public void shouldReturnNumberOfLoop() {

		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.head = new Node(1);
		myLinkedList.head.next = new Node(2);

		Node node = myLinkedList.head.next.next = new Node(3);
		myLinkedList.head.next.next.next = new Node(4);
		myLinkedList.head.next.next.next.next = new Node(5);
		myLinkedList.head.next.next.next.next.next = node;
		int actual = countLoopLinkList.lengthOfLoop(myLinkedList);

		assertEquals(3, actual);

	}

	@Test
	public void shouldReturnZeroIfListHaveTwoNumeberWithoutloop() {

		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.head = new Node(1);
		myLinkedList.head.next = new Node(1);

		int actual = countLoopLinkList.lengthOfLoop(myLinkedList);

		assertEquals(0, actual);

	}
}
