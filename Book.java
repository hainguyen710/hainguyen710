import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Book {
    public static Connection getConnection() throws SQLException {
        String dbURL = "jdbc:sqlsever://localhost:1433;databaseName=Book";
        String userName = "Book";
        String password = "sa";
        Connection connection = DriverManager.getConnection(dbURL, userName, password);
        if (getConnection() != null) {
            System.out.println("ket noi thanh cong");
        }
        return connection;
    }
    private String id;
    private String bookName;
    private String author;
    private Double price;

    public Book(String id, String bookName, String author, Double price) throws SQLException {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
