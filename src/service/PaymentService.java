package service;

import exception.OrderAlreadyPaidException;
import model.*;

public class PaymentService {

    public Payment createPayment(Order order, PaymentMethod paymentMethod) {
        double paymentAmount = order.getListOfDishes().stream().mapToDouble(MenuItem::getItemPrice).sum();
        order.setOrderStatus(Status.PAID);
        return new Payment(paymentAmount, paymentMethod);
    }

    public void checkOrderStatus(Order order) throws OrderAlreadyPaidException {
        if (order.getOrderStatus() == Status.PAID) {
            throw new OrderAlreadyPaidException("Заказ Номер " + order.getOrderId() + " уже оплачен");
        }
    }
}
