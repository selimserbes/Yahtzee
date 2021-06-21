package homework3;

public class Queue {
	private int rear, front;
	private Object[] elements;

	public Queue(int capacity) {
		elements = new Object[capacity];
		rear = -1;
		front = 0;
	}

	public boolean isEmpty() {
		return rear < front;

	}

	public boolean isFull() {
		return (rear + 1 == elements.length);

	}

	public int size() {
		return (rear - front + 1);
	}

	public void enqueue(Object data) {
		if (isFull()) {
			System.out.println("Queue is full(Enqueue)");
		} else {
			rear++;
			elements[rear] = data;
		}
	}

	public Object dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		} else {
			Object retData = elements[front];
			elements[front] = null;
			front++;
			return retData;
		}

	}

	public Object peek() {
		Object retData = elements[front];
		return retData;

	}
}
