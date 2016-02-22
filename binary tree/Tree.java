/**
 * Created by MM on 2016-02-22.
 */
public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return ;
        }

        Node current = root;
        Node parent = null;

        while (current != null){
            parent = current;
            if (newNode.getValue() < current.getValue()) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(newNode);
                    return ;
                }
            }
            else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                    return ;
                }
            }
        }
    }

    public void traverse(Node node){
        if (node != null)
        {
            traverse(node.getLeft());
            node.printNode();
            traverse(node.getRight());
        }
    }

    public void display(){
        traverse(root);
    }

    public boolean deleteNode(int value){
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        //find the node to be deleted
        while (current.getValue() != value){
            parent = current;
            if (current.getValue() > value){
                isLeftChild = true;
                current = current.getLeft();
            }
            else{
                isLeftChild = false;
                current = current.getRight();
            }
            if (current == null){
                return (false);
            }
        }
        //Case 1: node to be deleted has no children
        if (current.getLeft() == null && current.getRight() == null){
            if (current == root){
                root = null;
            }
            if (isLeftChild == true)
                parent.setLeft(null);
            else
                parent.setRight(null);
        }
        //Case 2 : node to be deleted has only one child
        else if (current.getRight() == null){
            if (current == root)
                root = current.getLeft();
            else if (isLeftChild)
                parent.setLeft(current.getLeft());
            else
                parent.setRight(current.getLeft());
        }
        else if (current.getLeft() == null){
            if (current == root)
                root = current.getRight();
            else if (isLeftChild)
                parent.setLeft(current.getRight());
            else
                parent.setRight(current.getRight());
        }
        else if (current.getLeft() != null && current.getRight() != null){
            Node successor = getSuccessor(current);

            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.setLeft(successor);
            else
                parent.setRight(successor);
            successor.setLeft(current.getLeft());
        }
        return (true);
    }

    public Node getSuccessor(Node deleteNode){
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.getRight();
        while (current != null){
            successorParent = current;
            successor = current;
            current = current.getLeft();
        }
        if (successor != deleteNode.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(deleteNode.getRight());
        }
        return (successor);
    }
}