import java.util.*;
public class copy {
   



    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        int[] a={3,5,7,1,9,12,18,7,6};
        for (int i : a) {
            pQueue.add(i);
        }
        System.out.print(pQueue);
    }
}