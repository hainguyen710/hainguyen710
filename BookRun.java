package daoCrud;

import java.awt.print.Book;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRun implements BookFath{
    private static Connection connection;
    public BookRun(Connection conn){
        this.connection=conn;
    }
    @Override
    public static Book addFunction(Book book) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int result = 0;
        preparedStatement = connection.prepareStatement(addFunction());
        preparedStatement.setString(1,"BH213H");
        preparedStatement.setString(2,"Tat den");
        preparedStatement.setString(3,"Ngo Tat To");
        preparedStatement.setDouble(4,68);
        resultSet = preparedStatement.executeQuery();
        if(result > 0 ){
            System.out.println("Insert thanh cong");
        }else{
            System.out.println("Insert khong thanh cong");
        }

        return book;
    }
    @Override
    public String displayBook() throws Exception {
        String read = "select * from book";
        Statement statement = (Statement) connection.createStatement();
        ResultSet resultSet = statement.execute(read);
        while(resultSet.next()){
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String author = resultSet.getString(3);
            String price = resultSet.getString(4);
            System.out.println(id + " | " + name + " | " + author + " | " + price);
        }
        return "Thanh Cong";
    }
    @Override
    public String saveBook() throws SQLException{
        String querySave="insert into book values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(querySave);
         preparedStatement.setString(1,"B01010");
         preparedStatement.setString(2,"Song");
         preparedStatement.setString(3,"Xuan Quynh");
         preparedStatement.setDouble(4,98);
         preparedStatement.executeUpdate();
                 return "Thanh cong";
    }
}
