package test01;

import java.util.HashMap;
import java.util.Map;

public class test {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution=new Solution();
		int n=44;
		int f= solution.numWays(n);
		System.out.println(f);
	}

}
class Solution {
	Map<Integer, Integer> map=new HashMap<>();
    public int numWays(int n) {
    	if(n<3)
    		return n;
    	if(n<=1) 
    		return 1;
    	return numWays(n-1)+numWays(n-2);
    }
}