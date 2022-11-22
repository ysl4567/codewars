import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CaesarCipher {
  public static List<String> movingShift(String s, int shift) {

        List<Character> result = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
            if (shift == 26) shift = 0;

            if (!Character.isLetter(c)) {
                result.add(c);
                shift++;
                continue;
            }
            if ((c + shift > 90 && Character.isUpperCase(c)) || (c + shift > 122 && Character.isLowerCase(c))) {
                c += shift - 26;
                result.add(c);
            } else {
                c += shift;
                result.add(c);
            }
            shift++;
        }

        int length = result.size();
        int subLength = length / 5;
        int subLengthLast = subLength;
        if (length % 5 != 0) {
            ArrayList<Integer> reminders = new ArrayList<>();
            for (int i = 1; i <= length / 4; i++) {
                int temp = length % (4 * i);
                if (i >= temp) reminders.add(temp);
            }
            subLengthLast = Collections.max(reminders);
            subLength = (length - subLengthLast) / 4;
        }

        ArrayList<String> toReturn = new ArrayList<>();
        int count = 1;
        StringBuilder builder = new StringBuilder();
        for (Character aResult : result) {
            builder.append(aResult);
            if (builder.toString().length() == subLength && count < 5) {
                toReturn.add(builder.toString());
                builder = new StringBuilder();
                count++;
            }
            if (count == 5 && builder.toString().length() == subLengthLast) {
                toReturn.add(builder.toString());
            }
        }
        return toReturn;
    }

    public static String demovingShift(List<String> s, int shift) {
        StringBuilder builder = new StringBuilder();

        for (String subStrings : s) {
            builder.append(subStrings);
        }
        char[] temp = builder.toString().toCharArray();
        builder = new StringBuilder();

        for (char c : temp) {
            if (shift == 26) shift = 0;

            if (!Character.isLetter(c)) {
                builder.append(c);
                shift++;
                continue;
            }

            if ((c - shift < 65 && Character.isUpperCase(c)) || (c - shift < 97 && Character.isLowerCase(c))) {
                c = (char) (c - shift + 26);
                builder.append(c);
            } else {
                c -= shift;
                builder.append(c);
            }
            shift++;
        }
        return builder.toString();
    }

}
