/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author T-Gamer
 */
public class ProjectController {

    public void save(Project project) {
        // Estruturando a Query
        String query = "INSERT INTO projects (name,description,"
                + "createdAt,updatedAt)"
                + " VALUES(?,?,?,?)";
        Connection conn = null;
        PreparedStatement preparedStmt = null;

        try {
            //Estabelecendo a conexão com o DB
            conn = ConnectionFactory.getConnection();
            preparedStmt = conn.prepareStatement(query);
            //Settando os valores
            preparedStmt.setString(1, project.getName());
            preparedStmt.setString(2, project.getDescription());
            preparedStmt.setDate(3,
                    new java.sql.Date(project.getCreatedAt().getTime()));
            preparedStmt.setDate(4,
                    new java.sql.Date(project.getUpdatedAt().getTime()));
            //Executando a Query
            preparedStmt.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o projeto "
                    + e.getMessage(), e);

        } finally {
            //Fechando a conexão com o DB
            ConnectionFactory.CloseConnection(conn, preparedStmt);

        }

    }

    public void update(Project project)  {
        // Estruturando a Query
        String query = "UPDATE projects SET name = ?,description = ?,"
                + "createdAt =?,updatedAt = ?"
                + " WHERE id = ?";

        Connection conn = null;
        PreparedStatement preparedStmt = null;

        try {
            //Estabelecendo a conexão com o DB
            conn = ConnectionFactory.getConnection();
            preparedStmt = conn.prepareStatement(query);
            //Settandos os Valores
            preparedStmt.setString(1, project.getName());
            preparedStmt.setString(2, project.getDescription());
            preparedStmt.setDate(3,
                    new java.sql.Date(project.getCreatedAt().getTime()));
            preparedStmt.setDate(4,
                    new java.sql.Date(project.getUpdatedAt().getTime()));
            preparedStmt.setInt(5, project.getId());
            //Executando a Query
            preparedStmt.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a tarefa "
                    + e.getMessage(), e);

        } finally {
            //Fechando a conexão com o DB
            ConnectionFactory.CloseConnection(conn, preparedStmt);

        }
    }

    public void removeById(int projectId) {
        //Estruturando a Query
        String sql = "DELETE FROM projects WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            //Estabelecendo a conexão com o BD
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            //Settando os Valores
            statement.setInt(1, projectId);
            //Executando a Query
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar essa tarefa " + e.getMessage(), e);

        } finally {
            //Fechando a conexão com o DB
            ConnectionFactory.CloseConnection(conn, statement);
        }
    }
    
    public List<Project> getAll()  {
        //Estruturando a Query
        String query = "SELECT * FROM projects";

        Connection conn = null;
        PreparedStatement preparedStmt = null;
        ResultSet resultSet = null;
        
        //Criando a Lista que irá conter todas os Projetos
        List<Project> projects = new ArrayList<Project>();

        try {
            //Estabelecendo conexão com o BD
            conn = ConnectionFactory.getConnection();
            preparedStmt = conn.prepareStatement(query);
            //Setando os valores da Query
            resultSet = preparedStmt.executeQuery();

            //Carregando a lista com as Task's
            while (resultSet.next()) {

                Project project = new Project();

                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));

                projects.add(project);
 
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar os dados das tarefas " + e.getMessage(), e);

        } finally {
            //Fechando a conexão com o DB
            ConnectionFactory.CloseConnection(conn, preparedStmt, resultSet);
        }
        //Retornando a Lista carregada com todos os Proejtos do DB
        return projects;
    }

}
