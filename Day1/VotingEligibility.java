import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("Are you a citizen? (true/false): ");
        boolean citizen = scanner.nextBoolean();

        if (age >= 18 && citizen) {
            System.out.println("You can vote.");
        } else {
            System.out.println("You cannot vote.");
        }
        scanner.close();
    }
}
