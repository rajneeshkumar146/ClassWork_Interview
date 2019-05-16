package BinaryTree.Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Q018_ReverseTreePath extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		// removeComma("10,5,-3,3,2,null,11,3,-2,null,1");
		solve();
	}

	public static void solve() {
		Integer[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

	}

	public static boolean reversePath(TreeNode node, int tar, LinkedList<Integer> list) {
		if (node == null)
			return false;

		list.addLast(node.val);

		if (node.left == null && node.right == null) {
			node.val = list.removeFirst();
			return true;
		}

		if (reversePath(node.left, tar, list)) {
			node.val = list.removeFirst();
			return true;
		}
		if (reversePath(node.right, tar, list)) {
			node.val = list.removeFirst();
			return true;
		}

		list.removeLast();
		return false;

	}

}
