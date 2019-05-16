package BinaryTree.Traversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Q004_vertivcalOderTraversal extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		Integer[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

		System.out.println(method_02(root));
	}

	public static ArrayList<ArrayList<Integer>> method_02(TreeNode node) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if (node == null)
			return ans;

		int leftWidth = width(node, true);
		int rightWidth = width(node, false);

		for (int i = 0; i <= leftWidth + rightWidth; i++)
			ans.add(new ArrayList<>());

		ArrayDeque<TreeNode> queN = new ArrayDeque<>();
		ArrayDeque<Integer> queV = new ArrayDeque<>();
		queN.addLast(node);
		queV.addLast(leftWidth);

		while (!queN.isEmpty()) {

			TreeNode nn = queN.removeFirst();
			Integer val = queV.removeFirst();
			ans.get(val).add(nn.val);

			if (nn.left != null) {
				queN.addLast(nn.left);
				queV.addLast(val - 1);
			}

			if (nn.right != null) {
				queN.addLast(nn.right);
				queV.addLast(val + 1);
			}
		}

		// System.out.println(ans);
		return ans;

	}

	// Wrong_Method.get_wrong_for_tesCase3========================================================

	public static void method_01(TreeNode node) {
		int leftWidth = width(node, true);
		int rightWidth = width(node, false);

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (int i = 0; i <= leftWidth + rightWidth; i++)
			ans.add(new ArrayList<>());

		method_01_(node, leftWidth, ans);

	}

	private static int width(TreeNode node, boolean IsLeftWidth) {
		if (node == null)
			return -1;
		int left = width(node.left, IsLeftWidth) + (IsLeftWidth ? 1 : -1);
		int right = width(node.right, IsLeftWidth) + (IsLeftWidth ? -1 : 1);

		return Math.max(left, right);
	}

	private static void method_01_(TreeNode node, int width, ArrayList<ArrayList<Integer>> ans) {
		if (node == null)
			return;

		ans.get(width).add(node.val);
		method_01_(node.left, width - 1, ans);
		method_01_(node.right, width + 1, ans);
	}

}
