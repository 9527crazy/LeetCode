package 恢复空格;

import java.util.Arrays;

/*
 * dp[i]表示前ii个字符中无法识别的字符个数。
那么我们可以这样，我们从前到后枚举sentencesentence的每一个位置，
然后我们检查从当前这个位置向前lenlen（lenlen是dictionarydictionary中每个单词的长度，
我们可以挨个尝试）个位置组成的单词有没有在dictionarydictionary中出现，
如出现了可知转移方程为dp[i] = dp[i-len]dp[i]=dp[i−len]，
即前ii个字符中没有被识别的字符数等于前i-leni−len个字符中没有被识别的字符数，
若在这个位置ii上将dictionarydictionary中所有的单词都尝试过了都没有匹配的，
可知ii处这个字符不能被识别，那么dp[i] = dp[i-1]+1dp[i]=dp[i−1]+1。综合上述两种情况，就可以从后到前找出答案。
*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String[] dictionary = { "looked", "just", "like", "her", "brother" };
		String sentence = "jesslookedjustliketimherbrother";
		int i = solution.respace(dictionary, sentence);
		System.out.println(i);
	}

}

class Solution {
	public int respace(String[] dictionary, String sentence) {
		int n = sentence.length() + 1;// 字符长度
		int m = dictionary.length;// 单词个数
		int[] dp = new int[n];// dp[i]=有i个未被识别的字符
		Trie root=new Trie();
		for (String word : dictionary) {
			root.insert(word);
		}
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i < dp.length; i++) {// 字符数组的下标
			dp[i] = dp[i - 1] + 1;
			Trie curPos = root;// 重置指针
			for (int j = i; j >= 1; j--) {//
				int t = sentence.charAt(j - 1) - 'a';// 字典数的下标
				if (curPos.next[t] == null) {
					break;
				} else if (curPos.next[t].isEnd) {
					dp[i] = Math.min(dp[j - 1], dp[i]);
				}
				if (dp[i] == 0) {// 匹配完字符
					break;
				}
				curPos = curPos.next[t];// 下一个字符
			}
		}
		return dp[sentence.length()];
	}
}

class Trie {// 字典数
	public Trie[] next;
	public boolean isEnd;

	public Trie() {
		next = new Trie[26];// 26个小写字母（加减a97）
		isEnd = false;
	}

	public void insert(String s) {
		Trie curPos = this;// 指针
		for (int i = s.length() - 1; i >= 0; i--) {
			int t = s.charAt(i) - 'a';
			if (curPos.next[t] == null) {
				curPos.next[t] = new Trie();
			}
			curPos = curPos.next[t];
		}
		curPos.isEnd = true;
	}
}
