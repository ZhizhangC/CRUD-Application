package com.revature.service;

import com.revature.daos.PersonalDAO;
import com.revature.daos.PersonalDAOInterface;
import com.revature.models.Personal;

import java.util.ArrayList;

public class PersonalService {
    private final PersonalDAOInterface personalDAO = new PersonalDAO();

    public ArrayList<Personal> getAllPersonals(){
        return personalDAO.getAllPersonals();
    }

    public Personal createNewPersonal(Personal per){
        return personalDAO.insertPersonal(per);
    }

    public Personal removePersonal(int id){
        return personalDAO.removePersonalById(id);
    }

    public Personal getOnePersonal(int id){
        return personalDAO.getPersonalById(id);
    }

    public boolean updatePersonalYearInService(int y, int id){
        return personalDAO.updatePersonalYearInService(y, id);
    }



}
