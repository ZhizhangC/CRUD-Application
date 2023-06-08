package com.revature.daos;

import com.revature.models.Personal;

import java.util.ArrayList;

public interface PersonalDAOInterface {
    ArrayList<Personal> getAllPersonals();

    Personal insertPersonal(Personal p);
}
