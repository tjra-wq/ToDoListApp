package dev.ranieri.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.entities.task.Task;
import dev.ranieri.services.TaskService;
import dev.ranieri.services.TaskServiceImpl;

public class TaskController {
	
	TaskService tserv = new TaskServiceImpl();
	
	public void getAllTasks(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Gson gson = new Gson();
		List<Task> tasks = tserv.retrieveAllTasks();	
		PrintWriter pw = response.getWriter();
		String json = gson.toJson(tasks);
		pw.append(json);
		
	}
	
	// when you add information you want to send it in the body
	// therefore it is a post request
	public void addTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
	Gson gson = new Gson();
	
	// turn a json into an object you have to tell it what type of object to turn it into
	Task task = gson.fromJson(body, Task.class);
	tserv.createTask(task);
	response.getWriter().append("Success!!!!");
	}
		
	public void pendingTasks(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(tserv.retrievePendingTasks());
		response.getWriter().append(json);		
	}
	
	
	public void completedTasks(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(tserv.retrieveCompletedTasks());
		response.getWriter().append(json);
	}
	
	public void updateTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String json = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Task task = gson.fromJson(json, Task.class);
		tserv.markTaskComplete(task);
		System.out.println(task);
		response.getWriter().append("Successfully updated Task!!!!");
	}

}
