package org.pg4200.ex05;

import org.pg4200.les05.MyMapBinarySearchTree;

public class BinaryTreeLeftMaxDelete<K extends Comparable<K>, V>  extends MyMapBinarySearchTree<K, V> {

    @Override
    protected TreeNode delete(K key, TreeNode subtreeRoot) {
        if (subtreeRoot == null) return null;

        int cmp = key.compareTo(subtreeRoot.key);

        if (cmp < 0) {
            subtreeRoot.left = delete(key, subtreeRoot.left);
            return subtreeRoot;
        }
        if (cmp > 0) {
            subtreeRoot.right = delete(key, subtreeRoot.right);
            return subtreeRoot;
        }

        size--;

        if (subtreeRoot.left == null) return subtreeRoot.right;
        if (subtreeRoot.right == null) return subtreeRoot.left;


        TreeNode tmp = subtreeRoot;
        subtreeRoot = max(tmp.left);
        subtreeRoot.left = deleteMax(tmp.left);
        subtreeRoot.right = tmp.right;


        return subtreeRoot;
    }

    private TreeNode max(TreeNode subtreeRoot) {
        if (subtreeRoot.right == null) return subtreeRoot;

        return max(subtreeRoot.right);
    }

    private TreeNode deleteMax(TreeNode subtreeRoot) {
        if (subtreeRoot.right == null) return subtreeRoot.left;

        subtreeRoot.right = deleteMax(subtreeRoot.right);

        return subtreeRoot;
    }
}
