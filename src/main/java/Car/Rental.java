package Car;

import java.util.stream.IntStream;

public class Rental {
        private String Name;
        private String start_date;
        private String End_date;
        private int Number_of_days;
        private int identification_code;
        private Vehicle vehicle;

        public Rental(String name, String start_date, String end_date, int number_of_days, int identification_code, Vehicle vehicle) {
                Name = name;
                this.start_date = start_date;
                End_date = end_date;
                Number_of_days = number_of_days;
                this.identification_code = identification_code;
                this.vehicle = vehicle;
        }

        public String getName() {
                return Name;
        }

        public String getStart_date() {
                return start_date;
        }

        public String getEnd_date() {
                return End_date;
        }

        public int getNumber_of_days() {
                return Number_of_days;
        }

        public int getIdentification_code() {
                return identification_code;
        }

        public Vehicle getVehicle() {
                return vehicle;
        }

        public void setName(String name) {
                Name = name;
        }

        public void setStart_date(String start_date) {
                this.start_date = start_date;
        }

        public void setEnd_date(String end_date) {
                End_date = end_date;
        }

        public void setNumber_of_days(int number_of_days) {
                Number_of_days = number_of_days;
        }

        public void setIdentification_code(int identification_code) {
                this.identification_code = identification_code;
        }

        public void setVehicle(Vehicle vehicle) {
                this.vehicle = vehicle;
        }

}
