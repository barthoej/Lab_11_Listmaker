import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static ArrayList<String> myList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            String choice = SafeInput.getRegExString(scanner, "Enter your choice: [AaDdPpQq]", "[AaDdPpQq]");
            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (confirmQuit()) {
                        System.out.println("Exiting the program...");
                        scanner.close();
                        return;
                    }
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem() {
        System.out.print("Enter the item to add: ");
        String item = scanner.nextLine();
        myList.add(item);
        System.out.println("Item added successfully!");
    }

    private static void deleteItem() {
        if (myList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("Current list:");
        printNumberedList();
        int index = SafeInput.getRangedInt(scanner, "Enter the number of the item to delete: ", 1, myList.size()) - 1;
        String deletedItem = myList.remove(index);
        System.out.println("Item \"" + deletedItem + "\" deleted successfully!");
    }

    private static void printList() {
        if (myList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Current list:");
            for (String item : myList) {
                System.out.println("- " + item);
            }
        }
    }

    private static void printNumberedList() {
        for (int i = 0; i < myList.size(); i++) {
            System.out.println((i + 1) + ". " + myList.get(i));
        }
    }

    private static boolean confirmQuit() {
        return SafeInput.getYNConfirm(scanner, "Are you sure you want to quit? (Y/N): ");
    }
}
