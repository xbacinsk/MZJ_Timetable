package timetabler.entities;

import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QMouseEvent;
import java.util.List;

/**
 * Seminar
 * 
 * Holds information about seminar
 * 
 * @author Michal Kimle
 * @version 2012-05-04
 */
public class Seminar extends QLabel {

  /**
   * all terms within seminar
   */
  private List<Term> terms;
  /**
   * term which is currently chosen in GUI
   */
  private Term chosen;
  public final Signal0 requestSettings = new Signal0();

  public Seminar(List<Term> terms, Term chosen) {
    this.terms = terms;
    this.chosen = chosen;
  }

  public Term getChosen() {
    return chosen;
  }

  public void setChosen(Term chosen) {
    this.chosen = chosen;
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
}
