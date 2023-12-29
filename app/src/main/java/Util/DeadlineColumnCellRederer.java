/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;
import util.TaskTableModel;

/**
 *
 * @author T-Gamer
 */
public class DeadlineColumnCellRederer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object Value,
            boolean isSelected, boolean hasFocus, int row, int col) {

        JLabel label = (JLabel) super.getTableCellRendererComponent(table,
                Value, isSelected, hasFocus, row, col);
        
        //Centralizando a label da tabela
        label.setHorizontalAlignment(CENTER); 
        
        //Colorindo conforme o prazo
        TaskTableModel taskModel = (TaskTableModel) table.getModel();
        Task task = taskModel.getTasks().get(row);
        Color color = new Color(100, 153, 102);
        if (task.getDeadline().after(new Date())) { //Data antes ou depois
              label.setBackground(color);
        }else{
               label.setBackground(Color.RED); 
        }
        

        return label;
    }

}
