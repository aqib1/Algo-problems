import java.util.Objects;

public class LinkedList<T> {

	private Node<T> start;
	private Node<T> end;
	private int size;

	public LinkedList<T> push(T t) {
		if (Objects.isNull(start)) {
			addFirst(t);
		} else {
			addLast(t);
		}
		++size;
		return this;
	}

	public int size() {
		return size;
	}

	public LinkedList<T> reverseKElementsfromLinkedList(int k) {
		LinkedList<T> reversedLinkedList = new LinkedList<>();
		if (size() == 0) {
			throw new IllegalArgumentException("LinkedList is empty|Null");
		}
		Node<T> temp = end;
		while (!Objects.isNull(temp)) {
			if (k != 0) {
				reversedLinkedList.push(temp.value);
				--k;
			} else {
				reversedLinkedList.addStart(temp.value);
			}
			temp = temp.previous;
		}

		return reversedLinkedList;
	}

	public LinkedList<T> reverseEveryExceptkElement(int k) {
		LinkedList<T> reversedList = new LinkedList<>();
		LinkedList<T> nonChangeAble = new LinkedList<>();
		Node<T> temp = start;
		int counter = 1;
		while (!Objects.isNull(temp)) {
			if (counter % k == 0) {
				nonChangeAble.addStart(temp.value);
			} else {
				reversedList.push(temp.value);
			}
			temp = temp.next;
			counter++;
		}
		return mergeLists(reversedList, nonChangeAble, k);
	}

	private LinkedList<T> mergeLists(LinkedList<T> reversedList, LinkedList<T> nonChangeAble, int k) {
		LinkedList<T> merger = new LinkedList<T>();
		Node<T> reverse = reversedList.end;
		Node<T> nonChange = nonChangeAble.end;
		int counter = 1;
		while (true) {
			if (counter % k == 0) {
				if (!Objects.isNull(nonChange)) {
					merger.addLast(nonChange.value);
					nonChange = nonChange.previous;
				}
			} else {
				if (!Objects.isNull(reverse)) {
					merger.addLast(reverse.value);
					reverse = reverse.previous;
				}
			}
			counter++;
			if (Objects.isNull(nonChange) && Objects.isNull(reverse))
				break;
		}
		return merger;
	}

	public String fifoString() {
		Node<T> temp = start;
		String data = "";
		if (!Objects.isNull(temp))
			data = "[";
		while (!Objects.isNull(temp)) {
			data += temp.value + ", ";
			temp = temp.next;
		}
		if (!data.isEmpty())
			data = data.substring(0, data.length() - 2) + "]";
		return data;
	}

	public LinkedList<T> addStart(T t) {
		if (Objects.isNull(start)) {
			addFirst(t);
			return this;
		}
		start.previous = new Node<>(t);
		start.previous.next = start;
		start = start.previous;
		return this;
	}

	public LinkedList<T> addLast(T t) {
		if (Objects.isNull(end)) {
			addFirst(t);
			return this;
		}
		end.next = new Node<>(t);
		end.next.previous = end;
		end = end.next;
		return this;
	}

	private LinkedList<T> addFirst(T t) {
		start = new Node<>(t);
		start.previous = null;
		end = start;
		return this;
	}

	@Override
	public String toString() {
		Node<T> temp = end;
		String data = "";
		if (!Objects.isNull(temp))
			data = "[";
		while (!Objects.isNull(temp)) {
			data += temp.value + ", ";
			temp = temp.previous;
		}
		if (!data.isEmpty())
			data = data.substring(0, data.length() - 2) + "]";
		return data;
	}

	@SuppressWarnings("hiding")
	class Node<T> {
		private T value;
		private Node<T> next;
		private Node<T> previous;

		public Node() {

		}

		public Node(T value) {
			this.value = value;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public Node<T> getPrevious() {
			return previous;
		}

		public void setPrevious(Node<T> previous) {
			this.previous = previous;
		}
	}
}
