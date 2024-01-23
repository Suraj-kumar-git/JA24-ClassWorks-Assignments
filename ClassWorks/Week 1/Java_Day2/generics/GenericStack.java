package generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericStack<T> implements Iterable<T>{
	private T[] elements;
	private int top;
	
	public GenericStack(int size) {
		elements = (T[]) new Object[size];
		top=-1;
	}
	public void push(T element) {
		elements[++top]=element;
	}
	public T pop() {
		return elements[top--];
	}
	public static <T> void printStack(GenericStack<T> stack) {
	    Iterator<T> itr = stack.iterator();
	    while (itr.hasNext()) {
	        System.out.print(itr.next()+", ");
	    }
	}

	
	public static void main(String[] args) {
		GenericStack<Integer> stackInt = new GenericStack<>(10);
		stackInt.push(45);
		stackInt.push(59);
		stackInt.push(75);
		stackInt.push(40);
		stackInt.push(4);
		stackInt.push(5);
		System.out.println("Integer Elements of Stack:");
		printStack(stackInt);
		
		GenericStack<Double> stackDouble = new GenericStack<>(10);
		stackDouble.push(34.23);
		stackDouble.push(30.23);
		stackDouble.push(4.23);
		stackDouble.push(3.23);
		stackDouble.push(34.3);
		stackDouble.push(34.2);
		System.out.println("\n\nDouble Elements of Stack:");
		printStack(stackDouble);
		
		GenericStack<String> stackString = new GenericStack<>(10);
		stackString.push("Suraj");
		stackString.push("Kumar");
		stackString.push("Sidhi");
		stackString.push("Ayushi");
		stackString.push("Aanchal");
		stackString.push("Muskan");
		System.out.println("\n\nString Elements of Stack:");
		printStack(stackString);
		
	}
	@Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = top;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elements[currentIndex--];
            }
        };
    }
}