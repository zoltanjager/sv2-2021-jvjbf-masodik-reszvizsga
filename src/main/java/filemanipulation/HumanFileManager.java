package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {
    private List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return humans;
    }

    public void readHumansFromFile(Path path) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
            createHumans(lines);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        List<String> result = getMaleHumans();
        try {
            Files.write(path, result);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    private void createHumans(List<String> lines) {
        for (String actual : lines) {
            String[] temp = actual.split(";");
            humans.add(new Human(temp[0], temp[1]));
        }
    }

    private List<String> getMaleHumans() {
        List<String> result = new ArrayList<>();
        for (Human actual : humans) {
            if (isMale(actual)) {
                result.add(actual.getName() + ";" + actual.getIdentityNumber());
            }
        }
        return result;
    }

    private boolean isMale(Human human) {
        return human.getIdentityNumber().startsWith("1") || human.getIdentityNumber().startsWith("3");
    }
}
