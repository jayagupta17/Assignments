package com.jaya.DAO;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Repository
public class BookingDAO {
    private static String url = "jdbc:mysql://localhost:3306/gainsight";
    public boolean addBooking(String flightId, int passengerId) {
        int count = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "Jg@12345");
            pst = con.prepareStatement("insert into bookings(flight_id, passenger_id) values(?,?)");
            pst.setString(1, flightId);
            pst.setInt(2, passengerId);

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
}
