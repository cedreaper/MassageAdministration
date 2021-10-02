package model;


import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Client {

    //class for massage clientelle information

    private ArrayList<String> history;
    private String name;
    private String phone;
    private String address;
    private String healthComments;
    private String serviceType;
    private String nextAppointment;
    private double rate;
    

    public Client(String name, String phone) {

        this.name = name;
        this.phone = phone;

    }

    public String getName() {

        return name;
    }

    public String getAddress() {

        if(address != null) {

            return address;
        }

        return "";
        
    }

    public String getPhone() {

        return phone;
    }

    public String getHealthComments() {

        if(healthComments != null) {

            return healthComments;
        }

        return "";
    }

    public String getServiceType() {

        if(serviceType != null) {

            return serviceType;
        }

        return "";
    }

    public String getNextAppointment() {

        return nextAppointment;
    }

    public void setNextAppointment(String nextAppointment) {

        try {
            LocalDate.parse(nextAppointment);
            this.nextAppointment = nextAppointment;
        }
        catch(DateTimeParseException e) {

            return;

        }
    }

    public ArrayList<String> getHistory() {

        return history;
    }

    public Double getRate() {

        return rate;
    }

    public void setRate(double rate) {

        this.rate = rate;
    }

    public void setServiceType(String serviceType) {

        this.serviceType = serviceType;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    @Override
    public String toString() {

        return name + " | " + phone;
    }

}
