public class CountUpTo {
    public static void main(String[] args) {
        countUpTo(1, 10);
    }
    public static void countUpTo(int int1, int int2) {

        if(int2 >= int1) {
            System.out.print(int1);
            countUpTo(int1 + 1, int2);
        }
    }
}
