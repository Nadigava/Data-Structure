package binaryTree;

public class BinaryTree {
	
	 Node root = null;
	    
	  public BinaryTree(){}
	       
	  public void insert(int value)
	    {
	        Node node = new Node(value);
	           
	        if(root == null) // si el arbol esta vacio ponemos el nodo en la raiz
	        {
	            root = node;
	        }
	        else
	        {
	            Node temp = root;
	            Node parent = null;
	            boolean left = false;
	               
	            while(temp != null)
	            {
	                parent = temp;
	                   
	                if(value < temp.value)
	                {
	                    temp = temp.left;
	                    left = true;
	                }
	                else
	                {
	                    temp = temp.right;
	                    left = false;
	                }
	                   
	            }
	               
	                temp = node;
	               
	                if(left) parent.left = temp;
	                else parent.right = temp;
	          }
	     }
	       
	        public void deleteNode(int value )
	        {
	            Node node = new Node(value);
	           
	            if(node == null) return; // si el nodo es nulo no hace nada
	            else if(node.value == value) // se compara el nodo
	            {
	               
	            }
	        }
	       
	       
	       
	        public int offSpring(Node node)
	        {
	            return (node.left != null) ? (node.right != null ? 2 : 1) : (node.right != null ? 1 : 0);
	        }
	       
	       
	       
	        public void preOrderPrint(Node node)
	        {
	            if(node != null)
	            {
	                System.out.print(node.toString());
	                preOrderPrint(node.left);
	                preOrderPrint(node.right);
	            }   
	        }
	       
	       
	        public void posOrderPrint(Node node)
	        {
	            if(node != null)
	            {
	                posOrderPrint(node.left);
	                posOrderPrint(node.right);
	                System.out.print(node.toString());
	            }   
	        }
	       
	        public void inOrderPrint(Node node)
	        {
	            if(node != null)
	            {
	                inOrderPrint(node.left);
	                System.out.print(node.toString());
	                inOrderPrint(node.right);
	            }   
	        }
	        
	        
	        public Node search(int value)
	        {
	            Node temp = root;
	            while(temp != null)
	            {
	                if(temp.value == value) return temp; // si el valor es igual se retorna 
	                else
	                {
	                    if(value < temp.value) temp = temp.left; 
	                    else temp = temp.right;
	                }
	            }
	            
	            return null;
	        }
	        
	        public void delete(int value)
	        {
	            Node temp = root;
	            Node parent = root;
	            boolean left = false; // determina si se mueve a la izquierda o derecha
	            
	            while(temp != null)
	            {
	                if(temp.value == value) break;
	                else
	                {
	                    parent = temp;
	                    if(value < temp.value)
	                    {
	                        temp = temp.left;
	                        left = true;
	                    }
	                    else
	                    {
	                        temp = temp.right;
	                        left = false;
	                    }
	                }
	            }
	            
	            if(temp != null)
	            {
	                int counter = this.offSpring(temp); //busqueda del nodo
	                if(counter == 0)
	                {
	                    if(left) parent.left = null;
	                    else parent.right = null;
	                }
	                else
	                {
	                    if(counter == 1)
	                    {
	                        if(temp.left != null)
	                        {
	                            if(left) parent.left = temp.left;
	                            else parent.right = temp.left;
	                        }
	                        else
	                        {
	                            if(left) parent.left = temp.right;
	                            else parent.right = temp.right;
	                        }
	                    }
	                    else
	                    {
	                    	Node less = temp.right; //Para encontrar el hijo mayor de los menores
	                    	Node less_parent = less;
	                    	
	                    	while(less.left != null)
	                    	{
	                    		less_parent = less;
	                    		less = less.left;
	                    	}
	                    	if(!less_parent.equals(less))
	                        {
	                              if(less.right != null)
	                                less_parent.left = less.right;
	                              
	                                less.right = temp.right;
	                        }
	                               
	                    	less.left = temp.left;
	                    	
	                    	if(left)
	                    		parent.left = less;
	                    	else
	                    		parent.right = less;
	                    	
	                    }
	                }
	            }
	        }
	       
	       
	       
	        public static void main(String[] args)
	        {
	           
	            BinaryTree testTree = new BinaryTree();
	            testTree.insert(52);
	            testTree.insert(18);
	            testTree.insert(74);
	            testTree.insert(60);
	            testTree.insert(87);
	            testTree.insert(83);
	            testTree.insert(100);
	            testTree.insert(85);
	            
	            testTree.delete(87);
	            testTree.delete(74);
	            
	            System.out.println("Pre - Orden: " + "\n");
	            testTree.preOrderPrint(testTree.root);
	            
	            System.out.println("In - Orden: "+ "\n");
	            testTree.inOrderPrint(testTree.root);
	            
	            System.out.println("Pos - Orden: "+ "\n");
	            testTree.posOrderPrint(testTree.root);
	            
	            
	               
	        }

}
 

