package city;

public class Home extends Building {

    public static final int SQUARE_METERS_NEED_PER_PERSON = 20;


    public Home(int area, int numberOfFloors, Address address) {
        super(area, numberOfFloors, address);
        if (numberOfFloors > 3) {
            throw new IllegalArgumentException("");
        }
    }

    public Home(int area, Address address) {
        super(area, address);
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return super.getFullArea() / SQUARE_METERS_NEED_PER_PERSON;
    }
}
