package BinaryTree.Constructor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Q016_BTFromParentArray extends BinaryTree.Base {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
//		int par[] = { -1, 0, 0, 1, 1, 3, 5 };
		 int[] par={1, 5, 5, 2, 2, -1, 3};

		System.out.println(BtFromParentArray(par).toString());
	}

	public static TreeNode BtFromParentArray(int[] par) {
		TreeNode[] map = new TreeNode[par.length];
		TreeNode root = null;
		for (int i = 0; i < par.length; i++)
			map[i] = new TreeNode(i);

		for (int i = 0; i < par.length; i++) {
			if (par[i] == -1) {
				root = map[i];
				continue;
			}

			if (map[par[i]].left == null)
				map[par[i]].left = map[i];
			else
				map[par[i]].right = map[i];

		}

		return root;
	}

}
