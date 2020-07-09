package 杨辉三角II;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution=new Solution();
		solution.getRow(3).forEach((s) -> {
			System.out.print(s);
		});
	}

}
class Solution {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<>();
		if (rowIndex == 0 || rowIndex == 1) {
			list.add(1);
			if (rowIndex == 1)
				list.add(1);
    		return list;
    	}
		List<Integer> pass = getRow(rowIndex - 1);
		list.add(1);
		for (int i = 1; i <= rowIndex - 1; i++) {
			int fl = pass.get(i - 1);
			int fr = pass.get(i);
			list.add(fl + fr);
		}
		list.add(1);

		return list;
    }
}