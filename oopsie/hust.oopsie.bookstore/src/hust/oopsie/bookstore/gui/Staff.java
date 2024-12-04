package hust.oopsie.bookstore.gui;

public class Staff implements Personnel {
    // private DataRepositoryPublicService
    private String name;
    private final int ID;
    private static int IdCounter;
    private double salary;

    public Staff (int ID, String name, double salary) {
        IdCounter++;
        this.ID = IdCounter;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return ID;
    }

    public String getName() {
        return name;
    }
    
    public void getService(){
        //DataRepositoryPublicService service
    }
    // public DataRepositoryPublicService getService
    // ???
    public Report getReport() {
        Report report = new Report();
        return report;
    }
    @Override
    public double getSalary() {
        return -1;
    }
    @Override
    public String toString() {
        return "Employee Information";
    }   
}   
