package main.java.problem_604;

public class Solution {

    static class StringIterator {

        int index;
        int[] frequency;
        String[] occurence, letterArray;
        public StringIterator(String compressedString) {
            this.index = 0;
            this.occurence = compressedString.split("['a-zA-Z']+");
            this.letterArray = compressedString.split("['0-9']+");
            this.frequency = new int[occurence.length];
            int counter=0;
            for(String freq : occurence) {
                frequency[counter] = Integer.parseInt(freq);
                counter++;
            }
        }

        public char next() {
            if(frequency[index] > 0) {
                frequency[index]--;
                return letterArray[index].toCharArray()[0];
            } else {
                index++;
                frequency[index]--;
                return letterArray[index].toCharArray()[0];
            }
        }

        public boolean hasNext() {
            return this.index < this.frequency.length;
        }
    }

    public static void main(String[] args) {
        StringIterator stringIterator = new StringIterator("x6");
    }
}
