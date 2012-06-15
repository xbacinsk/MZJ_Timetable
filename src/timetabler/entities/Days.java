package timetabler.entities;

/**
 * Used to represent a day of week as a parameter in Lecture and Seminar objects.
 * 
 * @author Enthas
 */
public enum Days {
    MON("monday"), 
    TUE("tuesday"), 
    WED("wednesday"), 
    THU("thursday"), 
    FRI("friday"), 
    SAT("saturday"), 
    SUN("sunday");
    
    private String text;

    Days(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Days fromString(String text) {
        if (text != null) {
        for (Days day : Days.values()) {
            if (text.equalsIgnoreCase(day.text)) {
            return day;
            }
        }
        }
        return null;
    }
}