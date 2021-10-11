package Tests;

import model.Client;

public class MassageTest {

    public static void main(String[] args) {


        Client c1 = new Client("Mark Benson", "405-799-1234");
        
        c1.setNextAppointment("2020-12-13"); ///////////////////////YYYY-MM-DD
        System.out.println(c1.getNextAppointment());
        assert c1.getNextAppointment() != null;
    }
    
}
