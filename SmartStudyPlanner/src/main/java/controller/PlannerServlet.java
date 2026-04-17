package controller;

import model.Subject;
import dao.SubjectDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class PlannerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String[] names = request.getParameterValues("name");
        String[] difficulty = request.getParameterValues("difficulty");

        List<Subject> subjects = new ArrayList<>();
        SubjectDAO dao = new SubjectDAO();

        // Safety check (VERY IMPORTANT)
        if (names == null || difficulty == null) {
            response.sendRedirect("jsp/index.jsp");
            return;
        }

        int totalSubjects = names.length;

        for (int i = 0; i < names.length; i++) {

            // Skip empty inputs
            if (names[i] == null || names[i].trim().isEmpty()) {
                continue;
            }

            int hours = 1;

            // Base allocation
            if (difficulty[i].equals("Hard")) {
                hours = 3;
            } else if (difficulty[i].equals("Medium")) {
                hours = 2;
            }

            // 🔥 Adaptive logic (AI-like behavior)

            // If many subjects → increase workload
            if (totalSubjects > 3) {
                hours += 1;
            }

            // Extra focus on hard subjects
            if (difficulty[i].equals("Hard")) {
                hours += 1;
            }

            // Create subject object
            Subject subject = new Subject(names[i], difficulty[i], hours);

            // Add to list
            subjects.add(subject);

            // 🔥 Save to database
            try {
                dao.saveSubject(subject);
            } catch (Exception e) {
                e.printStackTrace(); // won't crash app
            }
        }

        // Send data to JSP
        request.setAttribute("subjects", subjects);

        RequestDispatcher rd = request.getRequestDispatcher("jsp/dashboard.jsp");
        rd.forward(request, response);
    }
}