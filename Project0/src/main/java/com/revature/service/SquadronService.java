package com.revature.service;

import com.revature.daos.SquadronDAO;
import com.revature.daos.SquadronDAOInterface;
import com.revature.models.Squadron;

public class SquadronService {

    private final SquadronDAOInterface squadDao = new SquadronDAO();

    public Squadron getSquaByID(int id){
        if(id > 0){
            return squadDao.getSquaById(id);
        }else{
            return null;
        }
    }

    public boolean updateLocation(String loc, int id){
        if(id <= 0){
            return false;
        }

        if(loc != null && !loc.trim().equals("")){
            return squadDao.updateSquaLocation(loc, id);
        }
        return false;
    }

    public boolean updateActivePersonal(int act_p, int id){
        if(id <= 0){
            return false;
        }

        if(act_p > 0){
            return squadDao.updateSquaActivePersonal(act_p, id);
        }
        return false;
    }
}
