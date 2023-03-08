import org.Generalov.utils.GetProperties;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class SqlRunner {


    public static void executeSqlFile(String fileName) throws Exception {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(GetProperties.DB_URL, GetProperties.DB_USERNAME, GetProperties.DB_PASSWORD);
            stmt = conn.createStatement();

            List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            String sql = String.join(" ", lines);
            String[] queries = sql.split(";");

            for (String query : queries) {
                stmt.executeUpdate(query.trim());
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

}
