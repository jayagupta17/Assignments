package com.jaya.DAO;

import com.jaya.entity.Passenger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class PassengerDAO {
    private static String url = "jdbc:mysql://localhost:3306/gainsight";
    public boolean addPassenger(String fisrtName, String lastName, long mobile, String email) {
        int count = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "Jg@12345");
            pst = con.prepareStatement("insert into passengers(first_name, last_name, mobile, email) values(?,?,?,?)");
            pst.setString(1, fisrtName);
            pst.setString(2, lastName);
            pst.setLong(3, mobile);
            pst.setString(4, email);

            count = pst.executeUpdate();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if(pst!=null) pst.close();
                if(con!=null) con.close();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        return count==1;
    }

    public int getIdByEmail(String email) {
        int id=0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "Jg@12345");
            pst = con.prepareStatement("select passenger_id from passengers where email=?");
            pst.setString(1, email);
            rs = pst.executeQuery();
            if(rs.next())
                id = (rs.getInt(1));
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if(pst!=null) pst.close();
                if(con!=null) con.close();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        return id;
    }

    public Passenger getPassengerById(int passengerId) {
        Passenger passenger = new Passenger();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "Jg@12345");
            pst = con.prepareStatement("select * from passengers where passenger_id = ?");
            pst.setInt(1, passengerId);
            rs = pst.executeQuery();
            if(rs.next()) {
                passenger.setPassengerId(rs.getInt(1));
                passenger.setFirstName(rs.getString(2));
                passenger.setLastName(rs.getString(3));
                passenger.setMobile(rs.getLong(4));
                passenger.setEmail(rs.getString(5));
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if(pst!=null) pst.close();
                if(con!=null) con.close();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        return passenger;
    }
}
