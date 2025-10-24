package com.university.lab3.gui;

import com.university.lab3.Car;
import com.university.lab3.Driver;
import com.university.lab3.Engine;

import javax.swing.*;
import java.awt.*;

/**
 * Диалог для ввода/редактирования данных Car.
 */
public class CarDialog extends JDialog {
    private Car result = null;

    private final JTextField brandField = new JTextField(20);
    private final JTextField classField = new JTextField(5);
    private final JTextField weightField = new JTextField(8);

    private final JTextField driverNameField = new JTextField(20);
    private final JTextField driverExpField = new JTextField(4);

    private final JTextField enginePowerField = new JTextField(6);
    private final JTextField engineManField = new JTextField(12);

    public CarDialog(Frame owner, Car initial) {
        super(owner, true);
        setTitle(initial == null ? "Add Car" : "Edit Car");
        initLayout();
        if (initial != null) fillFromCar(initial);
        pack();
        setLocationRelativeTo(owner);
    }

    private void initLayout() {
        JPanel p = new JPanel(new GridLayout(0, 2, 6, 6));
        p.add(new JLabel("Brand:")); p.add(brandField);
        p.add(new JLabel("Class:")); p.add(classField);
        p.add(new JLabel("Weight (kg):")); p.add(weightField);
        p.add(new JLabel("Driver name:")); p.add(driverNameField);
        p.add(new JLabel("Driver exp (years):")); p.add(driverExpField);
        p.add(new JLabel("Engine power (hp):")); p.add(enginePowerField);
        p.add(new JLabel("Engine manufacturer:")); p.add(engineManField);

        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancel");
        ok.addActionListener(_ -> onOk());
        cancel.addActionListener(_ -> {
            result = null;
            dispose();
        });

        JPanel buttons = new JPanel();
        buttons.add(ok);
        buttons.add(cancel);

        getContentPane().setLayout(new BorderLayout(8, 8));
        getContentPane().add(p, BorderLayout.CENTER);
        getContentPane().add(buttons, BorderLayout.SOUTH);
    }

    private void fillFromCar(Car c) {
        brandField.setText(c.getBrand());
        classField.setText(c.getCarClass());
        weightField.setText(String.valueOf(c.getWeight()));
        driverNameField.setText(c.getDriver().getFullName());
        driverExpField.setText(String.valueOf(c.getDriver().getDrivingExperience()));
        enginePowerField.setText(String.valueOf(c.getEngine().getPower()));
        engineManField.setText(c.getEngine().getManufacturer());
    }

    private void onOk() {
        try {
            String brand = brandField.getText().trim();
            String carClass = classField.getText().trim();
            double weight = Double.parseDouble(weightField.getText().trim());
            String dName = driverNameField.getText().trim();
            int dExp = Integer.parseInt(driverExpField.getText().trim());
            int ePower = Integer.parseInt(enginePowerField.getText().trim());
            String eMan = engineManField.getText().trim();

            Driver drv = new Driver(dName, dExp);
            Engine eng = new Engine(ePower, eMan);
            result = new Car(brand, carClass, weight, drv, eng);
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ошибка ввода: неверный формат числа.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ошибка ввода: " + ex.getMessage());
        }
    }

    public Car getResult() {
        return result;
    }
}
