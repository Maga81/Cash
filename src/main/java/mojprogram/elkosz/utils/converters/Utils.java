package mojprogram.elkosz.utils.converters;

import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Dany on 2017-10-04.
 */
public class Utils {



    public static Date convertToDate(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate convertToLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
