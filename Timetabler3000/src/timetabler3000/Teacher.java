/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timetabler3000;

/**
 *
 * @author Enthas
 */
class Teacher {
    
    private String name;
    private Integer uco;

    public Teacher(String name, Integer uco) {
        this.name = name;
        this.uco = uco;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUco() {
        return uco;
    }

    public void setUco(Integer uco) {
        this.uco = uco;
    }
    
}
