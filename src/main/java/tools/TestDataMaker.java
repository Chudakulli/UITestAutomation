package tools;

import java.sql.* ;

public class TestDataMaker {
    private static Connection con = null;
    static final String JDBC_DRIVER = PropertiesProvider.getProperty("JDBCdriver");
    private static String sqlUserName = PropertiesProvider.getProperty("sqlServerUsername");
    private static String sqlUserPass = PropertiesProvider.getProperty("sqlServerPassword");
    private static String sqlURL = PropertiesProvider.getProperty("sqlServerAddress");
    Connection conn = null;
    Statement stmt = null;
    String sql = "";

    public TestDataMaker() throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        System.out.println("Connecting to a selected database...");
        try {
            conn = DriverManager.getConnection(sqlURL, sqlUserName, sqlUserPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connected database successfully...");
    }

    public void insertRecordsToDB(String tableName, String records){
        try{

            //Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            sql = "INSERT INTO Compass.dbo." + tableName + " " + "VALUES " + records;
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    public void deleteRecordsFromDB(String tableName, String id){
        try{

        //Execute a query
        System.out.println("deleting records from the table...");
        stmt = conn.createStatement();

        sql = "DELETE FROM " + tableName + " " + "WHERE id > "+ id;
        stmt.executeUpdate(sql);
        System.out.println("Deleted records from the table...");


        } catch (SQLException e) {
        e.printStackTrace();
        } finally{
        //finally block used to close resources
        try{
        if(stmt!=null)
        conn.close();
        }catch(SQLException se){
        }// do nothing
        try{
        if(conn!=null)
        conn.close();
        }catch(SQLException se){
        se.printStackTrace();
        }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    public void TestData(){
        String[] LoginScenarios;
        String domain1 = "";
        String domain2 = "";
        String domain1user = "";
        String domain2user = "";

    }

}





