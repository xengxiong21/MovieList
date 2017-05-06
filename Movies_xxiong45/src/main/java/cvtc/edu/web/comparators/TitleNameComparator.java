/**
 * 
 */
package cvtc.edu.web.comparators;

import java.util.Comparator;

import cvtc.edu.web.model.Movie;

/**
 * @author fish
 *
 */
public class TitleNameComparator implements Comparator<Movie> {
	
	@Override
	public int compare(Movie movie1, Movie movie2) {
		
		return movie1.getTitle().compareTo(movie2.getTitle());
		
	}

}
