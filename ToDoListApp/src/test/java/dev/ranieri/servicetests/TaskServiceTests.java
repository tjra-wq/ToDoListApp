package dev.ranieri.servicetests;

import static org.junit.Assert.*;

import org.junit.Test;


import dev.entities.task.Task;
import dev.ranieri.services.TaskService;
import dev.ranieri.services.TaskServiceImpl;

public class TaskServiceTests {

	TaskService tserv = new TaskServiceImpl();
	@Test
	public void test() {
		
		Task t = tserv.getTaskById(4);
		System.out.println(t);
		tserv.markTaskComplete(t);
	}
	

}
