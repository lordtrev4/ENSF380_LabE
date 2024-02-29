package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToDoList implements IToDoList {
    private List<Task> tasks;
    private Stack<List<Task>> history;

    public ToDoList() {
        this.tasks = new ArrayList<>();
        this.history = new Stack<>();
    }

    private void saveState() {
        List<Task> snapshot = new ArrayList<>();
        for (Task task : tasks) {
            snapshot.add(task.copy());
        }
        history.push(snapshot);
    }

    @Override
    public void addTask(Task task) {
        saveState();
        tasks.add(task);
    }

    @Override
    public void completeTask(String taskId) {
        saveState();
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setCompleted(true);
                break;
            }
        }
    }

    @Override
    public void deleteTask(String taskId) {
        saveState();
        tasks.removeIf(task -> task.getId() == taskId);
    }

    @Override
    public void editTask(String taskId, String newTitle, boolean isCompleted) {
        saveState();
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setTitle(newTitle);
                task.setCompleted(isCompleted);
                break;
            }
        }
    }

    @Override
    public void undo() {
        if (!history.isEmpty()) {
            tasks = history.pop();
        }
    }

    @Override
    public List<Task> listTasks() {
        return new ArrayList<>(tasks);
    }
}