package com.university.lab3;

import com.university.lab3.gui.CarManagerGUI;
import javax.swing.SwingUtilities;

public class MainGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CarRepository repo = new CarRepository();

            repo.add(new Car("Москвич", "C", 1200, new Driver("Иван Иванов", 3), new Engine(100, "Завод СССР")));
            repo.add(new Car("Ford Focus", "B", 1400, new Driver("Петр Петров", 10), new Engine(150, "Ford")));
            repo.add(new Car("Жигули", "C", 1300, new Driver("Сергей Сергеев", 6), new Engine(120, "Завод СССР")));

            CarManagerGUI gui = new CarManagerGUI(repo);
            gui.setVisible(true); // ← вот это было критично!
            System.out.println("GUI started...");
        });
    }
}
