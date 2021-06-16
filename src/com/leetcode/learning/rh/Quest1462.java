package com.leetcode.learning.rh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 你总共需要上 n 门课，课程编号依次为 0 到 n-1 。
 *
 * 有的课会有直接的先修课程，比如如果想上课程 0 ，你必须先上课程 1 ，那么会以 [1,0] 数对的形式给出先修课程数对。
 *
 * 给你课程总数 n 和一个直接先修课程数对列表 prerequisite 和一个查询对列表 queries 。
 *
 * 对于每个查询对 queries[i] ，请判断 queries[i][0] 是否是 queries[i][1] 的先修课程。
 *
 * 请返回一个布尔值列表，列表中每个元素依次分别对应 queries 每个查询对的判断结果。
 *
 * 注意：如果课程 a 是课程 b 的先修课程且课程 b 是课程 c 的先修课程，那么课程 a 也是课程 c 的先修课程。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Quest1462 {
    class Solution {
        public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] queries) {
            List<Integer>[] adj = new List[n];
            for (int i = 0; i < n; ++i){
                adj[i] = new ArrayList<>();
            }
            // 建立邻接表、计算入度
            int[] degree = new int[n];
            for (int[] p : pre){
                int from = p[0], to = p[1];
                adj[from].add(to);
                degree[to] += 1;
            }
            Set<Integer>[] memo = new HashSet[n];

            for (int i = 0; i < n; ++i){
                // 只计算入度为0的节点
                if (degree[i] == 0){
                    dfs(i, adj, memo);
                }
            }

            List<Boolean> ret = new ArrayList<>();
            for (int[] q : queries){
                ret.add(memo[q[0]].contains(q[1]));
            }
            return ret;
        }
        private void dfs(int u, List<Integer>[] adj, Set<Integer>[] memo){
            if (memo[u] != null) return;
            memo[u] = new HashSet<>();
            memo[u].add(u);
            // 将子节点的后修课程加入父节点的后修课程
            for (int v : adj[u]){
                dfs(v, adj, memo);
                for (int e : memo[v]){
                    memo[u].add(e);
                }
            }
        }
    }

}
