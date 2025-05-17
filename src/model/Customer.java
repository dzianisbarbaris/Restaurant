package model;

import java.util.Objects;
import java.util.Random;

public class Customer {
    private static final Random random = new Random();
    private Integer customerID;
    private final String customerName;
    private final String customerPhone;

    public Customer(String customerName, String customerPhone) {
        this.customerID = random.nextInt(10000, 99999);
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(customerID, customer.customerID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(customerID);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                '}';
    }
}
