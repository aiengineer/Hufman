import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import sun.misc.Queue;
public class Huffman {
    
    public static Node[] nodes;
    public static int jj;
    public static int freq =0;
    public static StringBuilder sb = new StringBuilder();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1. encode\n2. decode");
        int a = in.nextInt();
        if (a==1) {
            encode();
        }else{
            decode();
        }
        
    }
    public static void encode() throws InterruptedException{
        System.out.println("enter the string");
        String sin = in.next();
        char[] arr = sin.toCharArray();
        boolean b = true;
        
        // -----------Seperating the String ---------
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < sb.length(); j++) 
                if (sb.charAt(j)==arr[i]) 
                    b=false;
            if (b) 
                sb.append(arr[i]);
            b = true;
        }
        nodes = new Node[sb.length()];
        for (int w = 0; w < sb.length(); w++) {
            nodes[w] = new Node();
        }
        for (int k = 0; k < sb.length(); k++) {
            nodes[k].setName(sb.charAt(k));
            nodes[k].setWieght(0);
            for (int s = 0; s < sin.length(); s++) {
                if (sin.charAt(s)==nodes[k].getName()) {
                    nodes[k].setWieght(nodes[k].getWieght()+1);
                }
            }
            System.out.println(nodes[k].getName() + "  : "+nodes[k].getWieght());
        }
        // -----------End of Seperating the String ---------
        
        makeTree();
        
    }
    public static void decode(){
        System.out.println("enter the binery code");
        
    }
    public static void makeTree() throws InterruptedException{
        PriorityQueue pq = new PriorityQueue();
        Queue<Node> q = new Queue<Node>() ;
        Node[] temp = new Node[sb.length()+1];
        quickSort(nodes, 0, nodes.length-1);
        int l =0;
        for (int i = 0; i < sb.length(); i++) {
            q.enqueue(nodes[i]);
        }
        for (int i = 0; i < sb.length()-1; i++) {
            if (sb.length()%2 == 0) {
            //------Merge and Make Tree------
                Node left = q.dequeue();
                Node right = q.dequeue();
                Node parent = new Node();
                parent.setWieght(left.getWieght() + right.getWieght());
                parent.setLeft(left);
                parent.setRight(right);
                q.enqueue(parent);
            }else{
            //------Merge and Make Tree------
                Node left = q.dequeue();
                Node right = q.dequeue();
                Node parent = new Node();
                parent.setWieght(left.getWieght() + right.getWieght());
                parent.setLeft(left);
                parent.setRight(right);
                q.enqueue(parent);
            }
            
            for (int j = 0; j < sb.length(); j++) {
                jj = j;
                if (q.isEmpty()) {
                    break;
                }
                temp[j] = q.dequeue();
                System.out.print("temp : "+temp[j].getWieght()+"   -"+j+"///");
            }
            quickSort(temp, 0, jj-1);
            quickSort(temp, 0, jj-1);
            
            for (int j = jj-1; j >= 0; j--) {
                q.enqueue(temp[j]);
            }
        }
        
        // ----------------- Print the Tree ----------
         Node pa = q.dequeue();
         //System.out.println(pa.getWieght());
         //pa = q.dequeue();
        while (pa!=null) {
            System.out.print(pa.getWieght()+"   ");
            pa = pa.getLeft();
        }
        
        
    }
    public static void quickSort(Node[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle].getWieght();
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i].getWieght() < pivot) {
				i++;
			}
 
			while (arr[j].getWieght() > pivot) {
				j--;
			}
 
			if (i <= j) {
				Node temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
    
    
}