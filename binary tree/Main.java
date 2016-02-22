/**
 * Created by MM on 2016-02-22.
 */
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(20);
        tree.insert(15);
        tree.insert(18);
        tree.insert(10);
        tree.insert(25);
        tree.insert(16);
        tree.insert(17);
        tree.insert(84);
        tree.insert(91);

        System.out.println("Create a tree with 9 nodes as 20, 15, 18, 10, 25, 16, 17, 84, 91\n\n");
        System.out.println("Initial tree:");
        tree.display();
        System.out.println("\nDelete node 20 and print the tree:");
        tree.deleteNode(20);
        tree.display();
    }
}
