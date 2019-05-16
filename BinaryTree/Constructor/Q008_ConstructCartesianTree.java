package BinaryTree.Constructor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q008_ConstructCartesianTree extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		// int inorder[] = {5, 10, 40, 30, 28};
		int inorder[] = { 1, 5, 10, 40, 30, 15, 28, 20 };

		TreeNode root = buildTree(new ArrayList<>(Arrays.asList(1, 5, 10, 40, 30, 15, 28, 20)));

	}

	public static TreeNode buildTree(ArrayList<Integer> A) {
		return CartesianTree(A, 0, A.size() - 1);
	}

	public static TreeNode CartesianTree(ArrayList<Integer> inoder, int si, int ei) {
		if (si > ei) {
			return null;
		}

		int maxi = si;
		for (int i = si; i <= ei; i++) {
			if (inoder.get(i) > inoder.get(maxi)) {
				maxi = i;
			}
		}

		TreeNode node = new TreeNode(inoder.get(maxi));
		node.left = CartesianTree(inoder, si, maxi - 1);
		node.right = CartesianTree(inoder, maxi + 1, ei);

		return node;
	}

}
