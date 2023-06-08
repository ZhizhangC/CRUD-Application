package com.revature.daos;

import com.revature.models.Squadron;
public interface SquadronDAOInterface {
    Squadron getSquaById(int id);

    boolean updateSquaLocation(String location, int id);

    boolean updateSquaActivePersonal(int act_p, int id);
}
