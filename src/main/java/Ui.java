import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private static String LINE = "___________________________________________________________________";
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void printWelcome() {
        System.out.println(LINE);
        System.out.println(" Hello! I'm LunaBot");
        System.out.println(" What can I do for you?");
        System.out.println(LINE);
    }

    public void printGoodbye() {
        System.out.println(LINE);
        System.out.println(" Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    public void printLoadingError() {
        System.out.println(LINE);
        System.out.println(" Unable to load tasks from file.");
        System.out.println(LINE);
    }

    public void printError(String message) {
        System.out.println(LINE);
        System.out.println(" Error: " + message);
        System.out.println(LINE);
    }

    public void printTaskList(ArrayList<Task> taskList) {
        System.out.println(LINE);
        if (taskList.isEmpty()) {
            System.out.println(" You have no tasks in your task list.");
        }
        else {
            System.out.println(" Here are the tasks in your list:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println(" " + (i + 1) + "." + taskList.get(i));
            }
        }
        System.out.println(LINE);
    }

    public void printTaskMarked(Task task) {
        System.out.println(LINE);
        System.out.println(" Nice! I've marked this task as done:");
        System.out.println("   " + task);
        System.out.println(LINE);
    }

    public void printTaskUnmarked(Task task) {
        System.out.println(LINE);
        System.out.println(" OK, I've marked this task as not done yet:");
        System.out.println("   " + task);
        System.out.println(LINE);
    }

    public void printTaskDeleted(Task task, int size) {
        System.out.println(LINE);
        System.out.println(" Noted. I've removed this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " +  size + " tasks in the list.");
        System.out.println(LINE);

    }
    public void printTaskAdded(Task task, int size) {
        System.out.println(LINE);
        System.out.println(" Got it! I've added this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + size + " tasks in the list");
        System.out.println(LINE);
    }

    public void printErrorMessage(String message) {
        System.out.println(LINE);
        System.out.println(" Error: " + message);
        System.out.println(LINE);
    }
}
