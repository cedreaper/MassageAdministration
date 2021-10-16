package model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Client {

    //class for massage client information

    private ArrayList<Boolean> medicalProblems = new ArrayList<>();
    
   

    private String name;
    private String phone;
    private String address;
    private String serviceType;
    private String nextAppointment;
    private String appointmentTime;
    private String price;
    private String email;
    private String workPhone;
    private String emergencyName;
    private String emergencyPhone;
    private String state;
    private String city;
    private String zip;
    private String history;
    private String medicalNotes;
    private String notes;
    
    

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

    public String getServiceType() {

        if(serviceType != null) {

            return serviceType;
        }

        return "";
    }

    public String getAppointmentTime() {

        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {

        this.appointmentTime = appointmentTime;
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

    public String getHistory() {

        return history;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }


    public String getEmail() {
        return email;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public String getPrice() {
        return price;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getNotes() {

        return notes;
    }

    public String getMedicalNotes() {

        return medicalNotes;
    }

    public ArrayList<Boolean> getMedicalProblems() {

        return medicalProblems;
    }

    public String getRate() {

        return price;
    }

    public void setRate(String price) {

        this.price = price;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public void setMedicalNotes(String medicalNotes) {
        this.medicalNotes = medicalNotes;
    }

    public void setMedicalProblems(ArrayList<Boolean> medicalProblems) {
        this.medicalProblems = medicalProblems;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    @Override
    public String toString() {

        return name;
        
    }

}
