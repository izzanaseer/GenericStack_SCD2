import java.util.Scanner;
class EmptyStackException extends RuntimeException {
    public EmptyStackException(String message) {
        super(message);
    }
}
public class Main {
    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String s) {
        try {
            Float.parseFloat(s.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isString(String s) {
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Stack size: ");
        int size = sc.nextInt();

        genericStack<Object> MyStack = new genericStack<>();
        System.out.println("Enter Stack Values");
        for(int count=0 ;count<size; count++)
        {
            try {
                String input = sc.next();
                Object value;
                if (isInteger(input)) {
                    value = Integer.parseInt(input);
                } else if (isFloat(input)) {
                    value = Float.parseFloat(input);
                } else if (isString(input)) {
                    value = input;
                } else {
                    throw new InvalidDataTypeException("Invalid input. Please enter a valid integer, float, or string.");
                }
                MyStack.push(value);
            }
            catch (InvalidDataTypeException e) {
                System.out.println(e.getMessage());
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.nextLine();
                count--;
            }
        }

        try {
            System.out.println("Popped: " + MyStack.pop());
            System.out.println("Popped: " + MyStack.pop());
        } catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Stack Size: " + MyStack.size());

        if(MyStack.isEmpty() == true)
        {
            System.out.println("Stack is Empty");
        }
        else {
            System.out.println("Stack is not Empty");
        }
    }
}