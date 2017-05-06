package cvtc.edu.web.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import cvtc.edu.web.model.Movie;
import cvtc.edu.web.util.WorkbookUtility;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/Search")
public class SearchController extends HttpServlet {
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
			
			final String title = request.getParameter("title");
			
			final List<Movie> filteredMovie = movie
					.stream()
					.filter((Person) -> Person.getTitle().equalsIgnoreCase(title))
					.collect(Collectors.toList());
			
			request.setAttribute("", filteredMovie);
			
			target = "view-all.jsp";
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			request.setAttribute("message", "The workbook file has an invalid format");
			target = "error.jsp";
		
		}
		
		request.getRequestDispatcher(target).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
