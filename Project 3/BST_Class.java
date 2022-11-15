/* Assignment 3 BSt
 * Author: Atreya Sridharan (axs2220) 
 * Resources used: Lecture slides and Java Oracle Documentation
 * I would also like to thank my TA Yao Fu for helping me with my doubts 
 */

 /*
  * Creating Node class with objects required for the main BST_Class
  */
class Node {
    int key;
    Node left, right;
    public Node(int data){
        key = data;
        left = right = null;
    }
}
class BST_Class {
    //node class that defines BST node
    // BST root node 
    Node root;
    // Constructor for BST =>initial empty tree
    BST_Class(){
        root = null;
    }
    //delete a node from BST
    // logic followed from insert method
    //Main function is to call recursive function for delete
    void deleteKey(int key) {
        root = delete_Recursive(root, key);
    }
    private Node delete_Recursive(Node root, int key){
        // Base Case
        if(root.left == null && root.right == null){
            root = null;
            return root;
        }
        else{
            //Calling method recursively 
            if(key < root.key){
                root.left = delete_Recursive(root.left, key);
                return root;
            }
            if(key > root.key){
                root.right = delete_Recursive(root.right, key);
                return root;
            }
        }
        // Case 1 and 2 as shown in the lecture slide (No children and One child (respectively))
        if( root.right == null){
            return root.left;
        }
        if(root.left == null){
            return root.right;
        }
        else{
            // Case 3 (Two children), finding inOrder successor (Smallest node in the right subtree)
            Node replacePNode = root;
            Node replace = root.right;
            
            while(replace.left != null){
                replacePNode = replace;
                replace = replace.left;
            }
            root.key = replace.key ;
             root.key = replace.key;
             if( replacePNode != root){
                replacePNode.left = replace.right;
             }
             else{
                replacePNode.right = replace.left;
             }
             return root;
        }
        /* Method to return minValue of tree
         * The minimum value of a BST is the left leaf node of the left subtree of the BST 
         * Calling function to return minimum value of left subtree
         */ 
        }
    int minValue(Node root)  {
        if(root.left == null){
            return root.key;
        }
        else{
            return minValue(root.left);
        }
    }
    // insert a node in BST
    void insert(int key)  {
        root = insert_Recursive(root, key);
    }
    //recursive insert function
    Node insert_Recursive(Node root, int key) {
        //tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }
        //traverse the tree
        if (key < root.key)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key);
        else if (key > root.key)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key);
        // return pointer
        return root;
    }
    
    // Search method if key exists in the tree
    boolean search(int key)  {
      Node ptr = root;
      while (ptr != null){
        if(key < ptr.key){
            ptr = ptr.left;
        }
        else if(key > ptr.key){
            ptr = ptr.right;
        }
        else
        return key == ptr.key;
    }
    return false;
      }
       
    

    //PostOrder Traversal - Left:Right:rootNode (LRn)
    void postOrder(Node node)  {
        if( node == null){
            return;
        }
    // Traverse left subtree recursively
    if(node.left != null){
    postOrder(node.left);
    }
    // Traverse right subtree recursively
    if(node.right != null){
    postOrder(node.right);
    }
    System.out.println(node.key + " ");
    }
    // InOrder Traversal - Left:rootNode:Right (LnR)
    void inOrder(Node node)  {
        if (node == null)
            return;
        //first traverse left subtree recursively
        inOrder(node.left);
        //then go for root node
        System.out.print(node.key + " ");
        //next traverse right subtree recursively
        inOrder(node.right);
    }
    //PreOrder Traversal - rootNode:Left:Right (nLR)
    void preOrder(Node node)  {
  System.out.println(node.key + " ");
    if(node.left != null){
        preOrder(node.left);
    }
    if(node.right != null){
        preOrder(node.right);
    }
    }
    // Wrappers for recursive functions
    void postOrder_traversal()  {
       postOrder(root);    
    }
    void inOrder_traversal() {
        inOrder(root);   }
    void preOrder_traversal() {
        preOrder(root);  }
}
class Main{
    public static void main(String[] args)  {
        //create a BST object
        BST_Class bst = new BST_Class();
        //insert data into BST
        bst.insert(45);
        bst.insert(10);
        bst.insert(7);
        bst.insert(12);
        bst.insert(90);
        bst.insert(50);
        //print the BST
        System.out.println("The BST Created with input data(Left-root-right)");
        bst.inOrder_traversal();
        System.out.println("\n");
        
        //delete leaf node
        System.out.println("The BST after Delete 12(leaf node)");
        bst.deleteKey(12);
        bst.inOrder_traversal();
        System.out.println("\n");

        //delete the node with one child
        System.out.println("The BST after Delete 90 (node with 1 child)");
        bst.deleteKey(90);
        bst.inOrder_traversal();
        System.out.println("\n");

        //delete node with two children  
        System.out.println("The BST after Delete 45 (Node with two children)");
        bst.deleteKey(45);
        bst.inOrder_traversal();
        System.out.println("\n");

        //search a key in the BST
        boolean ret_val = bst.search (50);
        System.out.println("\nKey 50 found in BST: " + ret_val );
        ret_val = bst.search (12);
        System.out.println("Key 12 found in BST: " + ret_val );

        //construct a BST
        BST_Class tree = new BST_Class();
        tree.root = new Node(45);
        tree.root.left = new Node(10);
        tree.root.right = new Node(90);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(12);
        //PreOrder Traversal
        System.out.println("BST => PreOrder Traversal:");
        tree.preOrder_traversal();
        //InOrder Traversal
        System.out.println("\nBST => InOrder Traversal:");
        tree.inOrder_traversal();
        //PostOrder Traversal
        System.out.println("\nBST => PostOrder Traversal:");
        tree.postOrder_traversal();
         
    }
}
