public class Main {
    public static void main(String[] args) {
        //System.out.println(10 & 2);
        for (int i = 0; i < 12; i++) {
            System.out.println(Integer.toBinaryString((int) Math.pow(2, i)) + " - " + (int) Math.pow( 2, i));
        }
    }
}
