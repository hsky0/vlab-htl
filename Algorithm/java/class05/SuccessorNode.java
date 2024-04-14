package class05;

public class SuccessorNode {
    public class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int val){
          value = val;
        }
    }
    
    public static Node getSuccessorNode(Node node){
        if(node == null){
            return null;
        }
        if(node.right != null){
            return getLeftMost(node.right);     // 得到右子树的最左边的节点
        } else {        // 无右子树， 得到该节点所属左子树的第一个父节点
            Node parent  = node.parent;
            while(parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    @SuppressWarnings("null")
    public static Node getSuccesorNode2(Node node){
        if(node == null){
            return null;
        }
        if(node.right != null){
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
               node = parent;
               parent = node.parent; 
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node){
        if(node == null){
            return node;
        }

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    public static void main(String[] args) {
        
    }
}
