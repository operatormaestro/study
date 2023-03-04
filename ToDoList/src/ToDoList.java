import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private final List<String> list = new ArrayList<>();

    public void addCase(String Case) {
        if (!list.contains(Case)) {
            list.add(Case);
            System.out.println("Добавлено!" + "\n");
        } else {
            System.out.println("Дело с таким названием уже имеется в списке.");
        }
    }

    public void printAllCase() {
        System.out.println("==============================");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        System.out.println("==============================");
    }

    public void deleteByNum(int num) {
        if (num <= list.size()) {
            list.remove(num - 1);
            System.out.println("Удалено!");
        } else System.out.println("Введено некорректное значение пункта списка дел.");
    }

    public void deleteByText(String text) {
        boolean flag = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(text)) {
                list.remove(i);
                System.out.println("Удалено!");
                flag = false;
                break;
            }
        }
        if (flag) System.out.println("Дело с искомым названием не найдено в списке.");
    }

    public void deleteByWord(String word) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(word)) {
                nums.add(i);
            }
        }
        if (nums.size() > 0) {
            for (int i = nums.size() - 1; i >= 0; i--) {
                this.deleteByNum(nums.get(i) + 1);
            }
        } else System.out.println("Заданное ключевое слово не обнаружено в списке дел.");
    }
}