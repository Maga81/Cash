package mojprogram.elkosz.modelFX;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Dany on 2017-07-29.
 */
public class CompanyFx {
    private IntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty companyNameFx = new SimpleStringProperty();
    private SimpleStringProperty taxIdfx = new SimpleStringProperty();
    private SimpleStringProperty cityfx = new SimpleStringProperty();
    private SimpleStringProperty streetfx = new SimpleStringProperty();
    private SimpleStringProperty contactpersonfx = new SimpleStringProperty();
    private SimpleStringProperty phonenumberfx = new SimpleStringProperty();



    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getCompanyNameFx() {
        return companyNameFx.get();
    }

    public SimpleStringProperty companyNameFxProperty() {
        return companyNameFx;
    }

    public void setCompanyNameFx(String companyNameFx) {
        this.companyNameFx.set(companyNameFx);
    }

    public String getTaxIdfx() {
        return taxIdfx.get();
    }

    public SimpleStringProperty taxIdfxProperty() {
        return taxIdfx;
    }

    public void setTaxIdfx(String taxIdfx) {
        this.taxIdfx.set(taxIdfx);
    }

    public String getCityfx() {
        return cityfx.get();
    }

    public SimpleStringProperty cityfxProperty() {
        return cityfx;
    }

    public void setCityfx(String cityfx) {
        this.cityfx.set(cityfx);
    }

    public String getStreetfx() {
        return streetfx.get();
    }

    public SimpleStringProperty streetfxProperty() {
        return streetfx;
    }

    public void setStreetfx(String streetfx) {
        this.streetfx.set(streetfx);
    }

    public String getContactpersonfx() {
        return contactpersonfx.get();
    }

    public SimpleStringProperty contactpersonfxProperty() {
        return contactpersonfx;
    }

    public void setContactpersonfx(String contactpersonfx) {
        this.contactpersonfx.set(contactpersonfx);
    }

    public String getPhonenumberfx() {
        return phonenumberfx.get();
    }

    public SimpleStringProperty phonenumberfxProperty() {
        return phonenumberfx;
    }

    public void setPhonenumberfx(String phonenumberfx) {
        this.phonenumberfx.set(phonenumberfx);
    }


}
