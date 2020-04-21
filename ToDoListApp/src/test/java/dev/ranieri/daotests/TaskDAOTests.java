package dev.ranieri.daotests;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.entities.task.Task;
import dev.ranieri.daos.TaskDAO;
import dev.ranieri.daos.TaskDAOMaria;

public class TaskDAOTests {

	private TaskDAO tdao = new TaskDAOMaria();
	
	@Test
	public void test() {
		Task t = new Task(0,"Finish this example",2,false);	
		tdao.createTask(t);
		System.out.println(t);
	}

	@Test
	public void getAll() {
		System.out.println(tdao.getAllTasks());
	}
	
	@Test
	public void getTaskById() {
		System.out.println(tdao.getTaskById(2));
	}
}
