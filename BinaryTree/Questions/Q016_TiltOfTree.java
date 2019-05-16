package BinaryTree.Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q016_TiltOfTree extends BinaryTree.Base {
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

	private static class tilt {
		int sum = 0;
		int overallTilt = 0;

		public tilt(int sum, int overallTilt) {
			this.sum = sum;
			this.overallTilt = overallTilt;
		}
	}

	public static int findTilt(TreeNode node) {
		return TiltOfTree(node).overallTilt;
	}

	public static tilt TiltOfTree(TreeNode node) {
		if (node == null)
			return new tilt(0, 0);

		tilt left = TiltOfTree(node.left);
		tilt right = TiltOfTree(node.right);

		int sum = Math.abs(left.sum - right.sum);

		tilt ans = new tilt(left.sum + right.sum + node.val, left.overallTilt + right.overallTilt + sum);
		return ans;
	}

}
