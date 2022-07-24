package Assigiment2.Student;

import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;

public class ProductList {
    Scanner sc = new Scanner(System.in);

    public Connection getConnection() throws SQLException {
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Student";
        String username ="sa";
        String password ="123456";
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        return connection;
    }

    public void connection() throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            System.err.println("Connected!");
        }
    }


    public void addProduct() throws SQLException {
        System.out.print("Enter product name: "); String name = sc.next();
        System.out.print("Enter product id: "); int id = sc.nextInt();
        System.out.print("Enter product price: "); String price = sc.next();
        String query = "INSERT INTO product VALUES(?,?,?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, price);
        int rowInserted = preparedStatement.executeUpdate();
        if (rowInserted > 0) {
            System.err.println("Inserted!");
        }
    }


    public void editProduct() throws SQLException {
        System.out.print("Enter product name: "); String name = sc.next();
        System.out.print("Enter product id: "); int id = sc.nextInt();
        System.out.print("Enter product price: "); String price = sc.next();
        Connection connection = getConnection();
        String query = "UPDATE product SET name = ? , price = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(3, id);
        preparedStatement.setString(2,price);
        int rowUpdated = preparedStatement.executeUpdate();
        if (rowUpdated > 0) {
            System.err.println("Updated!");
        }
    }

    public void deleteProduct() throws SQLException {
        System.out.print("Enter product id: "); int id = sc.nextInt();
        Connection connection = getConnection();
        String query = "DELETE FROM product WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        int rowDelete = preparedStatement.executeUpdate();
        if (rowDelete > 0) {
            System.err.println("Deleted!");
        }
    }

    public void viewAll() throws SQLException {
        String query = "SELECT * FROM product ORDER BY id";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("names");
            String price = resultSet.getString("price");
            System.out.println(id + " " + name + " " + price);
        }
    }

    public void searchById() throws  SQLException {
        System.out.print("Enter id: " ); int idS = sc.nextInt();
        Connection connection = getConnection();
        String query = ("SELECT * FROM product WHERE id = ?");
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idS);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString("names");
            String price = resultSet.getString("price");
            System.out.println();
            System.out.println(id + " " + name + " " + price);
            System.out.println();
        }
    }

    public void searchByName() throws  SQLException {
        System.out.print("Enter name: " ); String nameS = sc.nextLine();
        Connection connection = getConnection();
        String query = ("SELECT * FROM product WHERE names = ?");
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nameS);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString("names");
            String price = resultSet.getString("price");
            System.out.println(id + " " + name + " " + price);
        }
    }
}