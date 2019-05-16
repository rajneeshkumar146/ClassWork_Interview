package BinaryTree.Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q003_WidthOfBinarytree extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		int[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

		width_02(root);
		width_01(root);

	}

	public static void width_02(TreeNode root) {

		int left = width_02(root, true);
		int right = width_02(root, true);

		System.out.println(left + right + 1);

	}

	private static int width_02(TreeNode root, boolean isLeftWidth) {
		if (root == null)
			return -1;

		int left = width_02(root.left, isLeftWidth) + (isLeftWidth ? 1 : -1);
		int right = width_02(root.right, isLeftWidth) + (isLeftWidth ? -1 : 1);

		return Math.max(left, right);
	}

	public static void width_01(TreeNode root) {
		TreeNode min = new TreeNode(0);
		TreeNode max = new TreeNode(0);

		width_01(root, min, max, 0);

		System.out.println(max.val - min.val + 1);

	}

	private static void width_01(TreeNode root, TreeNode min, TreeNode max, int level) {
		if (root == null)
			return;

		min.val = Math.min(min.val, level);
		max.val = Math.max(max.val, level);

		width_01(root.left, min, max, level - 1);
		width_01(root.right, min, max, level + 1);

	}

}
