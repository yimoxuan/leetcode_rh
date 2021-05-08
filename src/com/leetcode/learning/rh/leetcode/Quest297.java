package com.leetcode.learning.rh.leetcode;


import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }


public class Quest297 {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Queue<ArrayList<TreeNode>> queue = new LinkedList<>();
            queue.add(new ArrayList<>(){{add(root);}});
            StringBuffer stringBuffer = new StringBuffer();
            while(!queue.isEmpty()) {
                ArrayList<TreeNode> rowList = queue.poll();
                ArrayList<TreeNode> nextRow = new ArrayList<>();
                for (int i=0; i<rowList.size(); i++) {
                    if (rowList.get(i) == null)
                        stringBuffer.append("#\t");
                    else {
                        stringBuffer.append(rowList.get(i).val);
                        nextRow.add(rowList.get(i).left);
                        nextRow.add(rowList.get(i).right);
                    }
                }
                if (nextRow.size() != 0)
                    queue.add(new ArrayList<>(nextRow));
            }
            stringBuffer.delete(stringBuffer.length()-1, stringBuffer.length());
            return stringBuffer.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<TreeNode> fatherList = new LinkedList<>();
            TreeNode root = null;
            boolean fag = true;
            for (String num : data.split("\t")) {
                if (fatherList.size() == 0) {
                    if (num.equals("#"))
                        return null;
                    root = new TreeNode(Integer.valueOf(num));
                    fatherList.add(root);
                }
                else{
                    if (fag){
                        // 左子树
                        TreeNode father = fatherList.peek();
                        if (!num.equals("#")) {
                            father.left = new TreeNode(Integer.valueOf(num));
                            fatherList.add(father.left);
                        }
                        fag = false;
                    }
                    else{
                        // 柚子树
                        TreeNode father = fatherList.poll();
                        if (!num.equals("#")) {
                            father.right = new TreeNode(Integer.valueOf(num));
                            fatherList.add(father.right);
                        }
                        fag = true;
                    }
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Quest297 quest297 = new Quest297();
        Codec codec = quest297.new Codec();
        System.out.println(codec.deserialize("7\t2\t#"));
    }

}
