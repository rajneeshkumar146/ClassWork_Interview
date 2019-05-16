package BinaryTree.Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

import BinaryTree.Base.TreeNode;

public class Q005_VerticalSum extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		int[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

		verticalSum(root);

	}

	public static void verticalSum(TreeNode node) {
		TreeNode curr = new TreeNode(0); // traversalNode.
		TreeNode pair = new TreeNode(-1, curr, curr); // dummy_for_head_and_Tail.

		verticalSum_(node, pair, curr);

		for (TreeNode head = pair.left; head != null; head = head.right)
			System.out.print(head.val + " ");

		System.out.println();
		HashMap<Integer, Integer> map = new HashMap<>();
		verticalSum_01(node, map, 0);
		for (int i : map.keySet())
			System.out.print(map.get(i) + " ");

	}

	private static void verticalSum_(TreeNode node, TreeNode pair, TreeNode curr) {
		if (node == null)
			return;

		curr.val += node.val;
		if (node.left != null) {
			if (curr.left == null) {
				curr.left = new TreeNode(0, null, curr);
				pair.left = curr.left;
			}
			verticalSum_(node.left, pair, curr.left);
		}

		if (node.right != null) {
			if (curr.right == null) {
				curr.right = new TreeNode(0, curr, null);
				pair.right = curr.right;
			}
			verticalSum_(node.right, pair, curr.right);
		}

	}

	private static void verticalSum_01(TreeNode node, HashMap<Integer, Integer> map, int level) {
		if (node == null)
			return;

		if (!map.containsKey(level)) {
			map.put(level, node.val);
		} else {
			map.put(level, map.get(level) + node.val);
		}

		verticalSum_01(node.left, map, level + 1);
		verticalSum_01(node.right, map, level - 1);

	}

}
