package data_structures.queue.circular;


public class CircularQueue implements ICircularQueue{
    int SIZE = 5;
    int front, rear;
    int[] items = new int[SIZE];

    CircularQueue() {
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        if (front == 0 && rear == SIZE - 1) return true;
        return front == rear + 1;
    }

    @Override
    public int size() {
        if (isEmpty()) return 0;
        // General formula for circular distance
        return ((rear - front + SIZE) % SIZE) + 1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public void clear() {
        front = -1;
        rear = -1;
        System.out.println("Queue cleared.");
    }

    public void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % SIZE;
            items[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    public int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (-1);
        } else {
            element = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } /* Q has only one element, so we reset the queue after deleting it. */
            else {
                front = (front + 1) % SIZE;
            }
            return (element);
        }
    }

    public void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front -> " + front);
            System.out.println("Items -> ");
            for (i = front; i != rear; i = (i + 1) % SIZE)
                System.out.print(items[i] + " ");
            System.out.println(items[i]);
            System.out.println("Rear -> " + rear);
        }
    }
}
