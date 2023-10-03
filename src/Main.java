import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Stack size: ");
        int size = sc.nextInt();

        genericStack<Integer> MyStack = new genericStack<>();
        System.out.println("Enter Stack Values");
        for(int count=0 ;count<size; count++)
        {
            int value = sc.nextInt();
            MyStack.push(value);
        }

        System.out.println("Popped: " + MyStack.pop());
        System.out.println("Popped: " + MyStack.pop());

        System.out.println("Stack Size: " + MyStack.size());

        if(MyStack.isEmpty() == true)
        {
            System.out.println("Stack is Empty");
        }
        else {
            System.out.println("Stack is not Empty");
        }

        System.out.println("Program Exited!");
    }
}