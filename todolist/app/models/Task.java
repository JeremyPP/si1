package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Task extends Model {

	@Id
	public Long id;

	public boolean completed;

	@Required
	public String label;

	private String project;

	public static Finder<Long, Task> find = new Finder(Long.class, Task.class);

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static Task taskById(Long id) {
		return find.byId(id);
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public static Integer count(boolean completed) {
		String status = completed ? "TRUE" : "FALSE";
		return find.where("completed = " + status).findRowCount();
	}

	public static Integer count() {
		return find.findRowCount();
	}

	public static List<Task> all() {
		return find.all();
	}

	public static void create(Task task) {
		task.save();
	}

	public static void update(Task task) {
		task.update();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

}