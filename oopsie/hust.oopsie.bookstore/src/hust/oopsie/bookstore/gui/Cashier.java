package hust.oopsie.bookstore.gui;

public class Cashier extends Staff {
    // private Customer customer;

    public Cashier(int id, String name, double salary) {
        super(id, name, salary);
    }

    public void createMembershipAccount() {
    }
    public boolean checkMembershipStatus() {
        return true;
    }
    public void makePaymentService() {
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
