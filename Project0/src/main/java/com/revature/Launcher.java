package com.revature;

import com.revature.daos.SquadronDAO;
import com.revature.daos.PersonalDAO;
import com.revature.models.Personal;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Launcher {

    public static void main(String[] args) {
        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("Connection Successful!!");
        }catch(SQLException e){
            System.out.println("Connection Failed!!");
        }

        SquadronDAO sDAO = new SquadronDAO();
        System.out.println(sDAO.getSquaById(2));

        PersonalDAO pDAO = new PersonalDAO();
        ArrayList<Personal> personalList = pDAO.getAllPersonals();

        for(Personal p : personalList){
            System.out.println(p);
        }

    }
}
