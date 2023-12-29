/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author T-Gamer
 */
public class ButtonColumnCellRender extends DefaultTableCellRenderer{
    
    private String buttonType;

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object Value,
            boolean isSelected, boolean hasFocus, int row, int col) {
        
        JLabel label = (JLabel) super.getTableCellRendererComponent(table,
                Value, isSelected, hasFocus, row, col);
        
        //Centralizando a label da tabela
        label.setHorizontalAlignment(CENTER);
        //Passando o icone
        label.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/"+ buttonType +".png")));
        
        return label;
    }
    
}
