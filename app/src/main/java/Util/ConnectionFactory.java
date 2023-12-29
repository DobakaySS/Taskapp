    package util;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;

    public class ConnectionFactory {
        
        public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
        public static final String URL = "jdbc:mysql://localhost:3306/todoapp";
        public static final String USER = "root";
        public static final String PASS = "";

        public static Connection getConnection() {
            try {
               // Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(URL, USER, PASS);
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao tentar se conectar ao Banco de Dados", ex);
            }
        }

        public static void CloseConnection(Connection connection) {

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao tentar fechar a conexão", ex);
            }
        }

        public static void CloseConnection(Connection connection, PreparedStatement stmt) {

            try {
                if (connection != null) {
                    connection.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao tentar fechar a conexão", ex);
            }
        }

        public static void CloseConnection(Connection connection, PreparedStatement stmt, ResultSet resultSet) {

            try {
                if (connection != null) {
                    connection.close();
                }
                if (stmt != null) {
                    stmt.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao tentar fechar a conexão", ex);
            }
        }

    }
