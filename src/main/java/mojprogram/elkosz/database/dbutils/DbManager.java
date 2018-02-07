package mojprogram.elkosz.database.dbutils;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import mojprogram.elkosz.database.models.CashRegister;
import mojprogram.elkosz.database.models.Company;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Dany on 2017-07-28.
 */
public class DbManager {

    private static final String SQLITE_DRIVER = "jdbc:sqlite:Elkosz.db";
    private static ConnectionSource connectionSource;

    public static void initDatabase(){
        createConnection();
        dropTable();
        createTable();
        closeConnectionSource();
    }


    private static void createConnection(){

        try {
            connectionSource = new JdbcConnectionSource(SQLITE_DRIVER);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionSource getConnectionSource(){
        if(connectionSource == null){
            createConnection();
        }
        return connectionSource;
    }

    public static void closeConnectionSource(){
        if(connectionSource!=null){
            try {
                connectionSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createTable(){

        try {
            TableUtils.createTableIfNotExists(connectionSource, Company.class);
            TableUtils.createTableIfNotExists(connectionSource, CashRegister.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void dropTable(){
        try {
            TableUtils.dropTable(connectionSource, Company.class, true);
            TableUtils.dropTable(connectionSource, CashRegister.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
