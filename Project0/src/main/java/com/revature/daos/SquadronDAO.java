package com.revature.daos;

import com.revature.models.Squadron;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SquadronDAO implements SquadronDAOInterface{
    @Override
    public Squadron getSquaById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM squadron WHERE squa_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                Squadron squadron = new Squadron(
                        rs.getInt("squa_id"),
                        rs.getString("squa_name"),
                        rs.getInt("active_personal"),
                        rs.getString("base_location"),
                        rs.getString("aircraft_type")
                );
                return squadron;
            }

        }catch (SQLException e){
            System.out.println("error getting Squadron");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateSquaLocation(String location, int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE squadron SET base_location = ? WHERE squa_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, location);
            ps.setInt(2, id);

            ps.executeUpdate();

            return true;
        }catch (SQLException e){
            System.out.println("Updating Squadron Location Failed");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateSquaActivePersonal(int act_p, int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE squadron SET active_personal = ? WHERE squa_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, act_p);
            ps.setInt(2, id);

            ps.executeUpdate();

            return true;
        }catch (SQLException e){
            System.out.println("Updating Active Personal Failed");
            e.printStackTrace();
        }
        return false;
    }
}
