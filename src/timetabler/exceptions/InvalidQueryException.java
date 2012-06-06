package timetabler.exceptions;

/**
 * Exception which is thrown when trying evaluate invalid xquery
 * 
 * @author Michal Kimle
 * @version 2012-05-04
 */
public class InvalidQueryException extends ParsingException{

  public InvalidQueryException(String message) {
    super(message);
  }
  
}
