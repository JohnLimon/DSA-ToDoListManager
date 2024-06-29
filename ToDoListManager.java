import java.util.ArrayList;

class Task {
    String description;
    boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return description + " - " + (completed ? "Completed" : "Pending");
    }
}

class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
    }

    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markCompleted();
        } else {
            System.out.println("Invalid task index");
        }
    }

    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Task " + (i + 1) + ": " + tasks.get(i));
        }
    }
}

class User {
    String name;
    TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public void addTask(String description) {
        taskList.addTask(description);
    }

    public void markTaskCompleted(int index) {
        taskList.markTaskCompleted(index);
    }

    public void printTasks() {
        System.out.println("Tasks for user " + name + ":");
        taskList.printTasks();
    }
}

class TodoListManager {
    public static void main(String[] args) {
        User[] users = new User[5];
        users[0] = new User("Zoie");
        users[1] = new User("Zeia");
        users[2] = new User("Zione");
        users[3] = new User("Zaira");
        users[4] = new User("John");

        users[0].addTask("Create marketing materials ");
        users[1].addTask("Prepare project presentation ");
        users[2].addTask("Write documentation ");
        users[3].addTask("Plan team meeting ");
        users[4].addTask("Review the project reports ");

        users[1].markTaskCompleted(0); // marking the first task as completed for Zeia

        //printing task for each user
        for (User user : users) {
            user.printTasks();
        }
    }
}