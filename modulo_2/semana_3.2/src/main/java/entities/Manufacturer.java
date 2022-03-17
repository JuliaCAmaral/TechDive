package entities;

public class Manufacturer {

    private int id;
    private String name;

    public Manufacturer(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Id: %s - Nome: %s", id,name);
    }

}
