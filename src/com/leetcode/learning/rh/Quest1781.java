package com.leetcode.learning.rh;

public class Quest1781 {
    class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            int zeroFag = 1;
            boolean [] fags = new boolean[s.length()];
            fags[0] = true;
            for (int i=1; i<minJump; i++) {
                fags[i] = false;
            }
            for (int i=minJump; i<maxJump; i++){
                if (s.charAt(i) == '0'){
                    fags[i] = true;
                }
                if (fags[i-minJump+1])
                    zeroFag += 1;
            }
            for (int i = maxJump; i<s.length(); i++) {
                if(zeroFag != 0 && s.charAt(i) == '0')
                    fags[i] = true;
                if (s.charAt(i-maxJump) == '0' && fags[i-maxJump])
                    zeroFag -= 1;
                if (s.charAt(i-minJump+1) == '0' && fags[i-minJump+1])
                    zeroFag += 1;
            }
            return fags[s.length()-1];

        }
    }

    public static void main(String[] args) {
        Solution solution = new Quest1781().new Solution();
        System.out.println(solution.canReach("011111111101111111111110", 2, 18));
    }
}
