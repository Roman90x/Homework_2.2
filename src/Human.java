public class Human {
    public String name;
    private int yearOfBirth;
    private String town;
    public String job;

    public Human(String name, int yearOfBirth, String town, String job) {

        if (name == null) {
            this.name = "Информация не указана";
        } else {
            this.name = name;
        }

        if (job == null) {
            this.job = "Информация не указана";
        } else {
            this.job = job;
        }

        if (yearOfBirth <= 0) {
            this.yearOfBirth = 0;
        } else {
            this.yearOfBirth = yearOfBirth;
        }

        if (town == null) {
            this.town = "Информация не указана";
        } else {
            this.town = town;
        }

    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth <= 0) {
            this.yearOfBirth = 0;
        } else {
            this.yearOfBirth = yearOfBirth;
        }
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        if (town == null) {
            this.town = "Информация не указана";
        } else {
            this.town = town;
        }
    }
}
