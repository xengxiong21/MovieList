/**
 * 
 */
package cvtc.edu.web.dao;

import java.util.List;

import cvtc.edu.web.dao.impl.MovieDaoException;
import cvtc.edu.web.model.Movie;

/**
 * @author fish
 *
 */
public interface MovieDao {
	
	void populate(String filePath) throws MovieDaoException;
	
	List<Movie> retrieveMovie() throws MovieDaoException;
	
	void insertMovie(Movie movie) throws MovieDaoException;
	

}
