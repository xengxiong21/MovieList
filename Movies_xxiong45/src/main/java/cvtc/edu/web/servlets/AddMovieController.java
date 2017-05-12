package cvtc.edu.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import cvtc.edu.web.dao.MovieDao;
import cvtc.edu.web.dao.impl.MovieDaoException;
import cvtc.edu.web.dao.impl.MovieDaoImpl;
import cvtc.edu.web.model.Movie;

/**
 * Servlet implementation class AddMovieController
 */
@WebServlet("/AddMovie")
public class AddMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final String title = request.getParameter("title");
			final String director = request.getParameter("director");
			final String lengthString = request.getParameter("lengthInMinutes");
			
			if(Strings.isNullOrEmpty(title) || Strings.isNullOrEmpty(director) || Strings.isNullOrEmpty(lengthString)) {
				
				request.setAttribute("message", "You must enter all the fields to submit the form.");
				target = "error.jsp";
				
			} else {
				
				final int length = Integer.parseInt(lengthString);
				final Movie movie = new Movie(title, director, length);
				
				final MovieDao movieDao = new MovieDaoImpl();
				movieDao.insertMovie(movie);
				
				request.setAttribute("message", "Thanks for submitting the completed form.");
				target = "success.jsp";
				
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("message", "Error You must enter a numeric value for age.");
			target = "error.jsp";

		} catch (MovieDaoException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
