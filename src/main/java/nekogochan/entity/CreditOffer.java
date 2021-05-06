package nekogochan.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@ToString
public class CreditOffer {

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @NotNull
    @Min(0)
    private Long paymentAmount;

    @NotNull
    @ManyToOne(cascade=CascadeType.DETACH)
    private Client client;

    @NotNull
    @ManyToOne(cascade=CascadeType.DETACH)
    private Credit credit;

    @NotNull
    @OneToMany(cascade=CascadeType.PERSIST)
    private List<PaymentGraph> paymentGraph;

}
