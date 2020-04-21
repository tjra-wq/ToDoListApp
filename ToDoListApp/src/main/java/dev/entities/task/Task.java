package dev.entities.task;

public class Task {
	
	private int tId;
	private String description;
	private int priority;
	private boolean isDone;
	
	public Task() {
		super();
	}

	public Task(int tId, String description, int priority, boolean isDone) {
		super();
		this.tId = tId;
		this.description = description;
		this.priority = priority;
		this.isDone = isDone;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "Task [tId=" + tId + ", description=" + description + ", priority=" + priority + ", isDone=" + isDone
				+ "]";
	}

}
