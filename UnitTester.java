import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnitTester {
    Calculator myCalc = Calculator.getInstance(1);
    AbstractStack<Integer> myStack = new StackSLList<>();

    @Test
    void TC1_Operation1() {
        int result = myCalc.calculate("1+3+5");
        assertEquals(9, result);
    }

    @Test
    void TC2_Operation2() {
        int result = myCalc.calculate("(1+2)*9");
        assertEquals(27, result);
    }

    @Test
    void TC3_AddingToStackUsingSLList() {
        myStack.push(1);
        myStack.push(6);
        myStack.push(9);
        assertEquals(9, myStack.pull());
    }

}
