import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <br>
 * <p>
 * {@link Solution3
 * <p>
 * Longest Substring Without Repeating Characters   medium
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author wangzhe
 * @version 1.0
 * @date 2019/1/15 2:52 PM
 */
public class Solution3 {

    public static void main(String[] args) {
        //3 abc
        System.out.println("test--->\"abcabcbb\"");
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        //1 b
        System.out.println("test--->\"bbbbb\"");
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        //3 wke
        System.out.println("test--->\"pwwkew\"");
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        //0
        System.out.println("test--->\"\"");
        System.out.println(lengthOfLongestSubstring(""));
        //3 vdf
        System.out.println("test--->\"dvdf\"");
        System.out.println(lengthOfLongestSubstring("dvdf"));
        //6 sjrgap
        System.out.println("test--->\"asjrgapa\"");
        System.out.println(lengthOfLongestSubstring("asjrgapa"));
        //6 tablud
        System.out.println("test--->\"bbtablud\"");
        System.out.println(lengthOfLongestSubstring("bbtablud"));
        //5 ilbkd
        System.out.println("test--->\"ckilbkd\"");
        System.out.println(lengthOfLongestSubstring("ckilbkd"));
    }

    /**
     * lengthOfLongestSubstring (这里用一句话描述这个方法的作用)
     *
     * @param s
     * @return int
     * @author WangZhe
     * @since 1.0
     */
    public static int lengthOfLongestSubstring(String s) {

        if (s != null && s.length() > 0) {
            int maxSize = 0;
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!list.contains(c)) {
                    list.add(c);
                    if (list.size() > maxSize) {
                        maxSize = list.size();
                    }
                } else {
                    if (list.size() > maxSize) {
                        maxSize = list.size();
                    }
                    //若果发现相同的字符，则清空这个字符及这个字符之前的字符
                    int index = list.indexOf(c);
                    for (int j = 0; j <= index; j++) {
                        list.remove(0);
                    }
                    list.add(c);
                }
            }
            return maxSize;
        }
        return 0;
    }
}
