package BinaryTree.Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q009_SumRootToLeafNumber extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		// removeComma("4,9,0,5,1");
		solve();
	}

	public static void solve() {
		Integer[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

		System.out.println(sumNumbers(root));

	}

	public static int sumNumbers(TreeNode root) {
		return sumPairs_(root, 0);

	}

	private static int sumPairs_(TreeNode root, int sum) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return sum * 10 + root.val;

		int left = sumPairs_(root.left, sum * 10 + root.val);
		int right = sumPairs_(root.right, sum * 10 + root.val);

		return left + right;

	}

}
