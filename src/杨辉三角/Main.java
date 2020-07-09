package 杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution=new Solution();
		solution.generate(3).forEach((s)->{
			s.forEach((sh)->{
				System.out.print(sh);
			});
		});
	}

}
class Solution {
    public List<List<Integer>> generate(int numRows) {
    	if(numRows==0) {
    		List<List<Integer>> list=new ArrayList<>();
    		return list;
    	}
    	
    	if(numRows==1||numRows==2) {
    		List<List<Integer>> list=new ArrayList<>();
    		List<Integer> row=new ArrayList<>();
    		row.add(1);
    		list.add(row);
    		if(numRows==2) {
    		List<Integer> row1=new ArrayList<>();
    		row1.add(1);
    		row1.add(1);
    		list.add(row1);
    		}
    		return list;
    	}
    	List<List<Integer>> list = generate(numRows-1);
    	List<Integer> row=new ArrayList<>();//curr
    	row.add(1);
    	for(int i=1;i<=numRows-2;i++) {
    		int fl=list.get(numRows-2).get(i-1);
    		int fr=list.get(numRows-2).get(i);
    		row.add(fl+fr);
    	}
    	row.add(1);
    	list.add(row);
		return list;
    }
}