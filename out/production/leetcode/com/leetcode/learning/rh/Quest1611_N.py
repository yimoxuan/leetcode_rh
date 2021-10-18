# 1611. 使整数变为 0 的最少操作次数
# 给你一个整数 n，你需要重复执行多次下述操作将其转换为 0 ：
#
# 翻转 n 的二进制表示中最右侧位（第 0 位）。
# 如果第 (i-1) 位为 1 且从第 (i-2) 位到第 0 位都为 0，则翻转 n 的二进制表示中的第 i 位。
# 返回将 n 转换为 0 的最小操作次数。


class Solution:
    def minimumOneBitOperations(self, n):
        res_natural = 0
        while n > 0:
            res_natural ^= n
            n = n >> 1
        return res_natural  #格雷码所代表的自然数
