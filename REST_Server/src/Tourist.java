import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public Tourist(){

    }
    public Tourist(String name, String sourname, Character sex, String country, String notes, Date birthDate) {
        this.name = name;
        this.sourname = sourname;
        this.sex = sex;
        this.country = country;
        this.notes = notes;
        this.birthDate = birthDate;
    }

    public static void newTourist(String name, String sourname, Character sex, String country, String notes, Date birthDate) {
        Session session = Main.getSession();
        Transaction tx = session.beginTransaction();
        Tourist tourist = new Tourist(name, sourname, sex, country, notes, birthDate);
        session.save(tourist);
        tx.commit();
        session.close();
    }

    public static List<Tourist> getAllTourist (){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDatabaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        return (List<Tourist>) em.createQuery(
                "SELECT t FROM Tourist t").getResultList();
    }
}
