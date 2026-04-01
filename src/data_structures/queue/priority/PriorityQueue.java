package data_structures.queue.priority;


import java.util.ArrayList;

class PriorityQueue implements IPriorityQueue {

    public void heapify(ArrayList<Integer> hT, int i) {
        int size = hT.size();
        // Find the largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < size && hT.get(l) > hT.get(largest))
            largest = l;
        if (r < size && hT.get(r) > hT.get(largest))
            largest = r;

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            int temp = hT.get(largest);
            hT.set(largest, hT.get(i));
            hT.set(i, temp);

            heapify(hT, largest);
        }
    }

    public void insert(ArrayList<Integer> hT, int newNum) {
        int size = hT.size();
        hT.add(newNum);
        if (size != 0) {
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(hT, i);
            }
        }
    }

    public void deleteNode(ArrayList<Integer> hT, int num) {
        int size = hT.size();
        int i;
        for (i = 0; i < size; i++) {
            if (num == hT.get(i))
                break;
        }

        int temp = hT.get(i);
        hT.set(i, hT.get(size - 1));
        hT.set(size - 1, temp);

        hT.remove(size - 1);
        for (int j = size / 2 - 1; j >= 0; j--) {
            heapify(hT, j);
        }
    }

    public void printArray(ArrayList<Integer> array, int size) {
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<Integer>();
        int size = array.size();

        PriorityQueue h = new PriorityQueue();
        h.insert(array, 3);
        h.insert(array, 4);
        h.insert(array, 9);
        h.insert(array, 5);
        h.insert(array, 2);

        System.out.println("Max-Heap array: ");
        h.printArray(array, size);

        h.deleteNode(array, 4);
        System.out.println("After deleting an element: ");
        h.printArray(array, size);
    }
}
