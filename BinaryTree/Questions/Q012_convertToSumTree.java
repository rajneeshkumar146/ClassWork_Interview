package BinaryTree.Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q012_convertToSumTree extends BinaryTree.Base {
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

	public static int sumTree(TreeNode node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null) {
			int temp = node.val;
			node.val = 0;
			return temp;
		}

		int left = sumTree(node.left);
		int right = sumTree(node.right);

		int temp = node.val;
		node.val = left + right;

		return temp + node.val;
	}

}
