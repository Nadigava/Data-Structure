package binaryTree;

public class Node {
	
	int value;
	
    //Apuntadores
    Node right = null;
    Node left = null;
       
    public Node(int value)
    {
            this.value = value;
        }
       
       
        public String toString()
        {
            return "Value: " + this.value + "\n";
        }
       
        public Node clone()
        {
            return new Node(this.value);
        }
       
       
}
