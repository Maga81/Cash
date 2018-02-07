package mojprogram.elkosz.modelFX;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import mojprogram.elkosz.database.dao.CompanyDao;
import mojprogram.elkosz.database.models.Company;
import mojprogram.elkosz.utils.converters.ConverterCompany;
import org.omg.CORBA.portable.ApplicationException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dany on 2017-07-30.
 */
public class CompanyModel {

    private ObjectProperty<CompanyFx> companyFxObjectProperty = new SimpleObjectProperty<>(new CompanyFx());


    public CompanyFx getCompanyFxObjectProperty() {
        return companyFxObjectProperty.get();
    }

    public ObjectProperty<CompanyFx> companyFxObjectPropertyProperty() {
        return companyFxObjectProperty;
    }

    private BooleanProperty disableTextfield = new SimpleBooleanProperty(true);

    public boolean isDisableTextfield() {
        return disableTextfield.get();
    }

    public BooleanProperty disableTextfieldProperty() {
        return disableTextfield;
    }

    public void setCompanyFxObjectProperty(CompanyFx companyFxObjectProperty) {
        this.companyFxObjectProperty.set(companyFxObjectProperty);
    }

    public void saveComapanyInDataBase() throws ApplicationException{
        CompanyDao companyDao = new CompanyDao();
        Company company = ConverterCompany.convetToCompany(this.getCompanyFxObjectProperty());
        companyDao.createOrUpdate(company);

    }

}
