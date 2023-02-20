import java.util.ArrayList;

public class InfixReader {
    
    public String toPostfix(String s) {
        String[] unordered = s.split("");
        AbstractStack<String> sorting = new StackArrayList<>();
        AbstractStack<String> temp = new StackArrayList<>();
        ArrayList<String> ordered = new ArrayList<>();
        String result;
        for (String c : unordered) {
            if (checkNum(c)) {
                sorting.push(c);
            } else {
                if (c.equals(")")) {
                    while (!temp.peek().equals("(")) {
                        sorting.push(temp.pull());
                    }
                    temp.pull();
                } else {
                    temp.push(c);
                }
            }
        }

        while (!temp.isEmpty()) {
            sorting.push(temp.pull());
        }

        while (!sorting.isEmpty()) {
            temp.push(sorting.pull());
        }

        while (!temp.isEmpty()) {
            ordered.add(temp.pull());
        }

        StringBuilder sb = new StringBuilder();
        for (String x : ordered) {
            sb.append(x);
        }

        result = sb.toString();

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
}
