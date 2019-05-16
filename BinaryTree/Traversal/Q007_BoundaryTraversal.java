package BinaryTree.Traversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q007_BoundaryTraversal extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		int[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

		boundary(root);
	}

	public static void boundary(TreeNode node) {
		if (node.left == null && node.right == null)
			System.out.println(node.val);

		leftView(node);
		leafeNode(node);
		rightView(node.right);
	}

	private static void leftView(TreeNode node) {
		if (node == null)
			return;

		if (node.left != null) {
			System.out.print(node.val + " ");
			leftView(node.left);
		} else if (node.right != null) {
			System.out.print(node.val + " ");
			leftView(node.right);
		}

	}

	private static void leafeNode(TreeNode node) {
		if (node == null)
			return;

		if (node.left == null && node.right == null)
			System.out.print(node.val + " ");

		leafeNode(node.left);
		leafeNode(node.right);
	}

	private static void rightView(TreeNode node) {
		if (node == null)
			return;

		if (node.right != null) {
			leftView(node.right);
			System.out.print(node.val + " ");
		} else if (node.left != null) {
			leftView(node.left);
			System.out.print(node.val + " ");
		}
	}
}
