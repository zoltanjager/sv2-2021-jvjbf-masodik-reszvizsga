package city;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();


    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public void addBuilding(Building building) {
        checkIsNewBuildingFit(building);
        buildings.add(building);
    }

    public Building findHighestBuilding() {
        int highestLevel = buildings.get(0).getLevels();
        Building highestBuilding = buildings.get(0);
        for (Building actual : buildings) {
            if (actual.getLevels() > highestLevel) {
                highestLevel = actual.getLevels();
                highestBuilding = actual;
            }
        }
        return highestBuilding;
    }

    List<Building> findBuildingsByStreet(String street) {
        List<Building> result = new ArrayList<>();
        for (Building actual : buildings) {
            if (actual.getAddress().getStreet().equals(street)) {
                result.add(actual);
            }
        }
        return result;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        for (Building actual : buildings) {
            if (actual.calculateNumberOfPeopleCanFit() > numberOfPeople) {
                return true;
            }
        }
        return false;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    private void checkIsNewBuildingFit(Building building) {
        int sum = building.getArea();
        for (Building actual : buildings) {
            sum += actual.getArea();
        }
        if (sum > fullArea) {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
    }
}
