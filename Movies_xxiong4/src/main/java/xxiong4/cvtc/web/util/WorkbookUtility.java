/**
 * 
 */
package xxiong4.cvtc.web.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import xxiong.cvtc.web.Movie;

/**
 * @author fish
 *
 */
public class WorkbookUtility {
	
public static final String INPUT_FILE = "/assets/moviesList.xlsx";
	
	public static List<Movie> retrieveMoviesFromWorkbook(final File inputFile) throws InvalidFormatException, IOException {
		
		final List<Movie> moviesList = new ArrayList<>();
		
		final Workbook workbook = WorkbookFactory.create(inputFile);
		
		final Sheet sheet = workbook.getSheetAt(0);

		for (final Row row : sheet) {
			final Cell movieTitleCell = row.getCell(0);
			final Cell directorNameCell = row.getCell(1);
			final Cell lengthInMinutesCell = row.getCell(2);
			
			final Movie movies = new Movie();
			movies.setDirector(directorNameCell.getStringCellValue().trim());
			movies.setTitle(movieTitleCell.getStringCellValue().trim());
			movies.setLengthInMinutes(( int) lengthInMinutesCell.getNumericCellValue());
			
			
			moviesList.add(movies);
			
		}
		
		return moviesList;
		
	}

	
	
	
	
	
	
	
	

}
