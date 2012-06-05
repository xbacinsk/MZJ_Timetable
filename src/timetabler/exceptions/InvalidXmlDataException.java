package timetabler.exceptions;

/**
 * Exception which is thrown when loaded xml data is not in right format
 * 
 * @author Michal Kimle
 * @version 2012-06-04
 */
public class InvalidXmlDataException extends Exception{
    
    public InvalidXmlDataException(String message){
        super(message);
    }
}
