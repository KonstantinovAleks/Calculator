package src;

public class NumHelper {
    public Integer romanToArabic(String romanInput) {
        int res = 0;
        int[] arabic = {10, 9, 5, 4, 1};
        String[] roman = {"X", "IX", "V", "IV", "I"};
        for (int i = 0; i < arabic.length; i++) {
            while (romanInput.indexOf(roman[i]) == 0) {
                res += arabic[i];
                romanInput = romanInput.substring(roman[i].length());
            }
        }
        if (res == 0) throw new NumberFormatException();
        return res;
    }

    public String arabicToRoman(int arabicInput) {
        String res = "";
        int value;
        int[] arabic = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < arabic.length; i++) {
            value = arabicInput / arabic[i];
            for (int j = 0; j < value; j++) {
                res = res.concat(roman[i]);
            }
            arabicInput = arabicInput % arabic[i];
        }
        return res;
    }
}
