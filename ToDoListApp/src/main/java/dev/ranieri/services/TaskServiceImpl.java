package dev.ranieri.services;

import java.util.List;

import dev.entities.task.Task;
import dev.ranieri.daos.TaskDAO;
import dev.ranieri.daos.TaskDAOMaria;

public class TaskServiceImpl implements TaskService {

	private TaskDAO tdao = new TaskDAOMaria();
	
	@Override
	public Task createTask(Task task) {
		tdao.createTask(task);
		return task;
	}

	@Override
	public Task markTaskComplete(Task task) {
		task.setDone(true);
		tdao.updateTask(task);
		return task;
	}

	@Override
	public List<Task> retrieveAllTasks() {		
		return tdao.getAllTasks();
	}

	@Override
	public List<Task> retrievePendingTasks() {
		return tdao.getPendingTasks();
	}

	@Override
	public List<Task> retrieveCompletedTasks() {
		return tdao.getCompletedTasks();
	}

	@Override
	public Task getTaskById(int id) {		
		return tdao.getTaskById(id);
	}

}
