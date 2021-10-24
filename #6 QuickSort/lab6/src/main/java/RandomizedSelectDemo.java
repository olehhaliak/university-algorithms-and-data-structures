import java.util.Arrays;
import java.util.Scanner;

public class RandomizedSelectDemo {

    public static void main(String args[]) {
        RandomizedSelect randomizedSelect = new RandomizedSelect();
        int[] arr = getArrayFromConsole();
        System.out.println("Select statistic to find:");
        int statisticsNum = new Scanner(System.in).nextInt();
        System.out.println("Your statistic is: "+ randomizedSelect.randomizedSelect(arr,statisticsNum));
    }

    public static int[] getArrayFromConsole() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter array elements separated by space : ");
        String[] tokens = scn.nextLine().split(" ");
        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        return arr;
    }
}
