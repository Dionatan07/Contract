package services;

public class PaypalService implements OnlinePayService{

    public static final Double FEE_PERCENTAGE = 0.02;
    public static final Double MONTHLY_INTEREST = 0.01;

    @Override
    public Double paymentFee(Double amount){
        return amount * FEE_PERCENTAGE;
    }

    @Override
    public Double interest(Double amount, Integer months){
        return amount * MONTHLY_INTEREST * months;
    }

}
