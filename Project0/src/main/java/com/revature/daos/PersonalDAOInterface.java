package com.revature.daos;

import com.revature.models.Personal;

import java.util.ArrayList;

public interface PersonalDAOInterface {
    ArrayList<Personal> getAllPersonals();

    Personal insertPersonal(Personal p);

    Personal removePersonalById(int id);

    Personal getPersonalById(int id);

    boolean updatePersonalYearInService(int y, int id);

}
