package BinaryTree.Traversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BinaryTree.Base.TreeNode;

public class Q003_inOderRecursion extends BinaryTree.Base {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		int[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		// System.out.println(root.toString());
		System.out.println(inorderTraversal(root));
	}

	public static List<Integer> inorderTraversal(TreeNode node) {
		// List<Integer> myAns=inorderTraversalReturnType(node);

		List<Integer> myAns = new ArrayList<>();
		inorderTraversalVoidType(node, myAns);

		return myAns;

	}

	public static List<Integer> inorderTraversalReturnType(TreeNode node) {
		if (node == null)
			return new ArrayList<Integer>();

		List<Integer> myAns = new ArrayList<Integer>();
		List<Integer> left = inorderTraversalReturnType(node.left);
		List<Integer> right = inorderTraversalReturnType(node.right);

		myAns.addAll(left);
		myAns.add(node.val);
		myAns.addAll(right);

		return myAns;

	}

	public static void inorderTraversalVoidType(TreeNode node, List<Integer> myAns) {
		if (node == null)
			return;

		inorderTraversalVoidType(node.left, myAns);
		myAns.add(node.val);
		inorderTraversalVoidType(node.right, myAns);
	}
}
