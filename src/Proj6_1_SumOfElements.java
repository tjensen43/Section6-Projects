import java.util.ArrayList;

public class Proj6_1_SumOfElements {
    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(1);
        integerArrayList.add(1);
        integerArrayList.add(1);
        integerArrayList.add(1);
        integerArrayList.add(1);
        integerArrayList.add(1);
        integerArrayList.add(1);
        System.out.println(sumElements(integerArrayList));
    }
    public static int sumElements(ArrayList<Integer> arrayList) {
        int sum = 0;
        for (int i = 0; i < arrayList.size(); i++ ) {
            sum += arrayList.get(i);
        }
        return sum;
    }
}
