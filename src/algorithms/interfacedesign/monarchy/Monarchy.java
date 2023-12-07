package algorithms.interfacedesign.monarchy;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Monarchy {

    private Person rootPerson;

    public Monarchy(String name) {
        rootPerson = new Person(name);
    }

    public void birth(String child, String parent) {
        Person person = findPersonByName(parent);
        if (person != null) {
            person.addChild(new Person(child));
        }
    }

    public void death(String name) {
        Person person = findPersonByName(name);
        if (person != null) {
            person.death();
        }
    }

    public List<String> getOrderOfSuccession() {
        return getOrderOfSuccession(rootPerson, new ArrayList<>());
    }

    private List<String> getOrderOfSuccession(Person person, List<String> orderOfSuccession) {
        if (person.isAlive()) {
            orderOfSuccession.add(person.getName());
        }
        for (Person child : person.getChildren()) {
            getOrderOfSuccession(child, orderOfSuccession);
        }
        return orderOfSuccession;
    }

    private Person findPersonByName(String name) {
        Queue<Person> queue = new LinkedBlockingQueue<>();
        queue.add(rootPerson);
        while (!queue.isEmpty()) {
            Person currentPerson = queue.poll();
            if (currentPerson.getName().equals(name)) {
                return currentPerson;
            } else {
                queue.addAll(currentPerson.getChildren());
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Monarchy monarchy = new Monarchy("Jake");
        monarchy.birth("Catherine", "Jake");
        monarchy.birth("Jane", "Catherine");
        monarchy.birth("Farah", "Jane");
        monarchy.birth("Tom", "Jake");
        monarchy.birth("Celine", "Jake");
        monarchy.birth("Mark", "Catherine");
        monarchy.birth("Peter", "Celine");
        System.out.println("Order of succession -> " + monarchy.getOrderOfSuccession()); // Jake, Catherine, Jane, Farah, Mark, Tom, Celine, Peter
        monarchy.death("Jake");
        monarchy.death("Jane");
        System.out.println("Order of succession -> " + monarchy.getOrderOfSuccession()); // Catherine, Farah, Mark, Tom, Celine, Peter
    }

}
