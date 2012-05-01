/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timetabler3000;

import java.util.List;

/**
 *
 * @author Enthas
 */
class Seminar {
    
    private List<Term> terms;
    private Term chosen;

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
    
}
