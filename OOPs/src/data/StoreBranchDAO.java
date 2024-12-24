package data;

import personnel.*;

import java.io.*
import java.util.ArrayList;

import customer.MemberCustomer;

public class StoreBranchDAO {
    private StoreBranch branch;

    public StoreBranchDAO(StoreBranch branch) {
        this.branch = branch;
    }

    public void setBranchNumber(int nb) {
        branch.setBranchNumber(nb);
    }

    public void setAddress(String address) {
        branch.setAddress(address);
    }

    public void setBranchManager(StoreBranchManager manager) {
        branch.setBranchManager(manager);
    }

    protected String getFilePath() {
        return "store_branch_" + branch.getBranchNumber() + ".dat"; // Example file path
    }

    public void loadFromFile(String file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            branch = (StoreBranch) ois.readObject();
            System.out.println("Branch loaded from file: " + file);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile(String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(branch);
            System.out.println("Branch saved to file: " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public void setPersonnels(ArrayList<Personnel> personnels) {
        branch.setPersonnels(personnels); 
    }

    public void setItems(ArrayList<Item> items) {
        branch.setItems(items); 
    }

    public void setMemberCustomers(ArrayList<MemberCustomer> memberCustomers) {
        branch.setMemberCustomers(memberCustomers); //check it again if needed
    }

    public void setBasicSalary(float salary) {
        branch.setBasicSalary(salary);
    }
