public class ex01 {
public static void main(String[] args) {
    String url = "jdbc:ucanaccess://C:\Users\Custom-tc-cen05\Desktop\03-04-2023\nonPoliceDatabase.accdb";

    Connection con;
    Statement stmt;
    String query = "Select * from nonPoliceEmployee";

    try {
        // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        con = DriverManager.getConnection(url, "", "");

        stmt = con.createStatement();

        // Returns a ResultSet that contains the data produced by the query;
        // never null
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("User Data:");
        System.out.println("FirstName\tLastName\tAge");

        while (rs.next()) {
            String fName = rs.getString("FirstName");
            String lName = rs.getString("LastName");
            int age = rs.getInt("age");
            System.out.println(fName + "\t" + lName + "\t" + age);
        }

        stmt.close();

        con.close();
    } catch (SQLException ex) {
        System.err.println("SQLException: " + ex.getMessage());
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}