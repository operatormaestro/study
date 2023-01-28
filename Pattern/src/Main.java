public class Main {
    public static final String TEXT = "aaababaabaaaabaabaabaabaaababaabaaababaabaaaabaabaabaabbabaabaaababaababaabaabaabaaabbaab";
    public static final String PATTERN = "aab";

    public static void main(String[] args) {
        int count = 0;

        for (int i = 0; i < TEXT.length() - 2; i++) {
            String tmp = TEXT.substring(i, i + 3);
            if (tmp.equals(PATTERN)) count++;
        }

        System.out.println("Строка " + PATTERN + " встретилась в тексте " + count + " раз");
    }
}