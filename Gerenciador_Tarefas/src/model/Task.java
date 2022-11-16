package model;

import java.util.Date;

public class Task {
	
	private int idTask;
	private int foreignKeyProject;
	private String name;
	private String description;
	private boolean completed;
	private String notes;
	private Date deadline;
	private Date createdAt;
	private Date updatedAt;
	
	
	public Task(int idTask, int foreignKeyProject, String name, String description, boolean completed, String notes,
			Date deadline, Date createdAt, Date updatedAt) {
		super();
		this.idTask = idTask;
		this.foreignKeyProject = foreignKeyProject;
		this.name = name;
		this.description = description;
		this.completed = completed;
		this.notes = notes;
		this.deadline = deadline;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Task() {
		this.createdAt = new Date();
	}


	public int getIdTask() {
		return idTask;
	}


	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}


	public int getForeignKeyProject() {
		return foreignKeyProject;
	}


	public void setForeignKeyProject(int foreignKeyProject) {
		this.foreignKeyProject = foreignKeyProject;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isCompleted() {
		return completed;
	}


	public void setCompleted(boolean completed) {
		this.completed = completed;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public Date getDeadline() {
		return deadline;
	}


	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	@Override
	public String toString() {
		return "Task [idTask=" + idTask + ", foreignKeyProject=" + foreignKeyProject + ", name=" + name
				+ ", description=" + description + ", completed=" + completed + ", notes=" + notes + ", deadline="
				+ deadline + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
	
	

}
