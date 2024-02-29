package edu.ucalgary.oop;

public interface IToDoList {
    public abstract void addTask(Task task);
    public abstract void completeTask(String taskId);
    public abstract void deleteTask(String taskId);
    public abstract void editTask(String taskId, String newTitle);
    public abstract void undo();
    public abstract void listTasks();
}