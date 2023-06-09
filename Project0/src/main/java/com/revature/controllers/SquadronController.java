package com.revature.controllers;

import com.revature.models.Squadron;
import com.revature.service.SquadronService;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SquadronController {

    private static final SquadronService squadronService = new SquadronService();

    private static final Logger logger = LoggerFactory.getLogger(SquadronController.class);

//    public static void handleGetAll(Context ctx){
//        ctx.status(405);
//    }

    public static void handleGetOne(Context ctx){
        int id;
        try{
            id = Integer.parseInt(ctx.pathParam("id"));
        }catch(NumberFormatException e){
            ctx.status(400);
            logger.warn("Unable to parse id = " + ctx.pathParam("id"));
            return;
        }
        Squadron squadron = squadronService.getSquaByID(id);
        if(squadron != null){
            ctx.status(200);
            ctx.json(squadron);
            logger.info("The following squadron was obtained from db: " + squadron.toString());
        }else{
            ctx.status(400);
            logger.warn("No resource was found at id = " + id + " from ip: " + ctx.ip());
        }
    }

//    public static void handleCreate(Context ctx){
//        ctx.status(405);
//    }

    public static void handleUpdateLocation(Context ctx){
        Squadron submittedSquadron = ctx.bodyAsClass(Squadron.class);
        boolean updateSuccessful = squadronService.updateLocation(submittedSquadron.getBase_location(),
                                                                  submittedSquadron.getSqua_id());
        if (updateSuccessful){
            ctx.status(200);
            logger.info("The Base Location of Squadron: " + submittedSquadron.getSqua_name() + "with id" +
                    submittedSquadron.getSqua_id()
                    + "was updated to" + submittedSquadron.getBase_location());
        }else{
            ctx.status(400);
            logger.warn("The Base Location Update Failed!");
        }

    }

    public static void handleUpdateActivePersonal(Context ctx){
        Squadron submittedSquadron = ctx.bodyAsClass(Squadron.class);
        boolean updateSuccessful = squadronService.updateActivePersonal(submittedSquadron.getActive_personal(),
                                                                        submittedSquadron.getSqua_id());
        if (updateSuccessful){
            ctx.status(200);
            logger.info("The Active Personal of Squadron: " + submittedSquadron.getSqua_name() + "with id" +
                    submittedSquadron.getSqua_id()
                    + "was updated to" + submittedSquadron.getActive_personal());
        }else{
            ctx.status(400);
            logger.warn("The Active Personal Update Failed!");
        }

    }

//    public static void handleDelete(Context ctx){
//        ctx.status(405);
//    }

}
