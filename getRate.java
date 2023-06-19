import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class getRate {
    @Test
    public void testGetRate() {
        String amt = "100,";

        System.out.println(this.processNum(amt));
    }

    private BigDecimal getRate(List feeList, BigDecimal count) {
        BigDecimal result = new BigDecimal(0);
        if(feeList.size() == 1){
            result = ((StockFeeRate)feeList.get(0)).getFeeRate();
        }
        for (int i = 0; i < feeList.size(); i++) {
            StockFeeRate tempObj = (StockFeeRate)feeList.get(i);
            if (count.compareTo(tempObj.getStartValue()) != -1
                && count.compareTo(tempObj.getEndValue()) != 1) {
                result = tempObj.getFeeRate();
                break;
            }
        }

        return result;
    }

    private String processNum(String text) {
        String result = text.replaceAll(",", ".");
        if (result.substring(result.length() - 1).equals(".")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    private class StockFeeRate {
        private BigDecimal startValue;

        private BigDecimal endValue;

        private BigDecimal feeRate;

        public BigDecimal getStartValue() {
            return startValue;
        }

        public void setStartValue(BigDecimal startValue) {
            this.startValue = startValue;
        }

        public BigDecimal getEndValue() {
            return endValue;
        }

        public void setEndValue(BigDecimal endValue) {
            this.endValue = endValue;
        }

        public BigDecimal getFeeRate() {
            return feeRate;
        }

        public void setFeeRate(BigDecimal feeRate) {
            this.feeRate = feeRate;
        }

        public StockFeeRate(BigDecimal startValue, BigDecimal endValue, BigDecimal feeRate) {
            this.startValue = startValue;
            this.endValue = endValue;
            this.feeRate = feeRate;
        }

        public StockFeeRate() {
        }
    }
}
