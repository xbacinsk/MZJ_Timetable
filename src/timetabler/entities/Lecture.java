package timetabler.entities;

import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QMouseEvent;

/**
 * Holds information about lecture.
 * 
 * All information are stored in its Term object.
 * 
 * @author Michal Kimle
 * @version 2012-05-04
 */
public class Lecture extends QLabel {

  private Term term;
  public final Signal0 requestSettings = new Signal0();

  public Lecture(Term term) {
    this.term = term;
  }

  public Term getTerm() {
    return term;
  }

  public void setTerm(Term term) {
    this.term = term;
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
}
