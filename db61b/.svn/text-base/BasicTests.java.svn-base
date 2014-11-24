package db61b;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Iterator;

/* Tests basic functionality of all implemented methods.
 * @author Rafayel Mkrtchyan
 */

public class BasicTests {

    /** Sample tests to make sure that size method
     *  works properly. */
    @Test
    public void testRowsize() {
        Row a = new Row(new String[]{});
        Row b = new Row(new String[]{"testing"});
        Row c = new Row(new String[]{"am", "testing"});
        Row d = new Row(new String[]{"I", "am", "testing"});
        Row e = new Row(new String[]{"I", "am", "testing", "this"});
        Row f = new Row(new String[]{"I", "am", "testing", "this", "method"});
        Row g = new Row(new String[]{"This", "is", "the", "final", "test",
            "for", "now"});
        assertEquals(0, a.size());
        assertEquals(1, b.size());
        assertEquals(2, c.size());
        assertEquals(3, d.size());
        assertEquals(4, e.size());
        assertEquals(5, f.size());
        assertEquals(7, g.size());
    }

    /** The first test to check a possible Exception for get method. */
    @Test(expected = DBException.class)
    public void testRowgetExcF() {
        Row f = new Row(new String[]{"I", "am", "testing", "this", "method"});
        f.get(10);
    }

    /** The second test to check a possible Exception for get method. */
    @Test(expected = DBException.class)
    public void testRowgetExcS() {
        Row r = new Row(new String[]{});
        r.get(1);
    }

    /** Sample tests to make sure that get method
     *  works properly. */
    @Test
    public void testRowget() {
        Row a = new Row(new String[]{"This", "is", "a", "new", "test"});
        Row b = new Row(new String[]{"single"});
        assertEquals("This", a.get(0));
        assertEquals("is", a.get(1));
        assertEquals("a", a.get(2));
        assertEquals("new", a.get(3));
        assertEquals("test", a.get(4));
        assertEquals("single", b.get(0));
    }

    /** Checks that the added method toString()
     *  works correctly. */
    @Test
    public void testRowtoString() {
        Row r = new Row(new String[]{"This", "is", "a", "new", "test"});
        String act = "  This is a new test";
        String exp = r.toString();
        assertTrue(act.equals(exp));
        Row a = new Row(new String[]{"Jason", "Knowles", "B"});
        String act1 = "  Jason Knowles B";
        String exp1 = a.toString();
        assertTrue(act1.equals(exp1));
        Row b = new Row(new String[]{"Shana", "Brown", "B+"});
        String act2 = "  Shana Brown B+ ";
        String exp2 = b.toString();
        assertFalse(act2.equals(exp2));
        Row c = new Row(new String[]{"Yangfan", "Chan", "B"});
        String act3 = " Yangfan Chan B";
        String exp3 = c.toString();
        assertFalse(act3.equals(exp3));
        Row d = new Row(new String[]{"Valerie", "Chan", "B+"});
        String act4 = "Valerie Chan B+";
        String exp4 = d.toString();
        assertFalse(act4.equals(exp4));
    }

    /** Different tests to make sure that equals method
     *  works properly. */
    @Test
    public void testRowequals() {
        int[] z = new int[]{1, 2, 3};
        Row e = new Row(new String[]{});
        Row f = new Row(new String[]{});
        Row c = new Row(new String[]{"I", "am", "testing"});
        Row d = new Row(new String[]{"I", "am", "testing"});
        Row a = new Row(new String[]{"This", "is", "a", "new", "test"});
        Row b = new Row(new String[]{"This", "is", "a", "new", "test"});
        Row r = new Row(new String[]{"This", "is", "a", "new", "test1"});
        Row k = new Row(new String[]{"This", "is", "a", "new", "test1"});
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
        assertTrue(a.equals(a));
        assertTrue(b.equals(b));
        assertTrue(c.equals(d));
        assertTrue(d.equals(c));
        assertTrue(c.equals(c));
        assertTrue(d.equals(d));
        assertTrue(e.equals(f));
        assertTrue(f.equals(e));
        assertTrue(e.equals(e));
        assertTrue(r.equals(k));
        assertTrue(f.equals(f));
        assertFalse(a.equals(c));
        assertFalse(a.equals(f));
        assertFalse(b.equals(d));
        assertFalse(b.equals(f));
        assertFalse(c.equals(b));
        assertFalse(d.equals(a));
        assertFalse(c.equals(e));
        assertFalse(d.equals(f));
        assertFalse(e.equals(b));
        assertFalse(f.equals(a));
        assertFalse(e.equals(d));
        assertFalse(f.equals(c));
        assertFalse(a.equals(r));
        assertFalse(r.equals(a));
        assertFalse(k.equals(e));
        assertFalse(a.equals(z));
        assertFalse(e.equals(z));
        assertFalse(d.equals(z));
    }

    /** Test Row constructor constuctor. */
    @Test
    public void testRowconst() {
        ArrayList<Column> columns = new ArrayList<Column>();
        Row[] rows = new Row[2];
        Table students = Table.readTable("testing/students");
        Table enrolled = Table.readTable("testing/enrolled");
        Iterator<Row> strow = students.iterator();
        Iterator<Row> enrow = enrolled.iterator();
        Row row1 = strow.next();
        Row row2 = enrow.next();
        rows[0] = row1;
        rows[1] = row2;
        Column col1 = new Column("Lastname", students, enrolled);
        Column col2 = new Column("Firstname", students, enrolled);
        Column col3 = new Column("Grade", students, enrolled);
        columns.add(col1);
        columns.add(col2);
        columns.add(col3);
        Row result = new Row(columns, rows);
        String checker = "  Brown Shana B";
        String actual = result.toString();
        assertTrue(checker.equals(actual));
        Row[] newrows = new Row[2];
        Row newrow1 = strow.next();
        Row newrow2 = enrow.next();
        newrows[0] = newrow1;
        newrows[1] = newrow2;
        Row newresult = new Row(columns, newrows);
        String act = "  Knowles Jason B+";
        String exp = newresult.toString();
        assertTrue(act.equals(exp));
    }

    /** A basic for testing an Exception in Table Constructor. */
    @Test(expected = DBException.class)
    public void testTableExc() {
        Table a = new Table(new String[]{"ID", "ID", "Year", "Class", "Grade"});
    }

    /** A basic test that makes sure columnTitles have at least one Title*/
    @Test(expected = DBException.class)
    public void testTableexc() {
        Table a = new Table(new String[]{});
        assertEquals(0, a.columns());
    }

    /** A test that makes sure List<String> columnTitles have at least
     * one Title*/
    @Test(expected = DBException.class)
    public void testTableexcs() {
        ArrayList<String> colist = new ArrayList<String>();
        Table testing = new Table(colist);
    }

    /** Sample tests to make sure that columns() method
     *  in Table class works properly. */
    @Test
    public void testTablecolumns() {
        Table b = new Table(new String[]{"ID"});
        Table c = new Table(new String[]{"ID", "Name"});
        Table d = new Table(new String[]{"ID", "Name", "Year"});
        Table e = new Table(new String[]{"ID", "Name", "Year", "Class"});
        Table f = new Table(new String[]{"ID", "Name", "Year", "Class",
            "Grade"});
        Table a = new Table(new String[]{"This", "is", "the", "final",
            "chechking", "test"});
        assertEquals(1, b.columns());
        assertEquals(2, c.columns());
        assertEquals(3, d.columns());
        assertEquals(4, e.columns());
        assertEquals(5, f.columns());
        assertEquals(6, a.columns());
    }

    /** Tests the functionallity of column() method using
     * the second constructor of Table class. */
    @Test
    public void testTablecol() {
        ArrayList<String> columnlist = new ArrayList<String>();
        columnlist.add("ID");
        columnlist.add("Name");
        columnlist.add("Year");
        columnlist.add("Class");
        columnlist.add("Grade");
        Table t = new Table(columnlist);
        assertEquals(5, t.columns());
    }

    /** A checking test for catching an exception in columns()
    method. */
    @Test(expected = DBException.class)
    public void testColexp() {
        Table a = new Table(new String[]{});
        a.columns();
    }

    /** A sample test to get the list of column Names of a given
     * table. */
    @Test
    public void testgetColumns() {
        Table t = new Table(new String[]{"ID", "Name", "Year",
            "Class", "Grade"});
        String[] result = t.getColumnTitles();
        String[] checker = new String[]{"ID", "Name", "Year", "Class", "Grade"};
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < checker.length; j++) {
                if (i == j) {
                    assertTrue(result[i].equals(checker[j]));
                }
            }
        }
    }

    /** Trivial tests to make sure that getTitle() method
     *  in Table class works properly. */
    @Test
    public void testTablegetTitle() {
        Table a = new Table(new String[]{"ID", "Name", "Year", "Class",
            "Grade"});
        assertEquals("ID", a.getTitle(0));
        assertEquals("Name", a.getTitle(1));
        assertEquals("Year", a.getTitle(2));
        assertEquals("Class", a.getTitle(3));
        assertEquals("Grade", a.getTitle(4));
    }

    @Test(expected = DBException.class)
    public void testTablegetexp() {
        Table a = new Table(new String[]{"ID", "Name", "Year", "Class",
            "Grade"});
        a.getTitle(10);
    }

    /** Tests for findColumn() method, which is in
     *  Table class. */
    @Test
    public void testTablefindColumn() {
        Table A = new Table(new String[]{"ID", "Name", "Year", "Class",
            "Grade"});
        assertEquals(-1, A.findColumn("Yerevan"));
        assertEquals(0, A.findColumn("ID"));
        assertEquals(1, A.findColumn("Name"));
        assertEquals(2, A.findColumn("Year"));
        assertEquals(3, A.findColumn("Class"));
        assertEquals(4, A.findColumn("Grade"));
    }

    /** Sample tests for size() method, which is in
     *  Table class. Uses add() method for double
     *  check. */
    @Test
    public void testTablesize() {
        Table T = new Table(new String[]{"ID", "Name", "Year", "Class",
            "Grade"});
        Row a = new Row(new String[]{"This", "is", "row", "number",
            "one"});
        Row b = new Row(new String[]{"Here", "are", "new", "more",
            "tests"});
        Row c = new Row(new String[]{"I", "am", "testing", "this",
            "method"});
        assertEquals(0, T.size());
        T.add(a);
        assertEquals(1, T.size());
        T.add(b);
        assertEquals(2, T.size());
        T.add(c);
        assertEquals(3, T.size());
        T.add(b);
        assertEquals(3, T.size());
        T.add(a);
        assertEquals(3, T.size());
    }

    /** Sample tests for add() method, which is in
     *  Table class. */
    @Test
    public void testTableadd() {
        Table T = new Table(new String[]{"ID", "Name", "Year", "Class",
            "Grade"});
        Row a = new Row(new String[]{"This", "is", "row", "number",
            "one"});
        assertTrue(T.add(a));
        assertFalse(T.add(a));
        Row b = new Row(new String[]{"Here", "are", "new", "more",
            "tests"});
        assertTrue(T.add(b));
        assertFalse(T.add(a));
        assertFalse(T.add(b));
    }

    /** The first test to check a possible Exception for add method. */
    @Test(expected = DBException.class)
    public void testRowaddtExcF() {
        Table t = Table.readTable("testing/students");
        Row r = new Row(new String[]{"103", "Gillespe"});
        t.add(r);
    }

     /** The first test to check a possible Exception for add method. */
    @Test(expected = DBException.class)
    public void testRowaddtExcS() {
        Table t = Table.readTable("testing/students");
        Row r = new Row(new String[]{"102", "Jones", "Jack", "F", "2002",
            "EECS", "A+"});
        t.add(r);
    }

    /** Example of printing the table's content. */
    @Test
    public void testTableprint() {
        Table t = new Table(new String[]{"Name", "Surname", "Grade"});
        Row a = new Row(new String[]{"Jason", "Knowles", "B"});
        Row b = new Row(new String[]{"Shana", "Brown", "B+"});
        Row c = new Row(new String[]{"Yangfan", "Chan", "B"});
        Row d = new Row(new String[]{"Valerie", "Chan", "B+"});
        String[] rowstostring = new String[4];
        rowstostring[0] = a.toString();
        rowstostring[1] = b.toString();
        rowstostring[2] = c.toString();
        rowstostring[3] = d.toString();
        assertTrue(t.size() == 0);
        t.add(a);
        t.add(b);
        t.add(c);
        t.add(d);
        t.add(a);
        assertTrue(t.size() == rowstostring.length);
    }

    /** A sample test that checks the functionality of our
     * ReadTable method */
    @Test
    public void testReadTable() {
        Table t = Table.readTable("testing/schedule");
        Iterator<Row> rows = t.iterator();
        int counter = 0;
        while (rows.hasNext()) {
            counter++;
            Row row = rows.next();
        }
        assertEquals(8, counter);
    }

    /** Tests put method from Database file. */
    @Test
    public void testDatabaseput() {
        Database d = new Database();
        String str = "Student_Info";
        Object exp = d.get(str);
        boolean checker = false;
        if (exp == null) {
            checker = true;
        }
        assertTrue(checker);
    }

    /** Tests get method from Database file. */
    @Test
    public void testDatabaseget() {
        Database d = new Database();
        Table a = new Table(new String[]{"Student", "Age", "Year"});
        String str = "Student_Info";
        d.put(str, a);
        assertTrue(a.equals(d.get(str)));
        Table b = new Table(new String[]{"Course", "Department",
            "Professor", "CCN"});
        String str1 = "Course_Info";
        d.put(str1, b);
        assertTrue(b.equals(d.get(str1)));
        String str2 = "Class_Name";
        Table c = new Table(new String[]{"Class", "Number", "Average"});
        d.put(str2, c);
        assertTrue(c.equals(d.get(str2)));
    }

    /** A sample test for my select method for one table and without
    a condition. */
    @Test
    public void testTableselectnocond() {
        Table t = new Table(new String[]{"Name", "Surname", "Grade"});
        Row a = new Row(new String[]{"Jason", "Knowles", "B"});
        Row b = new Row(new String[]{"Shana", "Brown", "B+"});
        Row c = new Row(new String[]{"Yangfan", "Chan", "B"});
        Row d = new Row(new String[]{"Valerie", "Chan", "B+"});
        t.add(a);
        t.add(b);
        t.add(c);
        t.add(d);
        ArrayList<String> selected = new ArrayList<String>();
        selected.add("Name");
        selected.add("Surname");
        Table res = t.select(selected, null);
        Table compare = new Table(new String[]{"Name", "Surname"});
        Row r1 = new Row(new String[]{"Jason", "Knowles"});
        Row r2 = new Row(new String[]{"Shana", "Brown"});
        Row r3 = new Row(new String[]{"Yangfan", "Chan"});
        Row r4 = new Row(new String[]{"Valerie", "Chan"});
        compare.add(r1);
        compare.add(r2);
        compare.add(r3);
        compare.add(r4);
        Iterator<Row> firstTable = res.iterator();
        Iterator<Row> secondTable = compare.iterator();
        while (firstTable.hasNext()) {
            Row row1 = firstTable.next();
            Row row2 = secondTable.next();
            assertTrue(row1.equals(row2));
        }
    }

    /** A sample test for my select method for one table and a
    a condition. */
    @Test
    public void testTableselectcond() {
        Table t = new Table(new String[]{"Name", "Surname", "Grade"});
        Row a = new Row(new String[]{"Jason", "Knowles", "B"});
        Row b = new Row(new String[]{"Shana", "Brown", "B+"});
        Row c = new Row(new String[]{"Yangfan", "Chan", "B"});
        Row d = new Row(new String[]{"Valerie", "Chan", "B+"});
        t.add(a);
        t.add(b);
        t.add(c);
        t.add(d);
        ArrayList<String> selected = new ArrayList<String>();
        selected.add("Name");
        selected.add("Surname");
        Column col1 = new Column("Grade", t);
        Condition cond = new Condition(col1, "!=", "B");
        Column col2 = new Column("Surname", t);
        Condition cond1 = new Condition(col2, "=", "Brown");
        ArrayList<Condition> conds = new ArrayList<Condition>();
        conds.add(cond);
        conds.add(cond1);
        Table res = t.select(selected, conds);
        Iterator<Row> rowline = res.iterator();
        Row act = rowline.next();
        Row exp = new Row(new String[]{"Shana", "Brown"});
        assertTrue(act.equals(exp));
    }

    /** A sample test to check intersections of columnNames of
     * two tables. */
    @Test
    public void testTableintersections() {
        Table a = Table.readTable("testing/students");
        Table b = Table.readTable("testing/enrolled");
        ArrayList<String> intersect = a.intersections(b);
        for (String item: intersect) {
            assertTrue("SID".equals(item));
        }
    }

    /** Sample test for two tables without a condition. */
    @Test
    public void testselecttwotables() {
        Table a = Table.readTable("testing/students");
        String[] columnNamesofa = a.getColumnTitles();
        Table b = Table.readTable("testing/enrolled");
        ArrayList<Condition> bbb = new ArrayList<Condition>();
        ArrayList<String> columnNames = new ArrayList<String>();
        columnNames.add("Lastname");
        columnNames.add("Firstname");
        columnNames.add("CCN");
        Table c = a.select(b, columnNames, bbb);
        assertEquals(19, c.size());
    }

    /** A test for select two tables with a condition. */
    @Test
    public void testselecttwotablescond() {
        Table a = Table.readTable("testing/students");
        String[] columnNamesofa = a.getColumnTitles();
        Table b = Table.readTable("testing/enrolled");

        ArrayList<Condition> bbb = new ArrayList<Condition>();
        Column col1 = new Column("SID", a, b);
        Condition first = new Condition(col1, "=", "101");
        Column col2 = new Column("CCN", a, b);
        Condition second = new Condition(col2, "<=", "21228");
        bbb.add(first);
        bbb.add(second);
        ArrayList<String> columnNames = new ArrayList<String>();
        columnNames.add("Lastname");
        columnNames.add("Firstname");
        columnNames.add("CCN");
        Table c = a.select(b, columnNames, bbb);
        assertEquals(3, c.size());
    }

    /* Run the unit tests in this file. */
    public static void main(String... args) {
        System.exit(ucb.junit.textui.runClasses(BasicTests.class));
    }
}
