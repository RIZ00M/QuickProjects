import java.util.Scanner ;

public class StringAnalyzer{
	
    //Array for matching letters as string is analyzed
	private char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'} ;
    //array that holds the frequency of occurences of each letter in its respictive index positon 'a'=0, 'z'=25
    private int[] frequency = new int[26];
	// Hold string data
    Scanner scan = new Scanner(System.in);
    private String stringsample;

    public static void main(String[] args){
        // Instantiating self class so we can make use of the instance variables declared herewith and
        // avoid the need to make more methods in this class static.
        StringAnalyzer myAnalyzer = new StringAnalyzer() ;
        myAnalyzer.start() ;
    }
    
    private void start(){
        // Decomposing the problem into a discrete set of well focussed steps.
        boolean c = true;

        this.getString();
        this.analyzeString();
        this.reportAnalysis();
        System.out.println("Terminating Goodbye.");
    }
	//
	//Your Task - Complete thje following 3 methods as instructed in the spec.
	//1. getString() - Read a string of text from keyboard
    public void getString() {
        System.out.println("Please enter a string: ");
        String inputString = scan.nextLine().toLowerCase();
        this.stringsample = inputString;
    }
	//2. analyzeString() - Perform encryption on the string as required
    public void analyzeString() {
        char[] splitString = this.stringsample.toCharArray();
        for (int i = 0; i < splitString.length; i++) {
            for(int x = 0; x < letters.length; x++ ) {
                if (splitString[i] == letters[x]) {
                    frequency[x] += 1;
                }
            }
        }
    }
	//3. reportAnalysis() - Print the results back to the user on the screen #
    public void reportAnalysis() {
        for (int i = 0; i < letters.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("The occurrence of the letter: " + letters[i] + " occurs: " + frequency[i]);
            }
        }
    }
	// Feel free to declare other variables as needed.
} // End of class StringAnalyser
