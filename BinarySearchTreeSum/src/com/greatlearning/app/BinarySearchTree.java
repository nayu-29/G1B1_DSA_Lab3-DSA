package com.greatlearning.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.greatlearning.model.*;

public class BinarySearchTree {

	ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Node root = null;
		Node nn = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter number of nodes");
		int size = sc.nextInt();
		int i;
		for (i = 1; i <= size; i++) {
			System.out.println("Enter Data for the node");
			int item = sc.nextInt();
			nn = new Node(item);
			if (root == null)
				root = nn;
			else
				bst.insert(root, nn);
		}

		bst.inOrder(root);
		System.out.println(bst.list);

		System.out.println("Enter Sum to search");
		int search = sc.nextInt();
		int flag = 0;
		for (int j = 0; j < bst.list.size(); j++) {
			int n1 = bst.list.get(j);
			int n2 = search - n1;
			if (bst.list.contains(n2)) {
				System.out.println("FOUND");
				System.out.println(n1 + "," + n2);
				flag = 1;
				break;
			}
		}
		if (flag == 0)
			System.out.println("NO MATCHING ELEMENTS FOUND");

	}

	private void insert(Node root, Node nn) {
		if (nn.data < root.data) {
			if (root.left == null) {
				root.left = nn;
			} else {
				insert(root.left, nn);
			}
		} else {
			if (root.right == null) {
				root.right = nn;
			} else {
				insert(root.right, nn);
			}
		}
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			list.add(root.data);
			inOrder(root.right);
		}
	}

}
