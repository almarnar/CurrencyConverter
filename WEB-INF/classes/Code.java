
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Code extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/rar");
      
        try {
            response.setHeader("Content-Disposition",
                    "attachment;filename=code.rar");
            ServletContext ctx = getServletContext();
            InputStream is = ctx.getResourceAsStream("/code.rar");

            int read = 0;
            byte[] bytes = new byte[1024];
            OutputStream os = response.getOutputStream();


            while ((read = is.read(bytes)) != -1) {
                os.write(bytes, 0, read);
            }
            os.flush();
            os.close();
        } finally {
        }
    }
}