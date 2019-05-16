package BinaryTree.Questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q001_MaximumWidth_01 extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		Integer[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

		ArrayList<Integer> levelArr = new ArrayList<>(); // maximumSizeGoesTo_LogN.
		MaximumWidth(root, levelArr, 0);
		System.out.println(Collections.max(levelArr)); // logN_loopToFindMaximum.
	}

	private static void MaximumWidth(TreeNode node, ArrayList<Integer> levelArr, int level) {

		if (node == null)
			return;

		if (level < levelArr.size())
			levelArr.set(level, levelArr.get(level) + 1);
		else
			levelArr.add(1);

		MaximumWidth(node.left, levelArr, level + 1);
		MaximumWidth(node.right, levelArr, level + 1);

	}

}
