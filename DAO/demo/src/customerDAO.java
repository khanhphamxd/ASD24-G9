import java.util.List;

public interface customerDAO {

    customer getUserById(int customer_id);

    List<customer> getAllUsers();

    boolean insertUser(customer customer);

    boolean deleteUser(int customer_id);
}