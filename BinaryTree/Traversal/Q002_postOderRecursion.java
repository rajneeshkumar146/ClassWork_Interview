package BinaryTree.Traversal;

import java.io.*;
import java.util.*;

import BinaryTree.Base.TreeNode;

public class Q002_postOderRecursion extends BinaryTree.Base {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		int[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_03(arr,new TreeNode(0));
		// System.out.println(root.toString());

		System.out.println(postorderTraversal(root));

	}

	public static List<Integer> postorderTraversal(TreeNode node) {
		// List<Integer> myAns=postorderTraversalReturnType(node);

		List<Integer> myAns = new ArrayList<>();
		postorderTraversalVoidType(node, myAns);

		return myAns;

	}

	public static List<Integer> postorderTraversalReturnType(TreeNode node) {
		if (node == null)
			return new ArrayList<Integer>();

		List<Integer> myAns = new ArrayList<Integer>();
		List<Integer> left = postorderTraversalReturnType(node.left);
		List<Integer> right = postorderTraversalReturnType(node.right);

		myAns.addAll(left);
		myAns.addAll(right);
		myAns.add(node.val);
		return myAns;

	}

	public static void postorderTraversalVoidType(TreeNode node, List<Integer> myAns) {
		if (node == null)
			return;

		postorderTraversalVoidType(node.left, myAns);
		postorderTraversalVoidType(node.right, myAns);
		myAns.add(node.val);
	}

}
