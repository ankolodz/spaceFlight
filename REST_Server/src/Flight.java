import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public Flight() {
    }
    public Flight(Date departue, Date arrival, int numberOfSeat, int numberOfTourist, double price) {
        this.departue = departue;
        this.arrival = arrival;
        this.numberOfSeat = numberOfSeat;
        this.numberOfTourist = numberOfTourist;
        this.price = price;
    }

    public static void newFlight (Date departue, Date arrival, int numberOfSeat, int numberOfTourist, double price){
        Session session = Main.getSession();
        Transaction tx = session.beginTransaction();
        Flight flight = new Flight( departue,  arrival,  numberOfSeat,  numberOfTourist,  price);
        session.save(flight);
        tx.commit();
        session.close();
    }
    public static List<Flight> getAllFlight (){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDatabaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        return (List<Flight>) em.createQuery(
                "SELECT f FROM Flight f").getResultList();
    }
}
