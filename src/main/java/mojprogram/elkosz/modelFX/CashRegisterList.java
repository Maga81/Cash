package mojprogram.elkosz.modelFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mojprogram.elkosz.database.dao.CashRegisterDao;
import mojprogram.elkosz.database.models.CashRegister;
import mojprogram.elkosz.utils.converters.ConverterCashRegister;
import mojprogram.elkosz.utils.converters.Utils;
import org.omg.CORBA.portable.ApplicationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dany on 2017-10-07.
 */
public class CashRegisterList {

    private ObservableList<CashRegisterFx> cashRegisterFxObservableList = FXCollections.observableArrayList();
    private List<CashRegisterFx> cashRegisterList = new ArrayList<>();

    public void init() throws ApplicationException {
        cashRegisterList.clear();
        CashRegisterDao cashRegisterDao = new CashRegisterDao();
        List<CashRegister> cashRegisters = cashRegisterDao.queryForAll(CashRegister.class);

        cashRegisters.forEach( cashregi ->{
            this.cashRegisterList.add(ConverterCashRegister.convertToCashRegisterFX(cashregi));

        });
        this.cashRegisterFxObservableList.setAll(cashRegisterList);



    }
    public void callservice(CashRegisterFx cashRegisterFx) throws ApplicationException {

        LocalDate templocaldate = cashRegisterFx.getLastcheckFx();
        templocaldate = templocaldate.plusMonths(24);
        CashRegisterDao cashRegisterDao = new CashRegisterDao();
        CashRegister cashRegister = cashRegisterDao.findById(CashRegister.class, cashRegisterFx.getId_cashRegister() );
        cashRegister.setLastCheck(Utils.convertToDate(templocaldate));
        cashRegisterDao.createOrUpdate(cashRegister);
        init();


    }
    public ObservableList<CashRegisterFx> getCashRegisterFxObservableList() {
        return cashRegisterFxObservableList;
    }

    public void setCashRegisterFxObservableList(ObservableList<CashRegisterFx> cashRegisterFxObservableList) {
        this.cashRegisterFxObservableList = cashRegisterFxObservableList;
    }
}
