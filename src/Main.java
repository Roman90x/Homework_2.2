import transport.car;

import java.awt.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human maksim = new Human("Максим", 2022 - 35, "Минск", "бренд-менеджер");
        Human anya = new Human("Аня", 2022 - 29, "Москва", "методист образовательных программ");
        Human katya = new Human("Катя", 2022 - 28, "Калининград", "продакт-менеджер");
        Human artem = new Human("Артем", 2022 - 27, "Москва", "директор по развитию бизнеса");
        Human vladimir = new Human("Владимир",  2022 - 21, "Казань", null);

        printInfo(maksim);
        printInfo(anya);
        printInfo(katya);
        printInfo(artem);
        printInfo(vladimir);

        System.out.println();

        Flower rose = new Flower("Роза обыкновенная",null,"Голландия",35.59f,0);
        Flower hrizantema = new Flower("Хризантема",null,null,15f,5);
        Flower pion =  new Flower("Пион",null,"Англия",69.9f,1);
        Flower gipsofila = new Flower("Гипсофила",null,"Турция",19.5f,10);

        printInfo(rose);
        printInfo(hrizantema);
        printInfo(pion);
        printInfo(gipsofila);

        System.out.println();

        bouquetInfo(rose,rose,rose,
                hrizantema,hrizantema,hrizantema,hrizantema,hrizantema,
                gipsofila);

        System.out.println();

        car granta = new car(
                "Lada",
                "Granta",
                2015,
                "Россия",
                "Желтый",
                1.7,
                null,null,null,0,true);
        granta.setInsurance(new car.Insurance(LocalDate.now(),5000,"666666666"));
        car hyundai = new car("Hyundai",
                "Avante",
                2016,
                "Южная Корея",
                "Оранжевый",
                1.6,
                null,null,null,0,true);
        hyundai.setRegNumber("000000000");
        car kia = new car("Kia",
                "Sportage 4",
                2018,
                "Южная Корея",
                "Красный",
                2.4,
                null,null,null,0,true);
        kia.setWinterTires(false);
        car bmw = new car("BMW",
                "Z8",
                2021,
                "Германия",
                "Черный",
                3.0,
                null,null,null,0,true);
        bmw.setTransmission("МКПП");
        car audi = new car("AUDI",
                "A8 50 L TDI quattro",
                2020,
                "Германия",
                "Черный",
                3.0,
                null,null,null,0,true);
        audi.setRegNumber("а123аа456") ;
        audi.setKey(new car.key(true,true));

        printInfo(granta);
        printInfo(audi);
        printInfo(bmw);
        printInfo(kia);
        printInfo(hyundai);

    }
    public static void printInfo(Human human) {
        System.out.println("Привет! Меня зовут " + human.name +
                ". Я из города " + human.getTown() +
                ". Я родился в " + human.getYearOfBirth() +
                " году. Я работаю на должности " + human.job +
                ". Будем знакомы!");
    }

    public static void printInfo (Flower flower){
        System.out.println(
                flower.name +
                ", цвет " + flower.getFlowerColor() +
                ", страна " + flower.getCountry() +
                ", стоимость " + flower.getCost() + " рублей " +
                ", дней стояния " + flower.lifeSpan);
    }

    public static void bouquetInfo (Flower ... flowers){
        float bouquetCost = 0;
        int minimalLifeSpan = Integer.MAX_VALUE;
        for (Flower flower: flowers){
            if (flower.lifeSpan<minimalLifeSpan){
                minimalLifeSpan = flower.lifeSpan;
            }
            bouquetCost += flower.getCost();
            printInfo(flower);
        }
        bouquetCost = bouquetCost * 1.1f;
        System.out.println("Стоимость букета = " + bouquetCost);
        System.out.println("Срок стояния букета = " + minimalLifeSpan);
    }

    public static void printInfo(car car) {
        System.out.println("Марка автомобиля " + car.getBrand() +
                "; Модель " + car.getModel() +
                "; Год выпуска " + car.getProductionYear() +
                "; Страна сборки " + car.getProductionCountry() +
                "; Цвет кузова " + car.getColor() +
                "; Объем двигатель " + car.getEngineVolume() +
                "; Кпп " + car.getTransmission() +
                "; кузов " + car.getBody() +
                "; госномер " + (car.getRegNumber() + " " + car.isCorrectRegNumber()) +
                "; количество мест " + car.getSeats() +
                "; сезонность резины - " + (car.getWinterTires()?"зимняя ":"летняя ") +
                "; " + (car.getKey().isKeylessAccess()?"бесключевой доступ ":"обычный доступ ") +
                "; " + (car.getKey().isRemoteLaunch()?"удаленный запуск ":"обычный запуск ") +
                "; номер страховки " + car.getInsurance().getNumber() +
                "; стоимость страховки " + car.getInsurance().getCost() +
                "; срок действия страховки " + car.getInsurance().getValidityPeriod());

    }

}
