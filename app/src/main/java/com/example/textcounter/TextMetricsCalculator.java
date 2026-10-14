package com.example.textcounter;

public class TextMetricsCalculator {

    public int countSentences(String text) {
        int count = 0;

        String[] sentences = text.split("\\.");

        for (String sentence : sentences) {
            if (!sentence.trim().isEmpty()) {
                count++;
            }
        }

        return count;
    }

    public int countWords(String text) {
        int count = 0;
        boolean insideWord = false;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isLetter(currentChar)) {
                if (!insideWord) {
                    count++;
                    insideWord = true;
                }
            } else {
                insideWord = false;
            }
        }

        return count;
    }

    public int countPunctuation(String text) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (currentChar == ' ' ||
                    currentChar == ',' ||
                    currentChar == '.') {
                count++;
            }
        }

        return count;
    }

    public int countNumbers(String text) {
        int count = 0;
        boolean insideNumber = false;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isDigit(currentChar)) {
                if (!insideNumber) {
                    count++;
                    insideNumber = true;
                }
            } else {
                insideNumber = false;
            }
        }

        return count;
    }
}
