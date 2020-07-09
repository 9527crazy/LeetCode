package 相反的顺序打印字符串;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Hannah";
		char[] hello= str.toCharArray();
		Solution solution=new Solution();
		solution.reverseString(hello);
		System.out.println(hello);
	}


}
class Solution {
    public void reverseString(char[] s) {
    	char sf;
    	int start=0,end=s.length-1;
    	while (start<s.length/2) {
			sf=s[start];
			s[start]=s[end];
			s[end]=sf;
			start++;
			end--;
		}
    }
}
