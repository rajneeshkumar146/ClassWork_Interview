package BinaryTree.Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q011_SumOfLeftSubtree extends BinaryTree.Base {
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

	public static int sumOfLeftSubTree(TreeNode node) {
		if (node == null)
			return 0;

		int left = sumOfLeftSubTree(node.left);
		node.val += left;
		int right = sumOfLeftSubTree(node.right);

		return node.val + right;
	}

}
