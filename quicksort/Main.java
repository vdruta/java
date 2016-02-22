/**
 * Created by MM on 2016-02-22.
 */
public class Main {
    public static void main(String[] args) {
        String[] content = new String[10];
        content[0] = "Johannis1";
        content[1] = "Johannis2";
        content[7] = "Johannis8";
        content[2] = "Johannis3";
        content[4] = "Johannis5";
        content[5] = "Johannis6";
        content[3] = "Johannis4";
        content[6] = "Johannis7";
        content[8] = "Johannis9";
        content[9] = "Johannis0";

        System.out.println("Nesortat:");
        for (int i = 0; i < content.length; i++)
            System.out.println(content[i]);

        Sort.quicksort(content, 0, content.length - 1);

        System.out.println("Sortata:");
        for (int i = 0; i < content.length; i++)
            System.out.println(content[i]);
    }
}
