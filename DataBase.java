
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {
    public void createTable() {
        try {
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NO EXISTS pets(id in NOT NULL AUTO_INCREMENT, nameOfPet varchar(20), age INT(2), vaccinationStatus BOOLEAN, gender INT(1),PRIMARY KEY(id))");
            create.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:33061/University", "ret", "1234");
    }
}
