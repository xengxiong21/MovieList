package cvtc.edu.web.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cvtc.edu.web.dao.MovieDao;
import cvtc.edu.web.dao.impl.MovieDaoImpl;
import cvtc.edu.web.model.Movie;

/**
 * Servlet implementation class MoviesListController
 */
@WebServlet("/ViewAll")
public class MoviesListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final MovieDao movieDao = new MovieDaoImpl();
			final List<Movie> movie = movieDao.retrieveMovie();
			
			final String sortType = request.getParameter("sortType");
			
			if (null != sortType) {
				sort(movie, sortType);
			}
			
			request.setAttribute("movie", movie);
			
			target = "view-all.jsp";
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			
			target = "error.jsp";
			
		}
		
		request.getRequestDispatcher(target).forward(request, response);
		
	}
	
	private void sort(final List<Movie> movie, final String sortType) {
		
		switch (sortType) {
		case "title":
			Collections.sort(movie, (m1, m2) -> m1.getTitle().compareTo(m2.getTitle()));
			break;
		case "director":
			Collections.sort(movie, (m1, m2) -> m1.getDirector().compareTo(m2.getDirector()));
			break;
		case "lengthInMinutes":
			//Collections.sort(movie, (m1, m2) -> m1.getLengthInMinutes().compareTo(m2.getLengthInMinutes()));
			break;
		default:
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
