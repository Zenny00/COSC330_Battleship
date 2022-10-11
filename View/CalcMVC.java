// CalcMVC.java -- Calculator in MVC pattern.

import javax.swing.*;

public class CalcMVC {
    //... Create model, view, and controller.  They are
    //    created once here and passed to the parts that
    //    need them so there is only one copy of each.
    public static void main(String[] args) {
        
        //CalcModel      model      = new CalcModel();
        View view = new View;
        Player controller = new Player(view);
        
        view.setVisible(true);
    }
}
