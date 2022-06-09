package services;

public interface OnlinePayService {

    Double paymentFee(Double amount);
    Double interest(Double amount, Integer months);
}
