//package com.leetcode.learning.rh;
//
//import java.util.ArrayList;
//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.List;
//
//
//public class BinaryTreeTraversalTest {
// 	// junit	4.12
//	public void testPreorderTraverse() {
//		TreeNode treeNode = TreeNode.buildTree(new Integer[] { 1, 2, 7, 3, 4, null, 8, null, null, 5, 6, 9 });
//
//		List<Integer> traversal = preorderMorrisTraversal(treeNode);
//		System.out.println("preorderMorrisTraversal\t\t" + traversal);
//
//		traversal = preorderChrootTraversal(treeNode);
//		System.out.println("preorderChrootTraversal\t\t" + traversal);
//
//		traversal = preorderTwoStackTraversal(treeNode);
//		System.out.println("preorderTwoStackTraversal\t" + traversal);
//
//		System.out.println("------------------------------");
//
//		traversal = inorderMorrisTraversal(treeNode);
//		System.out.println("inorderMorrisTraversal\t\t" + traversal);
//
//		traversal = inorderChrootTraversal(treeNode);
//		System.out.println("inorderChrootTraversal\t\t" + traversal);
//
//		traversal = inorderTwoStackTraversal(treeNode);
//		System.out.println("inorderTwoStackTraversal\t" + traversal);
//
//		System.out.println("------------------------------");
//
//		traversal = postorderMorrisTraversal(treeNode);
//		System.out.println("postorderMorrisTraversal\t" + traversal);
//
//		traversal = postorderChrootTraversal(treeNode);
//		System.out.println("postorderChrootTraversal\t" + traversal);
//
//		traversal = postorderTwoStackTraversal(treeNode);
//		System.out.println("postorderTwoStackTraversal\t" + traversal);
//
//		traversal = postorderReverseTraversal(treeNode);
//		System.out.println("postorderReverseTraversal\t" + traversal);
//	}
//
//	public List<Integer> preorderMorrisTraversal(TreeNode root) {
//		LinkedList<Integer> res = new LinkedList<>();
//		if (root == null) {
//			return res;
//		}
//
//		TreeNode node = root;
//		while (node != null) {
//			if (node.left != null) { // 左节点不为空，找到前驱节点后构建到本节点的回溯关系（该关系保存在前驱节点空闲的右指针中）
//				TreeNode predecessor = node.left;
//				while ((predecessor.right != null) && (predecessor.right != node)) {
//					predecessor = predecessor.right;
//				} // 找到当前节点在中序遍历结果中的前驱节点
//
//				if (predecessor.right == null) { // 左节点不为空，但是前驱节点的回溯关系还没建立
//					res.add(node.val); // 由于是先序遍历，在构建关系的这里visit访问节点信息
//					predecessor.right = node;
//					node = node.left;
//				} else { // predecessor.right不为null，说明当前节点是回溯到这里的，该访问右边了，并将predecessor的状态改回去
//					predecessor.right = null;
//					node = node.right;
//				}
//			} else { // 没有左节点，可以直接访问当前节点。然后切换到右节点（这里的右节点也可能是回溯的节点）
//				res.add(node.val);
//				node = node.right;
//			}
//		}
//		return res;
//	}
//
//	public List<Integer> preorderChrootTraversal(TreeNode root) {
//		List<Integer> res = new LinkedList<Integer>();
//		Deque<TreeNode> stack = new LinkedList<TreeNode>();
//		TreeNode node = root;
//		while (node != null || !stack.isEmpty()) {
//			while (node != null) {
//				res.add(node.val);
//				stack.push(node);
//				node = node.left;
//			}
//			node = stack.pop();
//			node = node.right;
//		}
//		return res;
//	}
//
//	public List<Integer> preorderTwoStackTraversal(TreeNode root) {
//		List<Integer> result = new LinkedList<>();
//		Deque<TreeNode> mainStack = new LinkedList<TreeNode>();
//		Deque<TreeNode> unvisitedStack = new LinkedList<TreeNode>();
//		mainStack.push(root);
//		while (!mainStack.isEmpty()) {
//			TreeNode node = mainStack.peek();
//			unvisitedStack.push(node);
//			while (!mainStack.isEmpty() && mainStack.peek() == unvisitedStack.peek()) {
//				unvisitedStack.pop();
//				TreeNode visitNode = mainStack.pop();
//				result.add(visitNode.val);
//			}
//			// 上面的while循环等价于下面的代码，因此先序遍历在不change root的情况下只需要一个栈即可
//			// TreeNode node = mainStack.pop();
//			// result.add(node.val);
//			if (node.right != null) {
//				mainStack.push(node.right);
//			}
//			if (node.left != null) {
//				mainStack.push(node.left);
//			}
//
//		}
//		return result;
//	}
//
//	public List<Integer> inorderMorrisTraversal(TreeNode root) {
//		LinkedList<Integer> res = new LinkedList<>();
//		if (root == null) {
//			return res;
//		}
//
//		TreeNode node = root;
//		while (node != null) {
//			if (node.left != null) { // 左节点不为空，找到前驱节点后构建到本节点的回溯关系（该关系保存在前驱节点空闲的右指针中）
//				TreeNode predecessor = node.left;
//				while ((predecessor.right != null) && (predecessor.right != node)) {
//					predecessor = predecessor.right;
//				} // 找到当前节点在中序遍历结果中的前驱节点
//
//				if (predecessor.right == null) { // 左节点不为空，但是前驱节点的回溯关系还没建立
//					predecessor.right = node;
//					node = node.left;
//				} else { // predecessor.right不为null，说明当前节点是回溯到这里的，该访问右边了，并将predecessor的状态改回去
//					res.add(node.val); // 由于是中序遍历，在回溯的这里visit访问节点信息
//					predecessor.right = null;
//					node = node.right;
//				}
//			} else { // 没有左节点，可以直接访问当前节点。然后切换到右节点（这里的右节点也可能是回溯的节点）
//				res.add(node.val);
//				node = node.right;
//			}
//		}
//		return res;
//	}
//
//	public List<Integer> inorderChrootTraversal(TreeNode root) {
//		List<Integer> res = new LinkedList<Integer>();
//		Deque<TreeNode> stack = new LinkedList<TreeNode>();
//		TreeNode node = root;
//		while (node != null || !stack.isEmpty()) {
//			while (node != null) {
//				stack.push(node);
//				node = node.left;
//			}
//			node = stack.pop();
//			res.add(node.val);
//			node = node.right;
//		}
//		return res;
//	}
//
//	public List<Integer> inorderTwoStackTraversal(TreeNode root) {
//		List<Integer> result = new LinkedList<>();
//		if (root == null) {
//			return result;
//		}
//		Deque<TreeNode> mainStack = new LinkedList<TreeNode>();
//		Deque<TreeNode> unvisitedStack = new LinkedList<TreeNode>();
//		mainStack.push(root);
//		while (!mainStack.isEmpty()) {
//			TreeNode node = mainStack.peek();
//			unvisitedStack.push(node);
//			if (node.left != null) {
//				mainStack.push(node.left);
//			}
//			while (!mainStack.isEmpty() && mainStack.peek() == unvisitedStack.peek()) {
//				unvisitedStack.pop();
//				TreeNode visitNode = mainStack.pop();
//				result.add(visitNode.val);
//				if (visitNode.right != null) {
//					mainStack.push(visitNode.right);
//				}
//			}
//		}
//		return result;
//	}
//
//	public List<Integer> postorderMorrisTraversal(TreeNode root) {
//		List<Integer> res = new ArrayList<Integer>();
//		if (root == null) {
//			return res;
//		}
//
//		TreeNode node = root;
//		while (node != null) {
//			TreeNode predecessor = node.left;
//			if (predecessor != null) {
//				while (predecessor.right != null && predecessor.right != node) {
//					predecessor = predecessor.right;
//				}
//				if (predecessor.right == null) {
//					predecessor.right = node;
//					node = node.left;
//					continue;
//				} else {
//					predecessor.right = null;
//					addPath(res, node.left);
//				}
//			}
//			node = node.right;
//		}
//		addPath(res, root);
//		return res;
//	}
//
//	private void addPath(List<Integer> res, TreeNode node) {
//		List<Integer> tmp = new ArrayList<Integer>();
//		while (node != null) {
//			tmp.add(node.val);
//			node = node.right;
//		}
//		for (int i = tmp.size() - 1; i >= 0; --i) {
//			res.add(tmp.get(i));
//		}
//	}
//
//	public List<Integer> postorderChrootTraversal(TreeNode root) {
//		List<Integer> res = new ArrayList<Integer>();
//		if (root == null) {
//			return res;
//		}
//
//		Deque<TreeNode> stack = new LinkedList<TreeNode>();
//		TreeNode node = root;
//		TreeNode prev = null;
//		while (node != null || !stack.isEmpty()) {
//			while (node != null) {
//				stack.push(node);
//				node = node.left;
//			}
//			node = stack.peek(); // 只是瞄一眼栈顶的元素
//			if (node.right == null || node.right == prev) { // 如果没有右节点，或者右节点刚刚已经访问过了
//				stack.pop(); // 当前节点需要处理，因此可以出栈了
//				res.add(node.val);
//				prev = node;
//				node = null;
//			} else { // 右节点还没访问，当前节点继续留在栈中，指针转到右节点，进入下一轮
//				node = node.right;
//			}
//		}
//		return res;
//	}
//
//	public List<Integer> postorderTwoStackTraversal(TreeNode root) {
//		List<Integer> result = new LinkedList<>();
//		Deque<TreeNode> mainStack = new LinkedList<TreeNode>();
//		Deque<TreeNode> unvisitedStack = new LinkedList<TreeNode>();
//		mainStack.push(root);
//		while (!mainStack.isEmpty()) {
//			TreeNode node = mainStack.peek();
//			unvisitedStack.push(node);
//			if (node.right != null) {
//				mainStack.push(node.right);
//			}
//			if (node.left != null) {
//				mainStack.push(node.left);
//			}
//			while (!mainStack.isEmpty() && mainStack.peek() == unvisitedStack.peek()) {
//				unvisitedStack.pop();
//				TreeNode visitNode = mainStack.pop();
//				result.add(visitNode.val);
//			}
//
//		}
//		return result;
//	}
//
//	public List<Integer> postorderReverseTraversal(TreeNode root) {
//		Deque<TreeNode> stack = new LinkedList<>();
//		LinkedList<Integer> output = new LinkedList<>();
//		if (root == null) {
//			return output;
//		}
//
//		stack.push(root);
//		while (!stack.isEmpty()) {
//			TreeNode node = stack.pop();
//			output.addFirst(node.val); // 迭代式后序遍历就是在此处完成reverse操作！
//			if (node.left != null) {
//				stack.push(node.left);
//			}
//			if (node.right != null) {
//				stack.push(node.right);
//			}
//		}
//		return output;
//	}
//}
