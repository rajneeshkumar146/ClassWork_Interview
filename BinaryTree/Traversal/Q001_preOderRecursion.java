package BinaryTree.Traversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BinaryTree.Base.TreeNode;

public class Q001_preOderRecursion extends BinaryTree.Base {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		Integer[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		// System.out.println(root.toString());
		System.out.println(preorderTraversal(root));
	}

	public static List<Integer> preorderTraversal(TreeNode node) {
		// List<Integer> myAns=preorderTraversalReturnType(node);

		List<Integer> myAns = new ArrayList<>();
		preorderTraversalVoidType(node, myAns);

		return myAns;

	}

	public static List<Integer> preorderTraversalReturnType(TreeNode node) {
		if (node == null)
			return new ArrayList<Integer>();

		List<Integer> myAns = new ArrayList<Integer>();
		List<Integer> left = preorderTraversalReturnType(node.left);
		List<Integer> right = preorderTraversalReturnType(node.right);

		myAns.add(node.val);
		myAns.addAll(left);
		myAns.addAll(right);

		return myAns;

	}

	public static void preorderTraversalVoidType(TreeNode node, List<Integer> myAns) {
		if (node == null)
			return;

		myAns.add(node.val);
		preorderTraversalVoidType(node.left, myAns);
		preorderTraversalVoidType(node.right, myAns);
	}
}
