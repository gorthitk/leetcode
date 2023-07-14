class Solution {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int[] countG = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            count[secret.charAt(i) - '0']++;
            countG[guess.charAt(i) - '0']++;
        }

        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(count[i], countG[i]);
        }

        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                cows--;
            }
        }



        return String.format("%dA%dB", bulls, cows);
    }
}