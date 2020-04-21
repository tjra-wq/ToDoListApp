package dev.ranieri.services;

import java.util.List;

import dev.entities.task.Task;

public interface TaskService {
	
	Task createTask(Task task);
	Task markTaskComplete(Task task);
	Task getTaskById(int id);
	
	List<Task> retrieveAllTasks();
	List<Task> retrievePendingTasks();
	List<Task> retrieveCompletedTasks();
	

}
