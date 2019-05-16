package BinaryTree.Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Q010_SumNodeToNode extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		// removeComma("10,5,-3,3,2,null,11,3,-2,null,1");
		solve();
	}

	public static void solve() {
		Integer[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

		System.out.println(pathSum(root, 3));

	}

	/*
	 * So the idea is similar as Two sum, using HashMap to store ( key : the
	 * prefix sum, value : how many ways get to this prefix sum) , and whenever
	 * reach a node, we check if prefix sum - target exists in hashmap or not,
	 * if it does, we added up the ways of prefix sum - target into res. For
	 * instance : in one path we have 1,2,-1,-1,2, then the prefix sum will be:
	 * 1, 3, 2, 1, 3, let's say we want to find target sum is 2, then we will
	 * have{2}, {1,2,-1}, {2,-1,-1,2} and {2}ways.
	 */

	public static int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null && root.val != 0 && sum == 0)
			return 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		return pathSum_(root, 0, sum, map, "");

	}

	public static int pathSum_(TreeNode root, int currSum, int sum, HashMap<Integer, Integer> map, String ans) {
		if (root == null)
			return 0;

		currSum += root.val;
		int res = 0;
		res += map.getOrDefault(currSum - sum, 0);
		map.put(currSum, map.getOrDefault(currSum, 0) + 1);

		res += pathSum_(root.left, currSum, sum, map, ans + root.val + " ")
				+ pathSum_(root.right, currSum, sum, map, ans + root.val + " ");
		if (map.get(currSum) > 1)
			map.put(currSum, map.get(currSum) - 1);
		else
			map.remove(currSum);

		return res;

	}

	// 10 5 -3 3 2 null 11 3 -2 null 1
	// 8

	// ""
	// 1

	// 0
	// 0

	// 1 2
	// 0

	// 1 -2 -3 1 3 -2 null -1
	// 3

	// 1 null 2 null 3 null 4 null 5
	// 3

}
