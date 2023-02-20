public class StackMaker<T> {
    
    public AbstractStack<T> makeStack(int option) {
        AbstractStack<T> newStack;
        
        switch (option) {
            case 1:
                newStack = new StackArrayList<T>();
                break;
            case 2:
                newStack = new StackVector();
                break;
            case 3:
                newStack = new StackSLList();
                break;
            case 4:
                newStack = new StackDLList();
                break;
        }
    }
}
