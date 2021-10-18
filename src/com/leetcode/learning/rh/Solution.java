//import java.io.BufferedInputStream;
//import java.io.BufferedWriter;
//import java.io.OutputStreamWriter;
//import java.util.Scanner;
//import java.util.TreeMap;

import com.leetcode.learning.rh.Main;

import javax.print.DocFlavor;
import java.io.BufferedInputStream;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//package com.leetcode.learning.rh;
//
//import org.w3c.dom.Node;
//
//import javax.print.DocFlavor;
//import java.io.BufferedInputStream;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.util.*;
//import java.io.*;
//import java.util.concurrent.*;
//import java.util.concurrent.locks.AbstractQueuedSynchronizer;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//import static java.lang.Math.*;
//
//
//class Trie {
//    private HashMap<Character, Trie> children;
//
//    /** Initialize your data structure here. */
//    public Trie() {
//        children = new HashMap<>();
//    }
//
//    /** Inserts a word into the trie. */
////    public void insert(String word) {
////        Trie temRoot = this;
////        for (char c : word.toCharArray()) {
////            if (temRoot.children.keySet().contains(c)){
////                temRoot = temRoot.children.get(c);
////            }
////            else{
////                temRoot.children.put(c, new Trie());
////                temRoot = temRoot.get(c);
////            }
////        }
////        temRoot.children.put('#', null);
////    }
//
//    /** Returns if the word is in the trie. */
////    public boolean search(String word) {
////        Trie temRoot = this;
////        for (char c : word.toCharArray()) {
////            if (!temRoot.children.keySet().contains(c))
////                return false;
////            temRoot = temRoot.get(c);
////        }
////        if (temRoot.children.keySet().contains('#'))
////            return true;
////        return false;
////    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        Trie temRoot = this;
//        for (char c : prefix.toCharArray()) {
//            if (!temRoot.children.keySet().contains(c))
//                return false;
//            temRoot = temRoot.children.get(c);
//        }
//        return true;
//    }
//}
//
///**
// * Your Trie object will be instantiated and called as such:
// * Trie obj = new Trie();
// * obj.insert(word);
// * boolean param_2 = obj.search(word);
// * boolean param_3 = obj.startsWith(prefix);
// */
//
//
////public class Solution {
////    // alt insert 添加构造方法
////    // alt enter  提示重写
////    public int findMaxForm(String[] strs, int m, int n) {
////        int [][] table = new int[m+1][n+1];
////
////        for(int i = 0; i<strs.length; i++) {
////            int zero_num = 0;
////            for (int index=0; index < strs[i].length(); index++){
////                if (strs[i].charAt(index) == '0')
////                    zero_num += 1;
////            }
////            int one_num = strs[i].length()-zero_num;
////            for (int j = m; j>=zero_num; j--){
////                for (int k= n; k >= one_num; k--){
////                    table[j][k] = max(table[j][k], table[j-zero_num][k-one_num] + 1);
////                }
////            }
////        }
////        return table[m][n];
////    }
////    public int maxTurbulenceSize(int[] arr) {
////
////        if (arr.length == 0){
////            return 0;
////        }
////        int [] bigger = new int[arr.length];
////        int [] smaller = new int[arr.length];
////        Arrays.fill(bigger, 1);
////        Arrays.fill(smaller, 1);
////        int max_res = 1;
////        for (int index = 1; index < arr.length; index++) {
////            if (arr[index] > arr[index-1]) {
////                bigger[index] = smaller[index-1] + 1;
////            }
////            else if (arr[index] < arr[index-1]){
////                smaller[index] = bigger[index-1] + 1;
////            }
////            max_res = max(max(bigger[index], smaller[index]), max_res);
////        }
////        return max_res;
////    }
////
////
////    public static void main(String [] args) {
////
////        Solution solution = new Solution();
////        String[] strs = {"10","0001","111001","1","0"};
////        int []nums = {9,4,2,10,7,8,8,1,9};
////        System.out.println(solution.maxTurbulenceSize(nums));
////
////    }
////}
//
////public class Solution {
////    public Solution() {
////    }
////
////    public String reorganizeString(String S) {
////        HashMap<Character, Integer> hashmap = new HashMap<>();
////        int mid_length = ((S.length() + 1) >> 1) + 1;
////        for (int i = 0; i < S.length(); i++) {
////            if (hashmap.keySet().contains(S.charAt(i)))
////                hashmap.put(S.charAt(i), hashmap.get(S.charAt(i)) + 1);
////            else
////                hashmap.put(S.charAt(i), 1);
////            if (hashmap.get(S.charAt(i)) >= mid_length)
////                return "";
////        }
////        List<Map.Entry<Character, Integer>> mapentry = new ArrayList<>(hashmap.entrySet());
////        Collections.sort(mapentry, (o1, o2)-> {
////            return o2.getValue().compareTo(o1.getValue());
////        });
////        ArrayList<StringBuffer> stringBuffers = new ArrayList<>();
////        for (int i = 0; i < mapentry.get(0).getValue(); i++) {
////            stringBuffers.add(new StringBuffer("" + mapentry.get(0).getKey()));
////        }
////        int index = 0;
////        for (int i = 1; i < mapentry.size(); i++) {
////            for (int j = 0; j < mapentry.get(i).getValue(); j++) {
////                if (index == stringBuffers.size())
////                    index = 0;
////                stringBuffers.get(index++).append(mapentry.get(i).getKey());
////            }
////        }
////        StringBuffer res = new StringBuffer();
////        for (StringBuffer buf: stringBuffers
////             ) {
////            res.append(buf);
////        }
////        return res.toString();
////    }
////
////    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
////        ArrayList<Integer> res = new ArrayList<>();
////        if (k > input.length) {
////            return res;
////        }
////        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
////            @Override
////            public int compare(Integer o1, Integer o2) {
////                return o2.compareTo(o1);
////            }
////        });
////        for (int num :
////                input) {
////            priorityQueue.add(num);
////        }
////        for (int i =0; i < k; i++)
////            res.add(priorityQueue.poll());
////        return res;
////    }
////
////    public boolean isValid (String s) {
////        // write code here
////        Stack<Character> stack = new Stack<>();
////        for (int i = 0; i< s.length(); i++) {
////            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{')
////                stack.push(s.charAt(i));
////            else{
////                if (stack.empty())
////                    return false;
////                char c = stack.pop();
////                if (c == '(' && s.charAt(i) == ')')
////                    continue;
////                else if (c == '[' && s.charAt(i) == ']')
////                    continue;
////                else if (c == '{' && s.charAt(i) == '}')
////                    continue;
////                else
////                    return false;
////            }
////        }
////        return true;
////
////    }
////
////    public static void main(String[] args) {
//////        Solution solution = new Solution();
//////        int [] nums = {4,5,1,6,2,7,3,8};
//////        System.out.println(solution.GetLeastNumbers_Solution(nums,4));
////        Queue<Node> queue = new LinkedList<>();
////        queue.clear();
////        ArrayList<Integer> integers = new ArrayList<>();
////        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
////            int N = scanner.nextInt();
////            int L = scanner.nextInt();
////            if (L == 1)
////                System.out.println(N);
////            while (true) {
////                if (L + L * L > 2 * N) {
////                    System.out.println("No");
////                    break;
////                }
////                if (N % L == 0 && L % 2 == 0) {
////                    L += 1;
////                }
////                else if (L % 2 == 0 && N % L == L /2) {
////                    int mid = N / L;
////                    for (int i = mid - L / 2 + 1; i <= mid + L / 2; i++) {
////                        if (i == mid + L / 2)
////                            System.out.println(i);
////                        else
////                            System.out.print("" + i + " ");
////                    }
////                    break;
////                }
////                else if(L % 2 != 0 && N % L == 0) {
////                    int mid = N / L;
////                    for (int i = mid - L / 2; i <= mid + L / 2; i++) {
////                        if (i == mid + L / 2)
////                            System.out.println(i);
////                        else
////                            System.out.print("" + i + " ");
////                    }
////                    break;
////                }
////                else{
////                    L += 1;
////                }
////        }
////
////    }
////}
////
////class Sigleton {
////    private static Sigleton sigleton;
////
////    private Sigleton getSigleton() {
////        if (sigleton == null)
////            sigleton = new Sigleton();
////        return sigleton;
////    }
////}
//
//
//class TreeNode {
//    public TreeNode(int val) {
//        this.val = val;
//    }
//    int val;
//    TreeNode left = null;
//    TreeNode right = null;
//}
//
//public class Solution {
//    /**
//     *
//     * @param head ListNode类
//     * @param m int整型
//     * @param n int整型
//     * @return ListNode类
//     */
////    public ListNode reverseBetween (ListNode head, int m, int n) {
////        // write code here
////        ListNode newHead = new ListNode(0);
////        ListNode fatherNode = null;
////        ListNode tmpHead = head;
////        ListNode tailNode = null;
////        int count = 1;
////        while(count <= n) {
////            if (count == m-1)
////                fatherNode = tmpHead;
////            if (count < m){
////                tmpHead = tmpHead.next;
////                count += 1;
////                continue;
////            }
////            if (count == m)
////                tailNode = tmpHead;
////
////            ListNode tmpNode = tmpHead.next;
////            tmpHead.next = newHead.next;
////            newHead.next = tmpHead;
////            tmpHead = tmpNode;
////            count += 1;
////        }
////        if (fatherNode != null){
////            fatherNode.next = newHead.next;
////            tailNode.next = tmpHead;
////            return head;
////        }
////        else{
////            tailNode.next = tmpHead;
////            return newHead.next;
////        }
////    }
//
//
//    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
//        // write code here
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        boolean fag = true;
//        ArrayList<TreeNode> oneRow = new ArrayList<>();
//        if (root == null)
//            return new ArrayList<>();
//
//        oneRow.add(root);
//
//        while (true) {
//            ArrayList<TreeNode> tmpRow = new ArrayList<>();
//            ArrayList<Integer> oneRowData = new ArrayList<>();
//            for (int i=0; i<oneRow.size(); i++) {
//                oneRowData.add(oneRow.get(i).val);
//                if (oneRow.get(i).left != null)
//                    tmpRow.add(oneRow.get(i).left);
//                if (oneRow.get(i).right != null)
//                    tmpRow.add(oneRow.get(i).right);
//            }
//            if (fag)
//                res.add(new ArrayList<>(oneRowData));
//            else {
//                Collections.reverse(oneRowData);
//                res.add(new ArrayList<>(oneRowData));
//            }
//            fag = !fag;
//            oneRow = tmpRow;
//            if (oneRow.size() == 0)
//                break;
//        }
//        return res;
//    }
//
//    public int maxProfit (int[] prices) {
//        // write code here
//        int [] res = new int[prices.length];
//        res[0] = prices[0];
//        int max_res = 0;
//        for (int i = 1; i < prices.length; i++) {
//            res[i] = min(res[i-1], prices[i]);
//            if(prices[i] - res[i] > max_res)
//                max_res = prices[i] - res[i];
//        }
//        return max_res;
//    }
//
//    public int countVowelStrings(int n) {
//        if(n == 0)
//            return 1;
//        if (n == 1)
//            return 5;
//        int [][]dp = new int[n+1][5];
//        for (int i=0; i<=n; i ++) {
//            for (int j=0; j<5; j++) {
//                if(j == 0 || i == 0)
//                    dp[i][j] = 1;
//                else{
//                    for (int k = 0; k<=j; k++)
//                        dp[i][j] += dp[i-1][k];
//                }
//            }
//        }
//        return dp[n][4];
//    }
//
//    private static int m = 1000000007;
//
//    private int quikPow(int base, int k) {
//        if (k == 0)
//            return 1;
//        if (k == 1)
//            return base;
//        if (k % 2 == 1){
//            long tmpRes =quikPow(base, k >> 1) % m;
//            tmpRes = (tmpRes * tmpRes) % m;
//            return (int) tmpRes * base % m;
//        }
//        else{
//            long tmpRes =quikPow(base, k >> 1) % m;
//            tmpRes = (tmpRes * tmpRes) % m;
//            return (int)tmpRes;
//        }
//    }
//
//    public int cuttingRope(int n) {
//        // 快速幂
//        if (n <= 2)
//            return 1;
//        if (n <= 3)
//            return 2;
//        if (n % 3 == 0){
//            return quikPow(3, n / 3);
//        }
//        else if(n % 3 == 1) {
//            return 4 * quikPow(3, n / 3 - 1) % m;
//        }
//        else{
//            return 2 * quikPow(3, n / 3) % m;
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.cuttingRope(127));
//    }
//
//}
//
//class Heap {
//    public void heapSort(int [] nums) {
//        int numLength = nums.length;
//        int times = numLength - 1;
//        while (times > 0) {
//            int tmp;
//            for (int i = times >> 1; i >= 0; i--) {
//                int maxIndex = 2 * i;
//                if (2 * i + 1 < numLength && nums[2 * i] < nums[2 * i + 1]) {
//                    maxIndex = 2 * i + 1;
//                }
//                if (nums[i] < nums[maxIndex]) {
//                    tmp = nums[i];
//                    nums[i] = nums[maxIndex];
//                    nums[maxIndex] = tmp;
//                }
//            }
//            tmp = nums[0];
//            nums[0] = nums[times];
//            nums[times] = tmp;
//            times -= 1;
//        }
//        for (int i = 0; i < numLength; i++) {
//            System.out.println(nums[i]);
//        }
//    }
//}
//
//
public class Solution {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(new BufferedInputStream(System.in));
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int [] nums = new int[n];
//        for (int i = 0; i<n; i++)
//            nums[i] = sc.nextInt();
//        int [] table1 = new int[n];
//        int [] table2 = new int[n];
//
//        for (int i=0; i<n; i++) {
//            if (nums[i] % 2){
//
//            }
//        }
//
//        for (int i = 0; i<m; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            int c = sc.nextInt();
//        }
//
//        OutputStreamWriter osr = new OutputStreamWriter(System.out);
//        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
//    }

//    long dfs(int leftNum, int before, int [] nums, int m, int k, int x) {
//        if (leftNum == 0){
//            if (before % x == k)
//                return 1L;
//            return 0L;
//        }
//        long res = 0;
//        if (before == 0) {
//            for (int i : nums)
//                res += dfs(leftNum - 1, i, nums, m, k, x);
//        }
//        else {
//            for (int i : nums){
//                res += dfs(leftNum - 1, i, nums, m, k, x);
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(new BufferedInputStream(System.in));
//        int n, m, k, x;
//        n = sc.nextInt();
//        m = sc.nextInt();
//        k = sc.nextInt();
//        k = sc.nextInt();
//        int [] nums = new int[n];
//
//
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(new BufferedInputStream(System.in));
//        int T, N, K, A, W;
//        T = sc.nextInt();
//        N = sc.nextInt();
//        K = sc.nextInt();
//        ArrayList<Integer> [] nums = new ArrayList[1001];
//        for (int i = 0; i < 1001; i++) {
//
//        }

//        ArrayList<int[]> ints = new ArrayList<>();
//        for (int i=0; i<N; i++) {
//            A = sc.nextInt();
//            W = sc.nextInt();
//            ints.add(new int[]{A, W});
//        }
//        ints.sort(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];
//            }
//        });
//        int mod = 1000000007;
//        Long sum = 0L;
//        for (int i=0; i<N; i++) {
//
//        }
//    }

//    void getRes(HashMap<Integer, Integer> hashMap, ArrayList<ArrayList<Integer>> table, int N, int M) {
//        HashSet<Integer> hashSet = new HashSet<>();
//        ArrayList<Integer> integers = new ArrayList<>();
//        for (int x=0; x<N; x++) {
//            int min_num = -1;
//            HashMap tmpHash = new HashMap<Integer>();
//            for (int y=0; y<M; y++) {
//            while table[y] and table[y][0] in ret_set:
//            table[y] = table[y][1:]
//            if not table[y]:
//            continue
//                    tmp_map[table[y][0]] += 1
//            if map_count[table[y][0]] == tmp_map[table[y][0]]:
//            if not min_num:
//            min_num = table[y][0]
//                else:
//            print("NO")
//            return
//            if not min_num:
//            print("NO")
//            return
//                    ret_set.add(min_num)
//            ret_list.append(min_num)
//            print(" ".join(ret_list))
//
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(new BufferedInputStream(System.in));
//        int T = sc.nextInt();
//        for (int i = 0; i<T; i++) {
//            int N = sc.nextInt();
//            int M = sc.nextInt();
//            HashMap<Integer, Integer> hashCount = new HashMap<Integer, Integer>();
//            ArrayList<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>();
//            for ( int j= 0; j<M; j++) {
//                int c = sc.nextInt();
//                table.add(new ArrayList<>());
//                table.get(j).add(c);
//                hashCount.put(c, hashCount.getOrDefault(c, 0)+1);
//            }
//            getRe
//        }
//
//    }



//    public static void main(String[] args) {
//
//        Integer value1 = 1, value2 = 2;
//
//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                synchronized (value1) {
//                    System.out.println("thread 1 get value1");
//                    try {
//                        sleep(2);
//                        synchronized (value2) {
//                            System.out.println("thread1 get value2");
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//
//        Thread thread2 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    sleep(1);
//                    synchronized (value2) {
//                        System.out.println("thread2 get value2");
//                        synchronized (value1) {
//                            System.out.println("thread2 get value1");
//                        }
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                super.run();
//            }
//        };
//
//        thread1.start();
//        thread2.start();
//    }
    //

//    public int get_res(int[] weights, int w) {
//        int res = 0;
//        for (int i=weights.length-1; i>=0; i--) {
//            if (weights[i] == w + 1)
//                continue;
//            for (int j = i-1; i>=0; i--) {
//                if ((weights[i] + weights[j]) <= w && (weights[i] + weights[j]) % 2 == 0) {
//                    weights[j] = w + 1;
//                    break;
//                }
//            }
//            res += 1;
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(new BufferedInputStream(System.in));
//        Main test = new Main();
//        int T = sc.nextInt();
//        for (int t=0; t<T; t++) {
//            int n = sc.nextInt();
//            int w = sc.nextInt();
//            int[] weights = new int[n];
//            for (int i=0; i<n; i++)
//                weights[i] = sc.nextInt();
//            Arrays.sort(weights);
//            System.out.println();
////            System.out.println(main.get_res(weights, w));
//        }
//
//
//    }


}
