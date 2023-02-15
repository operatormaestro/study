public class Main {
    public static void main(String[] args) {
        SimpleLogger simpleLogger = new SimpleLogger();
        SmartLogger smartLogger = new SmartLogger();
        simpleLogger.log("Test1");
        smartLogger.log("Test2");
        for (int i = 0; i < 10; i++) {
            smartLogger.log("Test " + i);
            simpleLogger.log("SimpleTest " + i);
        }
        smartLogger.log("Test error");
        smartLogger.log("Test Error");
        smartLogger.log("Test ERROR");
    }
}
