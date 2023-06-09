package com.revature.daos;

import com.revature.models.Personal;
import com.revature.models.Squadron;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class PersonalDAO implements PersonalDAOInterface{

    @Override
    public ArrayList<Personal> getAllPersonals() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM personal";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            ArrayList<Personal> personalList = new ArrayList<>();

            SquadronDAO sDAO = new SquadronDAO();

            while(rs.next()){
                Personal personal = new Personal(
                        rs.getInt("personal_id"),
                        rs.getString("personal_name"),
                        rs.getInt("years_in_service"),
                        sDAO.getSquaById(rs.getInt("squa_id_fk"))
                );
                personalList.add(personal);

            }
            return personalList;

        }catch (SQLException e){
            System.out.println("error getting all personal");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Personal insertPersonal(Personal p) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO personal (personal_name, years_in_service, squa_id_fk) VALUES(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getPersonal_name());
            ps.setInt(2, p.getYears_in_service());
            ps.setInt(3, p.getSqua_id_fk());

            ps.executeUpdate();

            return p;

        }catch (SQLException e){
            System.out.println("Insert Personal Failed");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Personal removePersonalById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String selectSql = "SELECT * FROM personal WHERE personal_id = ?";
            PreparedStatement selectPs = conn.prepareStatement(selectSql);
            selectPs.setInt(1, id);
            ResultSet rs = selectPs.executeQuery();
            SquadronDAO sDAO = new SquadronDAO();

            if(rs.next()) {
                Personal personal = new Personal(
                        rs.getInt("personal_id"),
                        rs.getString("personal_name"),
                        rs.getInt("years_in_service"),
                        sDAO.getSquaById(rs.getInt("squa_id_fk"))
                );

                String deleteSql = "DELETE FROM personal WHERE personal_id = ?";
                PreparedStatement deletePs = conn.prepareStatement(deleteSql);
                deletePs.setInt(1, id);
                int rowsAffected = deletePs.executeUpdate();

                if (rowsAffected > 0) {
                    return personal;
                }
            }
        }catch (SQLException e){
            System.out.println("Remove Personal Failed");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Personal getPersonalById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String selectSql = "SELECT * FROM personal WHERE personal_id = ?";
            PreparedStatement selectPs = conn.prepareStatement(selectSql);
            selectPs.setInt(1, id);
            ResultSet rs = selectPs.executeQuery();
            SquadronDAO sDAO = new SquadronDAO();

            if(rs.next()) {
                Personal personal = new Personal(
                        rs.getInt("personal_id"),
                        rs.getString("personal_name"),
                        rs.getInt("years_in_service"),
                        sDAO.getSquaById(rs.getInt("squa_id_fk"))
                );
                return personal;
            }
        }catch (SQLException e){
            System.out.println("Select Personal Failed");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatePersonalYearInService(int y, int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE personal SET years_in_service = ? WHERE personal_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, y);
            ps.setInt(2, id);

            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println("Updating Personal Years In Service Failed");
            e.printStackTrace();
        }
        return false;
    }
}
