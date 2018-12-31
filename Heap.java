import java.util.*;
public class Heap<E extends Comparable<E>>
{
    private ArrayList<E> heapArray; //holds heap elements

    public Heap() { //creates new heap object
        heapArray = new ArrayList<E>();
        heapArray.add(null); 
    }

    public void addElement(E e) { //adds to end of heap
        heapArray.add(e);
    }

    public E removeElement() { //removes maximum item in heap
        E maxItem = heapArray.get(1);
        heapArray.set(1, heapArray.get(heapArray.size() - 1)); 
        percolateDown(1);
        heapArray.remove(heapArray.size() - 1);
        return maxItem;
    }

    public void heapify() { //turns arraylist int maxheap
        for(int i = heapArray.size() / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    private void percolateDown(int x) { //helps with heapify
        int child;
        E tmp = heapArray.get(x);
        for( ; x * 2 <= heapArray.size() - 1; x = child) {
            child = x * 2;
            if(child != heapArray.size() - 1 && heapArray.get(child + 1).compareTo(heapArray.get(child)) > 0) {
                child++;
            }
            if(heapArray.get(child).compareTo(tmp) > 0) {
                heapArray.set(x, heapArray.get(child));
            }
            else {
                break;
            }
        }
        heapArray.set(x, tmp);
    }

    public ArrayList<E> toArray() { //returns the heap
        return heapArray;
    }

    public int getHeapSize() { //returns heap size
        return heapArray.size();
    }
}