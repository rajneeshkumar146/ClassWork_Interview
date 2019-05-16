package BinaryTree.Traversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q012_MorriesIn extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		int[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

		MorriesIn(root);
		test(root);
	}

	public static void MorriesIn(TreeNode node) { //jb_null_hua_tb_print_karo_ya_phir_jb_thread_ke_through_wapish_aya_hu_tb_print_karo.
		TreeNode curr = node;
		while (curr != null) {
			if (curr.left == null) {
				System.out.print(curr.val + " ");
				curr = curr.right;
				continue;
			}

			TreeNode left = curr.left;
			while (left.right != null && left.right != curr)
				left = left.right;

			if (left.right == null) {
				left.right = curr;
				curr = curr.left;
			} else {
				left.right = null;
				System.out.print(curr.val + " ");
				curr = curr.right;
			}
		}
		System.out.println();

	}

	private static void test(TreeNode node) {
		if (node == null)
			return;

		test(node.left);
		System.out.print(node.val + " ");
		test(node.right);
	}

}
