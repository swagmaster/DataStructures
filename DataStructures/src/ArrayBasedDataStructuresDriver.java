

public class ArrayBasedDataStructuresDriver {
	
	public static void main(String[] args) {
		System.out.println("Now testing ArrayLists: ");
		arrayListTests();
		
		System.out.println("Now testing Queues: ");
		queueTests();
		
		System.out.println("Now testing Stacks: ");
		stackTests();	
	}
	
	private static void arrayListTests() {
		//todo: make more tests here
		ArrayList a = new ArrayList();
		a.insert('B', 0);
		a.insert('a', 1);
		a.insert('t', 2);
		a.insert('S', 3);
		a.remove(2);
		System.out.println(a.getIndexOf('a'));	
		//a.insert('F', 10); //Should produce an 'index out of bounds'
		System.out.println("List: " + a.toString());
		while(a.isEmpty() == false) {
			System.out.println(a.remove(0));
		}
		System.out.println();
	}
	
	private static void queueTests() {
		//todo: make more tests here
		Queue a = new Queue();
		a.enqueue('B');
		a.enqueue('a');
		a.enqueue('t');
		a.enqueue('T');
		a.dequeue();
		System.out.println(a.toString());
		
		while(a.isEmpty() == false) {
			System.out.println(a.dequeue());
		}
		System.out.println();
	}
	
	private static void stackTests() {
		//todo: make more tests here
		Stack a = new Stack();
		a.push('B');
		a.push('a');
		a.push('t');
		a.push('F');
		a.push('1');
		a.pop();
		
		System.out.println(a.toString());
		
		while(a.isEmpty() == false) {
			System.out.println(a.pop());
		}
		System.out.println();
	}
}