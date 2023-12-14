package algorithms.interfacedesign.monarchy;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final String name;
    private boolean isAlive;
    private final List<Person> children;

    public Person(String name) {
        this.name = name;
        this.isAlive = true;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public void death() {
        this.isAlive = false;
    }

}
