package BinaryTree.Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q008_AllRootToLeafPathSum extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		// removeComma("5,4,8,11,null,13,4,7,2,null,null,5,1");
		solve();
	}

	public static void solve() {
		Integer[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		// System.out.println(root.toString());

		System.out.println(pathSum(root, scn.nextInt()));
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null)
			return new ArrayList<>();

		if (root.left == null && root.right == null && sum - root.val == 0) {
			List<List<Integer>> base = new ArrayList<>();
			List<Integer> ans = new ArrayList<>();
			ans.add(root.val);
			base.add(ans);
			return base;
		}

		List<List<Integer>> ans = new ArrayList<>();

		List<List<Integer>> left = pathSum(root.left, sum - root.val);
		for (List<Integer> arr : left) {
			arr.add(0, root.val);
			ans.add(arr);
		}

		List<List<Integer>> right = pathSum(root.right, sum - root.val);
		for (List<Integer> arr : right) {
			arr.add(0, root.val);
			ans.add(arr);
		}

		return ans;

	}

	// 5 4 8 11 null 13 4 7 2 null null 5 1
	// 22

}
