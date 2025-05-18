package by.dzianisbarbaris.model;

import java.util.Objects;

public class Payment {
    private static int paymentCounter = 0;
    private final int paymentId;
    private final double paymentAmount;
    private final PaymentMethod paymentMethod;

    public Payment(double paymentAmount, PaymentMethod paymentMethod) {
        this.paymentId = ++paymentCounter;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Payment payment)) return false;
        return paymentId == payment.paymentId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(paymentId);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentAmount=" + paymentAmount +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
