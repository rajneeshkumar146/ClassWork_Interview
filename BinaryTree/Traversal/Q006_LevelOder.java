package BinaryTree.Traversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;

public class Q006_LevelOder extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		Integer
		[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

	}

	// LevelOderSimple.=====================================================

	public static void levelOderSimple(TreeNode node) {
		if (node == null || (node.left == null && node.right == null))
			return;

		ArrayDeque<TreeNode> que = new ArrayDeque<>();
		que.addLast(node);
		String ans = "";
		while (!que.isEmpty()) {
			TreeNode nd = que.removeFirst();
			ans += nd.val + " ";

			if (node.left != null)
				que.addLast(node.left);
			if (node.right != null)
				que.addLast(node.right);
		}

		System.out.println(ans);
	}

	// LevelOderLineWise.=====================================================

	public static void levelOderLineWiseUsingTwoQueue(TreeNode node) {
		if (node == null || (node.left == null && node.right == null))
			return;

		ArrayDeque<TreeNode> que = new ArrayDeque<>();
		ArrayDeque<TreeNode> que2 = new ArrayDeque<>();
		que.addLast(node);

		while (!que.isEmpty()) {
			TreeNode nd = que.removeFirst();
			System.out.print(node.val + " ");

			if (node.left != null)
				que2.addLast(node.left);
			if (node.right != null)
				que2.addLast(node.right);

			if (que.isEmpty()) {
				ArrayDeque<TreeNode> temp = que;
				que = que2;
				que2 = temp;
				System.out.println();
			}
		}
	}

	public static void levelOderLineWiseUsingOneQueueWithNull(TreeNode node) {
		if (node == null || (node.left == null && node.right == null))
			return;

		LinkedList<TreeNode> que = new LinkedList<>();
		que.addLast(node);
		que.addLast(null);

		while (que.size() != 1) {
			TreeNode nd = que.removeFirst();

			if (nd == null) {
				System.out.println();
				if (que.size() != 0)
					que.addLast(null);
				continue;
			}

			System.out.println(nd.val + " ");

			if (node.left != null)
				que.addLast(node.left);
			if (node.right != null)
				que.addLast(node.right);
		}
	}

	public static void levelOderLineWiseUsingOneQueueWithCount(TreeNode node) {
		if (node == null || (node.left == null && node.right == null))
			return;

		ArrayDeque<TreeNode> que = new ArrayDeque<>();
		que.addLast(node);
		int Rootchilds = 1;
		int localChild = 0;

		while (que.size() != 0) {
			TreeNode nd = que.removeFirst();
			Rootchilds--;
			System.out.println(nd.val + " ");

			if (node.left != null) {
				que.addLast(node.left);
				localChild++;
			}
			if (node.right != null) {
				que.addLast(node.right);
				localChild++;
			}

			if (Rootchilds == 0) {
				System.out.println();
				Rootchilds = localChild;
				localChild = 0;
			}
		}

	}

	public static void levelOderLineWiseUsingOneQueueWithLevel(TreeNode node) {
		if (node == null || (node.left == null && node.right == null))
			return;

		ArrayDeque<TreeNode> que = new ArrayDeque<>();
		ArrayDeque<Integer> level = new ArrayDeque<>();
		que.addLast(node);
		level.addLast(0);
		int lev = 0;
		while (que.size() != 0) {
			TreeNode nd = que.removeFirst();
			int nl = level.removeFirst();

			if (node.left != null) {
				que.addLast(node.left);
				level.addLast(nl + 1);
			}
			if (node.right != null) {
				que.addLast(node.right);
				level.addLast(nl + 1);
			}

			if (lev != nl) {
				System.out.println();
				lev = nl;
			}

			System.out.println(nd.val + " ");

		}

	}

}
