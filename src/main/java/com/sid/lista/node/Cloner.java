package com.sid.lista.node;

import java.util.HashMap;
import java.util.Map;

public class Cloner {

	Map<Node, Node> originalClone  = new HashMap<Node, Node>();
	public static void main(String[] args) {

		Node node1 = new Node();
		node1.setValue("A");
		
		Node node2 = new Node();
		node2.setValue("B");
		
		Node node3 = new Node();
		node3.setValue("A");
		
		Node node4 = new Node();
		node4.setValue("C");
		
		node1.setNext(node2);
		node1.setRandom(node3);
		
		node2.setNext(node3);
		node2.setRandom(node2);

		node3.setNext(node4);
		node3.setRandom(node2);
		
		node4.setRandom(node1);
		
		Cloner cloner = new Cloner();
		cloner.clone(node1);

	}
	public Node clone(Node head) {
		
		Node cloned = new Node();
		cloned.setValue(head.getValue());
		originalClone.put(head, cloned);
		Node next = head.getNext();
		while (next !=null) {
			Node nextClone = new Node();
			nextClone.setValue(next.getValue());
			originalClone.put(next, nextClone);
			next = next.getNext();
		}
		
		for(Node node : originalClone.keySet()) {
			originalClone.get(node).setNext(node.getNext());
			originalClone.get(node).setRandom(node.getRandom());
		}
		
		return cloned;
	}
}
