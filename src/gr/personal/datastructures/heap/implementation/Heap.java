package gr.personal.datastructures.heap.implementation;

import java.lang.reflect.Array;

/**
 * Created by Nicolas on 30/9/2017.
 *
 * This is a Max Heap implementation.
 */
public class Heap {

    private static final int ORIGINAL_ARRAY_SIZE = 10;
    private int[] array = new int[ORIGINAL_ARRAY_SIZE];
    private int lastOccupiedPointer = -1;

    public void insert(int value){
        if(lastOccupiedPointer <0){
            array[++lastOccupiedPointer] = value;
            return;
        }
        if( lastOccupiedPointer >= array.length -1  )
            increaseArray();

        array[++lastOccupiedPointer] = value;
        heapifyUp(lastOccupiedPointer);
    }

    public int extractMax(){
        if(array.length <=0)
            throw new IllegalStateException();

        int extractedValue = array[0];
        swapCells(0, lastOccupiedPointer);
        array[lastOccupiedPointer] = 0;
        lastOccupiedPointer--;
        heapifyDown(0);
        return extractedValue;
    }

    public int[] retrieveArray(){
        return array;
    }

    private void heapifyDown(int currentPointer) {
        while(currentPointer <= lastOccupiedPointer){
            int rightChildPointer = calculateRightChildPointer(currentPointer);
            int leftChildPointer = calculateLeftChildPointer(currentPointer);

            if(rightChildPointer > array.length -1 ||leftChildPointer > array.length -1)
                break;

            int maxChildPointer;
            if(array[leftChildPointer] > array[rightChildPointer] )
                maxChildPointer = leftChildPointer;
            else
                maxChildPointer = rightChildPointer;

            if(array[currentPointer] < array[maxChildPointer])
                swapCells(currentPointer, maxChildPointer);
            else
                break;

            currentPointer = maxChildPointer;
        }
    }

    private void heapifyUp(int currentPointer) {
        while(currentPointer > 0){
            int parentPointer = calculateParentPointer(currentPointer);
            if(array[parentPointer] < array[currentPointer])
                swapCells(parentPointer, currentPointer);
            else
                break;
            currentPointer = parentPointer;
        }
    }

    private int calculateParentPointer(int currentPointer){
        if(currentPointer <0)
            throw new IllegalArgumentException();
        return (currentPointer - 1)/2;
    }

    private int calculateRightChildPointer(int currentPointer){
        if(currentPointer <0)
            throw new IllegalArgumentException();
        return (currentPointer*2)+2;
    }

    private int calculateLeftChildPointer(int currentPointer){
        if(currentPointer <0)
            throw new IllegalArgumentException();
        return (currentPointer*2)+1;
    }

    private void swapCells(int parentPointer, int currentPointer) {
        int temp = array[parentPointer];
        array[parentPointer] = array[currentPointer];
        array[currentPointer] = temp;
    }

    private void increaseArray() {
        int[] clonedArray = new int[array.length*2];
        for (int i = 0; i < array.length; i++) {
            clonedArray[i] = array[i];
        }
        array = clonedArray;
        clonedArray = null;
    }
}