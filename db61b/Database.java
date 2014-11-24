package db61b;
import java.util.HashMap;

/** A collection of Tables, indexed by name.
 *  @author Rafayel Mkrtchyan
 */
class Database {
    /** An empty database. */
    public Database() {
        _table = new HashMap<String, Table>();
    }

    /** Return the Table whose name is NAME stored in this database, or null
     *  if there is no such table. */
    public Table get(String name) {
        return _table.get((Object) name);
    }

    /** Set or replace the table named NAME in THIS to TABLE.  TABLE and
     *  NAME must not be null, and NAME must be a valid name for a table. */
    public void put(String name, Table table) {
        if (name == null || table == null) {
            throw new IllegalArgumentException("null argument");
        } else {
            _table.put(name, table);
        }
    }

    /** A container that saves tables tables in the database. */
    private HashMap<String, Table> _table;
}
