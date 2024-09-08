package LunaBot.command;

import LunaBot.exception.LunaBotException;
import LunaBot.storage.Storage;
import LunaBot.task.Task;
import LunaBot.task.TaskList;
import LunaBot.ui.Ui;

public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(String input) throws LunaBotException {
        try {
            // extracts index as a string and converts to an int
            this.index = Integer.parseInt(input.substring(7).trim()) - 1;
        }
        catch (NumberFormatException e) {
            // checks if user inout an int
            throw new LunaBotException(" Invalid task number format");
        }
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws LunaBotException {
        // Checks if task number provided is valid and within range
        if (index < 0 || index >= taskList.size()) {
            throw new LunaBotException("Invalid task number provided");
        }
        Task task = taskList.get(index);
        task.unmarkAsDone();
        storage.save(taskList.getTasks());
        ui.printTaskUnmarked(task);
    }
}
