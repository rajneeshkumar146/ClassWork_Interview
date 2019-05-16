package BinaryTree.Constructor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Q005_PreIn extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		int[] pre = inputSplitSpace(scn.nextLine());
		int[] in = inputSplitSpace(scn.nextLine());

		TreeNode root = buildTree(pre, in);
		System.out.println(root.toString());
	}

	public static TreeNode buildTree(int[] pre, int[] in) {
		return constructPreIn_(pre, in, 0, pre.length - 1, 0, in.length - 1);

	}

	private static TreeNode constructPreIn_(int[] pre, int[] in, int psi, int pei, int isi, int iei) {
		if (psi > pei || isi > iei)
			return null;

		int i = isi;
		while (i <= iei && in[i] != pre[psi])
			i++;

		int gap = i - isi;
		TreeNode node = new TreeNode(pre[psi]);
		node.left = constructPreIn_(pre, in, psi + 1, pei + gap, isi, i - 1);
		node.right = constructPreIn_(pre, in, psi + gap + 1, pei, i + 1, iei);

		return node;
	}

}
