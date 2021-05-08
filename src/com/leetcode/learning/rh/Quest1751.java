package com.leetcode.learning.rh;

/**
 * 给你一个 events 数组，其中 events[i] = [startDayi, endDayi, valuei] ，表示第 i 个会议在 startDayi 天开始，第 endDayi 天结束，如果你参加这个会议，你能得到价值 valuei 。同时给你一个整数 k 表示你能参加的最多会议数目。
 *
 * 你同一时间只能参加一个会议。如果你选择参加某个会议，那么你必须 完整 地参加完这个会议。会议结束日期是包含在会议内的，也就是说你不能同时参加一个开始日期与另一个结束日期相同的两个会议。
 *
 * 请你返回能得到的会议价值 最大和 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Quest1751 {
    /**
     * class Solution:
     *     def maxValue(self, events: List[List[int]], k: int) -> int:
     *         n = len(events)
     *         events.sort(key = lambda x: x[1])       #按照结束时间升序排列
     *         dp = [[-0x3f3f3f3f for _ in range(k + 1)] for _ in range(n)]
     *         dp[0][0] = 0                #idnex==0 我不参加  累计已经参加0场
     *         dp[0][1] = events[0][2]     #index==0 我参加    累计已经参加1场
     *         for i in range(1, n):
     *             #情况1 index==i 的会议 参加了（一定参加，把前面的挤掉也在所不惜）
     *             L, R = 0, i - 1
     *             while L < R:                    #查找符合条件（L的结束时间 < i的开始时间）的最右端 标准框架之一
     *                 mid = (L + R + 1) >> 1
     *                 if events[mid][1] < events[i][0]:
     *                     L = mid
     *                 else:
     *                     R = mid - 1
     *             if events[L][1] < events[i][0]:
     *                 for j in range(1, k + 1):
     *                     dp[i][j] = max(dp[i][j], dp[L][j-1] + events[i][2])
     *             else:        #只能开i这次会议  前面全挤掉了
     *                 dp[i][1] =  max(dp[i][1], events[i][2])
     *
     *             #情况2：index==i 的会议，一定不参加
     *             for j in range(k + 1):
     *                 dp[i][j] = max(dp[i][j], dp[i-1][j])
     *
     *         res = 0
     *         for j in range(k + 1):
     *             res = max(res, dp[n-1][j])
     *         return res
     *
     * 作者：Hanxin_Hanxin
     * 链接：https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended-ii/solution/c-python3-dper-fen-cha-zhao-ti-su-hen-du-wpda/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
