package nekogochan.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class CreditOffer {

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @NotNull
    @Min(0)
    private Long paymentAmount;

    @NotNull
    @ManyToOne
    private Credit credit;

    @NotNull
    @OneToOne
    private PaymentGraph paymentGraph;

}
