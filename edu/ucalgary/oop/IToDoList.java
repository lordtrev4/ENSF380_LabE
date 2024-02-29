package edu.ucalgary.oop;

public interface IToDoList {
    public abstract void addTask(Task task);
    public abstract void completeTask(int taskId);
    public abstract void deleteTask(int taskId);
    public abstract void editTask(int taskId, String newTitle);
    public abstract void undoTask(int taskId);
    public abstract void listTasks();
}