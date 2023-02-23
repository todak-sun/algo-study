import java.util.Objects;

public class Solution {
  int temp = 0;

  public TreeNode bstToGst(TreeNode root) {
    if (Objects.nonNull(root.right)) {
      bstToGst(root.right);
    }
    root.val += temp;
    temp = root.val;
    if (Objects.nonNull(root.left)) {
      bstToGst(root.left);
    }
    return root;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}