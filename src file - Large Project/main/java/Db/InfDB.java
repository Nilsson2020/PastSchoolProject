package Db;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


    /*
     * Denna klassen samlar databasfunktioner på ett o samma ställe.
     * Tagen från örebro universitet (oru.se) och omgjord
     * Finns en del redundanta saker men det kan fixas efterhand
     *
     * Har metoder såsom fetchColumn som returnar en kolumn i from av en ArrayList (SELECT NAME FROM USER) ex.
     * Eller fetchRow som returnar en HashMap (SELECT Name, Age FROM USER WHERE xx)
     *
     * ELLER fetchRows som returnar flera objekt (ex. en join) i form av en ArrayList<HashMap<String,String>
     * */

    public class InfDB {
        private Connection con;
        private String dbName; // "1ik173v23-1
        private String username = "la224ab";
        private String password = "la224ab";
        private String path = "jdbc:mysql://194.47.178.142:3306/";
        private int connectionType = 1;

        public InfDB() throws Exception { // Onödigt med this.name osv, räcker med path tror jag om ens det är nödvändigt
            this.dbName = "1ik173v23-1";
            this.path = "jdbc:mysql://194.47.178.142:3306/1ik173v23";
            this.username = "la224ab";
            this.password = "la224ab";
            this.connectionType = 2;

            try {
                this.initConnection();
            } catch (Exception e) {
                throw new Exception(e);
            }
        }

        public InfDB(String dbName, String port, String username, String password) throws Exception { // Onödigt med this.name osv, räcker med path tror jag om ens det är nödvändigt
            this.dbName = dbName;
            this.path = "jdbc:mysql://194.47.178.142:" + port + "/1ik173v23";
            this.username = username;
            this.password = password;
            this.connectionType = 2;

            try {
                this.initConnection();
            } catch (Exception e) {
                throw new Exception(e);
            }
        }

        private void initConnection() throws Exception { // gör själva connectionen med getConnection()
            try {
                this.con = DriverManager.getConnection("jdbc:mysql://194.47.178.142:3306/1ik173v23-1", "la224ab", "la224ab");
            } catch (Exception e) {
                if (this.connectionType == 1) {
                    throw new Exception("Couldn't open MySQL database. Check that your MySQL server uses port 3306, the name of the database is correct, that the username is SYSDBA and password is masterkey. If you have another port or user credentials try connecting with the other InfDB constructor.");
                } else {
                    throw new Exception("Couldn't open MySQL database. Check that the name of the database is correct, your MySQL server uses the same port, and that your username & password are the same as the user credentials for your local MySQL server.");
                }
            }
        }

        private void closeConnection() throws Exception { // Stänger connection
            try {
                if (this.con != null) {
                    this.con.close();
                }

            } catch (Exception var2) {
                throw new Exception("Couldn't close the connection to the database");
            }
        }

        private void checkConnection() throws Exception { // Uppdaterar connectionen
            try {
                if (this.con == null || this.con.isClosed()) {
                    this.initConnection();
                }

            } catch (Exception var2) {
                throw new Exception("A checkConnection to the database failed");
            }
        }

        public String fetchSingle(String query) throws Exception {
            String result = null;

            try {
                this.checkConnection();
                Statement sm = this.con.createStatement();
                boolean hasResult = sm.execute(query);
                if (hasResult) {
                    ResultSet rs = sm.getResultSet();
                    if (rs.next()) {
                        result = rs.getString(1);
                    }
                }
            } catch (Exception var9) {
                throw new Exception("fetchSingle statement didn't work - check your query");
            } finally {
                this.closeConnection();
            }

            return result;
        }

        public ArrayList<String> fetchColumn(String query) throws Exception {
            ArrayList<String> result = new ArrayList();

            try {
                this.checkConnection();
                Statement sm = this.con.createStatement();
                ResultSet rs = sm.executeQuery(query);

                while(rs.next()) {
                    result.add(rs.getString(1));
                }
            } catch (Exception var8) {
                throw new Exception("fetchColumn statement didn't work - check your query");
            } finally {
                this.closeConnection();
            }

            return result;
        }

        public HashMap<String, String> fetchRow(String query) throws Exception {
            HashMap<String, String> result = new HashMap();

            try {
                this.checkConnection();
                Statement sm = this.con.createStatement();
                ResultSet rs = sm.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                int countColumns = rsmd.getColumnCount();
                int i = 1;
                if (rs.next()) {
                    while(i <= countColumns) {
                        result.put(rsmd.getColumnName(i), rs.getString(i));
                        ++i;
                    }
                }
            } catch (Exception var11) {
                throw new Exception("fetchRow statement didn't work - check your query");
            } finally {
                this.closeConnection();
            }

            return result;
        }

        public ArrayList<HashMap<String, String>> fetchRows(String query) throws Exception {
            ArrayList<HashMap<String, String>> result = new ArrayList();

            try {
                this.checkConnection();
                Statement sm = this.con.createStatement();
                ResultSet rs = sm.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                int countColumns = rsmd.getColumnCount();

                while(rs.next()) {
                    int i = 1;

                    HashMap tempHM;
                    for(tempHM = new HashMap(); i <= countColumns; ++i) {
                        tempHM.put(rsmd.getColumnName(i), rs.getString(i));
                    }

                    result.add(tempHM);
                }
            } catch (Exception var12) {
                throw new Exception("fetchRows statement didn't work - check your query");
            } finally {
                this.closeConnection();
            }

            return result;
        }

        public String getAutoIncrement(String table, String attribute) throws Exception {
            String result = null;
            String query = "SELECT " + attribute + " FROM " + table + " ORDER BY " + attribute + " DESC";

            try {
                this.checkConnection();
                Statement sm = this.con.createStatement();
                ResultSet rs = sm.executeQuery(query);
                if (rs.next()) {
                    String inc = rs.getString(1);
                    if (!inc.matches("\\D+\\d+") && !inc.matches("\\d+\\D+")) {
                        if (inc.matches("\\d+")) {
                            int lastInt = Integer.parseInt(inc);
                            ++lastInt;
                            result = "" + lastInt;
                        }
                    } else {
                        String[] ar = inc.split("");
                        String letters = "";
                        String numbers = "";
                        String[] var11 = ar;
                        int var12 = ar.length;

                        for(int var13 = 0; var13 < var12; ++var13) {
                            String anAr = var11[var13];
                            if (anAr.matches("\\D")) {
                                letters = letters + anAr;
                            } else if (anAr.matches("\\d")) {
                                numbers = numbers + anAr;
                            }
                        }

                        if (numbers.matches("\\d+")) {
                            int lastInt = Integer.parseInt(numbers);
                            ++lastInt;
                            if (inc.matches("\\D+\\d+")) {
                                result = letters + lastInt;
                            } else {
                                result = lastInt + letters;
                            }
                        }
                    }
                }
            } catch (Exception var18) {
                throw new Exception("getAutoIncrement statement didn't work - check your query, works with columns containing numbers, letters+numbers or numbers+letters");
            } finally {
                this.closeConnection();
            }

            return result;
        }

        private void modifyDB(String query) throws Exception {
            try {
                this.checkConnection();
                Statement sm = this.con.createStatement();
                sm.executeUpdate(query);
            } catch (SQLException var6) {
                throw new Exception(var6);
            } finally {
                this.closeConnection();
            }

        }

        public void insert(String query) throws Exception {
            if (query.toLowerCase().startsWith("insert into")) {
                this.modifyDB(query);
            } else {
                throw new Exception("Not valid INSERT query - check your query");
            }
        }

        public void delete(String query) throws Exception {
            if (query.toLowerCase().startsWith("delete")) {
                this.modifyDB(query);
            } else {
                throw new Exception("Not valid DELETE query - check your query");
            }
        }

        public void update(String query) throws Exception {
            if (query.toLowerCase().startsWith("update") && query.toLowerCase().contains("set")) {
                this.modifyDB(query);
            } else {
                throw new Exception("Not valid UPDATE query - check your query");
            }
        }
    }


