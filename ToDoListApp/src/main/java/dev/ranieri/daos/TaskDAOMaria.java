package dev.ranieri.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.entities.task.Task;

import dev.ranieri.utils.ConnectionUtil;

public class TaskDAOMaria implements TaskDAO {

	@Override
	public Task createTask(Task task) {
		
		String sql = "INSERT INTO tododb.TASK VALUES (?,?,?,?)";
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setString(2, task.getDescription());
			ps.setInt(3, task.getPriority());
			ps.setBoolean(4, task.isDone());
			ps.execute(); // execute the insert statement
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int key = rs.getInt("TASK_ID");
			task.settId(key);			
			return task;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Task getTaskById(int id) {
		
		String sql = "SELECT * FROM tododb.TASK WHERE TASK_ID = ?";
		try(Connection conn = ConnectionUtil.createConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Task task = new Task();
			task.settId(rs.getInt("TASK_ID"));
			task.setDescription(rs.getString("DESCRIPTION"));
			task.setPriority(rs.getInt("PRIORITY"));
			task.setDone(rs.getBoolean("ISDONE"));
			
			return task;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Task> getAllTasks() {
	
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM tododb.TASK";
			List<Task> tasks = new ArrayList<Task>();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				Task t = new Task();
				t.settId(rs.getInt("TASK_ID"));
				t.setDescription(rs.getString("Description"));
				t.setPriority(rs.getInt("PRIORITY"));
				t.setDone(rs.getBoolean("ISDONE"));
				tasks.add(t);
			}
			return tasks;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Task> getCompletedTasks() {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM tododb.TASK WHERE ISDONE = 1";
			List<Task> tasks = new ArrayList<Task>();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				Task t = new Task();
				t.settId(rs.getInt("TASK_ID"));
				t.setDescription(rs.getString("Description"));
				t.setPriority(rs.getInt("PRIORITY"));
				t.setDone(rs.getBoolean("ISDONE"));
				tasks.add(t);
			}
			return tasks;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Task> getPendingTasks() {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM tododb.TASK WHERE ISDONE = 0";
			List<Task> tasks = new ArrayList<Task>();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				Task t = new Task();
				t.settId(rs.getInt("TASK_ID"));
				t.setDescription(rs.getString("Description"));
				t.setPriority(rs.getInt("PRIORITY"));
				t.setDone(rs.getBoolean("ISDONE"));
				tasks.add(t);
			}
			return tasks;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Task updateTask(Task task) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "UPDATE tododb.TASK SET DESCRIPTION = ?, PRIORITY = ?, ISDONE = ? WHERE TASK_ID = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setString(1, task.getDescription());
			ps.setInt(2, task.getPriority());
			ps.setBoolean(3, task.isDone());
			ps.setInt(4, task.gettId());
			ps.execute();
			
			return task;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteTask(Task task) {
		return false;
	}

}
