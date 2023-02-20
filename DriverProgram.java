import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class DriverProgram {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        InfixReader reader = new InfixReader();
        String expression = "";
        String convertedExpression;
        Calculator calc;

        int selection = selectStructure(in);

        System.out.println("Leyendo el archivo...");
        try {
            expression = readFile("datos.txt");
        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo, error fatal.");
            System.exit(0);
        }

        convertedExpression = reader.toPostfix(expression);
        calc = Calculator.getInstance(selection);
        int result = calc.calculate(convertedExpression);

        System.out.println("El resultado de la operación " + expression + " es: " + result);

        in.close();
    }

    public static String readFile(String path) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            reader.close();
            return line;
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public static int selectStructure(Scanner in) {
        int opt = 0;
        boolean flag = true;

        System.out.println("Bienvenido al programa de calculadora.");
        while (flag) {
            System.out.println("Seleccione la estructura con la que quiere crear su pila.");
            System.out.println("1. ArrayList");
            System.out.println("2. Vector");
            System.out.println("3. List");
            System.out.println("Realice su selección: ");
            opt = Integer.parseInt(in.nextLine());
            if ((opt < 1) || (opt > 3)) {
                System.out.println("Ingrese un dato entre 1 y 3");
            } else {
                opt = 0;
                flag = false;
            }
        }

        if (opt == 3) {
            flag = true;
        }
        
        while (flag) {
            System.out.println("Seleccione el tipo de lista que quiere usar");
            System.out.println("1. SingleLinked");
            System.out.println("2. DoubleLinked");
            int opt2 = Integer.parseInt(in.nextLine());
            if (opt2 == 1) {
                flag = false;
            } else if (opt2 == 2) {
                opt++;
                flag = false;
            } else {
                System.out.println("Ingrese un número entre 1 y 2");
            }
        }

        return opt;
    }
}
