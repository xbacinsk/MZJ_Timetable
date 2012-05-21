package timetabler.entities;

import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QMouseEvent;
import java.util.List;

/**
 * Holds information about lecture.
 *
 * All information are stored in its Term object.
 *
 * @author Michal Kimle
 * @version 2012-05-04
 */
public class Lecture extends QLabel {

    private List<Term> terms;
    public final Signal0 requestSettings = new Signal0();

    public Lecture(List<Term> terms) {
        this.terms = terms;
    }

    public List<Term> getTerms() {
        return terms;
    }

    public void setTerms(List<Term> terms) {
        this.terms = terms;
    }

    /**
     * Executes on mouse double-click
     *
     * emits request for course dialog
     *
     * @param me mouse event generated within double-click
     */
    @Override
    protected void mouseDoubleClickEvent(QMouseEvent me) {
        requestSettings.emit();
    }

    @Override
    public String toString() {
        return "Lecture{" + "terms=" + terms + '}';
    }
}
