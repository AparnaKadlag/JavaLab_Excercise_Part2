package Car;

import java.util.stream.IntStream;

public class Vehicle {
        private int identification_code;
        private String brand;
        private String model;
        private int number_of_seats;
        private String license_plate;

        public Vehicle(int identification_code, String brand, String model, int number_of_seats, String license_plate) {
                this.identification_code = identification_code;
                this.brand = brand;
                this.model = model;
                this.number_of_seats = number_of_seats;
                this.license_plate = license_plate;
        }

        public void setIdentification_code(int identification_code) {
                this.identification_code = identification_code;
        }

        public void setBrand(String brand) {
                this.brand = brand;
        }

        public void setModel(String model) {
                this.model = model;
        }

        public void setNumber_of_seats(int number_of_seats) {
                this.number_of_seats = number_of_seats;
        }

        public void setLicense_plate(String license_plate) {
                this.license_plate = license_plate;
        }

        public int getIdentification_code() {
                return identification_code;
        }

        public String getBrand() {
                return brand;
        }

        public String getModel() {
                return model;
        }

        public int getNumber_of_seats() {
                return number_of_seats;
        }

        public String getLicense_plate() {
                return license_plate;
        }

}
