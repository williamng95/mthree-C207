package com.sg.booktracker;

import com.sg.booktracker.controller.BookController;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kyle David Rudy
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        
        // UserIO io = new UserIOConsoleImpl();
        // BookView view = new BookView(io);
        
        // BookDao dao = new BookDaoMemoryImpl();
        // BookService service = new BookService(dao);
        
        BookController controller = appContext.getBean("controller", BookController.class);
        controller.run();
    }
}
