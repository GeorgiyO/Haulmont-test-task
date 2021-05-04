package nekogochan.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
@Entity
public class PaymentGraph {

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @NotNull
    @Future
    private Date date;

    @NotNull
    @Min(0)
    private Long totalPayment;

    @NotNull
    @Min(0)
    private Long bodyPayment;

    @NotNull
    @Min(0)
    private Long percentagePayment;

}
