package com.revature.daos;

import com.revature.models.Personal;
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
}
