package Super;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RepoBasics {

    //Model getById(int id) throws SQLException;
    ArrayList<Modell> getAll() throws SQLException;
    //void add(Modell item) throws SQLException;
    //void delete(int id) throws SQLException;

}