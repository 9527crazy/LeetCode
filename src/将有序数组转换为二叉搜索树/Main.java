package 将有序数组转换为二叉搜索树;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] nums = { -10, -3, 0, 5, 9 };
		TreeNode treeNode = solution.sortedArrayToBST(nums);
		foreach(treeNode);
	}
	
	public static void foreach(TreeNode treeNode) {
		if (treeNode == null)
			return;
		if (treeNode.left == null && treeNode.right == null) {
			System.out.println(treeNode.val);
			return;
		}
		System.out.println(treeNode.val);
		foreach(treeNode.left);
		foreach(treeNode.right);
	}

}

class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
		return treeBuildHelper(nums, 0, nums.length);
	}

	private TreeNode treeBuildHelper(int[] nums, int start, int end) {
		if (start >= end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = treeBuildHelper(nums, start, mid - 1);
		root.right = treeBuildHelper(nums, mid + 1, end);
		return root;
	}

}