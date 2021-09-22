import view.LoginFrame;

// Main application file

public class App {


    public static void main(String[] args){


        var activeFrame = LoginFrame.getLoginFrame();

        activeFrame.loadFrame();
        activeFrame.setVisible(true);
        

    }

}