package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class TaskMethod {

    private Queue<Task> taskQueue;

    public TaskMethod() {
        taskQueue = new LinkedList<>();
    }

    public void taskInitialize() {
        taskQueue.add(new Task("Clean dishes", 3));
        taskQueue.add(new Task("Do laundry", 2));
        taskQueue.add(new Task("Walk the dog", 1));
        taskQueue.add(new Task("Pay bills", 2));
    }

    public void addTaskToQueue(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        taskQueue.add(task);
    }

    public Task processNextTaskFromQueue() {
        return taskQueue.poll();
    }

    public Task peekAtNextTaskInQueue() {
        return taskQueue.peek();
    }

    public int getTaskQueueSize() {
        return taskQueue.size();
    }

    public List<Task> getTasksWithPriority(int priority) {
        return taskQueue.stream().filter(task -> task.getPriority() == priority).collect(Collectors.toList());
    }
    
    public void moveTaskToBack(int numberOfPositions) {
        if (numberOfPositions <= 0 || numberOfPositions >= getTaskQueueSize()) {
            throw new IllegalArgumentException();
        }

        Task taskToMove = taskQueue.poll();
        List<Task> arrayList = new ArrayList<>(taskQueue);
        arrayList.set(numberOfPositions - 1, taskToMove);

        taskQueue.clear();
        taskQueue.addAll(arrayList);
    }
}
