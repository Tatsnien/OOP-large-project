package hust.oopsie.bookstore.gui;

public class Manager extends Staff {
    // private DataRepositoryManagerService service

    public Manager(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public double getSalary() {
        return -1;
    }
    @Override
    public String toString() {
        return "TODO";
    }
}
