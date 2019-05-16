package BinaryTree.Traversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Q009_PreOderIterative extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		int[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

		preOder_01(root);
		preOder_02(root);
		test(root);
	}

	public static void preOder_02(TreeNode root) {
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		TreeNode curr = root;

		while (!stack.isEmpty() || curr != null) {
			while (curr != null) {
				System.out.print(curr.val + " ");
				stack.addFirst(curr);
				curr = curr.left;
			}

			curr = stack.removeFirst().right;

		}
		System.out.println();
	}

	public static void preOder_01(TreeNode root) {
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		stack.addFirst(root);

		while (!stack.isEmpty()) {
			TreeNode nn = stack.removeFirst();
			System.out.print(nn.val + " ");

			if (nn.right != null)
				stack.addFirst(nn.right);

			if (nn.left != null)
				stack.addFirst(nn.left);

		}
		System.out.println();
	}

	private static void test(TreeNode node) {
		if (node == null)
			return;

		System.out.print(node.val + " ");
		test(node.left);
		test(node.right);
	}

}
