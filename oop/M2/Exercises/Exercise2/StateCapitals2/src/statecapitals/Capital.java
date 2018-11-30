/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals;

/**
 *
 * @author xito9
 */
public class Capital {

    public Capital(String name, int pop, double miles) {
        capitalName = name;
        capitalPop = pop;
        sqMiles = miles;
    }
        
    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public int getCapitalPop() {
        return capitalPop;
    }

    public void setCapitalPop(int capitalPop) {
        this.capitalPop = capitalPop;
    }

    public double getSqMiles() {
        return sqMiles;
    }

    public void setSqMiles(double sqMiles) {
        this.sqMiles = sqMiles;
    }
    String capitalName;
    int capitalPop;
    double sqMiles;

}
