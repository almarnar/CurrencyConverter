/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
import javax.servlet.*;

public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        ServletContext sc = sce.getServletContext();
        
        String report = sc.getInitParameter("rep");
        Dog d = new Dog(report);
        sc.setAttribute("dog", d);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
