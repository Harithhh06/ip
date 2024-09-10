package LunaBot.command;

import LunaBot.exception.LunaBotException;
import LunaBot.storage.Storage;
import LunaBot.task.TaskList;
import LunaBot.ui.Ui;

/**
 * Abstract command that is executed by LunaBot
 * All specific commands inherit from this class and implement the execute method.
 */
public abstract class Command {

    /**
     * @param taskList Current list of tasks to be operated on
     * @param ui User interface that handles user input and interactions
     * @param storage Storage system to save or load tasks to/from a file.
     * @throws LunaBotException If an error occurs while executing the command
     */
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws LunaBotException;

}
