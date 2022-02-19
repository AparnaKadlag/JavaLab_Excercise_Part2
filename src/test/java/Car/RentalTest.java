package Car;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class RentalTest extends TestCase {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<Rental> rentals = new ArrayList<>();
    Vehicle vehicle1 = null;
    Rental rental1;


    @org.junit.Test
    public void testTestGetName() {
        vehicle1 = new Vehicle(1,"SCODA","RAPID",4,"MH15Tt0462");
        rental1 = new Rental("Aparna","02-02-2022","03-02-2022",2,1,vehicle1);
        rentals.add(rental1);
        assertEquals("Aparna",rental1.getName());
    }
    @org.junit.Test
    public void testGetStart_date() {
        vehicle1 = new Vehicle(2,"SCODA","RAPID",4,"MH15Tt0462");
        rental1 = new Rental("Teena","02-02-2022","03-02-2022",2,1,vehicle1);
        rentals.add(rental1);
        assertEquals("02-02-2022",rental1.getStart_date());
    }
    @org.junit.Test
    public void testGetEnd_date() {
        vehicle1 = new Vehicle(1,"SCODA","RAPID",4,"MH15Tt0462");
        rental1 = new Rental("Aparna","02-02-2022","03-02-2022",2,1,vehicle1);
        rentals.add(rental1);
        assertEquals("03-02-2022",rental1.getEnd_date());
    }
    @org.junit.Test
    public void testGetNumber_of_days() {
        vehicle1 = new Vehicle(3,"HONDA","CIVIC",2,"MH15Tt0462");
        rental1 = new Rental("MEENA","02-02-2022","03-02-2022",2,1,vehicle1);
        rentals.add(rental1);
        assertEquals(2,rental1.getNumber_of_days());
    }
    @org.junit.Test
    public void testGetIdentification_code() {
        vehicle1 = new Vehicle(6,"HONDA","ACTIVA",4,"MH15Tt0462");
        rental1 = new Rental("Aparna","02-02-2022","03-02-2022",2,1,vehicle1);
        rentals.add(rental1);
        assertEquals(1,rental1.getIdentification_code());
    }

}