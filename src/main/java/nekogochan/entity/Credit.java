package nekogochan.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@ToString
public class Credit implements EntityI {

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @NotNull
    @Positive
    private Float percentage;

    @NotNull
    @Positive
    private Long limit;

    @NotNull
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Bank bank;
}
