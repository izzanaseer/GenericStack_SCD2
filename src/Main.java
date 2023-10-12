import java.util.Scanner;
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
        genericStack<Object> MyStack = new genericStack<>();
        int choice;

        do {
            System.out.println();
            System.out.println("************ Menu **********");
            System.out.println("1. Add()");
            System.out.println("2. Pop()");
            System.out.println("3. isEmpty()");
            System.out.println("4. size()");
            System.out.println("0. Exit");
            System.out.println();
            System.out.print("Input choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Stack size: ");
                    int size = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Stack Values");
                    for (int count = 0; count < size; count++) {
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
                        } catch (InvalidDataTypeException e) {
                            System.out.println(e.getMessage());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                            sc.nextLine();
                            count--;
                        }
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Popped: " + MyStack.pop());
                    }
                    catch (MyEmptyStackException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    if (MyStack.isEmpty()) {
                        System.out.println("Stack is Empty");
                    } else {
                        System.out.println("Stack is not Empty");
                    }
                    break;
                case 4:
                    System.out.println("Stack Size: " + MyStack.size());
                    break;
            }
        }while(choice != 0);
    }
}