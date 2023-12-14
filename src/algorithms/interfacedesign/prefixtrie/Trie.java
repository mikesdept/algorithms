package algorithms.interfacedesign.prefixtrie;

import java.util.HashMap;
import java.util.Map;

class Trie {

    private final Letter letter;

    public Trie() {
        letter = new Letter();
    }

    public void insert(String word) {
        insert(word, letter);
    }

    private void insert(String word, Letter letter) {
        if (word.length() == 0) {
            letter.setEnd();
            return;
        }
        char charAtZero = word.charAt(0);
        String newString = word.substring(1);
        if (letter.getLetters().containsKey(charAtZero)) {
            insert(newString, letter.getLetters().get(charAtZero));
        } else {
            Letter newLetter = new Letter(charAtZero);
            letter.addLetter(newLetter);
            insert(newString, newLetter);
        }
    }

    public boolean search(String word) {
        return search(word, letter);
    }

    private boolean search(String word, Letter letter) {
        if (word.length() == 0 && letter.isEnd()) {
            return true;
        } else if (word.length() == 0) {
            return false;
        } else if (!letter.getLetters().containsKey(word.charAt(0))) {
            return false;
        } else {
            return search(word.substring(1), letter.getLetters().get(word.charAt(0)));
        }
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, letter);
    }

    private boolean startsWith(String prefix, Letter letter) {
        if (prefix.length() == 0) {
            return true;
        } else if (!letter.getLetters().containsKey(prefix.charAt(0))) {
            return false;
        } else {
            return startsWith(prefix.substring(1), letter.getLetters().get(prefix.charAt(0)));
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("dog")); // false
        trie.insert("dog");
        System.out.println(trie.search("dog")); // true
        System.out.println(trie.startsWith("app")); // true
        System.out.println(trie.search("app")); // false
        trie.insert("app");
        System.out.println(trie.search("app")); // true
    }

    public static class Letter {

        private final Character character;
        private boolean isEnd;
        private final Map<Character, Letter> letters;

        public Letter() {
            this.character = null;
            this.isEnd = false;
            this.letters = new HashMap<>();
        }

        public Letter(char character) {
            this.character = character;
            this.isEnd = false;
            this.letters = new HashMap<>();
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public void addLetter(Letter letter) {
            this.letters.put(letter.getCharacter(), letter);
        }

        public char getCharacter() {
            return character;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public Map<Character, Letter> getLetters() {
            return letters;
        }

    }

}
