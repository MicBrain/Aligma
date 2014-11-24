package db61b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import static db61b.Utils.*;

/** A single table in a database.
 *  @author P. N. Hilfinger
 */
class Table implements Iterable<Row> {
    /** A new Table whose columns are given by COLUMNTITLES, which may
     *  not contain dupliace names. */
    Table(String[] columnTitles) {
        for (int i = columnTitles.length - 1; i >= 1; i -= 1) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (columnTitles[i].equals(columnTitles[j])) {
                    throw error("duplicate column name: %s",
                                columnTitles[i]);
                }
            }
        }
        _columns = columnTitles;
        if (_columns.length < 1) {
            throw error("length of columnTitles should be more than 0");
        }
    }

    /** A new Table whose columns are give by COLUMNTITLES. */
    Table(List<String> columnTitles) {
        this(columnTitles.toArray(new String[columnTitles.size()]));
    }

    /** Return the number of columns in this table. */
    public int columns() {
        return _columns.length;
    }

    /** RETURNS columnTitles of the Table. */
    public String[] getColumnTitles() {
        String[] columnNames = _columns;
        return columnNames;
    }

    /** Return the title of the Kth column.  Requires 0 <= K < columns(). */
    public String getTitle(int k) {
        if (k >= 0 && k < columns()) {
            return _columns[k];
        } else {
            throw error("Index is out of boundaries");
        }
    }

    /** Return the number of the column whose title is TITLE, or -1 if
     *  there isn't one. */
    public int findColumn(String title) {
        int columnNumber = -1;
        for (int i = 0; i < columns(); i++) {
            if (getTitle(i).equals(title)) {
                columnNumber = i;
                break;
            }
        }
        return columnNumber;
    }

    /** Return the number of Rows in this table. */
    public int size() {
        return _rows.size();
    }

    /** Returns an iterator that returns my rows in an unspecfied order. */
    @Override
    public Iterator<Row> iterator() {
        return _rows.iterator();
    }

    /** Add ROW to THIS if no equal row already exists.  Return true if anything
     *  was added, false otherwise. */
    public boolean add(Row row) {
        boolean ifadded = false;
        if (!(_rows.contains(row))) {
            if (row.size() != columns()) {
                throw error("inserted row has wrong length");
            }
            _rows.add(row);
            ifadded = true;
        }
        return ifadded;
    }

    /** Read the contents of the file NAME.db, and return as a Table.
     *  Format errors in the .db file cause a DBException. */
    static Table readTable(String name) {
        BufferedReader input;
        Table table;
        input = null;
        table = null;
        try {
            input = new BufferedReader(new FileReader(name + ".db"));
            String header = input.readLine();
            if (header == null) {
                throw error("missing header in DB file");
            }
            String[] columnNames = header.split(",");
            table = new Table(columnNames);
            String rowline = input.readLine();
            while (rowline != null) {
                String[] tostring = rowline.split(",");
                Row r = new Row(tostring);
                table.add(r);
                rowline = input.readLine();
            }
        } catch (FileNotFoundException e) {
            throw error("could not find %s.db", name);
        } catch (IOException e) {
            throw error("problem reading from %s.db", name);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    /* Ignore IOException */
                }
            }
        }
        return table;
    }

    /** Write the contents of TABLE into the file NAME.db. Any I/O errors
     *  cause a DBException. */
    void writeTable(String name) {
        PrintStream output;
        output = null;
        try {
            String sep;
            sep = "";
            output = new PrintStream(name + ".db");
            String[] header = _columns;
            String headresult = "";
            for (int index = 0; index < _columns.length - 1; index++) {
                headresult = headresult + getTitle(index) + ",";
            }
            headresult = headresult + getTitle(_columns.length - 1);
            output.println(headresult);
            Iterator<Row> content = iterator();
            while (content.hasNext()) {
                Row r = content.next();
                String rowresult = "";
                for (int rindex = 0; rindex < r.size() - 1; rindex++) {
                    rowresult = rowresult + r.get(rindex) + ",";
                }
                rowresult = rowresult + r.get(r.size() - 1);
                output.println(rowresult);
            }
        } catch (IOException e) {
            throw error("trouble writing to %s.db", name);
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    /** Print my contents on the standard output. */
    void print() {
        Iterator<Row> content = iterator();
        while (content.hasNext()) {
            System.out.println(content.next());
        }
    }

    /** Return a new Table whose columns are COLUMNNAMES, selected from
     *  rows of this table that satisfy CONDITIONS. */
    Table select(List<String> columnNames, List<Condition> conditions) {
        Table result = new Table(columnNames);
        int[] indeces = new int[columnNames.size()];
        for (int index = 0; index < columnNames.size(); index++) {
            indeces[index] = findColumn(result.getTitle(index));
        }
        Iterator<Row> content = iterator();
        while (content.hasNext()) {
            if (conditions == null) {
                Row r =  content.next();
                String[] data = new String[columnNames.size()];
                int rindex = 0;
                while (rindex < indeces.length) {
                    data[rindex] = r.get(indeces[rindex]);
                    rindex++;
                }
                Row newrow = new Row(data);
                result.add(newrow);
            } else {
                Row r =  content.next();
                boolean checker = true;
                for (Condition cond : conditions) {
                    if (!(cond.test(r))) {
                        checker = false;
                        break;
                    }
                }
                if (checker) {
                    String[] data = new String[columnNames.size()];
                    int rindex = 0;
                    while (rindex < indeces.length) {
                        data[rindex] = r.get(indeces[rindex]);
                        rindex++;
                    }
                    Row newrow = new Row(data);
                    result.add(newrow);
                }
            }
        }
        return result;
    }

    /** Return a new Table whose columns are COLUMNNAMES, selected
     *  from pairs of rows from this table and from TABLE2 that match
     *  on all columns with identical names and satisfy CONDITIONS. */
    Table select(Table table2, List<String> columnNames,
                 List<Condition> conditions) {
        Table result = new Table(columnNames);
        ArrayList<Column> columns = new ArrayList<Column>();
        for (String name : columnNames) {
            Column col = new Column(name, this, table2);
            columns.add(col);
        }

        ArrayList<String> intersectedTitles = intersections(table2);

        ArrayList<Column> common1 = new ArrayList<Column>();
        ArrayList<Column> common2 = new ArrayList<Column>();
        for (String name : intersectedTitles) {
            Column col1 = new Column(name, this);
            common1.add(col1);
            Column col2 = new Column(name, table2);
            common2.add(col2);
        }
        Iterator<Row> table1content = this.iterator();
        while (table1content.hasNext()) {
            Row row1 = table1content.next();
            Iterator<Row> table2content = table2.iterator(); {
                while (table2content.hasNext()) {
                    Row row2 = table2content.next();
                    if (equijoin(common1, common2, row1, row2)) {
                        if (conditions != null) {
                            if (Condition.test(conditions, row1, row2)) {
                                Row newrow = new Row(columns, row1, row2);
                                result.add(newrow);
                            }
                        } else {
                            Row newrow = new Row(columns, row1, row2);
                            result.add(newrow);
                        }
                    }
                }
            }
        }
        return result;
    }

    /** RETURNS the interesection of common column titles of  our table
     * and other TABLE2. */
    public ArrayList<String> intersections(Table table2) {
        ArrayList<String> intersected = new ArrayList<String>();
        String[] table2columnNames = table2.getColumnTitles();
        for (int index = 0; index < _columns.length; index++) {
            for (int jindex = 0; jindex < table2columnNames.length; jindex++) {
                if (_columns[index].equals(table2columnNames[jindex])) {
                    intersected.add(_columns[index]);
                }
            }
        }
        return intersected;
    }

    /** Return true if the columns COMMON1 from ROW1 and COMMON2 from
     *  ROW2 all have identical values.  Assumes that COMMON1 and
     *  COMMON2 have the same number of elements and the same names,
     *  that the columns in COMMON1 apply to this table, those in
     *  COMMON2 to another, and that ROW1 and ROW2 come, respectively,
     *  from those tables. */
    private static boolean equijoin(List<Column> common1, List<Column> common2,
                                    Row row1, Row row2) {
        boolean ifIdentical = true;
        int index = 0;
        while (index < common1.size()) {
            if (common1.get(index).getFrom(row1).
                compareTo(common2.get(index).getFrom(row2)) != 0) {
                ifIdentical = false;
                break;
            }
            index++;
        }

        return ifIdentical;
    }

    /** My rows. */
    private HashSet<Row> _rows = new HashSet<>();

    /** Column Titles. */
    private String[] _columns;
}
