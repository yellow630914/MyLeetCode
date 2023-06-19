import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class testFormatDate {
    @Test
    public void testGetRate() {
        String date = "2022-12-9 00:00";

//        System.out.println(this.formatDate(date));

        try {
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-M-d");
            Date rdate = format1.parse(date);
            SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
            System.out.println(format2.format(rdate));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private String formatDate(String date) {
        if (date.contains(" ")){
            String[] dateAry = date.split(" ");
            return dateAry[1] + this.formatFullMonth(dateAry[0]);
        } else {
            String year = date.substring(date.length() - 4,date.length());
            String fullMonth = date.substring(0,date.length() -4);
            date = year + this.formatFullMonth(fullMonth);
        }
        return date;
    }

    private String formatFullMonth(String fullMonth) {
        switch (fullMonth) {
            case "January":
                return "01";
            case "February":
                return "02";
            case "March":
                return "03";
            case "April":
                return "04";
            case "May":
                return "05";
            case "June":
                return "06";
            case "July":
                return "07";
            case "August":
                return "08";
            case "September":
                return "09";
            case "October":
                return "10";
            case "November":
                return "11";
            case "December":
                return "12";
            default:
                return fullMonth;
        }
    }
}
