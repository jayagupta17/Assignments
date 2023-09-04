package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookStore {
    private static String url = "jdbc:mysql://localhost:3306/gainsight";
    public boolean addBook(Book b)
    {
        int count = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "Jg@12345");
            pst = con.prepareStatement("insert into Book values(?,?,?,?,?)");
            pst.setString(1, b.getBookId());
            pst.setString(2, b.getTitle());
            pst.setString(3, b.getAuthor());
            pst.setString(4, b.getCategory());
            pst.setDouble(5, b.getPrice());
            count = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            try {
                if(rs!=null) rs.close();
                if(pst!=null) pst.close();
                if(con!=null) con.close();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        return count==1;
    }
    public boolean searchByTitle(String title)
    {
        int count=0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "Jg@12345");
            pst = con.prepareStatement("select * from Book where title = ?");
            pst.setString(1, title);
            rs = pst.executeQuery();
            while (rs.next()) {
                count += 1;
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getDouble(5));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            try {
                if(rs!=null) rs.close();
                if(pst!=null) pst.close();
                if(con!=null) con.close();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        return count>0;
    }
    public boolean searchByAuthor(String author)
    {
        int count=0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "Jg@12345");
            pst = con.prepareStatement("select * from Book where author = ?");
            pst.setString(1, author);
            rs = pst.executeQuery();
            while (rs.next()) {
                count += 1;
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getDouble(5));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
                try {
                    if(rs!=null) rs.close();
                    if(pst!=null) pst.close();
                    if(con!=null) con.close();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        return count>0;
    }
    public void displayAll()
    {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "Jg@12345");
            pst = con.prepareStatement("select * from Book");
            rs = pst.executeQuery();
            while(rs.next())
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getDouble(5));
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            try {
                if(rs!=null) rs.close();
                if(pst!=null) pst.close();
                if(con!=null) con.close();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
