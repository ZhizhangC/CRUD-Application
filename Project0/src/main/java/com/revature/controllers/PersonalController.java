package com.revature.controllers;


import com.revature.models.Personal;
import com.revature.models.Squadron;
import com.revature.service.PersonalService;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;



public class PersonalController {

    private static final PersonalService personalService = new PersonalService();

    private static final Logger logger = LoggerFactory.getLogger(PersonalController.class);
    public static void handleGetAll(Context ctx){
        ArrayList<Personal> personals = personalService.getAllPersonals();


        ctx.status(200);
        ctx.json(personals);
        logger.info("All Personals Are Retrieved!");
    }

    public static void handleCreate(Context ctx){
        Personal per = ctx.bodyAsClass(Personal.class);
        Personal returnedPersonal = personalService.createNewPersonal(per);
        if(returnedPersonal != null){
            ctx.status(201);
            ctx.json(returnedPersonal);
            logger.info("The following employee was created: " + returnedPersonal.toString());
        }else{
            ctx.status(400);
            logger.warn("Creation failed");
        }

    }

    public static void handleGetOne(Context ctx){
        int id;
        try{
            id = Integer.parseInt(ctx.pathParam("id"));
        }catch(NumberFormatException e){
            ctx.status(400);
            logger.warn("Unable to parse id = " + ctx.pathParam("id"));
            return;
        }
        Personal personal = personalService.getOnePersonal(id);
        if(personal != null){
            ctx.status(200);
            ctx.json(personal);
            logger.info("The following personal was obtained from db: " + personal.toString());
        }else{
            ctx.status(400);
            logger.warn("No resource was found at id = " + id + " from ip: " + ctx.ip());
        }
    }
//
//    public static void handleUpdate(Context ctx){
//        ctx.status(405);
//    }
//
//    public static void handleDelete(Context ctx){
//        ctx.status(405);
//    }

    public static void handleDeleteOne(Context ctx){
        int id;
        try{
            id = Integer.parseInt(ctx.pathParam("id"));
        }catch(NumberFormatException e){
            ctx.status(400);
            logger.warn("Unable to parse id = " + ctx.pathParam("id"));
            return;
        }
        Personal per = personalService.removePersonal(id);
        if(per != null){
            ctx.status(200);
            ctx.json(per);
            logger.info("The following personal was removed from db: " + per.toString());
        }else{
            ctx.status(400);
            logger.warn("No resource was found at id = " + id + " from ip: " + ctx.ip());
        }
    }

    public static void handleUpdateYearInService(Context ctx){
        int id;
        try{
            id = Integer.parseInt(ctx.pathParam("id"));
        }catch(NumberFormatException e){
            ctx.status(400);
            logger.warn("Unable to parse id = " + ctx.pathParam("id"));
            return;
        }
        Personal submittedPersonal = ctx.bodyAsClass(Personal.class);
        boolean updateSuccessful = personalService.updatePersonalYearInService(submittedPersonal.getYears_in_service(),
                                                                               submittedPersonal.getPersonal_id());
        if(updateSuccessful){
            ctx.status(200);
            logger.info("The Years of Service of Personal: " + submittedPersonal.getPersonal_name() + "with id" +
                        submittedPersonal.getPersonal_id()
                        + "was updated to" + submittedPersonal.getYears_in_service());
        }else {
            ctx.status(400);
            logger.warn("Years of Service Update Failed!");
        }
    }
}
