package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import util.ConnectionFactory;

public class ProjectController {
	
	public void save( Project project ) {
		
		String sql = "INSERT INTO project("
				+ "name,"
				+ "description,"
				+ "createdAt,"
				+ "updatedAt)"
				+ "VALUES(?, ?, ?, ?)";
		
		//Criação da conexão com o banco de dados
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			//Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			
			//Preparando a Query
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
			statement.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException("ERRO ao salvar a tarefa ", e);
		}finally {
			ConnectionFactory.closeConnection(connection, statement);
		}		
	}
	
	public void update( Project project) {
		
		String sql = "UPDATE project SET"
				+ "name = ?, "
				+ "description = ?,"
				+ "createdAt = ?,"
				+ "updatedAt = ? "
				+ "WHERE id = ?";
		
		//Criação da conexão com o banco de dados
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			//Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			
			//Preparando a Query
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
			statement.setInt(5, project.getId());
			
			//Executa a SQL para 
			statement.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException("ERRO ao salvar a tarefa ", e);
		}finally {
			ConnectionFactory.closeConnection(connection, statement);
		}	
		
	}
	
	
	public List<Project> getAll(){
		
		String sql = "SELECT * FROM project";		
		List<Project> projects = new ArrayList<>();
		
		//Criação da conexão com o banco de dados
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			//Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			
			//Preparando a Query
			statement = connection.prepareStatement(sql);			
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				
				Project project = new Project();				
				project.setId(resultSet.getInt("id"));
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setCreatedAt(resultSet.getDate("createdAt"));
				project.setUpdatedAt(resultSet.getDate("updatedAt"));				
				projects.add(project);				
			}			
		} catch (SQLException e) {
			throw new RuntimeException("ERRO ao salvar a tarefa ", e);
		}finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}		
		return projects;
	}
	
	
	public void removeById( int idProject) {
		
		String sql = "DELETE FROM project WHERE id = ?";
		
		//Criação da conexão com o banco de dados
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			//Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			
			//Preparando a Query
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, idProject);
			statement.execute();			
		} catch (Exception e) {
			throw new RuntimeException("ERRO ao salvar a tarefa ", e);
		}finally {
			ConnectionFactory.closeConnection(connection, statement);
		}		
	}
	
	
	
	
	
	
	
	
	
	

}
