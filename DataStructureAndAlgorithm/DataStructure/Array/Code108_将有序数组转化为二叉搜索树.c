
/*
平衡二叉树：树的所有结点的左右子树的深度相差不超过1
二叉搜索树：
    若它的左子树不为空，左子树上所有节点的值都小于它的根节点。
    若它的右子树不为空，右子树上所有的节点的值都大于它的根节点。
*/

#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
 }; 

struct TreeNode* helper(int *nums, int left, int right){
    if(left > right){
        return NULL;
    }

    int mid = ((right - left) >> 1) + left;
    struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    root->val = nums[mid];
    root->left = helper(nums, left, mid - 1);
    root->right = helper(nums, mid + 1, right);
    return root;
}

struct TreeNode* sortedArrayToBST(int* nums, int numsSize) {
    return helper(nums, 0, numsSize - 1);
}

void printTree(struct TreeNode* root){
    if(root == NULL){
        return;
    }

    printTree(root->left);
    printf("%d ", root->val);
    printTree(root->right);
}

int main(){

    int arr1[5] = {-10, 2, 5, 8, 12};
    struct TreeNode* root = sortedArrayToBST(arr1, 5);
    printTree(root);
}