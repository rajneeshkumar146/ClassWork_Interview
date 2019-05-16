package BinaryTree.Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q013_maximumPathSum extends BinaryTree.Base {
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

		System.out.println(maxPathSum(root));

	}

	public static int maxPathSum(TreeNode root) {
		pair p = new pair(Integer.MIN_VALUE);

		int ans = MaxPathSum(root, p);
		return p.res;
	}

	static class pair {
		int res = 0;

		public pair(int res) {
			this.res = res;
		}
	}

	public static int MaxPathSum(TreeNode node, pair p) {
		if (node == null)
			return 0;

		if (node.left == null && node.right == null) {
			p.res = Math.max(p.res, node.val);
			return node.val;
		}

		int left = MaxPathSum(node.left, p);
		int right = MaxPathSum(node.right, p);

		int max = Math.max(left, right);

		if (node.left != null && node.right != null) {
			p.res = Math.max(Math.max(left + right + node.val, p.res), Math.max(max + node.val, node.val));

			return Math.max(max + node.val, node.val);
		}

		int rVal = Math.max((node.left != null ? left : right) + node.val, node.val);
		p.res = Math.max(rVal, p.res);
		return rVal;
	}

}
