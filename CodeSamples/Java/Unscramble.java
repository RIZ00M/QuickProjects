public class Unscramble {
    private String sentence;
    private String[] words;

    public Unscramble(String sentence) {
        this.sentence = sentence;
        this.words = sentence.split(" ");
    }

    public String unscrambleSentence() {
        String decrypted = "";
        // From the start of the words to the end
        for (int i = 0; i < words.length; i++) {
            decrypted += unscrambleWord(words[i]) + " ";
        }
        return decrypted.trim();
    }

    public String unscrambleWord(String word) {
        String reversed = "";
        // For loop going from end of word list to start
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        return reversed;
    }

    // Return size of the word
    public int getWordCount() {
        return words.length;
    }

    public void report() {
    }
}


