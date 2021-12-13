package city;

public class Office extends Building {
    private String Company;
    private int numberOfTablesPerLevel;
    private static final int SQUARE_METERS_NEED_PER_TABLE_MIN = 2;
    private static final int SQUARE_METERS_NEED_PER_TABLE_MAX = 5;
    private static final int NUMBER_OF_ENTERTAINMENT_LEVELS = 1;


    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        Company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        if (isCorrectNumberOfTables()) {
            throw new IllegalArgumentException("");
        }
    }


    @Override
    public int calculateNumberOfPeopleCanFit() {
        return (super.getLevels() - NUMBER_OF_ENTERTAINMENT_LEVELS) * numberOfTablesPerLevel;
    }

    public String getCompany() {
        return Company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }

    private boolean isCorrectNumberOfTables() {
        return super.getArea() <= numberOfTablesPerLevel * SQUARE_METERS_NEED_PER_TABLE_MIN ||
                super.getArea() >= numberOfTablesPerLevel * SQUARE_METERS_NEED_PER_TABLE_MAX;
    }
}
