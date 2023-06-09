package com.revature;

import com.revature.controllers.PersonalController;
import com.revature.utils.JavalinAppConfig;
import io.javalin.Javalin;

public class AppDriver {
    public static void main(String[] args) {

//        Javalin app = Javalin.create().get("/", PersonalController::handleGetAll).start(7070);
        JavalinAppConfig app = new JavalinAppConfig();

        app.start(7070);
    }
}
