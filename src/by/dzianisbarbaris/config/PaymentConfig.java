package by.dzianisbarbaris.config;

public class PaymentConfig {
    private static final PaymentConfig INSTANCE = new PaymentConfig();

    private PaymentConfig() {
    }

    public static PaymentConfig getInstance() {
        return INSTANCE;
    }
}
