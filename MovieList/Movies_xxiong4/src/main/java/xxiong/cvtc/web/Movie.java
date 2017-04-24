/**
 * 
 */
package xxiong.cvtc.web;

/**
 * @author fish
 *
 */
public class Movie {
	
	private String title;
	private String director;
	private int lengthInMinutes;
	
	
	public Movie(final String title, final String director,final int lengthInMinutes) {
		
		this.title = title;
		this.director = director;
		this.lengthInMinutes = lengthInMinutes;
		
	}
	
	public Movie() {
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLengthInMinutes() {
		return lengthInMinutes;
	}
	public void setLengthInMinutes(int lengthInMinutes) {
		this.lengthInMinutes = lengthInMinutes;
	}
	
}
