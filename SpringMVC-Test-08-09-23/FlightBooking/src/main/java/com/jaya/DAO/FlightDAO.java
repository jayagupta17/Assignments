package com.jaya.DAO;

import com.jaya.entity.Flight;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class FlightDAO {
    private static String url = "jdbc:mysql://localhost:3306/gainsight";
    public ArrayList<Flight> getFlights(String source, String destination)
    {
        ArrayList<Flight> flights = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "Jg@12345");
            pst = con.prepareStatement("select * from flights where source = ? and destination = ?");
            pst.setString(1, source);
            pst.setString(2, destination);
            rs = pst.executeQuery();
            while(rs.next())
                flights.add(new Flight(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5)));
        }
        catch(Exception ex) {
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
        return flights;
    }

    public Flight getFlightById(String flightId) {
        Flight flight = new Flight();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "Jg@12345");
            pst = con.prepareStatement("select * from flights where flight_id = ?");
            pst.setString(1, flightId);
            rs = pst.executeQuery();
            if(rs.next()) {
                flight.setFlightId(rs.getString(1));
                flight.setSource(rs.getString(2));
                flight.setDestination(rs.getString(3));
                flight.setFare(rs.getDouble(4));
                flight.setSeats(rs.getInt(5));
            }
        }
        catch(Exception ex) {
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
        return flight;
    }
}
