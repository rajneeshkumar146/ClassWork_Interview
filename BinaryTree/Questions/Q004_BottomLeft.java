package BinaryTree.Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q004_BottomLeft  extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		int[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

		System.out.println(findBottomLeftValue(root));
	}

	public static int findBottomLeftValue(TreeNode root) {
		return findBottomLeftValue_(root).node.val;
	}

	public static class pair {
		int level = 0;
		TreeNode node = null;
	}

	public static pair findBottomLeftValue_(TreeNode root) {
		if (root == null)
			return new pair();

		pair left = findBottomLeftValue_(root.left);
		pair right = findBottomLeftValue_(root.right);

		pair mypair = new pair();
		if (left.level + 1 >= right.level + 1) {
			mypair.level = left.level + 1;
			mypair.node = left.node != null ? left.node : root;
		} else {
			mypair.level = right.level + 1;
			mypair.node = right.node != null ? right.node : root;

		}
		return mypair;
	}

}