package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

public class TaskController {
	
	public void save(Task task) {	
		
		String sql = "INSERT INTO tasks ("
				+ "foreignKeyProject, "
				+ "name, "
				+ "description, "
				+ "completed, "
				+ "notes, "
				+ "deadline, "
				+ "createdAt, "
				+ "updatedAt ) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		//Criação da conexão com o banco de dados
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			//Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			
			//Preparando a Query
			statement = connection.prepareStatement(sql);
			
			//Setando os valores no Statement
			statement.setInt(1, task.getForeignKeyProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setBoolean(4, task.isCompleted());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7, new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
			
			//Executando a Query
			statement.execute();
			
		} catch (Exception e) {
			throw new RuntimeException("ERRO ao salvar a tarefa " + e.getMessage(), e);
		}finally {
			ConnectionFactory.closeConnection(connection, statement);
		}		
	}
	
	
	
	public void update(Task task) {		
		
		String sql = "UPDATE tasks SET"
				+ "foreignKeyProject = ?, "
				+ "name = ?, "
				+ "description = ?, "
				+ "completed = ?, "
				+ "notes = ?, "
				+ "deadline = ?, "
				+ "createdAt = ?, "
				+ "updatedAt = ? "
				+ "WHERE id = ? ";
		
		//Criação da conexão com o banco de dados
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			//Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			
			//Preparando a Query
			statement = connection.prepareStatement(sql);
			
			//Setando os valores no Statement
			statement.setInt(1, task.getForeignKeyProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setBoolean(4, task.isCompleted());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7, new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
			statement.setInt(9, task.getIdTask());
			
			//Executando a Query
			statement.execute();			
		} catch (Exception e) {
			throw new RuntimeException("ERRO ao atualizar a tarefa " + e.getMessage(), e);
		}finally {
			ConnectionFactory.closeConnection(connection, statement);
		}	
	}
	
	
	
	
	public void removeById(int TaskId) throws SQLException {
		
		String sql = "DELETE FROM tasks WHERE id = ?";
		
		//Criação da conexão com o banco de dados
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			//Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			
			//Preparando a Query
			statement = connection.prepareStatement(sql);
			
			//Setando os valores no Statement
			statement.setInt(1, TaskId);
			
			//Executando a Query
			statement.execute();
			
		} catch (Exception e) {
			throw new RuntimeException("ERRO ao deletar a tarefa " + e.getMessage(), e);
		}finally {
			ConnectionFactory.closeConnection(connection, statement);
		}		
	}
	
	
	
	public List<Task> getAll(int IdProject){
		
		String sql = "SELECT * FROM tasks WHERE IdProject = ?";
		
		//Criação da conexão com o banco de dados
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		//Lista de tarefas que será devolvida quando a chamada acontecer
		List<Task> tasks = new ArrayList<>();
		
		try {			
			//Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			
			//Preparando a Query
			statement = connection.prepareStatement(sql);
			
			//Setando o valor que corresponde ao filtro de busca 
			statement.setInt(1, IdProject);
			
			//Valor retornado pela execução da Query
			resultSet = statement.executeQuery();
			
			
			//Enquanto houverem valores a serem percorridos pelo resultSet
			while (resultSet.next()) {				
				Task task = new Task();
				task.setIdTask(resultSet.getInt("id"));
				task.setForeignKeyProject(resultSet.getInt("foreignKeyProject"));
				task.setName(resultSet.getString("name"));
				task.setDescription(resultSet.getNString("description"));
				task.setCompleted(resultSet.getBoolean("completed"));
				task.setNotes(resultSet.getString("notes"));
				task.setCreatedAt(resultSet.getDate("createdAt"));
				task.setUpdatedAt(resultSet.getDate("updatedAt"));
				
				//Executando a Query
				tasks.add(task);				
			}			
		} catch (Exception e) {
			throw new RuntimeException("ERRO ao inserir a tarefa " + e.getMessage(), e);
		}finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}		
		//Lista de tarefas que foi criada e carregada do banco de dados
		return tasks;
	}
}
