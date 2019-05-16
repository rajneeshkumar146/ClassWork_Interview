package BinaryTree.Traversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;

import BinaryTree.Base.TreeNode;

public class Q011_InOderIterative extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		Integer[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());
		inOder(root);
		test(root);
	}

	public static void inOder(TreeNode root) {
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		TreeNode curr = root;
		
		while (!stack.isEmpty() || curr != null) {

			while (curr != null) {
				stack.addFirst(curr);
				curr = curr.left;
			}
			curr = stack.removeFirst();
			System.out.print(curr.val + " ");
			curr = curr.right;
		}
		
		System.out.println();
	}

	private static void test(TreeNode node) {
		if (node == null)
			return;

		test(node.left);
		System.out.print(node.val + " ");
		test(node.right);
	}

}
