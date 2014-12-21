import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String input = keyboard.nextLine();
        System.out.println(pangram(input) ? "pangram" : "not pangram");
    }

    public boolean pangram(String input) {
        return true;
    }
}
