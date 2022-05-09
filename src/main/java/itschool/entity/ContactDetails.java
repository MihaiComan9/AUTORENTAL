package itschool.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class ContactDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10, unique = true)
    private String phoneNumber;

    @Column(nullable = false, length = 30)
    private String city;

    @Column(nullable = false)
    private String address;

    @OneToOne(mappedBy = "contactDetails")
    @JsonIgnore
    private Manufacturer manufacturer;

    @OneToOne(mappedBy = "contactDetails", cascade = CascadeType.ALL)
    @JsonIgnore
    private Factory factory;

    @OneToOne(mappedBy = "contactDetails")
    @JsonIgnore
    private MyUser user;
}