/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.ServletConfig;

/**
 *
 * @author alex
 */
public class Report5 extends HttpServlet {

    
    @Override
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Dog dog = (Dog) getServletContext().getAttribute("dog");

            response.sendRedirect(dog.getRep());
        } finally {
        }
    }

    @Override
    public void destroy() {
    }
}
