import java.util.Scanner;

public class LunaBot {

    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    public LunaBot(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            this.taskList = new TaskList(storage.load());
        } catch (LunaBotException e) {
            ui.printError(e.getMessage());
            this.taskList = new TaskList();
        }
    }

    public void run() {
        ui.printWelcome();
        Scanner scanner = new Scanner(System.in);

        while (true) {  // Infinite loop, break on "bye" command
            try {
                String input = ui.readCommand();
                Command command = Parser.parse(input);
                command.execute(taskList, ui, storage);

                // Check if the command is an ExitCommand, break the loop if so
                if (command instanceof ExitCommand) {
                    break;
                }
            } catch (LunaBotException e) {
                ui.printError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "data/tasks.txt";
        new LunaBot(filePath).run();
    }
}
