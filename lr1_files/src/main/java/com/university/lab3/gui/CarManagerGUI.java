package com.university.lab3.gui;

import com.university.lab3.Car;
import com.university.lab3.CarRepository;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Swing-приложение для управления CarRepository.
 * Позволяет добавлять, редактировать и удалять машины.
 */
public class CarManagerGUI extends JFrame {
    private final CarRepository repo;
    private final DefaultListModel<Car> listModel = new DefaultListModel<>();
    private final JList<Car> carJList = new JList<>(listModel);

    public CarManagerGUI(CarRepository repo) {
        super("Car Manager GUI");
        this.repo = repo;
        initGui();
        loadFromRepo();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
    }

    private void initGui() {
        setLayout(new BorderLayout());

        carJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        carJList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Car c) { // современный instanceof
                    setText(c.toString());
                }
                return this;
            }
        });

        JScrollPane scrollPane = new JScrollPane(carJList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        JButton addBtn = new JButton("Add");
        JButton editBtn = new JButton("Edit");
        JButton delBtn = new JButton("Delete");
        JButton refreshBtn = new JButton("Refresh");

        buttons.add(addBtn);
        buttons.add(editBtn);
        buttons.add(delBtn);
        buttons.add(refreshBtn);
        add(buttons, BorderLayout.SOUTH);

        addBtn.addActionListener(_ -> onAdd());
        editBtn.addActionListener(_ -> onEdit());
        delBtn.addActionListener(_ -> onDelete());
        refreshBtn.addActionListener(_ -> loadFromRepo());
    }

    private void loadFromRepo() {
        listModel.clear();
        List<Car> all = repo.getAll();
        for (Car c : all) listModel.addElement(c);
    }

    private void onAdd() {
        CarDialog dialog = new CarDialog(this, null);
        dialog.setVisible(true);
        Car result = dialog.getResult();
        if (result != null) {
            repo.add(result);
            loadFromRepo();
        }
    }

    private void onEdit() {
        Car selected = carJList.getSelectedValue();
        if (selected == null) {
            JOptionPane.showMessageDialog(this, "Выберите машину для редактирования.");
            return;
        }
        CarDialog dialog = new CarDialog(this, selected);
        dialog.setVisible(true);
        Car edited = dialog.getResult();
        if (edited != null) {
            repo.update(selected, edited);
            loadFromRepo();
        }
    }

    private void onDelete() {
        Car selected = carJList.getSelectedValue();
        if (selected == null) {
            JOptionPane.showMessageDialog(this, "Выберите машину для удаления.");
            return;
        }
        int r = JOptionPane.showConfirmDialog(this, "Удалить выбранную машину?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (r == JOptionPane.YES_OPTION) {
            repo.remove(selected);
            loadFromRepo();
        }
    }

    public static void main(String[] args) {
        CarRepository repo = new CarRepository();
        SwingUtilities.invokeLater(() -> {
            CarManagerGUI gui = new CarManagerGUI(repo);
            gui.setVisible(true);
        });
    }
}
