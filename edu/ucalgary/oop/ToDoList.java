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
    public void completeTask(int taskId) {
        saveState();
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setCompleted(true);
                break;
            }
        }
    }

    @Override
    public void deleteTask(int taskId) {
        saveState();
        tasks.removeIf(task -> task.getId() == taskId);
    }

    @Override
    public void editTask(int taskId, String newTitle) {
        saveState();
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setTitle(newTitle);
                break;
            }
        }
    }

    @Override
    public void undoTask(int taskId) {
        if (!history.isEmpty()) {
            tasks = history.pop();
        }
    }

    @Override
    public void listTasks() {
        for (Task task : tasks) {
            System.out.println("ID: " + task.getId() + ", Title: " + task.getTitle() + ", Completed: " + task.isCompleted());
        }
    }
}