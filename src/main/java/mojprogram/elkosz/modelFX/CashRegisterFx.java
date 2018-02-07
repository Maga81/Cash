package mojprogram.elkosz.modelFX;

import javafx.beans.property.*;
import mojprogram.elkosz.database.models.Company;

import java.time.LocalDate;

/**
 * Created by Dany on 2017-07-29.
 */
public class CashRegisterFx {
    private IntegerProperty id_cashRegister = new SimpleIntegerProperty();
    private ObjectProperty<Company> company = new SimpleObjectProperty<>();
    private SimpleStringProperty modelfx = new SimpleStringProperty();
    private SimpleStringProperty srialnumberFX = new SimpleStringProperty();
    private ObjectProperty<LocalDate> datepuchacefx = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> lastcheckFx = new SimpleObjectProperty<>();


    public int getId_cashRegister() {
        return id_cashRegister.get();
    }

    public IntegerProperty id_cashRegisterProperty() {
        return id_cashRegister;
    }

    public void setId_cashRegister(int id_cashRegister) {
        this.id_cashRegister.set(id_cashRegister);
    }

    public Company getCompany() {
        return company.get();
    }

    public ObjectProperty<Company> companyProperty() {
        return company;
    }

    public void setCompany(Company company) {
        this.company.set(company);
    }



    public String getModelfx() {
        return modelfx.get();
    }

    public SimpleStringProperty modelfxProperty() {
        return modelfx;
    }

    public void setModelfx(String modelfx) {
        this.modelfx.set(modelfx);
    }

    public String getSrialnumberFX() {
        return srialnumberFX.get();
    }

    public SimpleStringProperty srialnumberFXProperty() {
        return srialnumberFX;
    }

    public void setSrialnumberFX(String srialnumberFX) {
        this.srialnumberFX.set(srialnumberFX);
    }

    public LocalDate getDatepuchacefx() {
        return datepuchacefx.get();
    }

    public ObjectProperty<LocalDate> datepuchacefxProperty() {
        return datepuchacefx;
    }

    public void setDatepuchacefx(LocalDate datepuchacefx) {
        this.datepuchacefx.set(datepuchacefx);
    }

    public LocalDate getLastcheckFx() {
        return lastcheckFx.get();
    }

    public ObjectProperty<LocalDate> lastcheckFxProperty() {
        return lastcheckFx;
    }

    public void setLastcheckFx(LocalDate lastcheckFx) {
        this.lastcheckFx.set(lastcheckFx);
    }


}
