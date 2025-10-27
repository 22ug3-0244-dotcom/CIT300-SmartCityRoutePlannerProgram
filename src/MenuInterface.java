import java.util.Scanner;

public class MenuInterface {


    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 7) {
            System.out.println("\n===== SMART CITY ROUTE PLANNER MENU =====");
            System.out.println("1. Add a new location");
            System.out.println("2. Remove a location");
            System.out.println("3. Add a road between locations");
            System.out.println("4. Remove a road");
            System.out.println("5. Display all connections");
            System.out.println("6. Display all locations");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            // check if input is a number
            if (!sc.hasNextInt()) {
                System.out.println("❌ Please enter a valid number!");
                sc.next(); // clear invalid input
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("➡ Adding new location (coming soon)");
                    break;
                case 2:
                    System.out.println("➡ Removing location (coming soon)");
                    break;
                case 3:
                    System.out.println("➡ Adding road (coming soon)");
                    break;
                case 4:
                    System.out.println("➡ Removing road (coming soon)");
                    break;
                case 5:
                    System.out.println("➡ Showing connections (coming soon)");
                    break;
                case 6:
                    System.out.println("➡ Showing all locations (coming soon)");
                    break;
                case 7:
                    System.out.println("👋 Exiting program... Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid choice! Please select 1–7");
            }
        }

        sc.close();
    }
}
