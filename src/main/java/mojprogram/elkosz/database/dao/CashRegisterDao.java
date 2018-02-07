package mojprogram.elkosz.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import mojprogram.elkosz.database.models.CashRegister;

import java.sql.SQLException;

/**
 * Created by Dany on 2017-07-30.
 */
public class CashRegisterDao extends CommonDao {

    public CashRegisterDao(){
        super();
    }

    public void deleteByColumn(String columnName, int id) throws SQLException {
        Dao<CashRegister, Object> dao = getDao(CashRegister.class);
        DeleteBuilder<CashRegister, Object> deleteBuilder = dao.deleteBuilder();
        deleteBuilder.where().eq(columnName, id);
        dao.delete(deleteBuilder.prepare());
    }
}
