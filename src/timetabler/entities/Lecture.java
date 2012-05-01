package timetabler.entities;

import com.trolltech.qt.gui.QLabel;

public class Lecture extends QLabel{
    
    private Term term;

    public Lecture(Term term) {
        this.term = term;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }
    
}
