import java.util.Scanner;

public class StringReverse {
    private Scanner scan = new Scanner(System.in);
    private String userString;
    private String[] uncrackedwords;
    private String crackedWords = "";
    private char[] uncrackedLetters;
    private String crackedLetters = "";

    public static void main(String[] args) {
        StringReverse myStringReverser = new StringReverse();
        myStringReverser.start();
    }

    public void start() {
        boolean c = true;
        while (c) {
            getString();
            crackString();
            getReport();
            System.out.println("Continue? Y/N");
            String response = scan.nextLine().strip();
            if (!response.equals("Y")) {
                System.out.println("Terminating, goodbye!");
                c = false;
            }
        }
    }

    public void getString() {
        System.out.println("Please input the string you want to unreverse.");
        String stringInput = scan.nextLine().strip();
        if (stringInput.isEmpty()){
            System.out.println("Empty entry.");
            this.userString = "";
        }
        else {
            this.userString = stringInput;
        }
    }

    public void crackString() {
        // Reset
        this.crackedLetters = "";
        this.crackedWords = "";

        this.uncrackedLetters = this.userString.toCharArray();
        this.uncrackedwords = this.userString.split(" ");

        for (int i = uncrackedLetters.length; i > 0; i--) {
            this.crackedLetters += this.uncrackedLetters[i - 1];
        }

        for (int i = uncrackedwords.length; i > 0; i--) {
            this.crackedWords += this.uncrackedwords[i - 1] + " ";
        }
    }

    public void getReport() {
        System.out.println("Original sentence: " + this.userString);
        System.out.println("Reversed letters: " + this.crackedLetters);
        System.out.println("Reversed Words sentence: " + this.crackedWords);
    }
}
