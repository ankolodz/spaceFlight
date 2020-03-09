import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    private String name;
    private String sourname;
    private Character sex;
    private String country;
    private String notes;
    private Date birthDate;

    @ManyToMany(mappedBy = "tourist",cascade = CascadeType.PERSIST)
    private List<Flight> flights = new LinkedList<Flight>();

}
