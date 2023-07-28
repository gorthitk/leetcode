class Solution {
    private static final String START_BOLD = "<b>";
    private static final String END_BOLD = "</b>";

    public String addBoldTag(String s, String[] words) {
        int n = s.length();
        char[] arr = s.toCharArray();

        boolean[] isBold = new boolean[n];

        for (String word : words) {
            int start = s.indexOf(word);
            while (start != -1) {
                for (int i = start; i < start + word.length(); i++) {
                    isBold[i] = true;
                }

                start = s.indexOf(word, start + 1);
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (isBold[i] && (i == 0 || !isBold[i - 1])) {
                sb.append(START_BOLD);
            }

            sb.append(arr[i]);


            if (isBold[i] && (i == n - 1 || !isBold[i + 1])) {
                sb.append(END_BOLD);
            }
        }


        return sb.toString();

    }
}