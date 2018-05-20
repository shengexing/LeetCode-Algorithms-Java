import java.util.ArrayList;
import java.util.List;

/**
 * 	Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
	(设计一个支持push，pop，top，并在常量时间内检索最小元素的堆栈。)
	
	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	getMin() -- Retrieve the minimum element in the stack.
	
	Example:
	MinStack minStack = new MinStack();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	minStack.getMin();   --> Returns -3.
	minStack.pop();
	minStack.top();      --> Returns 0.
	minStack.getMin();   --> Returns -2.
	
 * @author Time
 *
 */
public class MinStack {
	
	private List<Integer> entry = new ArrayList<>();
	
    public MinStack() {
        
    }
    
    public void push(int x) {
        entry.add(x);
    }
    
    public void pop() {
    	if(entry.size() > 0) entry.remove(entry.size() - 1);
    }
    
    public int top() {
        if(entry.size() > 0) return entry.get(entry.size() - 1);
        return Integer.MIN_VALUE;
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < entry.size(); i++)
        	if(min > entry.get(i)) min = entry.get(i);
        
        return min;
    }

	public static void main(String[] args) {
		 MinStack test = new MinStack();
		 test.push(7);
		 test.pop();
		 int param_3 = test.top();
		 int param_4 = test.getMin();
		 System.out.println("param_3=" + param_3 + ", param_4=" + param_4);
		 
	}

}
