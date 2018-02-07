package mojprogram.elkosz.utils.converters;

import mojprogram.elkosz.database.models.CashRegister;
import mojprogram.elkosz.modelFX.CashRegisterFx;

/**
 * Created by Dany on 2017-10-03.
 */
public class ConverterCashRegister {

    public static CashRegister convertToCashRegister(CashRegisterFx cashRegisterFx){
        CashRegister cashRegister = new CashRegister();
        cashRegister.setCash_id(cashRegisterFx.getId_cashRegister());
        cashRegister.setCompany(cashRegisterFx.getCompany());
        cashRegister.setCash_id(cashRegisterFx.getId_cashRegister());
        cashRegister.setModel(cashRegisterFx.getModelfx());
        cashRegister.setSerialNumber(cashRegisterFx.getSrialnumberFX());
        cashRegister.setDatepurchase(Utils.convertToDate(cashRegisterFx.getDatepuchacefx()));
        cashRegister.setLastCheck(Utils.convertToDate(cashRegisterFx.getLastcheckFx()));

        return cashRegister;
    }

    public static CashRegisterFx convertToCashRegisterFX(CashRegister cashRegister){
        CashRegisterFx cashRegisterFx = new CashRegisterFx();
        cashRegisterFx.setId_cashRegister(cashRegister.getCash_id());
        cashRegisterFx.setCompany(cashRegister.getCompany());
        cashRegisterFx.setModelfx(cashRegister.getModel());
        cashRegisterFx.setSrialnumberFX(cashRegister.getSerialNumber());
        cashRegisterFx.setDatepuchacefx(Utils.convertToLocalDate(cashRegister.getDatepurchase()));
        cashRegisterFx.setLastcheckFx(Utils.convertToLocalDate(cashRegister.getLastCheck()));

        return cashRegisterFx;
    }
}
