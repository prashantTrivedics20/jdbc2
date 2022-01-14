import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.Callable;
public class p1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
        Statement st = con.createStatement();
        // creation of the table..
        Scanner readme = new Scanner(System.in);
        while (true) {
            int i = st.executeUpdate("insert into callablestatement.table1 values(80,'hello','mtech')");
            System.out.println(i + "query");
            System.out.println("do you want to insert another query");
            String s = readme.next();
            if (s.equals("no")) {
                break;
            }
        }
        CallableStatement cs=con.prepareCall("{call sp1()}");
        ResultSet rs=cs.executeQuery("select * from callablestatement.table1");
        while(rs.next())
        {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
        }
        con.close();
        st.close();



    }

    }

