import java.util.*;
public class IntegerContainer
{
    protected ArrayList<Integer> nums;
    protected ArrayList<Integer> copy;

    public IntegerContainer() { //creates new IntegerContainer
        nums = new ArrayList<Integer>();
    }

    public void addRandom(int num, int seed) { //adds random numbers to nums
        Random random = new Random(seed);
        for(int i = 0; i < num; i++) {
            nums.add(random.nextInt(100 ));
        }
    }

    public void heapSort() { //applies heapsort to arraylist using heap class
        copy = new ArrayList<Integer>();
        Heap h = new Heap();
        for(int i : nums) {
            h.addElement(i);
        }
        h.heapify();
        for(int i = nums.size() - 1; i >= 0; i--) {
            copy.add(0, (int) h.removeElement());
        }
        nums = copy;
    }

    private static <E extends Comparable<? super E>> void percDown(ArrayList<Integer> a, int i, int n ) { //helps with heapsort
        int child;
        int tmp;
        for( tmp = a.get(i); a.get(i * 2) < n; i = child )
        {
            child = a.get(i * 2);
            if(child != n - 1 && a.get(child) - a.get(child + 1) < 0 ) {
                child++;
            }
            if(tmp - a.get(child) < 0 ) {
                a.set(i, a.get(child));
            }
            else {
                break;
            }
        }
        a.set(i, tmp);
    }

    public void mergeSort() { //applies mergesort to nums
        nums = mergeSortRecursion(nums);
    }

    private ArrayList<Integer> mergeSortRecursion(ArrayList<Integer> whole) { //helps with recursion for mergesort
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        int center;

        if (whole.size() == 1) {    
            return whole;
        } else {
            center = whole.size() / 2;
            for (int i = 0; i < center; i++) {
                left.add(whole.get(i));
            }

            for (int i = center; i < whole.size(); i++) {
                right.add(whole.get(i));
            }

            left  = mergeSortRecursion(left);
            right = mergeSortRecursion(right);

            // Merge the results back together.
            merge(left, right, whole);
        }
        return whole;
    }

    private void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> whole) {// helps with mergesort 
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }

        ArrayList<Integer> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }

        for (int i = restIndex; i < rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
}
