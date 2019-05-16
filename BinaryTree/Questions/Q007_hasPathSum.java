package BinaryTree.Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import BinaryTree.Base.TreeNode;

public class Q007_hasPathSum extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		// removeComma("4,9,0,5,1");
		solve();
	}

	public static void solve() {

		int[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && sum - root.val == 0) {
			return true;
		}

		boolean res = false;
		res = res || hasPathSum(root.left, sum - root.val);
		res = res || hasPathSum(root.right, sum - root.val);
		return res;

	}

}
