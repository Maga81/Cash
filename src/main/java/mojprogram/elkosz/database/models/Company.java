package mojprogram.elkosz.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Dany on 2017-07-27.
 */
@DatabaseTable(tableName = "COMPANY")
public class Company implements BaseModel {

    public Company() {
    }

    @DatabaseField(generatedId = true)
    private int id_company;

    @DatabaseField(columnName = "CompanyName")
    private String companyName;

    @DatabaseField(columnName = "taxId", unique = true)
    private String taxId;

    @DatabaseField(columnName = "City")
    private String city;

    @DatabaseField(columnName = "Street")
    private String street;

    @DatabaseField(columnName = "Contactperson")
    private String contactperson;

    @DatabaseField(columnName = "Phonenumer")
    private String phoneNumber;

    public int getId_company() {
        return id_company;
    }

    public void setId_company(int id_company) {
        this.id_company = id_company;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getPhoneNumer() {
        return phoneNumber;
    }

    public void setPhoneNumer(String phoneNumer) {
        this.phoneNumber = phoneNumer;
    }
}
