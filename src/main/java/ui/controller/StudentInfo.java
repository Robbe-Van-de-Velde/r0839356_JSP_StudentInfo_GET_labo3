package ui.controller;

import domain.db.StudentDB;
import domain.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentInfo")
public class StudentInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        StudentDB database = new StudentDB();

        Student robbe = new Student("Van de Velde", "Robbe", "Toegepaste informatica", 19);
        Student mieke = new Student("Janssens", "Mieke", "TEW", 21);
        Student niels = new Student("Verheyden", "Niels", "Elektronica", 20);

        database.voegStudentToe(robbe);
        database.voegStudentToe(mieke);
        database.voegStudentToe(niels);

        String ingegevenNaam = request.getParameter("naam");
        String ingegevenVoornaam = request.getParameter("voornaam");

        if (database.bevatStudent(ingegevenNaam, ingegevenVoornaam)){
            Student gevondenStudent = database.getStudent(ingegevenNaam, ingegevenVoornaam);
            String resultMessage =
                    "Je vroeg naar volgende gegevens: " + gevondenStudent.getNaam() + " " + gevondenStudent.getVoornaam() + " (" + gevondenStudent.getLeeftijd() + " jaar): " + gevondenStudent.getStudierichting();
            request.setAttribute("result", resultMessage);
            RequestDispatcher view = request.getRequestDispatcher("gevonden.jsp");
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("nietgevonden.jsp");
            view.forward(request,response);
        }

    }
}
