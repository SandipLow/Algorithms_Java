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
    private static void LL_traverse(LLNode head) {
        for (LLNode curr=head; curr!=null; curr=curr.next) {
            System.out.print(curr.value);
            System.out.print(" ");
        }

        System.out.println();
    }

    private static int LL_getLength(LLNode head) {
        int ans = 0;

        for (LLNode curr=head; curr!=null; curr=curr.next) {
            ans++;
        }

        return ans;
    }

    public static LLNode revereLL(LLNode head) {
        LLNode prev=null, curr=head, next=curr.next;

        while(true) {
            curr.next = prev;

            if (next==null) break;

            prev = curr;
            curr = next;
            next = next.next;
        }

        return curr;
    }
    
    public static void tortoiseHare(LLNode head) {
        LLNode tortoise = head, hare = head;

        while (hare!=null && hare.next!=null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }

        System.out.println(tortoise.value);
        System.out.println(hare.value);
    }

    public static LLNode cycleDetect(LLNode head) {
        LLNode tortoise = head, hare = head;

        // detect cycle
        while (hare!=null && hare.next!=null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        
            if (hare==tortoise) break;
        }

        if (hare==null || hare.next==null) return null; // Not Cyclic

        // get the cycle point
        tortoise = head;

        while (hare!=tortoise) {
            hare = hare.next;
            tortoise = tortoise.next;    
        }

        return hare;
    }

    public static LLNode getIntersection(LLNode h1, LLNode h2) {
        int diff = LL_getLength(h1) - LL_getLength(h2);

        if (diff < 0) getIntersection(h2, h1);

        while (diff > 0) {
            h1 = h1.next;
            diff--;
        }

        while (h1!=h2) {
            h1 = h1.next;
            h2 = h2.next;
        }

        return h1;
    }

    public static void main(String[] args) {
        LLNode n5 = new LLNode(5);
        LLNode n4 = new LLNode(4, n5);
        LLNode n3 = new LLNode(3, n4);
        LLNode n2 = new LLNode(2, n3);
        LLNode n1 = new LLNode(1, n2);


        LLNode reversed = revereLL(n1);
        LL_traverse(reversed);
    }
}