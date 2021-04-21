import java.util.*;
public class DequeTest {
    public static <T> void showDeque(String name, Deque<T> deque) {
        System.out.printf("%s(%d): %s" + 
            System.getProperty("line.separator"),
            name, deque.size(), deque.toString());
    }
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        //LinkedList 可以新建空
        System.out.println(deque);
        showDeque("now deque",deque);
        //add a few elements到队尾
        deque.add("My");
        deque.offer("name");
        deque.addLast("is");
        deque.offerLast("Mark");
        showDeque("add last",deque);
        //add a few elements到队首
        deque.addFirst("Hello");
        deque.offerFirst("eveyone");
        showDeque("add first",deque);
        //delect : remove poll
        deque.pollLast();
        showDeque("poll last",deque);
        deque.pollFirst();
        showDeque("poll first",deque);
        //使deque为完整句子
        deque.offerLast("Alice");
        showDeque("now",deque);

        //removeOccurrence test
        deque.offerLast("name");
        showDeque("now",deque);
        deque.removeFirstOccurrence("name");
        showDeque("removeFirstOccurrence",deque);
        deque.offerFirst("name");
        showDeque("now",deque);
        deque.removeLastOccurrence("name");
        showDeque("removeLastOccurrence",deque);
        //look : get peek
        while (!deque.isEmpty()) {
            String head = deque.peekFirst();
            String tail = deque.peekLast();
            System.out.printf("Head = %s, Tail = %s" +
                System.getProperty("line.separator"),
                head, tail);
            deque.pollFirst();
            deque.pollLast();
        }
        showDeque("now",deque);
    }
}