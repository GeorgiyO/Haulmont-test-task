package nekogochan.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Client {

    @EqualsAndHashCode.Include
    @NotNull
    @Min(0)
    @Id
    private Long passportNumber;

    @NotBlank
    @Size(max = 250)
    private String firstName;


    @NotBlank
    @Size(max = 250)
    private String secondName;


    @NotBlank
    @Size(max = 250)
    private String patronymic;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "^[+]?[(]?[0-9]{3}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$")
    private String phone;

    @ManyToOne
    private Bank bank;

}
