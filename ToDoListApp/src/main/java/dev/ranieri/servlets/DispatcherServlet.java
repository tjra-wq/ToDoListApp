package dev.ranieri.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.ranieri.controllers.TaskController;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DispatcherServlet() {
        super();
    }
    
    TaskController tcontroller = new TaskController();


    //Every http request you make will get sent to this method for processing
    // This method takes in an HTTP request and Respone object
    // those two objects are generated for you by each request
    // request object contains all the information about the http request
    // response object allows you to craft http response back to the webpage
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		System.out.println(uri);
		switch(uri) {
		
		// API application program interface does not usuallay do not return HTML pages/css/js
		// They are end points that you can send and get information from (usually in JSON)
		case "/ToDoListApp/api/tasks" : tcontroller.getAllTasks(request, response); break;
		case "/ToDoListApp/api/addtask" : tcontroller.addTask(request, response); break;
		case "/ToDoListApp/api/pendingtasks" : tcontroller.pendingTasks(request, response); break;
		case "/ToDoListApp/api/updatetask" : tcontroller.updateTask(request, response); break;
		case "/ToDoListApp/api/completedtasks" : tcontroller.completedTasks(request, response); break;
		
		default : response.getWriter().append("your request uri did not match anything");break;
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
//		
//		System.out.println(request.getRequestURI());
//		
//		// we can get parame
//		String param1 = request.getParameter("fname");
//		String param2 = request.getParameter("lname");
//		
//		System.out.println("console: Hello  " + param1 + param2);
//		// use the printwriter to send a response
//		PrintWriter pw = response.getWriter();
//		pw.append("browser: Hello " + param1 + param2);
//		
//		
//		// how to read a post body
//		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
//		System.out.println(body);
//		
//		// basic tools we need to create our api
//		// 1. we need to distinguish http requests based on the uri
//		// 2. we need to be able to read parameters from the uri
//		// 3. we need to be able to read the body of our post requests
		
	}

}
