package mojprogram.elkosz.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import mojprogram.elkosz.modelFX.CompanyFx;

import java.util.Date;

/**
 * Created by Dany on 2017-07-27.
 */
@DatabaseTable(tableName = "CASHMACHINE")
public class CashRegister implements BaseModel {

    public CashRegister() {
    }

    @DatabaseField(generatedId = true)
    private int cash_id;

    @DatabaseField(columnName = "Company_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Company company;

    @DatabaseField(columnName = "Model")
    private String model;

    @DatabaseField(columnName = "SerialNumber")
    private String serialNumber;

    @DatabaseField(columnName = "DatePurchase")
    private Date datepurchase;

    @DatabaseField(columnName = "LastCheck")
    private Date lastCheck;





    public int getCash_id() {
        return cash_id;
    }

    public void setCash_id(int cash_id) {
        this.cash_id = cash_id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getDatepurchase() {
        return datepurchase;
    }

    public void setDatepurchase(Date datepurchase) {
        this.datepurchase = datepurchase;
    }

    public Date getLastCheck() {
        return lastCheck;
    }

    public void setLastCheck(Date lastCheck) {
        this.lastCheck = lastCheck;
    }


}
