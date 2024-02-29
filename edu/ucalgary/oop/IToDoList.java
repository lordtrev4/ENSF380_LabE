package edu.ucalgary.oop;

import java.util.List;

public interface IToDoList {
    public abstract void addTask(Task task);
    public abstract void completeTask(String taskId);
    public abstract void deleteTask(String taskId);
    public abstract void editTask(String taskId, String newTitle, boolean isCompleted);
    public abstract void undo();
    public abstract List<Task> listTasks();
}