package servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xxiong.cvtc.web.Movie;
import xxiong4.cvtc.web.util.WorkbookUtility;

/**
 * Servlet implementation class MoviesListController
 */
@WebServlet("/MoviesList")
public class MoviesListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final String filePath = getServletContext().getRealPath(WorkbookUtility.INPUT_FILE);
			final File inputFile = new File(filePath);
			final List<Movie> movie = WorkbookUtility.retrieveMoviesFromWorkbook(inputFile);
			
			request.setAttribute("movie", movie);
			
			target = "movies-list.jsp";
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
			request.setAttribute("message", "There is a mistake here.");
			target = "index.jsp";
			
		}
		
		getServletContext().getRequestDispatcher(target).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
