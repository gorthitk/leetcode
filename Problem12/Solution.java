class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int thousands = num / 1000;
        while (thousands-- > 0) {
            sb.append('M');
        }
        num = num % 1000;

        sb.append(getRoman(num / 100, 'C', 'D', 'M'));
        num = num % 100;

        sb.append(getRoman(num / 10, 'X', 'L', 'C'));
        num = num % 10;

        sb.append(getRoman(num, 'I', 'V', 'X'));

        return sb.toString();
    }


    private static String getRoman(int count, char lesser, char fiver, char ten) {
        StringBuilder sb = new StringBuilder();

        if (count == 0) {
            return sb.toString();
        }

        if (count < 4) {
            while(count-- > 0) {
                sb.append(lesser);
            }
            return sb.toString();
        }

        if (count == 4) {
            return sb.append(lesser).append(fiver).toString();
        }

        if (count == 5) {
            return sb.append(fiver).toString();
        }

        if (count < 9){
            sb.append(fiver);
            while(count-- > 5) {
                sb.append(lesser);
            }
            return sb.toString();
        }

        // count = 9.
        return sb.append(lesser).append(ten).toString();
    }
}