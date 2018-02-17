import java.util.Arrays;

public class Tree{
    public int[] result = new int[0];
    public Node root;

    public Tree(){
        this.root = null;
    }


    public void add(int id){
        Node newNode = new Node(id);
        if (root == null){
            root = newNode;
        }
        else {
            Node current = root;
            Node parents = null;
            while(true){
                parents = current;
                if (id < current.data){
                    current = current.left;
                    if (current == null){
                        parents.left = newNode;
                        break;
                    }
                }
                else {
                    current = current.right;
                    if (current == null){
                        parents.right = newNode;
                        break;
                    }
                }
            }
        }
    }

    public void makeArr(Node root){
        if(root != null){
            makeArr(root.left);
            result = Arrays.copyOf(result, result.length + 1);
            result[result.length - 1] = root.data;
            makeArr(root.right);
        }
    }

    public int[] getArray(){
        return result;
    }

    public static void main(String[] args){
        Tree tree = new Tree();
        int[] ori = new int[]{1, 4, 55, 0, 567, 2, 4, 0, 900, -3};
        int summ = 0;
        for (int item: ori){
            tree.add(item);
        }
        tree.makeArr(tree.root);
        int[] res = tree.getArray();

        System.out.print("Result: ");
        for (int i: res){
            summ = summ + i; 
            System.out.print(i + " ");

        }
        summ = summ / res.length;
        System.out.print("\nAvarage:");
        System.out.println(summ);
    }
}