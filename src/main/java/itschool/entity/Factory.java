package itschool.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Factory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String factoryName;

    @Column(nullable = false, length = 4)
    private Integer foundingYear;

    @Column(nullable = false, length = 30, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = ProductionZone.class)
    private Set<ProductionZone> productionZone;

    @JsonIgnore
    @OneToMany(mappedBy = "factory")
    private List<Car> cars;

    @OneToOne(cascade = CascadeType.ALL)
    private ContactDetails contactDetails;
}
