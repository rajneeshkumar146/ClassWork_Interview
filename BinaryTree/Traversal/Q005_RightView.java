package BinaryTree.Traversal;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q005_RightView extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		Integer[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

	}

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		rightSideView_(root, ans, 0, new TreeNode(-1));
		return ans;
	}

	public static void rightSideView_(TreeNode root, List<Integer> ans, int level, TreeNode node) {
		if (root == null)
			return;

		if (level > node.val) {
			ans.add(root.val);
			node.val = level;
		}
		rightSideView_(root.right, ans, level + 1, node);
		rightSideView_(root.left, ans, level + 1, node);

	}

}
