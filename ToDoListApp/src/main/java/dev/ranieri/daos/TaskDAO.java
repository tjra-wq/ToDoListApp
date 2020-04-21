package dev.ranieri.daos;

import java.util.List;

import dev.entities.task.Task;

public interface TaskDAO {
	
	//CRUD
	
	//CREATE
	Task createTask(Task task);
	
	//READ
	Task getTaskById(int id);
	List<Task> getAllTasks();
	List<Task> getCompletedTasks();
	List<Task> getPendingTasks();
	
	//UPDATE
	Task updateTask(Task task);
	
	//DELETE
	boolean deleteTask(Task task); 
	
	
}
