import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class UnitTest
{
    @Test
    public void testAddElement() {
        Heap h = new Heap();
        h.addElement("hi");
        h.addElement("bye");
        h.addElement("no");
        int theAns = h.getHeapSize();
        int trueAns = 4;
        assertEquals(theAns, trueAns);
    }

    @Test
    public void testRemoveElement() {
        Heap h = new Heap();
        h.addElement("hi");
        h.addElement("bye");
        h.addElement("no");
        h.removeElement();
        h.removeElement();
        int theAns = h.getHeapSize();
        int trueAns = 2;
        assertEquals(theAns, trueAns);
    }

    @Test
    public void testHeapify() {
        Heap h = new Heap();
        h.addElement(3);
        h.addElement(1);
        h.addElement(4);
        h.heapify();
        ArrayList<Integer> ans = h.toArray();
        int[] theAns = new int[4];
        for(int i = 1; i < 4; i++) {
            theAns[i] = ans.get(i);
        }
        int[] trueAns = {0, 4, 1, 3};
        assertArrayEquals(theAns, trueAns);
    }

    @Test
    public void testAddRandon() {
        IntegerContainer ic = new IntegerContainer();
        ic.addRandom(2, 12345);
        boolean theAns = (ic.nums.get(0) == ic.nums.get(1));
        boolean trueAns = false;
        assertEquals(theAns, trueAns);
    }
    
    @Test
    public void testHeapSort() {
        IntegerContainer ic = new IntegerContainer();
        ic.nums.add(2);
        ic.nums.add(1);
        ic.nums.add(4);
        ic.heapSort();
        int[] theAns = new int[4];
        for(int i = 0; i < 3; i++) {
            theAns[i] = ic.copy.get(i);
        }
        int[] trueAns = {1, 2, 4, 0};
        assertArrayEquals(theAns, trueAns);
    }
    
    @Test
    public void testMergeSort() {
        IntegerContainer ic = new IntegerContainer();
        ic.nums.add(2);
        ic.nums.add(1);
        ic.nums.add(4);
        ic.mergeSort();
        int[] theAns = new int[4];
        for(int i = 0; i < 3; i++) {
            theAns[i] = ic.nums.get(i);
        }
        int[] trueAns = {1, 2, 4, 0};
        assertArrayEquals(theAns, trueAns);
    }
}