package nekogochan.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@EqualsAndHashCode
@Entity
@ToString
public class PaymentGraph {

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @NotNull
    @Future
    @Temporal(TemporalType.DATE)
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
