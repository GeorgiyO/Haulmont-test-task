package nekogochan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@ToString
public class Client implements EntityI {

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

    @Override
    @Transient
    @JsonIgnore
    public long getId() {
        return passportNumber;
    }

    @Override
    @Transient
    @JsonIgnore
    public void setId(long id) {
        passportNumber = id;
    }
}
