package com.sg.classroster;

import com.sg.classroster.controller.ClassRosterController;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public final class App {
    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // UserIO myIo = new UserIOConsoleImpl();
        // ClassRosterView myView = new ClassRosterView(myIo);
        // ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        // ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        // ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        // ClassRosterController controller = new ClassRosterController(myView, myService);
        // controller.run();
        
        ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassRosterController controller = ctx.getBean("controller", ClassRosterController.class);
        controller.run();
    }
}
