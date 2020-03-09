import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private Date departue;
    private Date arrival;
    private int numberOfSeat;
    private int numberOfTourist;
    private double price;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Tourist> tourist = new LinkedList<Tourist>();


}
