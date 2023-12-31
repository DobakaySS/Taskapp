/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ProjectController;
import Controller.TaskController;
import util.DeadlineColumnCellRederer;
import util.TaskTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Project;
import model.Task;
import util.ButtonColumnCellRender;

/**
 *
 * @author T-Gamer
 */
public class MainScreen extends javax.swing.JFrame {

    ProjectController projectController;
    TaskController taskController;
    DefaultListModel projectsModel;
    TaskTableModel tasksModel;

    public MainScreen() {
        initComponents(); 
        initDataController();
        initComponentsModel();
        decorateTableTask();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelEmptyTaskList = new javax.swing.JPanel();
        jLabelEmptyTaskListIcon = new javax.swing.JLabel();
        jLabelEmptyTaskListTitle = new javax.swing.JLabel();
        jLabelEmptyTaskListSubTitle = new javax.swing.JLabel();
        JPanelTitleBar = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelSubTitle = new javax.swing.JLabel();
        jPanelProjectsTitle = new javax.swing.JPanel();
        JLabelProjectsTitle = new javax.swing.JLabel();
        jLabelProjectsAdd = new javax.swing.JLabel();
        jPanelTaskTitle = new javax.swing.JPanel();
        jLabelTaskTitle = new javax.swing.JLabel();
        jLabelTaskAdd = new javax.swing.JLabel();
        jPanelProjectsList = new javax.swing.JPanel();
        jScrollPaneProjectsList = new javax.swing.JScrollPane();
        jListProjects = new javax.swing.JList<>();
        jPanelTaskGrid = new javax.swing.JPanel();
        jScrollPaneTasks = new javax.swing.JScrollPane();
        jTableTask = new javax.swing.JTable();

        jPanelEmptyTaskList.setBackground(new java.awt.Color(255, 255, 255));

        jLabelEmptyTaskListIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lists.png"))); // NOI18N

        jLabelEmptyTaskListTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelEmptyTaskListTitle.setForeground(new java.awt.Color(0, 152, 90));
        jLabelEmptyTaskListTitle.setText("Nenhuma tarefa por aqui! :D");

        jLabelEmptyTaskListSubTitle.setForeground(new java.awt.Color(204, 204, 204));
        jLabelEmptyTaskListSubTitle.setText("Clique no '+' para adicionar uma nova tarefa a esse projeto!");

        javax.swing.GroupLayout jPanelEmptyTaskListLayout = new javax.swing.GroupLayout(jPanelEmptyTaskList);
        jPanelEmptyTaskList.setLayout(jPanelEmptyTaskListLayout);
        jPanelEmptyTaskListLayout.setHorizontalGroup(
            jPanelEmptyTaskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEmptyTaskListLayout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addGroup(jPanelEmptyTaskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEmptyTaskListLayout.createSequentialGroup()
                        .addComponent(jLabelEmptyTaskListIcon)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEmptyTaskListLayout.createSequentialGroup()
                        .addComponent(jLabelEmptyTaskListTitle)
                        .addGap(45, 45, 45))
                    .addComponent(jLabelEmptyTaskListSubTitle, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(140, 140, 140))
        );
        jPanelEmptyTaskListLayout.setVerticalGroup(
            jPanelEmptyTaskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmptyTaskListLayout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jLabelEmptyTaskListIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEmptyTaskListTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEmptyTaskListSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(900, 950));
        setPreferredSize(new java.awt.Dimension(900, 915));
        setSize(new java.awt.Dimension(900, 900));

        JPanelTitleBar.setBackground(new java.awt.Color(0, 153, 102));

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png"))); // NOI18N
        jLabelTitle.setText("  Task App");

        jLabelSubTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelSubTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubTitle.setText("Anote tudo, não esqueça nada!");

        javax.swing.GroupLayout JPanelTitleBarLayout = new javax.swing.GroupLayout(JPanelTitleBar);
        JPanelTitleBar.setLayout(JPanelTitleBarLayout);
        JPanelTitleBarLayout.setHorizontalGroup(
            JPanelTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelTitleBarLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(JPanelTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSubTitle)
                    .addComponent(jLabelTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPanelTitleBarLayout.setVerticalGroup(
            JPanelTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelTitleBarLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSubTitle)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanelProjectsTitle.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProjectsTitle.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        JLabelProjectsTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        JLabelProjectsTitle.setForeground(new java.awt.Color(0, 152, 102));
        JLabelProjectsTitle.setText("Projetos");

        jLabelProjectsAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jLabelProjectsAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProjectsAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelProjectsTitleLayout = new javax.swing.GroupLayout(jPanelProjectsTitle);
        jPanelProjectsTitle.setLayout(jPanelProjectsTitleLayout);
        jPanelProjectsTitleLayout.setHorizontalGroup(
            jPanelProjectsTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLabelProjectsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelProjectsAdd)
                .addContainerGap())
        );
        jPanelProjectsTitleLayout.setVerticalGroup(
            jPanelProjectsTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsTitleLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanelProjectsTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabelProjectsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelProjectsAdd))
                .addGap(9, 9, 9))
        );

        jPanelTaskTitle.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTaskTitle.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabelTaskTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabelTaskTitle.setForeground(new java.awt.Color(0, 152, 102));
        jLabelTaskTitle.setText("Tarefas");

        jLabelTaskAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jLabelTaskAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTaskAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelTaskTitleLayout = new javax.swing.GroupLayout(jPanelTaskTitle);
        jPanelTaskTitle.setLayout(jPanelTaskTitleLayout);
        jPanelTaskTitleLayout.setHorizontalGroup(
            jPanelTaskTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTaskTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTaskTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTaskAdd)
                .addContainerGap())
        );
        jPanelTaskTitleLayout.setVerticalGroup(
            jPanelTaskTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTaskTitleLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelTaskTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTaskAdd)
                    .addComponent(jLabelTaskTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelProjectsList.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProjectsList.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jScrollPaneProjectsList.setBorder(null);

        jListProjects.setBackground(new java.awt.Color(255, 255, 255));
        jListProjects.setBorder(null);
        jListProjects.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jListProjects.setForeground(new java.awt.Color(0, 0, 0));
        jListProjects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListProjects.setFixedCellHeight(30);
        jListProjects.setSelectionBackground(new java.awt.Color(0, 154, 103));
        jListProjects.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jListProjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProjectsMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jListProjectsMouseReleased(evt);
            }
        });
        jScrollPaneProjectsList.setViewportView(jListProjects);

        javax.swing.GroupLayout jPanelProjectsListLayout = new javax.swing.GroupLayout(jPanelProjectsList);
        jPanelProjectsList.setLayout(jPanelProjectsListLayout);
        jPanelProjectsListLayout.setHorizontalGroup(
            jPanelProjectsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneProjectsList)
                .addContainerGap())
        );
        jPanelProjectsListLayout.setVerticalGroup(
            jPanelProjectsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneProjectsList)
                .addContainerGap())
        );

        jPanelTaskGrid.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTaskGrid.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanelTaskGrid.setLayout(new java.awt.BorderLayout());

        jTableTask.setBackground(new java.awt.Color(255, 255, 255));
        jTableTask.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableTask.setForeground(new java.awt.Color(0, 0, 0));
        jTableTask.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Descrição", "Prazo", "Tarefa Concluida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTask.setRowHeight(50);
        jTableTask.setSelectionBackground(new java.awt.Color(153, 255, 153));
        jTableTask.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTask.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTaskMouseClicked(evt);
            }
        });
        jScrollPaneTasks.setViewportView(jTableTask);

        jPanelTaskGrid.add(jScrollPaneTasks, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelTitleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelProjectsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProjectsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTaskTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTaskGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPanelTitleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelProjectsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTaskTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProjectsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTaskGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelProjectsAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProjectsAddMouseClicked
        // TODO add your handling code here:
        //Criando a Janela de Cadastro de Projeto e tornando-a visível
        RegisterProjectDialogScreen registerprojectdialogscreen = new RegisterProjectDialogScreen(this, rootPaneCheckingEnabled);
        registerprojectdialogscreen.setVisible(true);

        registerprojectdialogscreen.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                loadProjects();
            }
        });

    }//GEN-LAST:event_jLabelProjectsAddMouseClicked

    private void jLabelTaskAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTaskAddMouseClicked
        // TODO add your handling code here:
        //Passando o Index do projeto selecionado
        RegisterTaskDialogScreen registerTaskDialog = new RegisterTaskDialogScreen(this, rootPaneCheckingEnabled);
        int projectIndex = jListProjects.getSelectedIndex();
        Project project = (Project) projectsModel.get(projectIndex);
        registerTaskDialog.setProject(project);

        //Criando a Janela de Cadastro de Tarefas e tornando-a visível
        registerTaskDialog.setVisible(true);

        //Ao fechar a janela, carregar novamente as tarefas
        registerTaskDialog.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                int projectIndex = jListProjects.getSelectedIndex();
                Project project = (Project) projectsModel.get(projectIndex);
                loadTasks(project.getId());
            }
        });


    }//GEN-LAST:event_jLabelTaskAddMouseClicked

    private void jTableTaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTaskMouseClicked
        // TODO add your handling code here:
        int rowIndex = jTableTask.rowAtPoint(evt.getPoint());
        int collumnIndex = jTableTask.columnAtPoint(evt.getPoint());
        Task task = tasksModel.getTasks().get(rowIndex);
        //Cada numero no switch representa o indice de uma coluna na tabela
        switch (collumnIndex) {
            //Coluna 3, possibilita a edição do isCompleted
            case 3:
                taskController.update(task);
                break;
            //Coluna 5, possibilita deletar uma tarefa após confirmação de um ConfirmDialog
            case 5:
                if (JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja deletar essa tarefa?", "Deletar Tarefa", 2,JOptionPane.ERROR_MESSAGE) == 0) {
                    // If ok
                    taskController.removeById(task.getId());
                    tasksModel.getTasks().remove(task);
                    int projectIndex = jListProjects.getSelectedIndex();
                    Project project = (Project) projectsModel.get(projectIndex);
                    loadTasks(project.getId());
                }
                break;
            default:
                 
                break;
        }
    }//GEN-LAST:event_jTableTaskMouseClicked

    private void jListProjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProjectsMouseClicked
        // TODO add your handling code here:
        int projectIndex = jListProjects.getSelectedIndex();
        Project project = (Project) projectsModel.get(projectIndex);
        loadTasks(project.getId());
    }//GEN-LAST:event_jListProjectsMouseClicked

    private void jListProjectsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProjectsMouseReleased
        // TODO add your handling code here:
        int projectIndex = jListProjects.getSelectedIndex();
        Project project = (Project) projectsModel.get(projectIndex);
        loadTasks(project.getId());   
    }//GEN-LAST:event_jListProjectsMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelProjectsTitle;
    private javax.swing.JPanel JPanelTitleBar;
    private javax.swing.JLabel jLabelEmptyTaskListIcon;
    private javax.swing.JLabel jLabelEmptyTaskListSubTitle;
    private javax.swing.JLabel jLabelEmptyTaskListTitle;
    private javax.swing.JLabel jLabelProjectsAdd;
    private javax.swing.JLabel jLabelSubTitle;
    private javax.swing.JLabel jLabelTaskAdd;
    private javax.swing.JLabel jLabelTaskTitle;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JList<String> jListProjects;
    private javax.swing.JPanel jPanelEmptyTaskList;
    private javax.swing.JPanel jPanelProjectsList;
    private javax.swing.JPanel jPanelProjectsTitle;
    private javax.swing.JPanel jPanelTaskGrid;
    private javax.swing.JPanel jPanelTaskTitle;
    private javax.swing.JScrollPane jScrollPaneProjectsList;
    private javax.swing.JScrollPane jScrollPaneTasks;
    private javax.swing.JTable jTableTask;
    // End of variables declaration//GEN-END:variables

    public void decorateTableTask() {
        //Customizando o header da Table de Task
        jTableTask.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTableTask.getTableHeader().setBackground(new Color(0, 153, 102));
        jTableTask.getTableHeader().setForeground(new Color(255, 255, 255));
        //Criando um sorter automático para as colunas da Table (Opcional)
              //jTableTask.setAutoCreateRowSorter(false);
        //Ativando a coloração automática da coluna de prazos
        jTableTask.getColumnModel().getColumn(2).setCellRenderer(new DeadlineColumnCellRederer());
        //Definindo os icones dos Buttons
            //Botão de Editar
        ButtonColumnCellRender buttonedit = new ButtonColumnCellRender();
        buttonedit.setButtonType("edit");//nome do arquivo do icone
        jTableTask.getColumnModel().getColumn(4).setCellRenderer(buttonedit);
            //Botão de Excluir
        ButtonColumnCellRender buttondelete = new ButtonColumnCellRender();
        buttondelete.setButtonType("delete");//nome do arquivo do icone
        jTableTask.getColumnModel().getColumn(5).setCellRenderer(buttondelete);
    }

    public void initDataController() {
        projectController = new ProjectController();
        taskController = new TaskController();
    }

    public void initComponentsModel() {
        projectsModel = new DefaultListModel<Project>();
        loadProjects();
        tasksModel = new TaskTableModel();
        jTableTask.setModel(tasksModel);
        loadTasks(-1);

        if (!projectsModel.isEmpty()) {
            jListProjects.setSelectedIndex(0);
            Project project = (Project) projectsModel.get(0);
            loadTasks(project.getId());
        }
    }

    public void loadProjects() {
        List<Project> projectsList = projectController.getAll();

        projectsModel.clear();

        for (int i = 0; i < projectsList.size(); i++) {
            projectsModel.addElement(projectsList.get(i));
        }
        jListProjects.setModel(projectsModel);

    }

    public void loadTasks(int projectIndex) {

        List<Task> tasksList = taskController.getAll(projectIndex);
        tasksModel.setTasks(tasksList);
        showJTableTasks(!tasksList.isEmpty());

    }

    private void showJTableTasks(boolean hasTasks) {
        if (hasTasks) {

            //Se existem Tarefas
            if (jPanelEmptyTaskList.isVisible()) {
                jPanelEmptyTaskList.setVisible(false);
                jPanelTaskGrid.remove(jPanelEmptyTaskList);
            }
            jPanelTaskGrid.add(jScrollPaneTasks);
            jScrollPaneTasks.setVisible(true);
            jScrollPaneTasks.setSize(jPanelTaskGrid.getWidth(), jPanelTaskGrid.getHeight());
        } else {// Se nao existem
            if (jScrollPaneTasks.isVisible()) {
                jScrollPaneTasks.setVisible(false);
                jPanelTaskGrid.remove(jScrollPaneTasks);
            }

            jPanelTaskGrid.add(jPanelEmptyTaskList);
            jPanelEmptyTaskList.setVisible(true);
            jPanelEmptyTaskList.setSize(jPanelTaskGrid.getWidth(), jPanelTaskGrid.getHeight());

        }

    }
}
