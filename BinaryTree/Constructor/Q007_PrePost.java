package BinaryTree.Constructor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q007_PrePost extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		// int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
		// int[] post = { 4, 5, 2, 6, 7, 3, 1 };

		int[] pre = { 1, 2 };
		int[] post = { 2, 1 };

		TreeNode node = buildTree(pre, post);
		System.out.println(node.toString());
	}

	public static TreeNode buildTree(int[] pre, int[] post) {
		return constructPrePost_(pre, post, 0, pre.length - 1, 0, post.length - 1);

	}

	private static TreeNode constructPrePost_(int[] pre, int[] post, int psi, int pei, int posi, int poei) {
		if (psi > pei || posi > poei)
			return null;
		if (psi == pei && posi == poei)
			return new TreeNode(post[poei]);

		int i = posi;
		while (i <= poei && post[i] != pre[psi + 1])
			i++;

		int gap = i - posi;
		TreeNode node = new TreeNode(pre[psi]);
		node.left = constructPrePost_(pre, post, psi + 1, psi + 1 + gap, posi, posi + gap);
		node.right = constructPrePost_(pre, post, psi + gap + 2, pei, posi + gap + 1, poei - 1);

		return node;
	}

}
