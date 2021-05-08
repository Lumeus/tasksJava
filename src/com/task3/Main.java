package com.task3;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        TestList.main();
        TestMap.main();
        TestSet.main();
        JFrame frame = new JFrame("Выводы");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 300);
        frame.setLocation(0, 600);
        TextArea text = new TextArea("Подводя итоги проведенных тестов, следует прежде всего отметить, что сравнивать три типа коллекций между собой\n" +
                "нецелесообразно, так как они моделируют поведение разных математических абстракций: списки используются для работы с\n" +
                "упорядоченными данными, множества - с неупорядоченными и неповторяющимися, а \"карты\" - с парами ключ-значение.\n" +
                "Среди списков лучшие результаты показал ArrayList. Среди множеств Hashset и LinkedHashSet показали схожие результаты,\n" +
                "TreeSet показал худший результат. Среди карт результат аналогичен множествам.\n" +
                "Стоит отметить, что ArrayList показал для основных операций результат лучше, чем результаты всех других тестируемых коллекций.\n" +
                "Написанный мной односвязный список показал результаты почти идентичные двусвязному списку LinkedList.\n\n" +
                "P.S. Под графиками приведлены результаты измерений в микросекундах");
        text.setFont(new Font(null, Font.PLAIN, 22));
        frame.add(text);
        frame.setVisible(true);
    }
}
