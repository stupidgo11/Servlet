package sit.int202.classicmodelstue.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "Offices")
@Getter
@Setter
@ToString(exclude = {"addressLine1","addressLine2","territory"})
@NamedQueries(
        {
                @NamedQuery(name = "OFFICE.FIND_ALL",query="select o from Office o"),
                @NamedQuery(name = "OFFICE.FIND_BY_COUNTRY",
                query="select o from Office o where o.country like :countryParam"),
                @NamedQuery(name = "OFFICE.DELETE",query = "delete from Office o where o.officeCode =:officeCode")
        }
)

public class Office {
    @Id
    private String officeCode;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String territory;
    @OneToMany(mappedBy = "officeCode")
    private List<Employee> employeeList;
}
