package com.leetcode.learning.rh.search;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。
 *
 * 字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。
 *
 * 注意：子字符串 是字符串中的一个连续字符序列。
 *
 * 示例 1：
 *
 * 输入：s = "ababccc"
 * 输出：5
 * 解释：一种最大拆分方法为 ['a', 'b', 'ab', 'c', 'cc'] 。像 ['a', 'b', 'a', 'b', 'c', 'cc'] 这样拆分不满足题目要求，因为其中的 'a' 和 'b' 都出现了不止一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-a-string-into-the-max-number-of-unique-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Quest1893_N {
    class Solution {
        public int maxUniqueSplit(String s) {
            dfs(s, 0, new HashSet<>());
            return max;
        }
        private int max = 1;
        private void dfs(String s, int start, Set<String> set) {
            if (start == s.length()) {
                max = Math.max(set.size(), max);
                return;
            }
            for (int i = start + 1; i <= s.length(); i++) {
                String sub = s.substring(start, i);
                if (set.contains(sub))
                    continue;
                set.add(sub);
                dfs(s, i, set);
                set.remove(sub);
            }
        }
    }
}
