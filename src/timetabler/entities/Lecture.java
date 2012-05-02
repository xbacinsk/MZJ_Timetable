package timetabler.entities;

import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QMouseEvent;

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

  @Override
  protected void mouseDoubleClickEvent(QMouseEvent me) {
    requestSettings.emit();
  }
}
