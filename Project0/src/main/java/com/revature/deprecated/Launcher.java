package com.revature.deprecated;

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

        //Retrieve From squadron Table
//        SquadronDAO sDAO = new SquadronDAO();
//        System.out.println(sDAO.getSquaById(2));
        //End Retrieve From squadron Table

        //Update Base Location In squadron Table
//        SquadronDAO sDAO = new SquadronDAO();
//        System.out.println("Updating...");
//        System.out.println(sDAO.updateSquaLocation("Norfolk", 1));
//        System.out.println("Update Complete!");
        //End Update Years In Service In personal Table

        //Update Active Personal In squadron Table
//        SquadronDAO sDAO = new SquadronDAO();
//        System.out.println("Updating...");
//        System.out.println(sDAO.updateSquaActivePersonal(84, 3));
//        System.out.println("Update Complete!");
        //End Update Years In Service In personal Table


        //Retrieve From personal Table
//        PersonalDAO pDAO = new PersonalDAO();
//        System.out.println("Selecting...");
//        System.out.println(pDAO.getPersonalById(5));
//        System.out.println("Selection Complete!");
        //End Retrieve From personal Table

        //Insert Into personal Table
//        PersonalDAO pDAO = new PersonalDAO();
//        Personal newPerson = new Personal("Yoshi", 4, 4);
//        System.out.println("Inserting...");
//        System.out.println(pDAO.insertPersonal(newPerson));
//        System.out.println("Insertion Complete!");
        //End Insert Into personal Table

        //Update Years In Service In personal Table
//        PersonalDAO pDAO = new PersonalDAO();
//        System.out.println("Updating...");
//        System.out.println(pDAO.updatePersonalYearInService(4, 10));
//        System.out.println("Update Complete!");
        //End Update Years In Service In personal Table

        //Remove From personal Table
//        PersonalDAO pDAOr = new PersonalDAO();
//        System.out.println("Removing...");
//        System.out.println(pDAOr.removePersonalById(6));
//        System.out.println("Remove Complete!");
        //End Remove From personal Table

        //Display Personal
        PersonalDAO pDAOAll = new PersonalDAO();
        ArrayList<Personal> personalList = pDAOAll.getAllPersonals();

        for(Personal p : personalList){
            System.out.println(p);
        }
        //End Display Personal
    }
}
