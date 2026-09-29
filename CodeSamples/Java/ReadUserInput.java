import java.util.Scanner;

public class ReadUserInput {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter your name: ");

        String name = scan.nextLine().trim();

        System.out.println("Hello, " + name + "!");
    }
}
