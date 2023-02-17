public class PasswordChecker {
    private int minLength = 0;
    private int maxRepeats = 0;

    public void setMinLength(int minLength) {
        if (minLength > 0) {
            this.minLength = minLength;
        } else {
            throw new IllegalArgumentException("Минимально допустимая длина пароля должна быть больше нуля.");
        }

    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats > 0) {
            this.maxRepeats = maxRepeats;
        } else {
            throw new IllegalArgumentException("Максимально допустимого количества повторений символа подряд должно быть большне нуля.");
        }
    }

    public boolean verify(String password) {
        if (minLength == 0 && maxRepeats == 0) {
            throw new IllegalStateException("Установите минимально допустимую длину пароля и(или) максимально допустимое количество повторений символа подряд.");
        }
        return password.length() >= minLength && (maxRepeats >= countMaxChar(password));
    }

    private int countMaxChar(String word) {
        int max = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int tmp = 0;
            for (int j = i; j < word.length(); j++) {
                if (c == word.charAt(j)) {
                    tmp++;
                } else {
                    break;
                }
            }
            if (tmp > max) max = tmp;
        }
        return max;
    }
}
