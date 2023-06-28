class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            boolean isStartVowel = isVowel(words[i].charAt(0));

            StringBuilder newWord = new StringBuilder();
            if (isStartVowel) {
                newWord.append(words[i]);
            } else {
                newWord.append(words[i].substring(1, words[i].length()));
                newWord.append(words[i].charAt(0));
            }

            newWord.append("ma");

            int n = i + 1;
            while (n > 0) {
                newWord.append('a');
                n--;
            }

            sb.append(newWord.toString());
            if (i != words.length - 1) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }


    private boolean isVowel(char ch) {
        return ch == 'a' ||
                ch == 'e' ||
                ch == 'i' ||
                ch == 'o' ||
                ch == 'u' ||
                ch == 'A' ||
                ch == 'E' ||
                ch == 'I' ||
                ch == 'O' ||
                ch == 'U';
    }
}