package itschool.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String manufacturerName;

    @Column(nullable = false, length = 1)
    private Integer clientReviewStars;

    @Column(nullable = false, length = 30, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)//aici
    private ContactDetails contactDetails;

    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "manufacturers")
    private List<Car> cars;

}