package 单词拆分;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("code");
		wordDict.add("code");
		System.out.println(solution.wordBreak(s, wordDict));
	}

}

class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 0; j < wordDict.size(); j++) {
				if (i < wordDict.get(j).length())
					continue;
				String str = s.substring(i - wordDict.get(j).length(), i);
				if (wordDict.get(j).equals(str)) {
					return true;
				}
			}
		}
		return false;
	}
}