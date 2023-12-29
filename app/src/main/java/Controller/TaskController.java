/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author T-Gamer
 */
public class TaskController {

    public void save(Task task) {
        // Estruturando a Query
        String query = "INSERT INTO tasks (idProject,name,description,"
                + "isCompleted,notes,deadline,createdAt,updatedAt)"
                + " VALUES(?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement preparedStmt = null;

        try {
            //Estabelecendo a conexão com o DB
            conn = ConnectionFactory.getConnection();
            preparedStmt = conn.prepareStatement(query);
            //Settando os valores
            preparedStmt.setInt(1, task.getIdProject());
            preparedStmt.setString(2, task.getName());
            preparedStmt.setString(3, task.getDescription());
            preparedStmt.setBoolean(4, task.getIsCompleted());
            preparedStmt.setString(5, task.getNotes());
            preparedStmt.setDate(6,
                    new java.sql.Date(task.getDeadline().getTime()));
            preparedStmt.setDate(7,
                    new java.sql.Date(task.getCreatedAt().getTime()));
            preparedStmt.setDate(8,
                    new java.sql.Date(task.getUpdatedAt().getTime()));
            //Executando a Query
            preparedStmt.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a tarefa "
                    + e.getMessage(), e);

        } finally {
            //Fechando a conexão com o DB
            ConnectionFactory.CloseConnection(conn, preparedStmt);

        }

    }

    public void update(Task task) {
        // Estruturando a Query
        String query = "UPDATE tasks SET idProject = ?,name = ?,description = ?,"
                + "isCompleted = ?,notes = ?,deadline = ?,createdAt =?,updatedAt = ?"
                + " WHERE id = ?";

        Connection conn = null;
        PreparedStatement preparedStmt = null;

        try {
            //Estabelecendo a conexão com o DB
            conn = ConnectionFactory.getConnection();
            preparedStmt = conn.prepareStatement(query);
            //Settandos os Valores
            preparedStmt.setInt(1, task.getIdProject());
            preparedStmt.setString(2, task.getName());
            preparedStmt.setString(3, task.getDescription());
            preparedStmt.setBoolean(4, task.getIsCompleted());
            preparedStmt.setString(5, task.getNotes());
            preparedStmt.setDate(6,
                    new java.sql.Date(task.getDeadline().getTime()));
            preparedStmt.setDate(7,
                    new java.sql.Date(task.getCreatedAt().getTime()));
            preparedStmt.setDate(8,
                    new java.sql.Date(task.getUpdatedAt().getTime()));
            preparedStmt.setInt(9, task.getId());
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

    public void removeById(int taskId){
        //Estruturando a Query
        String sql = "DELETE FROM tasks WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            //Estabelecendo a conexão com o BD
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            //Settando os Valores
            statement.setInt(1, taskId);
            //Executando a Query
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar essa tarefa " + e.getMessage(), e);

        } finally {
            //Fechando a conexão com o DB
            ConnectionFactory.CloseConnection(conn, statement);
        }
    }

    public List<Task> getAll(int idProject) {
        //Estruturando a Query
        String query = "SELECT * FROM tasks WHERE idProject = ?";

        Connection conn = null;
        PreparedStatement preparedStmt = null;
        ResultSet resultSet = null;
        //Criando a Lista que irá conter todas as Task's
        List<Task> tasks = new ArrayList<Task>();

        try {
            //Estabelecendo conexão com o BD
            conn = ConnectionFactory.getConnection();
            preparedStmt = conn.prepareStatement(query);
            //Setando os valores da Query
            preparedStmt.setInt(1, idProject);
            resultSet = preparedStmt.executeQuery();

            //Carregando a lista com as Task's
            while (resultSet.next()) {

                Task task = new Task();

                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIsCompleted(resultSet.getBoolean("isCompleted"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));

                tasks.add(task);

            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar os dados das tarefas " + e.getMessage(), e);

        } finally {
            //Fechando a conexão com o DB
            ConnectionFactory.CloseConnection(conn, preparedStmt, resultSet);
        }
        //Retornando a Lista carregada com todas as Task's do DB
        return tasks;
    }

}
