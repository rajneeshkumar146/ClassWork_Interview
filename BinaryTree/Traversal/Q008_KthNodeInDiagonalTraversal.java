package BinaryTree.Traversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.soap.Node;

public class Q008_KthNodeInDiagonalTraversal extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		int[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		System.out.println(root.toString());

		KthNode(root, 5);

	}

	private static void KthNode(TreeNode node, int k) {
		StringBuilder ans = new StringBuilder();

		ArrayDeque<TreeNode> que = new ArrayDeque<>();
		que.addLast(node);
		que.addLast(new TreeNode(Integer.MAX_VALUE));
		TreeNode KthNode = null;

		while (que.size() != 1) {
			TreeNode nn = que.removeFirst();

			if (nn.val == Integer.MAX_VALUE) {
				que.addLast(new TreeNode(Integer.MAX_VALUE));
				ans.append("\n");
				continue;
			}

			while (nn != null) {
				ans.append(nn.val + " ");
				k--; // if k become zero return it.
				KthNode = k == 0 ? nn : KthNode;

				if (nn.left != null) // add in que for next diagonal process.
					que.addLast(nn.left);

				nn = nn.right; // move forward in respective diagonal.
			}
		}

		System.out.println(ans.toString());
		System.out.println("Kth Node: " + (KthNode != null ? KthNode.val : -1));
	}

}
