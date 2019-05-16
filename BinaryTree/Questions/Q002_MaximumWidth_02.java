package BinaryTree.Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q002_MaximumWidth_02 extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Integer[] arr = inputSplitSpace(scn.nextLine());
		TreeNode node = constructor_levelOderSerailize(arr);
		System.out.println(node.toString());

	}

	private static int width(TreeNode node, boolean leftWidth) {
		if (node == null)
			return -1;

		int left = width(node.left, leftWidth) + (leftWidth ? 1 : -1);
		int right = width(node.right, leftWidth) + (leftWidth ? -1 : 1);

		return Math.max(left, right);
	}

}
