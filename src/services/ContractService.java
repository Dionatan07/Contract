package services;

import entities.Contract;
import entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private OnlinePayService onlinePayService;

    public ContractService(OnlinePayService onlinePayService) {
        this.onlinePayService = onlinePayService;
    }

    public void processContract(Contract contract, Integer months) {
        double basicQuota = contract.getTotalValue() / months;
        for (int i = 1; i <= months; i++) {
            Date date = addMonths(contract.getDate(), i);
            double updatedQuota = basicQuota + onlinePayService.interest(basicQuota, i);
            double fullQuota = updatedQuota + onlinePayService.paymentFee(updatedQuota);
            contract.addInstallment(new Installment(date, fullQuota));
        }
    }
    public Date addMonths(Date date, int n){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, n);
            return calendar.getTime();
        }

    }


