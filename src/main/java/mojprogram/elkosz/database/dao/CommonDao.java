package mojprogram.elkosz.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import mojprogram.elkosz.database.dbutils.DbManager;
import mojprogram.elkosz.database.models.BaseModel;
import org.omg.CORBA.portable.ApplicationException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Dany on 2017-07-28.
 */
public abstract class CommonDao {

    protected final ConnectionSource connectionSource;

    public CommonDao() {
        this.connectionSource = DbManager.getConnectionSource();
    }

    public <T extends BaseModel, I> void createOrUpdate(BaseModel baseModel){
        Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
        try {
            dao.createOrUpdate((T)baseModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.CloseConnection();

        }
    }

    public <T extends BaseModel, I> Dao<T, I> getDao(Class<T>cls){
        try {
            return DaoManager.createDao(connectionSource, cls);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T extends BaseModel, I> void  refresh(BaseModel baseModel){
        try{
            Dao<T,I>dao = getDao((Class<T>) baseModel.getClass());
            dao.refresh((T)baseModel);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.CloseConnection();

        }
    }
    public <T extends BaseModel, I> List<T> queryForAll(Class<T> cls){
        try{
            Dao<T,I> dao = getDao(cls);
            return dao.queryForAll();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.CloseConnection();

        }
        return null;
    }

    public <T extends BaseModel, I> void delete(BaseModel baseModel){

        try {
            Dao<T,I> dao = getDao((Class<T>) baseModel.getClass());
            dao.delete((T)baseModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.CloseConnection();

        }
    }

    public <T extends BaseModel, I> void deleteById(Class<T> cls, Integer id) throws ApplicationException {
        try {
            Dao<T, I> dao = getDao(cls);
            dao.deleteById((I) id);
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
            this.CloseConnection();
        }
    }

    private void CloseConnection(){

        try {
            this.connectionSource.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public <T extends BaseModel, I> T findById(Class<T> cls, Integer id) throws ApplicationException {
        try {
            Dao<T, I> dao = getDao(cls);
            return dao.queryForId((I) id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.CloseConnection();
        }
        return null;
    }

}
