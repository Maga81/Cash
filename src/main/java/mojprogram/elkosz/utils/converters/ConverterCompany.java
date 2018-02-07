package mojprogram.elkosz.utils.converters;

import mojprogram.elkosz.database.models.Company;
import mojprogram.elkosz.modelFX.CompanyFx;

/**
 * Created by Dany on 2017-07-30.
 */
public class ConverterCompany {

    public static Company convetToCompany(CompanyFx companyfx){
        Company company = new Company();
        company.setId_company(companyfx.getId());
        company.setCompanyName(companyfx.getCompanyNameFx());
        company.setTaxId(companyfx.getTaxIdfx());
        company.setCity(companyfx.getCityfx());
        company.setStreet(companyfx.getStreetfx());
        company.setContactperson(companyfx.getContactpersonfx());
        company.setPhoneNumer(companyfx.getPhonenumberfx());

        return company;
    }

    public static CompanyFx converttoCompanyFX(Company company){

        CompanyFx companyFx = new CompanyFx();
        companyFx.setId(company.getId_company());
        companyFx.setCompanyNameFx(company.getCompanyName());
        companyFx.setTaxIdfx(company.getTaxId());
        companyFx.setCityfx(company.getCity());
        companyFx.setStreetfx(company.getStreet());
        companyFx.setContactpersonfx(company.getContactperson());
        companyFx.setPhonenumberfx(company.getPhoneNumer());

        return companyFx;
    }
}
