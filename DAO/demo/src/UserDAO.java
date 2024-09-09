import java.util.List;

public interface UserDAO {

    user getUserById(int id);

    List<user> getAllUsers();

    boolean insertUser(user user);

    boolean deleteUser(int id);
}