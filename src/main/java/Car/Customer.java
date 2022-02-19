package Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Customer {

    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<Rental> rentals = new ArrayList<>();
        Vehicle vehicle1 = null;
        Rental rental1;
        Vehicle v;
        Scanner sc = new Scanner(System.in);
        int selection;
        Integer num=0;
        String customerName="";
        FileWriter myWriter;
        FileWriter myWriter1;
        Scanner input = new Scanner(System.in);
        int temp=0;

        try {
            myWriter = new FileWriter("C:/Users/246714/IdeaProjects/JavaLab_Excercise_Part2/src/main/resources/Vehicle.csv");
            myWriter1 = new FileWriter("C:/Users/246714/IdeaProjects/JavaLab_Excercise_Part2/src/main/resources/rentalcustomerdetail.csv");

            int array[] = new int[2];
            String  Name[] = new String[2];
            while (temp!=8) {
                System.out.println("\n1.Enter Vehicle Record\n"+
                        "2.Enter Customer Record\n" +
                        "3.Cars Avilable For Rent \n" +
                        "4.Cars currently on rent \n" +
                        "5.Avilability check \n" +
                        "6.Add New Vehicle\n" +
                        "7.Cancellation of a vehicle \n" +
                        "8.Import Data to CSV File\n" +
                        "9.Export Data from CSV File\n" +
                        "10.Exit"
                );
                //Vehicle Record
                int option = sc.nextInt();
                switch (option) {
                    case 1:

                    System.out.println("********* Enter Vehicle Data *********");

                        System.out.println("Enter identification code= ");
                        int idcode = sc.nextInt();
                        sc.nextLine();

                        sc = new Scanner(System.in);
                        System.out.println("Enter brand= ");
                        String brandName = sc.nextLine();

                        sc = new Scanner(System.in);
                        System.out.println("Enter Model= ");
                        String model = sc.nextLine();

                        sc = new Scanner(System.in);
                        System.out.println("Enter number of Seats= ");
                        int seats = sc.nextInt();
                        sc.nextLine();

                        sc = new Scanner(System.in);
                        System.out.println("Enter license plate= ");
                        String lp = sc.nextLine();


                        vehicle1 = new Vehicle(idcode, brandName, model, seats, lp);
                        vehicles.add(vehicle1);


                    break;


                    //Customer Record
                    case 2:
                    if(vehicles.size()>=1) {
                        System.out.println("Enter Name Of customer=");
                        sc = new Scanner(System.in);
                        customerName = sc.nextLine();

                        System.out.println("Enter Number of your choice");
                        for (int i = 0; i < vehicles.size(); i++) {
                            System.out.println((i + 1) + "-"
                                    + "Identification_code=" + vehicles.get(i).getIdentification_code()
                                    + " " + "Brand=" + vehicles.get(i).getBrand()
                                    + " " + "Model=" + vehicles.get(i).getModel()
                                    + " " + "No of seats=" + vehicles.get(i).getNumber_of_seats()
                                    + " " + "License Plate=" + vehicles.get(i).getLicense_plate());
                        }
                        selection = input.nextInt();


                        System.out.println("Enter start Date(dd-mm-yyyy) : ");
                        String date = sc.nextLine();
                        Date date1 = null;
                        date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);


                        System.out.println("Enter End Date(dd-mm-yyyy) : ");
                        String date0 = sc.nextLine();
                        Date date2 = null;
                        date2 = new SimpleDateFormat("dd-MM-yyyy").parse(date0);

                        long timediff = date2.getTime() - date1.getTime();
                        long days = (timediff / (1000 * 60 * 60 * 24));

                        System.out.println(days + " Days Car Required On rent");


                        if (vehicles.size() >= 1) {
                            v = new Vehicle(vehicles.get(selection - 1).getIdentification_code(), vehicles.get(selection - 1).getBrand(), vehicles.get(selection - 1).getModel(), vehicles.get(selection - 1).getNumber_of_seats(), vehicles.get(selection - 1).getLicense_plate());
                            vehicles.remove(selection - 1);
                        } else {
                            v = new Vehicle(vehicles.get(0).getIdentification_code(), vehicles.get(0).getBrand(), vehicles.get(0).getModel(), vehicles.get(0).getNumber_of_seats(), vehicles.get(0).getLicense_plate());
                            vehicles.remove(0);
                        }


                        rental1 = new Rental(customerName, date1.toString(), date2.toString(), (int) days, selection, v);
                        rentals.add(rental1);

                    }else {
                        System.out.println("Please Enter vehicle Record To book a car ");
                    }

                    break;
                    //Cars Available for Rent
                    case 3:
                    System.out.println("**********Cars Available for Rent*************");
                        if(vehicles.size()>0) {
                            for (int i = 0; i < vehicles.size(); i++) {
                                System.out.println((i + 1) + "." + "Identification code=" + vehicles.get(i).getIdentification_code()
                                        + "," + "Brand=" + vehicles.get(i).getBrand()
                                        + "," + "Model=" + vehicles.get(i).getModel()
                                        + "," + "No of Seats=" + vehicles.get(i).getNumber_of_seats()
                                        + "," + "License plate=" + vehicles.get(i).getLicense_plate());
                            }
                        }else {
                            System.out.println("Currently no Car is Avilable on Rent");
                        }
                            System.out.println("\n*********************************************");

                    break;
                    //Cars currently On Rent
                    case 4:

                        System.out.println("**********Cars currently On Rent*************");
                        if(rentals.size()>=1) {
                            for (int i = 0; i < rentals.size(); i++) {
                                System.out.println((i + 1) + "."
                                        +"Identification_code="+ rentals.get(i).getVehicle().getIdentification_code() +
                                        ","+"Name Of customer="+ rentals.get(i).getName() +
                                        ","+"Start Date=" + rentals.get(i).getStart_date() +
                                        ","+"End Date="  + rentals.get(i).getEnd_date() +
                                        ","+"No of Days=" + rentals.get(i).getNumber_of_days() +
                                        ","+"License_plate=" + rentals.get(i).getVehicle().getLicense_plate() +
                                        ","+"Brand=" + rentals.get(i).getVehicle().getBrand() +
                                        ","+"Model=" + rentals.get(i).getVehicle().getModel() +
                                        ","+"Number of seats=" + rentals.get(i).getVehicle().getNumber_of_seats());
                            }
                        }else{
                            System.out.println("NO RECORD");
                        }

                        System.out.println("\n*********************************************");

                    break;
                    //check avilability
                    case 5:
                        if(vehicles.size()>=1) {
                            sc.nextLine();
                            System.out.println("Enter start Date(dd-mm-yyyy) to check Availablity : ");
                            String datee = sc.nextLine();
                            Date date3 = null;
                            date3 = new SimpleDateFormat("dd-MM-yyyy").parse(datee);


                            System.out.println("Enter End Date(dd-mm-yyyy) to check Availablity: ");
                            String date0e = sc.nextLine();
                            Date date4 = null;
                            date4 = new SimpleDateFormat("dd-MM-yyyy").parse(date0e);
                            if(rentals.size()>=1) {
                                for (int i = 0; i < rentals.size(); i++) {
                                    if ((rentals.get(i).getStart_date().compareTo(date3.toString()) > 0) &&
                                            (rentals.get(i).getEnd_date().compareTo(date4.toString()) > 0) || (rentals.get(i).getStart_date().compareTo(date3.toString()) < 0) && (rentals.get(i).getEnd_date().compareTo(date4.toString()) < 0)) {
                                        System.out.println("Identification code=" + vehicles.get(i).getIdentification_code()
                                                + "," + "Brand=" + vehicles.get(i).getBrand()
                                                + "," + "Model=" + vehicles.get(i).getModel()
                                                + "," + "No of Seats=" + vehicles.get(i).getNumber_of_seats()
                                                + "," + "License plate=" + vehicles.get(i).getLicense_plate());
                                    } else {
                                        System.out.println("Car is Not Available on Rent or Please enter valid date");
                                    }
                                }
                            }else{
                                System.out.println("**********Cars Available on Rent*************");
                                for (int j=0;j<vehicles.size();j++){
                                    System.out.println("Identification code=" + vehicles.get(j).getIdentification_code()
                                            + "," + "Brand=" + vehicles.get(j).getBrand()
                                            + "," + "Model=" + vehicles.get(j).getModel()
                                            + "," + "No of Seats=" + vehicles.get(j).getNumber_of_seats()
                                            + "," + "License plate=" + vehicles.get(j).getLicense_plate());
                                }
                                System.out.println("*******************************************");
                            }
                        }else{
                            System.out.println("No Vehicles are avilable Please first Enter Vehicle Record");
                        }
                        break;
                        //
                    case 6:
                        System.out.println("Enter identification code= ");
                        int idcode1 = sc.nextInt();
                        sc.nextLine();

                        sc = new Scanner(System.in);
                        System.out.println("Enter brand= ");
                        String brandName1 = sc.nextLine();

                        sc = new Scanner(System.in);
                        System.out.println("Enter Model= ");
                        String model1 = sc.nextLine();

                        sc = new Scanner(System.in);
                        System.out.println("Enter number of Seats= ");
                        int seats1 = sc.nextInt();
                        sc.nextLine();

                        sc = new Scanner(System.in);
                        System.out.println("Enter license plate= ");
                        String lp1 = sc.nextLine();


                        vehicle1 = new Vehicle(idcode1, brandName1, model1, seats1, lp1);
                        vehicles.add(vehicle1);




                        break;
                    case 7:
                        if(rentals.size()>=1) {
                            for (int i = 0; i < rentals.size(); i++) {
                                System.out.println((i + 1) + "-"
                                        +"Identification_code="+ rentals.get(i).getVehicle().getIdentification_code() +
                                        "," +"Name Of customer="+ rentals.get(i).getName() +
                                        "," +"Start Date="+ rentals.get(i).getStart_date() +
                                        "," +"End Date=" + rentals.get(i).getEnd_date() +
                                        "," +"No of Days="+ rentals.get(i).getNumber_of_days() +
                                        "," +"License plate=" + rentals.get(i).getVehicle().getLicense_plate() +
                                        "," +"Brand=" + rentals.get(i).getVehicle().getBrand() +
                                        "," +"Model="+ rentals.get(i).getVehicle().getModel() +
                                        "," +"Number of seats="+ rentals.get(i).getVehicle().getNumber_of_seats());
                            }
                            System.out.println("Choose Number to Cancel the Car = ");
                            int idcode2 = sc.nextInt();
                            sc.nextLine();

                                vehicle1 = new Vehicle(rentals.get(idcode2 - 1).getVehicle().getIdentification_code(),
                                        rentals.get(idcode2 - 1).getVehicle().getBrand(),
                                        rentals.get(idcode2 - 1).getVehicle().getModel(),
                                        rentals.get(idcode2 - 1).getVehicle().getNumber_of_seats(),
                                        rentals.get(idcode2 - 1).getVehicle().getLicense_plate());
                                vehicles.add(vehicle1);
                                rentals.remove(idcode2-1);


                        }else{
                            System.out.println("No Record To Cancel");
                        }
                        break;
                    case 8:
                        if(vehicles.size()>=1) {
                            for (int i = 0; i < vehicles.size(); i++) {
                                 myWriter.write(vehicles.get(i).getIdentification_code() +
                                            "," + vehicles.get(i).getBrand() + "," + vehicles.get(i).getModel() +
                                            "," + vehicles.get(i).getNumber_of_seats() +
                                            "," + vehicles.get(i).getLicense_plate()+"\n");

                            }
                            System.out.println("Vehicle Data is Imported");
                        }else if(rentals.size()>=1){
                            for (int i = 0; i < rentals.size(); i++) {
                                myWriter.write(rentals.get(i).getVehicle().getIdentification_code() +
                                        "," + rentals.get(i).getVehicle().getBrand() +
                                        "," + rentals.get(i).getVehicle().getModel() +
                                        "," + rentals.get(i).getVehicle().getNumber_of_seats() +
                                        "," + rentals.get(i).getVehicle().getLicense_plate() + "\n");

                            }
                            System.out.println("Vehicle Data is Imported");
                        }else
                        {
                            System.out.println("No Record to Import in to Vehicle");
                        }
                        if(rentals.size()>=1) {
                            for (int j = 0; j < rentals.size(); j++) {
                                myWriter1.write(rentals.get(j).getName() +
                            "," + rentals.get(j).getStart_date() +
                                        "," + rentals.get(j).getEnd_date() +
                                        "," + rentals.get(j).getNumber_of_days() +
                            "," + rentals.get(j).getVehicle().getIdentification_code() +
                            "," + rentals.get(j).getVehicle().getBrand() +
                            "," + rentals.get(j).getVehicle().getModel() +
                            "," + rentals.get(j).getVehicle().getNumber_of_seats() +
                            "," +  rentals.get(j).getVehicle().getLicense_plate() + "\n");
                            }
                            System.out.println("Rental Data is Imported");
                            //myWriter1.close();
                        }else{
                            System.out.println("No Record to Import in to Rental");
                        }
                        break;
                    case 9:
                        String line = "";
                        myWriter.close();
                        myWriter1.close();
                        try
                        {
                            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\246714\\IdeaProjects\\JavaLab_Excercise_Part2\\src\\main\\resources\\Vehicle.csv"));
                            int num1=1;
                            System.out.println("******Vehicle Record***********");
                            while ((line = br.readLine()) != null) {

                                String vehicledetails[] = line.split(",");

                                System.out.println("Identification_Code="+vehicledetails[0]+
                                        ","+"Brand="+vehicledetails[1]+
                                        ","+"Model="+vehicledetails[2]+
                                        ","+"No of Seats="+vehicledetails[3]+
                                        "License plate="+vehicledetails[4]);
                                num1=0;
                            }
                            if(num1==1){
                                System.out.println("No record to Display ");
                            }
                            System.out.println("*************************************");
                        }catch (
                                IOException e)
                        {
                            e.printStackTrace();
                        }
                        try
                        {
                            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\246714\\IdeaProjects\\JavaLab_Excercise_Part2\\src\\main\\resources\\rentalcustomerdetail.csv"));
                            boolean flag=false;
                            System.out.println("*******Car On rent**************");
                            while ((line = br.readLine()) != null) {

                                String Rent[] = line.split(",");
                                System.out.println("Name Of Customer="+Rent[0]
                                        +","+"Start Date="+Rent[1]
                                        +","+"End Date="+Rent[2]
                                        +","+"No of Days="+Rent[3]
                                        +","+"Identification Code="+Rent[4]+
                                        ","+"Brand="+Rent[5]+
                                        ","+"Model="+Rent[6]+
                                        ","+"No of Seats="+Rent[7]+
                                        ","+"License plate="+Rent[8]);
                                flag=true;
                            }
                            if(flag==false){
                                System.out.println("No record to Display ");
                            }
                            System.out.println("******************************");
                        }catch (
                                IOException e)
                        {
                            e.printStackTrace();
                        }
                        break;
                    case 10:
                        temp=10;
                        break;
                    default:
                        System.out.println("Try Again");
                        break;
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
