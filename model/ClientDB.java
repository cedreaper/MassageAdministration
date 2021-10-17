package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ClientDB {

    private static ArrayList<Client> clients = new ArrayList<>();
    private static String dbErrMsg = "";
    private static Client selectedClient = null;
    private static int loaded = 0;
    

    public ClientDB() { 

        
    }

    public static void loadClients() {

        if(loaded > 0) {
            
            return;
        }

        Scanner fileIn = new Scanner(System.in);

        try {

            fileIn = new Scanner(new File("mcdb/bdtneilc.txt"));
            
        }
        catch(Exception e) {

            System.out.println("Error" + e.toString());
        }

        while(fileIn.hasNext()) {

            String name = fileIn.nextLine();
            String phone = fileIn.nextLine();
                
            Client c = new Client(name, phone);

            c.setAddress(fileIn.nextLine());
            c.setServiceType(fileIn.nextLine());
            c.setNextAppointment(fileIn.nextLine());
            c.setAppointmentTime(fileIn.nextLine());
            c.setPrice(fileIn.nextLine());
            c.setEmergencyName(fileIn.nextLine());
            c.setEmergencyPhone(fileIn.nextLine());
            c.setState(fileIn.nextLine());
            c.setCity(fileIn.nextLine());
            c.setZip(fileIn.nextLine());
            c.setWorkPhone(fileIn.nextLine());
            c.setEmail(fileIn.nextLine());
            c.setHistory(fileIn.nextLine());
            c.setMedicalNotes(fileIn.nextLine());
            c.setNotes(fileIn.nextLine());


            for(int i = 0; i < 28; i++) {
                
                Boolean isWhat;

                String value = fileIn.nextLine();

                if(value.equals("true")) {

                    isWhat = true;
                    c.getMedicalProblems().add(isWhat);
                }
                else if(value.equals("false")) {

                    isWhat = false;
                    c.getMedicalProblems().add(isWhat);

                }
              
               
            }

            //add client
            clients.add(c);

        }

        fileIn.close();

        selectedClient = clients.get(0);

        loaded++;
    }

    public static ArrayList<Client> getClients() {

        return clients;
    }

    public static void updateAll() {


    }

    public static void updateClient(Client client) {


    }

   public static void removeClient(Client client) {

   }

   public static String getDbErrMsg() {

        return dbErrMsg;

   }

   public static Client getSelectedClient() {

        return selectedClient;

   }

   public static void setSelectedClient(int index) {

     
        selectedClient = clients.get(index); 

   }

   

    
}
