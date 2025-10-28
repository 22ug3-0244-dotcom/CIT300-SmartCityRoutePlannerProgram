

import java.util.Scanner;

public class SmartCityRoutePlanner {

    public static void main(String[] args) {
        System.out.println("=== SMART CITY ROUTE PLANNER ===\n");


        CityGraph graph = new CityGraph();
        LocationAVLTree tree = new LocationAVLTree();
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
            System.out.print("Enter your choice (1–7): ");

            if (!sc.hasNextInt()) {
                System.out.println("❌ Please enter a valid number!");
                sc.next(); 
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Location ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Location Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();

                    Location loc = new Location(id, name, desc);
                    graph.addLocation(id);
                    tree.insert(loc);
                    break;

                case 2:
                    System.out.print("Enter Location ID to remove: ");
                    String removeId = sc.nextLine();
                    graph.removeLocation(removeId);
                    
                    break;

                case 3:
                    System.out.print("Enter From Location ID: ");
                    String from = sc.nextLine();
                    System.out.print("Enter To Location ID: ");
                    String to = sc.nextLine();
                    graph.addRoad(from, to);
                    break;

                case 4:
                    System.out.print("Enter From Location ID: ");
                    String fromR = sc.nextLine();
                    System.out.print("Enter To Location ID: ");
                    String toR = sc.nextLine();
                    graph.removeRoad(fromR, toR);
                    break;

                case 5:
                    graph.displayConnections();
                    break;

                case 6:
                    tree.displayAll();
                    break;

                case 7:
                    System.out.println("👋 Exiting program... Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Please select between 1–7.");
            }
        }

        sc.close();
        System.out.println("\nProgram closed successfully. ✅");
    }
}
