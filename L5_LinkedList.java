class LLNode {
    public int value;
    public LLNode next;

    LLNode(int value) {
        this.value = value;
        this.next = null;
    }

    LLNode(int value, LLNode next) {
        this.value = value;
        this.next = next;
    }
}

public class L5_LinkedList {
    
    public static void tortoiseHare(LLNode head) {
        LLNode tortoise = head, hare = head;

        while (hare!=null && hare.next!=null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }

        System.out.println(tortoise.value);
        System.out.println(hare.value);
    }


    public static void main(String[] args) {
        LLNode n5 = new LLNode(5);
        LLNode n4 = new LLNode(4, n5);
        LLNode n3 = new LLNode(3, n4);
        LLNode n2 = new LLNode(2, n3);
        LLNode n1 = new LLNode(1, n2);


        tortoiseHare(n1);
    }
}