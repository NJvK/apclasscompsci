import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Runner1 {
    public static void main(String[] args) {
        ArrayList<Task> list = new ArrayList<Task>();
        Scanner input = new Scanner(System.in);

        // read tasks from save.dat
        try {
            File file = new File("save.dat");
            if (file.exists()) {
                Scanner fileScan = new Scanner(file);

                while (fileScan.hasNextLine()) {
                    String line = fileScan.nextLine();
                    String[] parts = line.split(":");

                    int rank = Integer.parseInt(parts[0]);
                    String name = parts[1];

                    list.add(new Task(rank, name));
                }

                fileScan.close();
            }
        } 
        catch (Exception e) {
            System.out.println("Error reading file.");
        }

        while (true) {
            System.out.println();
            System.out.println("1. Display list");
            System.out.println("2. Add task");
            System.out.println("3. Sort list");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.println("To-Do List:");
                for (Task t : list) {
                    System.out.println(t);
                }
            } 
            else if (choice == 2) {
                System.out.print("Enter task name: ");
                String name = input.nextLine();

                System.out.print("Enter rank: ");
                int rank = input.nextInt();
                input.nextLine();

                list.add(new Task(rank, name));
            } 
            else if (choice == 3) {
                // selection sort by rank
                for (int i = 0; i < list.size() - 1; i++) {
                    int minIndex = i;

                    for (int j = i + 1; j < list.size(); j++) {
                        if (list.get(j).getRank() < list.get(minIndex).getRank()) {
                            minIndex = j;
                        }
                    }

                    Task temp = list.get(i);
                    list.set(i, list.get(minIndex));
                    list.set(minIndex, temp);
                }

                System.out.println("List sorted by rank.");
            } 
            else if (choice == 4) {
                try {
                    PrintWriter writer = new PrintWriter("save.dat");

                    for (Task t : list) {
                        writer.println(t);
                    }

                    writer.close();
                    System.out.println("Tasks saved. Goodbye.");
                } 
                catch (Exception e) {
                    System.out.println("Error writing file.");
                }

                break;
            } 
            else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}