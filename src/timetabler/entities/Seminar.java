package timetabler.entities;

import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QMouseEvent;
import java.util.List;

public class Seminar extends QLabel {

  private List<Term> terms;
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

  @Override
  protected void mouseDoubleClickEvent(QMouseEvent me) {
    requestSettings.emit();
  }
}
