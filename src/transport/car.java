package transport;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Calendar;

public class car {
    private final String brand;
    private final String model;
    private final int productionYear;
    private final String productionCountry;
    private String color;
    private double engineVolume;
    private String transmission;
    private final String body;
    private String regNumber;
    private final int seats;
    private boolean winterTires;
    private key key;
    private Insurance insurance;


    public car(String brand,
               String model,
               int productionYear,
               String productionCountry,
               String color,
               double engineVolume,
               String transmission,
               String body,
               String regNumber,
               int seats,
               boolean winterTires,
               key key,
               Insurance insurance) {

        if (brand == null) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (productionYear == 0) {
            this.productionYear = 2000;
        } else {
            this.productionYear = productionYear;
        }
        if (productionCountry == null) {
            this.productionCountry = "default";
        } else {
            this.productionCountry = productionCountry;
        }
        if (color == null) {
            this.color = "белый";
        } else {
            this.color = color;
        }
        if (engineVolume == 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
        if (transmission == null) {
            this.transmission = "АКПП";
        } else {
            this.transmission = transmission;
        }
        if (body == null) {
            this.body = "седан";
        } else {
            this.body = body;
        }
        if (regNumber == null) {
            this.regNumber = "х000хх000";
        } else {
            this.regNumber = regNumber;
        }
        if (seats == 0) {
            this.seats = 5;
        } else {
            this.seats = seats;
        }
        this.winterTires = true;
        if (key == null) {
            this.key = new key();
        } else {
            this.key = key;
        }
        if (insurance == null) {
            this.insurance = new Insurance();
        } else {
            this.insurance = insurance;
        }

    }

    public car(String brand,
               String model,
               int productionYear,
               String productionCountry,
               String color,
               double engineVolume,
               String transmission,
               String body,
               String regNumber,
               int seats,
               boolean winterTires) {
        this(brand,
            model,
            productionYear,
            productionCountry,
            color,
            engineVolume,
            transmission,
            body,
            regNumber,
            seats,
            winterTires,
            new key(),
            new Insurance());
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public String getBody() {
        return body;
    }

    public int getSeats() {
        return seats;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null) {
            this.color = "белый";
        } else {
            this.color = color;
        }
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume == 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        if (transmission == null) {
            this.transmission = "АКПП";
        } else {
            this.transmission = transmission;
        }
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        if (regNumber == null) {
            this.regNumber = "х000хх000";
        } else {
            this.regNumber = regNumber;
        }
    }

    public boolean getWinterTires() {
        return winterTires;
    }

    public void setWinterTires(boolean winterTires) {
        this.winterTires = winterTires;
    }

    public car.key getKey() {
        return key;
    }

    public void setKey(car.key key) {
        this.key = key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public void changeTires() {
        winterTires = !winterTires;
    }

    public boolean isCorrectRegNumber() {
        if (regNumber.length() != 9) {
            return false;
        }
        char[] chars = regNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) || !Character.isAlphabetic(chars[5])) {
            return false;
        }
        return Character.isDigit(chars[1]) && Character.isDigit(chars[2]) && Character.isDigit(chars[3]) &&
                Character.isDigit(chars[6]) && Character.isDigit(chars[7]) && Character.isDigit(chars[8]);
    }

    public static class key {
        private final boolean remoteLaunch;
        private final boolean keylessAccess;

        public key(boolean remoteLaunch, boolean keylessAccess) {
            this.remoteLaunch = remoteLaunch;
            this.keylessAccess = keylessAccess;
        }
        public key(){
            this(false, false);
        }

        public boolean isRemoteLaunch() {
            return remoteLaunch;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }
    }

    public static class Insurance {
        private final LocalDate validityPeriod;
        private final int cost;
        private final String number;

        public Insurance(LocalDate validityPeriod, int cost, String number) {
            if (validityPeriod == null) {
                this.validityPeriod = LocalDate.now().plusDays(365);
            } else {
                this.validityPeriod = validityPeriod;
            }
            this.cost = cost;
            if (number == null) {
                this.number = "123456789";
            } else {
                this.number = number;
            }
        }

        public Insurance (){
            this(null, 12000, null);
        }

        public LocalDate getValidityPeriod() {
            return validityPeriod;
        }

        public int getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }

        public void checkValidity() {
            if (validityPeriod.isBefore(LocalDate.now()) || validityPeriod.isEqual(LocalDate.now())) ;
            System.out.println("Нужно срочно ехать оформлять новую страховку");
        }

        public void chekNumber() {
            if (number.length() != 9) {
                System.out.println("Номер страховки некорректный!");
            }
        }
    }

}


