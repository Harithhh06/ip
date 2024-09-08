import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public ArrayList<Task> getTasks() {
        return taskList;
    }

    public int size() {
        return taskList.size();
    }

    public boolean isEmpty() {
        return taskList.isEmpty();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public Task deleteTask(int index) throws LunaBotException {
        if (index < 0 || index >+ taskList.size()) {
            throw new LunaBotException(" Invalid task number.");
        }
        return taskList.remove(index);
    }

    public Task get(int index) throws LunaBotException {
        if (index < 0 || index >= taskList.size()) {
            throw new LunaBotException(" Invalid task number.");
        }
        return taskList.get(index);
    }
}
