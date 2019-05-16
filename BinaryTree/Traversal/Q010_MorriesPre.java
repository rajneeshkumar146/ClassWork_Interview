package BinaryTree.Traversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q010_MorriesPre extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		int[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

		MorriesPre(root);
		test(root);
	}

	public static void MorriesPre(TreeNode node) {

		TreeNode curr = node;
		while (curr != null) { //jb_thread_bnane_jayenge_to_print_krenge_or_jb_uska_left_child_nahi_hoga_tb. 
			if (curr.left == null) { 
				System.out.print(curr.val + " ");
				curr = curr.right;
				continue;
			}
			TreeNode left = curr.left;
			while (left.right != null && left.right != curr)
				left = left.right;

			if (left.right == null) {
				System.out.print(curr.val + " ");

				left.right = curr;
				curr = curr.left;
			} else {
				left.right = null;
				curr = curr.right;
			}
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
