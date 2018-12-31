import java.util.*;
public class ExperimentController
{
    public static void main(String[] args) {
        ExperimentController ec1 = new ExperimentController();
        IntegerContainer ic1 = new IntegerContainer();
        ec1.fillIntegerContainer(Integer.parseInt(args[0]), Integer.parseInt(args[1]), ic1);
        long t1 = ec1.timeToMergeSort(ic1);
        System.out.println("Time to MergeSort: " + t1 + "ns");

        ExperimentController ec2 = new ExperimentController();
        IntegerContainer ic2 = new IntegerContainer();
        ec2.fillIntegerContainer(Integer.parseInt(args[0]), Integer.parseInt(args[1]), ic2);
        long t2 = ec2.timeToHeapSort(ic2);
        System.out.println("Time to HeapSort: " + t2 + "ns");
    }

    public void fillIntegerContainer(int numberOfItems, int seed, IntegerContainer ic) {
        ic.addRandom(numberOfItems, seed);
    }

    public long timeToMergeSort(IntegerContainer ic) {
        long t1 = System.nanoTime();
        ic.mergeSort();
        long t2 = System.nanoTime();
        return t2 - t1;
    }

    public long timeToHeapSort(IntegerContainer ic) {
        long t1 = System.nanoTime();
        ic.heapSort();
        long t2 = System.nanoTime();
        return t2 - t1;
    }
}
