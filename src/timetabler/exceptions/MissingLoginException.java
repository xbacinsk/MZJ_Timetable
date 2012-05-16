package timetabler.exceptions;

/**
 * Exception which is thrown when no login information are available
 * 
 * @author Michal Kimle
 * @version 2012-05-04
 */
public class MissingLoginException extends Exception{

  public MissingLoginException(String message) {
    super(message);
  }
  
}
