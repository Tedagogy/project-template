import Util.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
//        this line is just for testing that your tables get set up correctly
//        if not, you'll get a stack trace

//        this is jdbc
        Connection conn = ConnectionSingleton.getConnection();
        PreparedStatement ps1 = conn.prepareStatement("insert into table1 (column1, column2) values (2, 'test2')");
        ps1.executeUpdate();
        PreparedStatement ps2 = conn.prepareStatement("select * from table1");
        ResultSet rs2 = ps2.executeQuery();

        while(rs2.next()){
            System.out.println(rs2.getInt("column1"));
            System.out.println(rs2.getString(("column2")));
        }

    }
}
/**
 * sql vs nosql
 * sql has the ability to strictly define tables and relate tables to each other
 * (referential integrity, eg a 'teachers' table may be related logically to a 'classrooms' table)
 *
 * noSQL is more scalable and more easily converted into a distributed system than sql
 * however, sql is better for maintaining strictly related entities (eg product > cart > user)
 *
 * there are many different variants of nosql that are well suited to different tasks
 * mongodb
 * cassandra
 *
 * a lot of the time, an organization uses a mix of sql and nosql depending on the use case of their specific project,
 * and based on their database needs such as distribution/scalability/consistency
 */