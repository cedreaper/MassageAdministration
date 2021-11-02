package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

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

    public static void updateClients() {

        FileWriter fileOut;
        FileWriter backup;
      

        try {

            fileOut = new FileWriter(new File("mcdb/bdtneilc.txt"));
            backup = new FileWriter(new File("mcdb/backup"));

            //////// Backup file generation first

            for (var c : clients) {

                backup.write(c.getName() + "\n");
                backup.write(c.getPhone() + "\n");
                backup.write(c.getAddress() + "\n");
                backup.write(c.getServiceType() + "\n");
                backup.write(c.getNextAppointment() + "\n");
                backup.write(c.getAppointmentTime() +"\n");
                backup.write(c.getPrice() + "\n");
                backup.write(c.getEmergencyName() + "\n");
                backup.write(c.getEmergencyPhone() + "\n");
                backup.write(c.getState() + "\n");
                backup.write(c.getCity() + "\n");
                backup.write(c.getZip() + "\n");
                backup.write(c.getWorkPhone() + "\n");
                backup.write(c.getEmail() + "\n");
                backup.write(c.getHistory() + "\n");
                backup.write(c.getMedicalNotes() + "\n");
                backup.write(c.getNotes() + "\n");

                //write check boxes

               for(int i = 0; i < 28; i++) {    

                    backup.write(Boolean.toString(c.getMedicalProblems().get(i)) + "\n");
                    
               }
    
            }

            backup.close();

           //write main file
           
           for (var c : clients) {

            fileOut.write(c.getName() + "\n");
            fileOut.write(c.getPhone() + "\n");
            fileOut.write(c.getAddress() + "\n");
            fileOut.write(c.getServiceType() + "\n");
            fileOut.write(c.getNextAppointment() + "\n");
            fileOut.write(c.getAppointmentTime() +"\n");
            fileOut.write(c.getPrice() + "\n");
            fileOut.write(c.getEmergencyName() + "\n");
            fileOut.write(c.getEmergencyPhone() + "\n");
            fileOut.write(c.getState() + "\n");
            fileOut.write(c.getCity() + "\n");
            fileOut.write(c.getZip() + "\n");
            fileOut.write(c.getWorkPhone() + "\n");
            fileOut.write(c.getEmail() + "\n");
            fileOut.write(c.getHistory() + "\n");
            fileOut.write(c.getMedicalNotes() + "\n");
            fileOut.write(c.getNotes() + "\n");

            for(int i = 0; i < 28; i++) {    

                fileOut.write(Boolean.toString(c.getMedicalProblems().get(i)) + "\n");
                   
            }

           }

           fileOut.close();
           

        }
        catch(Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: Changes have not been saved to the database.");

            return;

        }

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

 

   public static void resetLoaded() {

        loaded = 0;
   }

   

    
}
