import java.time.LocalDateTime;

public class SmartLogger implements Logger {
    private static int count = 0;
    //из текста задачи делаю вывод, что номерация ошибок не ведется отдельно, надеюсь я прав.
    @Override
    public void log(String msg) {
        count += 1;
        if (msg.toLowerCase().contains("error")) {
            System.out.println("ERROR#" + count + " " + LocalDateTime.now() + " " + msg);
        } else {
            System.out.println("INFO#" + count + " " + LocalDateTime.now() + " " + msg);
        }
    }
}
