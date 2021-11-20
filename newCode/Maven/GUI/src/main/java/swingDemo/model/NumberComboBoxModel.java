package swingDemo.model;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Freaver
 * @date 07/02/2021 10:35
 */
public class NumberComboBoxModel extends NumberListModel implements ComboBoxModel<BigDecimal> {
    private int selectId = 0;

    public NumberComboBoxModel(double start, double end, double step) {
        super(start, end, step);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof BigDecimal) {
            BigDecimal target = (BigDecimal) anItem;
            selectId = target.subtract(super.start).divide(super.step, 2, RoundingMode.HALF_DOWN).intValue();
        }
    }

    @Override
    public Object getSelectedItem() {
        return BigDecimal.valueOf(selectId).multiply(step).add(start).setScale(1, RoundingMode.HALF_DOWN);
    }
}
