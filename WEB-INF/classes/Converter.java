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
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.XMLOutputter;
import org.jdom.input.SAXBuilder;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;

/**
 *
 * @author alex
 */
public class Converter extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Vector currency = new Vector();
    Vector rate = new Vector();
    String xmlLink;

    @Override
    public void init(ServletConfig sc) {

        try {
            super.init(sc);
        } catch (ServletException ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
        }
        xmlLink = sc.getInitParameter("Par1");
        System.out.println(xmlLink);

        int number;
        //we make an object of org.jdom.input.SAXBuilder with no-args constructor 
        SAXBuilder saxBuilder = new SAXBuilder();


        try {
            // we call the Builder's build() method to build a document object from an xml file

            Document document = saxBuilder.build(xmlLink);
            // we navigate the document using the methods of the document class, the Element class
            //we get the root of the xml file (gesmes:Envelope)
            Element root = document.getRootElement();
            //we get the children of the root and we put them into a list
            //this list consists of 3 children <gesmes:Envelope>,<gesmes:Sender>,<Cube>
            List kids = root.getChildren();
            //We want the children of Cube so we consider the list and we take its third element
            Element cubeRoot = (Element) kids.get(2);
            //We get the children of cube and we put them into a list
            //this list consists of 1 children <Cube> 
            List cubeKids = cubeRoot.getChildren();
            //We want the children of Cube so we consider the list and we take its first element
            Element cubeRoot2 = (Element) cubeKids.get(0);
            //we get the children of cube and we put them into a list
            //this list consists of 33 children <Cube>....<Cube>
            List cubeKids2 = cubeRoot2.getChildren();

            //diatrexw th lista kai apo ka8e stoixeio ths anaktw to currency kai to rate
            for (number = 0; number < 33; number++) {
                Element kid = (Element) cubeKids2.get(number);
                currency.add((String) kid.getAttribute("currency").getValue());
                currency.trimToSize();
                rate.add((String) kid.getAttribute("rate").getValue());
                rate.trimToSize();
            }

        } catch (JDOMException ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        try {
            int a;

            double rateFrom = 0.0;
            double rateTo = 0.0;
            double result = 0.0;
            double amnt = 0;

            //we get the info that the user gives filling the form
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            String amount = request.getParameter("amount");

            try {
                amnt = Double.parseDouble(amount);
				
				for (a = 0; a < currency.size(); a++) {
                String str2 = (String) currency.get(a);
                if (str2.equals(to) == true) {
                    String str4 = (String) rate.get(a);
                    rateTo = Double.parseDouble(str4);
                }
				}
				for (a = 0; a < currency.size(); a++) {
                String str1 = (String) currency.get(a);

                if (str1.equals(from) == true) {
                    System.out.println("test1");
                    String str3 = (String) rate.get(a);
                    System.out.println(str3);
                    rateFrom = Double.parseDouble(str3);
                }
            }
            if (from.equals(to) == true) {
                result = 1.0 * amnt;
            } else if (from.equals("EUR") == true) {
                result = amnt * rateTo;
            } else if (to.equals("EUR") == true) {
                result = amnt * (1 / rateFrom);
            } else {
                result = amnt * (rateTo / rateFrom);
            }

            System.out.println("rateTo:" + rateTo);
            System.out.println("rateFrom:" + rateFrom);

            response.sendRedirect("index.jsp?result=" + result);
            } catch (NumberFormatException nfe) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.html");
                rd.forward(request, response);
            }

            

        } finally {
        }
    }

    @Override
    public void destroy() {
    }
}
