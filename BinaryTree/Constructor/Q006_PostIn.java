package BinaryTree.Constructor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q006_PostIn extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		int[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

	}

	public static TreeNode buildTree(int[] in, int[] post) {
		return constructor_postIn_(post, in, 0, post.length - 1, 0, in.length - 1);

	}

	private static TreeNode constructor_postIn_(int[] post, int[] in, int psi, int pei, int isi, int iei) {
		if (psi > pei || isi > iei)
			return null;

		int i = isi;
		while (i <= iei && in[i] != post[pei])
			i++;

		int gap = i - isi;
		TreeNode node = new TreeNode(post[pei]);
		node.left = constructor_postIn_(post, in, psi, psi + gap - 1, isi, i - 1);
		node.right = constructor_postIn_(post, in, psi + gap, pei - 1, i + 1, iei);
		return node;
	}

}
