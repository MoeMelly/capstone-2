import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        BreadType type = promptForEnum(scanner, BreadType.class,"Pick BreadType:");
        BreadSize size = promptForEnum(scanner,BreadSize.class, "Pick")

    }


















    private static <E extends Enum<E>> E promptForEnum(Scanner scanner, Class<E> enumClass, String prompt) {
        E result = null;
         while (result == null) {
             System.out.println(prompt + " " + Arrays.toString(enumClass.getEnumConstants()) + ": ");
             String input = scanner.nextLine().trim().toUpperCase().replace(" ","_");
             try {
                 result = Enum.valueOf(enumClass, input);

            } catch (IllegalArgumentException e) {
                 System.out.println("Invalid input. Please try again.");
             }
        }
         return result;
    }
}
