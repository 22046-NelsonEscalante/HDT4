public class Calculator {
    
    private static boolean flag = false;
    private static Calculator _calc;
    private AbstractStack<String> myStack;
    
    private Calculator() throws SingletonException {
        flag = true;
    }

    public static Calculator getInstance() {
        if (flag) {
            return _calc;
        } else {
            _calc = new Calculator();
            return _calc;
        }
    }

    public int calculate(String op) {
        int result = 0;
        String[] op2 = op.split("");
        for (String s : op2) {
            if (checkNum(s)) {
                myStack.push(s);
            } else {
                int num1 = Integer.parseInt(myStack.pull());
                int num2 = Integer.parseInt(myStack.pull());
                String res = Integer.toString(operate(num1, num2, s));
                myStack.push(res);
            }
        }

        result = Integer.parseInt(myStack.pull());
        
        return result;
    }

    private boolean checkNum(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private int operate(int num1, int num2, String operator) {
        int res = 0;
        switch (operator) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
        }
        return res;
    }
}
