import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class SubmitInquiryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");
        String brand = request.getParameter("brand");
        String budget = request.getParameter("budget");
        String contact = request.getParameter("contact");
        String location = request.getParameter("location");

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO inquiry (category, brand, budget, contact, location) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category);
            stmt.setString(2, brand);
            stmt.setString(3, budget);
            stmt.setString(4, contact);
            stmt.setString(5, location);

            int rowsInserted = stmt.executeUpdate();
            stmt.close();
            conn.close();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (rowsInserted > 0) {
                out.println("<html><body style='background-color:#0f2027; color:white; text-align:center;'>");
                out.println("<h2>Inquiry Submitted Successfully!</h2>");
                out.println("<h3>Thanks for Visiting Techaj ©</h3>");
                out.println("</body></html>");
            } else {
                out.println("Error submitting inquiry.");
            }
        } catch (Exception e) {
            throw new ServletException("Database Error: " + e.getMessage());
        }
    }
}