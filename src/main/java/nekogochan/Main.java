package nekogochan;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import nekogochan.entity.*;
import nekogochan.repository.EntityNotFoundException;
import nekogochan.service.BankService;
import nekogochan.service.ClientService;
import nekogochan.service.CreditOfferService;
import nekogochan.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
@Log4j2
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Autowired
    BankService bankService;

    @Autowired
    ClientService clientService;

    @Autowired
    CreditService creditService;

    @Autowired
    CreditOfferService creditOfferService;

    @PostConstruct
    public void fillDatabaseIfEmpty() {



        if (bankService.getAll().size() != 0) return;

        var paymentGraphElements = new ArrayList<PaymentGraphElement>();
        var bank = new Bank();
        var client = new Client();
        var credit = new Credit();
        var creditOffer = new CreditOffer();

        try {
            bank.setName("Neko-bank");
            bank = bankService.add(bank);

            client.setFirstName("Ivan");
            client.setSecondName("Ivanov");
            client.setPatronymic("Ivanovich");
            client.setEmail("iii@mail.ru");
            client.setPhone("79093375392");
            client.setPassportNumber(4444_666666L);
            client = clientService.add(client);

            credit.setBank(bank);
            credit.setLimit(10000L);
            credit.setPercentage(10.0F);
            credit = creditService.add(credit);

            for (int i = 0; i < 2; i++) {
                var pge = new PaymentGraphElement();
                pge.setBodyPayment(5000L);
                pge.setPercentagePayment(500L);
                pge.setTotalPayment(5500L);
                pge.setDate(Date.from(LocalDate.now()
                                               .plusMonths(i + 1)
                                               .atStartOfDay()
                                               .atZone(ZoneId.systemDefault())
                                               .toInstant()
                ));
                paymentGraphElements.add(pge);
            }
            creditOffer.setPaymentGraph(paymentGraphElements);
            creditOffer.setCredit(credit);
            creditOffer.setClient(client);
            creditOffer.setPaymentAmount(credit.getLimit());

            creditOfferService.add(creditOffer);
        } catch (Exception e) {
            try {
                bankService.delete(bank.getId());
                clientService.delete(client.getId());
                creditService.delete(credit.getId());
                creditOfferService.delete(creditOffer.getId());
            } catch (EntityNotFoundException ignored) {}
            throw e;
        }
    }

}
