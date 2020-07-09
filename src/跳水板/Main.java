package 跳水板;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int shorter=1;
		int longer=2;
		int k = 3;
		Solution solution=new Solution();
		int[] lenth = solution.divingBoard(6, 9, 47997);
		for (int i : lenth) {
			System.out.println(i);
		}
	}

}

class Solution {
	public int[] divingBoard(int shorter, int longer, int k) {
		if (k == 0)
			return new int[0];
		if (longer == shorter)
			return new int[] { k * longer };
		int[] lengths=new int[k+1];
		for (int i = 0; i <= k; i++) {
			lengths[i] = (k - i) * shorter + i * longer;
		}
		return lengths;
	}
}