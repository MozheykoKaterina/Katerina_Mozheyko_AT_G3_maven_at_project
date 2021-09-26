package baseDate;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DbConnect {
    
    private static Properties prop = getProperties();
    
    public static void main(String[] args) {
        prop.forEach((k, v) -> System.out.println(v.toString()));
        String querry = "SHOW TABLES";
        //String querry = "DESCRIBE Products";
        //String querry = "select * from Products where Price > 20.00";
        execStatement(querry);
        //String querry = "select * from Categories where CategoryID = ?";
        //execPreparedStatement(querry, 3);
        loadCategories();
    }
    
    private static Properties getProperties() {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("src/test/resources/db.properties")) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
    
    private static MysqlDataSource getDataSourse(Properties prop) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(prop.getProperty("HOST"));
        dataSource.setPort(Integer.parseInt(prop.getProperty("PORT")));
        dataSource.setUser(prop.getProperty("USER"));
        dataSource.setPassword(prop.getProperty("PWD"));
        dataSource.setDatabaseName(prop.getProperty("DBNAME"));
        return dataSource;
    }
    
    private static void execStatement(String query) {
        try (Connection connection = getDataSourse(prop).getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query);) {
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + " | ");
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void execPreparedStatement(String querry, int id) {
        try (Connection connection = getDataSourse(prop).getConnection();
             PreparedStatement statement = connection.prepareStatement(querry)) {
            
            statement.setInt(1, id);
            
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.getString(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } ;
    }
    
    private static void loadCategories() {
        String querry = "SELECT * FROM Categories";
        List<Category> categories = new ArrayList<Category>();
        
        try (Connection connection = getDataSourse(prop).getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(querry)) {
            
            while (rs.next()) {
                categories.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        categories.forEach(category -> System.out.println(category.toString()));
    }
}