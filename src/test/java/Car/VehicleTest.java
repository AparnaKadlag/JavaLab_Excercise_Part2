package Car;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class VehicleTest extends TestCase {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    Vehicle vehicle1 = null;

    @Test
    public void testGetIdentification_code() {
        vehicle1 = new Vehicle(4,"SCODA","RAPID",4,"MH15Tt0462");
        assertEquals(4,vehicle1.getIdentification_code());
    }

    @org.junit.Test
    public void testGetBrand() {
        vehicle1 = new Vehicle(1,"SUZUKI","MARUTI",4,"MH15Tt0462");
        assertEquals("SUZUKI",vehicle1.getBrand());
    }

    @org.junit.Test
    public void testGetModel() {
        vehicle1 = new Vehicle(4,"SCODA","RAPID",4,"MH15Tt0462");
        assertEquals("RAPID",vehicle1.getModel());
    }

    @org.junit.Test
    public void testGetNumber_of_seats() {
        vehicle1 = new Vehicle(1,"BAJAJ","PULSAR",2,"MH15Tt0462");
        assertEquals(2,vehicle1.getNumber_of_seats());
    }

    @org.junit.Test
    public void testGetLicense_plate() {
        vehicle1 = new Vehicle(4,"HONDA","ACTIVA",2,"MH03TT1234");
        assertEquals("MH03TT1234",vehicle1.getLicense_plate());
    }
}