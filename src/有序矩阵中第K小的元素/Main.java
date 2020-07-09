package 有序矩阵中第K小的元素;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[][] matrix = { { 1, 2 }, { 1, 3 } };
		System.out.println(solution.kthSmallest(matrix, 2));
	}

}

class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			int[] js = matrix[i];
			for (int j = 0; j < js.length; j++) {
				list.add(js[j]);
			}
		}
		Collections.sort(list);
		return list.get(k - 1);
	}
}