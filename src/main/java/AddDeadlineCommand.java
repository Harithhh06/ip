import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AddDeadlineCommand extends Command {
    private String[] parts;
    private String description;
    private LocalDateTime by;

    public AddDeadlineCommand(String input) throws LunaBotException {
        this.parts = input.substring(9).split(" /by ");
        if (parts.length < 2) {
            throw new LunaBotException("Invalid deadline format");
        }
        if (parts[0].isEmpty()) {
            throw new LunaBotException("Description of task cannot be empty");
        }
        if (parts[1].isEmpty()) {
            throw new LunaBotException("Deadline of task cannot be empty");
        }
        this.description = parts[0];
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            this.by = LocalDateTime.parse(parts[1], formatter);
        }
        catch (DateTimeParseException e) {
            throw new LunaBotException("Invalid deadline date/time format. Use yyyy-MM-dd HH:mm");
        }
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws LunaBotException {
        Deadline deadline = new Deadline(description, by);
        taskList.addTask(deadline);
        storage.save(taskList.getTasks());
        ui.printTaskAdded(deadline, taskList.size());
    }
}
