
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import static java.awt.AlphaComposite.Clear;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static javax.swing.text.html.HTML.Attribute.ROWS;

public class Inter extends javax.swing.JFrame {

    //функция обзора
    public class SimpleTableTest extends JFrame {

        public SimpleTableTest(String Namefile, String Name, String Title, int kolvo) {
            JFrame frame = new JFrame();
            Vector<String> mas = new Vector<String>();
            FileReader fr;
            try {

                //Озаглавление
                String Str = Name;
                String[] mass = new String[kolvo];
                mass = Str.split(";");
                for (int i = 0; i < mass.length; i++) {
                    mas.add(mass[i]);

                }
                //заполнение
                Vector<Vector<String>> data = new Vector<Vector<String>>();
                fr = new FileReader(Namefile);
                Scanner Sc = new Scanner(fr);
                String[] massiv = new String[kolvo];
                while (Sc.hasNextLine()) {
                    Str = Sc.nextLine();
                    massiv = Str.split(";");
                    Vector<String> row = new Vector<String>();
                    for (int i = 0; i < kolvo; i++) {
                        row.add(massiv[i]);
                    }
                    data.add(row);
                }
                JTable table = new JTable(data, mas);

                JScrollPane scrollPane = new JScrollPane(table);
                frame.setTitle(Title);
                frame.add(scrollPane, BorderLayout.CENTER);
                frame.setSize(650, 300);
                frame.setVisible(true);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    //конец функции обзора
    //функция добавления
    public class dobavlenie extends JFrame {

        String save2 = null;
        Integer Ko = 0;
        String savename = null;
        JTextField j1 = new javax.swing.JTextField("");
        JTextField j2 = new javax.swing.JTextField("");
        JTextField j3 = new javax.swing.JTextField("");
        JTextField j4 = new javax.swing.JTextField("");
        JTextField j5 = new javax.swing.JTextField("");
        JTextField j6 = new javax.swing.JTextField("");
        JTextField j7 = new javax.swing.JTextField("");
        JTextField j8 = new javax.swing.JTextField("");
        JTextField j9 = new javax.swing.JTextField("");
        JTextField j10 = new javax.swing.JTextField("");
        JTextField j11 = new javax.swing.JTextField("");
        JTextField j12 = new javax.swing.JTextField("");
        JFrame fram = new JFrame();

        public dobavlenie(String FileName, String Zapros, String Ozag, Integer Kolvo) {
            Ko = Kolvo;
            savename = Ozag;
            save2 = FileName;
            String Str = Zapros;
            String[] mass = new String[Kolvo];
            mass = Str.split(";", 12);
            fram.setTitle(Ozag);
            fram.setLayout(new GridLayout(Kolvo + 1, 10));
            for (int i = 0; i < Kolvo; i++) {
                JLabel t = new javax.swing.JLabel("Введите " + mass[i] + ":");
                fram.add(t);
                if (i + 1 == 1) {
                    fram.add(j1);
                }
                if (i + 1 == 2) {
                    fram.add(j2);
                }
                if (i + 1 == 3) {
                    fram.add(j3);
                }
                if (i + 1 == 4) {
                    fram.add(j4);
                }
                if (i + 1 == 5) {
                    fram.add(j5);
                }
                if (i + 1 == 6) {
                    fram.add(j6);
                }
                if (i + 1 == 7) {
                    fram.add(j7);
                }
                if (i + 1 == 8) {
                    fram.add(j8);
                }
                if (i + 1 == 9) {
                    fram.add(j9);
                }
                if (i + 1 == 10) {
                    fram.add(j10);
                }
                if (i + 1 == 11) {
                    fram.add(j11);
                }
                if (i + 1 == 12) {
                    fram.add(j12);
                }
            }
            JButton button = new JButton("потвердить");
            JButton buton = new JButton("отмена");
            buton.addActionListener(new ButonEventListener());
            button.addActionListener(new ButtonEventListener());
            fram.add(buton);
            fram.add(button);
            setSize(250, 100);
            fram.setSize(650, 300);
            fram.setVisible(true);
        }

        public class ButtonEventListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                String vvod = j1.getText() + ";" + j2.getText() + ";" + j3.getText() + ";" + j4.getText()
                        + ";" + j5.getText() + ";" + j6.getText() + ";" + j7.getText() + ";" + j8.getText()
                        + ";" + j9.getText() + ";" + j10.getText() + ";" + j11.getText() + ";" + j12.getText();;
                if (!TrueFalse(Ko)) {
                    JOptionPane.showMessageDialog(clear, "заполните все поля");
                } else {

                    try {
                        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(save2, true)));
                        writer.println(vvod);
                        writer.flush();
                        writer.close();
                        fram.removeAll();
                        fram.dispose();
                        savename = savename + " выполнено успешно";
                        JOptionPane.showMessageDialog(clear, savename);
                    } catch (IOException ex) {
                        Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            public boolean TrueFalse(Integer kolvo) {
                if (kolvo >= 1 && j1.getText().equals("")) {
                    return false;
                }
                if (kolvo >= 2 && j2.getText().equals("")) {
                    return false;
                }
                if (kolvo >= 3 && j3.getText().equals("")) {
                    return false;
                }
                if (kolvo >= 4 && j4.getText().equals("")) {
                    return false;
                }
                if (kolvo >= 5 && j5.getText().equals("")) {
                    return false;
                }
                if (kolvo >= 6 && j6.getText().equals("")) {
                    return false;
                }
                if (kolvo >= 7 && j7.getText().equals("")) {
                    return false;
                }
                if (kolvo >= 8 && j8.getText().equals("")) {
                    return false;
                }
                if (kolvo >= 9 && j9.getText().equals("")) {
                    return false;
                }
                if (kolvo >= 10 && j10.getText().equals("")) {
                    return false;
                }
                if (kolvo >= 11 && j11.getText().equals("")) {
                    return false;
                }
                if (kolvo >= 12 && j12.getText().equals("")) {
                    return false;
                }
                return true;
            }
        }

        public class ButonEventListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                fram.removeAll();
                fram.dispose();
            }
        }
    }

    //осчистка данных
    public class Clear {

        public Clear(String FileName) {
            try {
                FileWriter writer = new FileWriter(FileName);
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //измена
    public class Izmena {

        public Izmena(String NameFile, String Name, Integer Kolvo, String What) {
            int check = 0;
            int kstl = 0;
            String Final = "";
            String In = JOptionPane.showInputDialog(What);
            if (In == null || "".equals(In)) {
                JOptionPane.showMessageDialog(clear, "неправильный ввод");
                return;
            }
            try {
                FileReader fr = new FileReader(NameFile);
                Scanner Sc = new Scanner(fr);
                String[] mas = new String[Kolvo];
                String Str = "";
                while (Sc.hasNextLine()) {
                    Str = Sc.nextLine();
                    mas = Str.split(";", 8);
                    if (In.equals(mas[0])) {
                        String save;
                        save = JOptionPane.showInputDialog(clear, "!                 Введите      измененную        информацию                     !", Str);
                        if (kstl != 0) {
                            Final = Final + "\n" + save;
                            check = 1;
                        } else {
                            Final = Final + save;
                            kstl = 1;
                            check = 1;
                        }
                    } else {
                        if (kstl != 0) {
                            Final = Final + "\n" + Str;
                        } else {
                            Final = Final + Str;
                            kstl = 1;
                        }
                    }

                }
                if (check == 1) {
                    FileWriter cleaner = new FileWriter(NameFile);
                    cleaner.flush();
                    cleaner.close();
                    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(NameFile, true)));
                    writer.println(Final);
                    writer.flush();
                    writer.close();
                } else {
                    JOptionPane.showMessageDialog(clear, "сходств не найдено");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public class del {

        public del(String NameFile, Integer Kolvo, String What) {
            int check = 0;
            int kstl = 0;
            String Final = "";
            String ch = null;
            String In = JOptionPane.showInputDialog(What);
            if (ch.equals(In)) {
            } else {
                try {
                    FileReader fr = new FileReader(NameFile);
                    Scanner Sc = new Scanner(fr);
                    String[] mas = new String[Kolvo];
                    String Str = "";
                    while (Sc.hasNextLine()) {
                        Str = Sc.nextLine();
                        mas = Str.split(";", Kolvo);
                        if (In.equals(mas[0])) {
                            if (kstl != 0) {
                                check = 1;
                            } else {
                                kstl = 1;
                                check = 1;
                            }
                        } else {
                            if (kstl != 0) {
                                Final = Final + "\n" + Str;
                            } else {
                                Final = Final + Str;
                                kstl = 1;
                            }
                        }

                    }
                    if (check == 1) {
                        FileWriter cleaner = new FileWriter(NameFile);
                        cleaner.flush();
                        cleaner.close();
                        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(NameFile, true)));
                        writer.println(Final);
                        writer.flush();
                        writer.close();
                    } else {
                        JOptionPane.showMessageDialog(clear, "сходств не найдено");
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private static class janrpoisk extends JFrame {

        Vector<String> ozag = new Vector<String>();
        JFrame frame = new JFrame();

        public janrpoisk() {
            // Создание списка
            final JList<String> list = new JList<String>(ozag);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setPrototypeCellValue("Увеличенный");
            try {
                FileReader janr = new FileReader("жанры.txt");
                Scanner Sc1 = new Scanner(janr);
                while (Sc1.hasNextLine()) {
                    String Str = null;
                    Str = Sc1.nextLine();
                    String[] massiv1 = new String[3];
                    massiv1 = Str.split(";");
                    ozag.add(massiv1[1]);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Создание текстового поля
            // Подключения слушателя
            list.addListSelectionListener(new listSelectionListener());

            // Подключение слушателя мыши
            list.addMouseListener(new MouseAdapter() {

            });

            // Размещение компонентов в интерфейсе
            frame.add(new JScrollPane(list), BorderLayout.CENTER);
            // Вывод окна
            frame.setSize(300, 300);
            frame.setVisible(true);
            frame.setTitle("Выберете жанр");

        }

        class listSelectionListener implements ListSelectionListener {

            public void valueChanged(ListSelectionEvent e) {
                // Выделенная строка
                int selected = ((JList<?>) e.getSource()).
                        getSelectedIndex();
                frame.removeAll();
                frame.dispose();
                JFrame frame = new JFrame();
                Vector<String> mas = new Vector<String>();
                FileReader fr;
                Vector<Vector<String>> data = new Vector<Vector<String>>();
                String Str = "Описание жанра;Код кассеты;Наименование фильма;Год создания;Производитель;Страна;Главный актер;Дата записи;Цена";
                String[] mass = new String[9];
                mass = Str.split(";");

                for (int i = 0; i < mass.length; i++) {
                    mas.add(mass[i]);
                }
                try {
                    FileReader janr = new FileReader("жанры.txt");
                    Scanner Sc1 = new Scanner(janr);
                    while (Sc1.hasNextLine()) {
                        String Stri = null;
                        Stri = Sc1.nextLine();
                        String[] massiv1 = new String[3];
                        massiv1 = Stri.split(";");
                        FileReader cas = new FileReader("кассеты.txt");
                        Scanner Sc2 = new Scanner(cas);
                        while (Sc2.hasNextLine()) {
                            Vector<String> row = new Vector<String>();
                            String Str1 = null;
                            Str1 = Sc2.nextLine();
                            String[] massiv2 = new String[9];
                            massiv2 = Str1.split(";");
                            if (Integer.parseInt(massiv1[0]) == Integer.parseInt(massiv2[7])) {
                                for (int i = 2; i < 3; i++) {
                                    row.add(massiv1[i]);
                                }
                                for (int i = 0; i < 9; i++) {
                                    if (i != 7) {
                                        row.add(massiv2[i]);
                                    }
                                }
                                if (Integer.parseInt(massiv1[0]) == selected + 1) {
                                    data.add(row);
                                }
                            }
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
                }
                JTable table = new JTable(data, mas);
                JScrollPane scrollPane = new JScrollPane(table);
                frame.add(scrollPane, BorderLayout.CENTER);
                frame.setSize(650, 300);
                frame.setVisible(true);

            }
        }
    }

    private static class yearpoisk extends JFrame {

        Vector<String> ozag = new Vector<String>();
        JFrame frame = new JFrame();

        public yearpoisk() {
            // Создание списка
            final JList<String> list = new JList<String>(ozag);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setPrototypeCellValue("Увеличенный");
            try {
                FileReader janr = new FileReader("кассеты.txt");
                Scanner Sc1 = new Scanner(janr);
                for (int i = 1900; i < 2000; i++) {
                    ozag.add(Integer.toString(i));
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Создание текстового поля
            // Подключения слушателя
            list.addListSelectionListener(new listSelectionListener());

            // Подключение слушателя мыши
            list.addMouseListener(new MouseAdapter() {

            });

            // Размещение компонентов в интерфейсе
            frame.add(new JScrollPane(list), BorderLayout.CENTER);
            // Вывод окна
            frame.setSize(300, 300);
            frame.setVisible(true);
            frame.setTitle("Выберете год");

        }

        class listSelectionListener implements ListSelectionListener {

            public void valueChanged(ListSelectionEvent e) {
                // Выделенная строка
                int selected = ((JList<?>) e.getSource()).
                        getSelectedIndex();
                frame.removeAll();
                frame.dispose();
                JFrame frame = new JFrame();
                Vector<String> mas = new Vector<String>();
                FileReader fr;
                Vector<Vector<String>> data = new Vector<Vector<String>>();
                String Str = "Название жанра;Описание жанра;Код кассеты;Наименование фильма;Производитель;Страна;Главный актер;Дата записи;Код кассеты;Цена";
                String[] mass = new String[9];
                mass = Str.split(";");

                for (int i = 0; i < mass.length; i++) {
                    mas.add(mass[i]);
                }
                try {
                    FileReader janr = new FileReader("жанры.txt");
                    Scanner Sc1 = new Scanner(janr);

                    while (Sc1.hasNextLine()) {
                        String Stri = null;
                        Stri = Sc1.nextLine();
                        String[] massiv1 = new String[3];
                        massiv1 = Stri.split(";");
                        FileReader cas = new FileReader("кассеты.txt");
                        Scanner Sc2 = new Scanner(cas);
                        while (Sc2.hasNextLine()) {
                            Vector<String> row = new Vector<String>();
                            String Str1 = null;
                            Str1 = Sc2.nextLine();
                            String[] massiv2 = new String[9];
                            massiv2 = Str1.split(";");
                            if (Integer.parseInt(massiv1[0]) == Integer.parseInt(massiv2[7])) {
                                for (int i = 1; i < 3; i++) {
                                    row.add(massiv1[i]);
                                }
                                for (int i = 0; i < 9; i++) {
                                    if (i != 2) {
                                        row.add(massiv2[i]);
                                    }
                                }
                                if (Integer.parseInt(massiv2[2]) == Integer.parseInt((String) ((JList<?>) e.getSource()).getSelectedValue())) {
                                    data.add(row);
                                }
                            }
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
                }
                JTable table = new JTable(data, mas);
                JScrollPane scrollPane = new JScrollPane(table);
                frame.add(scrollPane, BorderLayout.CENTER);
                frame.setSize(650, 300);
                frame.setVisible(true);

            }
        }
    }

    private static class actorpoisk extends JFrame {

        Vector<String> ozag = new Vector<String>();
        JFrame frame = new JFrame();

        public actorpoisk() {
            // Создание списка
            final JList<String> list = new JList<String>(ozag);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setPrototypeCellValue("Увеличенный");
            try {
                FileReader janr = new FileReader("кассеты.txt");
                Scanner Sc1 = new Scanner(janr);
                while (Sc1.hasNextLine()) {
                    String Str = null;
                    Str = Sc1.nextLine();
                    String[] massiv1 = new String[9];
                    massiv1 = Str.split(";");
                    ozag.add(massiv1[5]);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Создание текстового поля
            // Подключения слушателя
            list.addListSelectionListener(new listSelectionListener());

            // Подключение слушателя мыши
            list.addMouseListener(new MouseAdapter() {

            });

            // Размещение компонентов в интерфейсе
            frame.add(new JScrollPane(list), BorderLayout.CENTER);
            // Вывод окна
            frame.setSize(300, 300);
            frame.setVisible(true);
            frame.setTitle("Выберете актера");

        }

        class listSelectionListener implements ListSelectionListener {

            public void valueChanged(ListSelectionEvent e) {
                // Выделенная строка
                int selected = ((JList<?>) e.getSource()).
                        getSelectedIndex();
                frame.removeAll();
                frame.dispose();
                JFrame frame = new JFrame();
                Vector<String> mas = new Vector<String>();
                FileReader fr;
                Vector<Vector<String>> data = new Vector<Vector<String>>();
                String Str = "Название жанра;Описание жанра;Код кассеты;Наименование фильма;Год создания;Производитель;Страна;Дата записи;Цена";
                String[] mass = new String[9];
                mass = Str.split(";");

                for (int i = 0; i < mass.length; i++) {
                    mas.add(mass[i]);
                }
                try {
                    FileReader janr = new FileReader("жанры.txt");
                    Scanner Sc1 = new Scanner(janr);
                    while (Sc1.hasNextLine()) {
                        String Stri = null;
                        Stri = Sc1.nextLine();
                        String[] massiv1 = new String[3];
                        massiv1 = Stri.split(";");
                        FileReader cas = new FileReader("кассеты.txt");
                        Scanner Sc2 = new Scanner(cas);
                        while (Sc2.hasNextLine()) {
                            Vector<String> row = new Vector<String>();
                            String Str1 = null;
                            Str1 = Sc2.nextLine();
                            String[] massiv2 = new String[9];
                            massiv2 = Str1.split(";");
                            if (Integer.parseInt(massiv1[0]) == Integer.parseInt(massiv2[7])) {
                                for (int i = 1; i < 3; i++) {
                                    row.add(massiv1[i]);
                                }
                                for (int i = 0; i < 9; i++) {
                                    if (i != 7 & i != 5) {
                                        row.add(massiv2[i]);
                                    }
                                }
                                if (massiv2[5].equals((String) ((JList<?>) e.getSource()).getSelectedValue())) {
                                    data.add(row);
                                }
                            }
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
                }
                JTable table = new JTable(data, mas);
                JScrollPane scrollPane = new JScrollPane(table);
                frame.add(scrollPane, BorderLayout.CENTER);
                frame.setSize(650, 300);
                frame.setVisible(true);

            }
        }
    }

    private static class klientpoisk extends JFrame {

        Vector<String> ozag = new Vector<String>();
        JFrame fram = new JFrame();

        public klientpoisk() {
            // Создание списка
            final JList<String> list = new JList<String>(ozag);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setPrototypeCellValue("Увеличенный");
            try {
                FileReader janr = new FileReader("клиенты.txt");
                Scanner Sc = new Scanner(janr);
                while (Sc.hasNextLine()) {
                    String Strш = null;
                    Strш = Sc.nextLine();
                    String[] massiv1m = new String[9];
                    massiv1m = Strш.split(";");
                    ozag.add(massiv1m[0]);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Создание текстового поля
            // Подключения слушателя
            list.addListSelectionListener(new listSelectionListener());

            // Подключение слушателя мыши
            list.addMouseListener(new MouseAdapter() {

            });

            // Размещение компонентов в интерфейсе
            fram.add(new JScrollPane(list), BorderLayout.CENTER);
            // Вывод окна
            fram.setSize(300, 300);
            fram.setVisible(true);
            fram.setTitle("Выберете актера");

        }

        class listSelectionListener implements ListSelectionListener {

            public void valueChanged(ListSelectionEvent e) {
                // Выделенная строка
                fram.removeAll();
                fram.dispose();
                JFrame frame = new JFrame();
                Vector<String> mas = new Vector<String>();
                FileReader fr;
                Vector<Vector<String>> data = new Vector<Vector<String>>();
                String Str = "ФИО к;Адрес к;Телефон к;отметка об оплате;отметка о возврате;Имя фильма;Цена;ФИО с;Должность";
                String[] mass = new String[9];
                mass = Str.split(";");

                for (int i = 0; i < mass.length; i++) {
                    mas.add(mass[i]);
                }
                try {
                    FileReader kli = new FileReader("клиенты.txt");
                    Scanner Sc11 = new Scanner(kli);
                    while (Sc11.hasNextLine()) {
                        String Str1 = null;
                        Str1 = Sc11.nextLine();
                        String[] massiv1 = new String[12];
                        massiv1 = Str1.split(";");
                        FileReader cas = new FileReader("кассеты.txt");
                        Scanner Sc2 = new Scanner(cas);
                        while (Sc2.hasNextLine()) {
                            String Str2;
                            Str2 = Sc2.nextLine();
                            String[] massiv2 = new String[9];
                            massiv2 = Str2.split(";");
                            if (Integer.parseInt(massiv1[8]) == Integer.parseInt(massiv2[0]) || Integer.parseInt(massiv1[9]) == Integer.parseInt(massiv2[0]) || Integer.parseInt(massiv1[10]) == Integer.parseInt(massiv2[0])) {
                                Vector<String> row = new Vector<String>();
                                for (int i = 0; i < 8; i++) {
                                    if (i != 5 && i != 4 && i != 3) {
                                        row.add(massiv1[i]);
                                    }
                                }
                                for (int i = 0; i < 9; i++) {
                                    if (i == 1 || i == 8) {
                                        row.add(massiv2[i]);
                                    }
                                }
                                FileReader sot = new FileReader("сотрудники.txt");
                                Scanner Sc3 = new Scanner(sot);
                                while (Sc3.hasNextLine()) {
                                    String Str3;
                                    Str3 = Sc3.nextLine();
                                    String[] massiv3 = new String[9];
                                    massiv3 = Str3.split(";");
                                    if (Integer.parseInt(massiv1[11]) == Integer.parseInt(massiv3[0])) {
                                        row.add(massiv3[1]);
                                        FileReader dol = new FileReader("должности.txt");
                                        Scanner Sc4 = new Scanner(dol);
                                        while (Sc4.hasNextLine()) {
                                            String Str4;
                                            Str4 = Sc4.nextLine();
                                            String[] massiv4 = new String[9];
                                            massiv4 = Str4.split(";");
                                            if (Integer.parseInt(massiv3[7]) == Integer.parseInt(massiv4[0])) {

                                                row.add(massiv4[1]);

                                            }
                                        }

                                    }
                                }

                                if (massiv1[0].equals((String) ((JList<?>) e.getSource()).getSelectedValue())) {
                                    data.add(row);
                                }
                            }
                        }
                    }
                    JTable table = new JTable(data, mas);

                    JScrollPane scrollPane = new JScrollPane(table);
                    frame.setTitle("Кассеты");
                    frame.add(scrollPane, BorderLayout.CENTER);
                    frame.setSize(650, 300);
                    frame.setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    private static class oplatapoisk extends JFrame {

        Vector<String> ozag = new Vector<String>();
        JFrame fram = new JFrame();

        public oplatapoisk() {
            // Создание списка
            final JList<String> list = new JList<String>(ozag);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setPrototypeCellValue("Увеличенный");
            try {
                FileReader janr = new FileReader("клиенты.txt");
                Scanner Sc = new Scanner(janr);
                ozag.add("Оплачено");
                ozag.add("Не оплачено");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Создание текстового поля
            // Подключения слушателя
            list.addListSelectionListener(new listSelectionListener());

            // Подключение слушателя мыши
            list.addMouseListener(new MouseAdapter() {

            });

            // Размещение компонентов в интерфейсе
            fram.add(new JScrollPane(list), BorderLayout.CENTER);
            // Вывод окна
            fram.setSize(300, 300);
            fram.setVisible(true);
            fram.setTitle("Выберете актера");

        }

        class listSelectionListener implements ListSelectionListener {

            public void valueChanged(ListSelectionEvent e) {
                // Выделенная строка
                fram.removeAll();
                fram.dispose();
                JFrame frame = new JFrame();
                Vector<String> mas = new Vector<String>();
                FileReader fr;
                Vector<Vector<String>> data = new Vector<Vector<String>>();
                String Str = "ФИО к;Адрес к;Телефон к;отметка об оплате;отметка о возврате;Имя фильма;Цена;ФИО с;Должность";
                String[] mass = new String[9];
                mass = Str.split(";");

                for (int i = 0; i < mass.length; i++) {
                    mas.add(mass[i]);
                }
                try {
                    FileReader kli = new FileReader("клиенты.txt");
                    Scanner Sc11 = new Scanner(kli);
                    while (Sc11.hasNextLine()) {
                        String Str1 = null;
                        Str1 = Sc11.nextLine();
                        String[] massiv1 = new String[12];
                        massiv1 = Str1.split(";");
                        FileReader cas = new FileReader("кассеты.txt");
                        Scanner Sc2 = new Scanner(cas);
                        while (Sc2.hasNextLine()) {
                            String Str2;
                            Str2 = Sc2.nextLine();
                            String[] massiv2 = new String[9];
                            massiv2 = Str2.split(";");
                            if (Integer.parseInt(massiv1[8]) == Integer.parseInt(massiv2[0]) || Integer.parseInt(massiv1[9]) == Integer.parseInt(massiv2[0]) || Integer.parseInt(massiv1[10]) == Integer.parseInt(massiv2[0])) {
                                Vector<String> row = new Vector<String>();
                                for (int i = 0; i < 8; i++) {
                                    if (i != 5 && i != 4 && i != 3) {
                                        row.add(massiv1[i]);
                                    }
                                }
                                for (int i = 0; i < 9; i++) {
                                    if (i == 1 || i == 8) {
                                        row.add(massiv2[i]);
                                    }
                                }
                                FileReader sot = new FileReader("сотрудники.txt");
                                Scanner Sc3 = new Scanner(sot);
                                while (Sc3.hasNextLine()) {
                                    String Str3;
                                    Str3 = Sc3.nextLine();
                                    String[] massiv3 = new String[9];
                                    massiv3 = Str3.split(";");
                                    if (Integer.parseInt(massiv1[11]) == Integer.parseInt(massiv3[0])) {
                                        row.add(massiv3[1]);
                                        FileReader dol = new FileReader("должности.txt");
                                        Scanner Sc4 = new Scanner(dol);
                                        while (Sc4.hasNextLine()) {
                                            String Str4;
                                            Str4 = Sc4.nextLine();
                                            String[] massiv4 = new String[9];
                                            massiv4 = Str4.split(";");
                                            if (Integer.parseInt(massiv3[7]) == Integer.parseInt(massiv4[0])) {

                                                row.add(massiv4[1]);

                                            }
                                        }

                                    }
                                }

                                if (massiv1[6].equals((String) ((JList<?>) e.getSource()).getSelectedValue())) {
                                    data.add(row);
                                }
                            }
                        }
                    }
                    JTable table = new JTable(data, mas);

                    JScrollPane scrollPane = new JScrollPane(table);
                    frame.setTitle("Кассеты");
                    frame.add(scrollPane, BorderLayout.CENTER);
                    frame.setSize(650, 300);
                    frame.setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    private static class vozvratpoisk extends JFrame {

        Vector<String> ozag = new Vector<String>();
        JFrame fram = new JFrame();

        public vozvratpoisk() {
            // Создание списка
            final JList<String> list = new JList<String>(ozag);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setPrototypeCellValue("Увеличенный");
            try {
                FileReader janr = new FileReader("клиенты.txt");
                Scanner Sc = new Scanner(janr);
                ozag.add("Возвращено");
                ozag.add("Не возвращено");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Создание текстового поля
            // Подключения слушателя
            list.addListSelectionListener(new listSelectionListener());

            // Подключение слушателя мыши
            list.addMouseListener(new MouseAdapter() {

            });

            // Размещение компонентов в интерфейсе
            fram.add(new JScrollPane(list), BorderLayout.CENTER);
            // Вывод окна
            fram.setSize(300, 300);
            fram.setVisible(true);
            fram.setTitle("Выберете актера");

        }

        class listSelectionListener implements ListSelectionListener {

            public void valueChanged(ListSelectionEvent e) {
                // Выделенная строка
                fram.removeAll();
                fram.dispose();
                JFrame frame = new JFrame();
                Vector<String> mas = new Vector<String>();
                FileReader fr;
                Vector<Vector<String>> data = new Vector<Vector<String>>();
                String Str = "ФИО к;Адрес к;Телефон к;отметка об оплате;отметка о возврате;Имя фильма;Цена;ФИО с;Должность";
                String[] mass = new String[9];
                mass = Str.split(";");

                for (int i = 0; i < mass.length; i++) {
                    mas.add(mass[i]);
                }
                try {
                    FileReader kli = new FileReader("клиенты.txt");
                    Scanner Sc11 = new Scanner(kli);
                    while (Sc11.hasNextLine()) {
                        String Str1 = null;
                        Str1 = Sc11.nextLine();
                        String[] massiv1 = new String[12];
                        massiv1 = Str1.split(";");
                        FileReader cas = new FileReader("кассеты.txt");
                        Scanner Sc2 = new Scanner(cas);
                        while (Sc2.hasNextLine()) {
                            String Str2;
                            Str2 = Sc2.nextLine();
                            String[] massiv2 = new String[9];
                            massiv2 = Str2.split(";");
                            if (Integer.parseInt(massiv1[8]) == Integer.parseInt(massiv2[0]) || Integer.parseInt(massiv1[9]) == Integer.parseInt(massiv2[0]) || Integer.parseInt(massiv1[10]) == Integer.parseInt(massiv2[0])) {
                                Vector<String> row = new Vector<String>();
                                for (int i = 0; i < 8; i++) {
                                    if (i != 5 && i != 4 && i != 3) {
                                        row.add(massiv1[i]);
                                    }
                                }
                                for (int i = 0; i < 9; i++) {
                                    if (i == 1 || i == 8) {
                                        row.add(massiv2[i]);
                                    }
                                }
                                FileReader sot = new FileReader("сотрудники.txt");
                                Scanner Sc3 = new Scanner(sot);
                                while (Sc3.hasNextLine()) {
                                    String Str3;
                                    Str3 = Sc3.nextLine();
                                    String[] massiv3 = new String[9];
                                    massiv3 = Str3.split(";");
                                    if (Integer.parseInt(massiv1[11]) == Integer.parseInt(massiv3[0])) {
                                        row.add(massiv3[1]);
                                        FileReader dol = new FileReader("должности.txt");
                                        Scanner Sc4 = new Scanner(dol);
                                        while (Sc4.hasNextLine()) {
                                            String Str4;
                                            Str4 = Sc4.nextLine();
                                            String[] massiv4 = new String[9];
                                            massiv4 = Str4.split(";");
                                            if (Integer.parseInt(massiv3[7]) == Integer.parseInt(massiv4[0])) {

                                                row.add(massiv4[1]);

                                            }
                                        }

                                    }
                                }

                                if (massiv1[7].equals((String) ((JList<?>) e.getSource()).getSelectedValue())) {
                                    data.add(row);
                                }
                            }
                        }
                    }
                    JTable table = new JTable(data, mas);

                    JScrollPane scrollPane = new JScrollPane(table);
                    frame.setTitle("Кассеты");
                    frame.add(scrollPane, BorderLayout.CENTER);
                    frame.setSize(650, 300);
                    frame.setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    public Inter() {

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        nobyisotrydnik = new javax.swing.JButton();
        novayadoljnost = new javax.swing.JButton();
        newjanr = new javax.swing.JButton();
        newkas = new javax.swing.JButton();
        newklient = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        izmena = new javax.swing.JButton();
        Obzor = new javax.swing.JButton();
        obzor = new javax.swing.JButton();
        obzorjanr = new javax.swing.JButton();
        obzorkas = new javax.swing.JButton();
        obzorkli = new javax.swing.JButton();
        izmenadoljnost = new javax.swing.JButton();
        clearD = new javax.swing.JButton();
        izmenajanra = new javax.swing.JButton();
        clearjanr = new javax.swing.JButton();
        izmenakas = new javax.swing.JButton();
        clearkas = new javax.swing.JButton();
        izmenakli = new javax.swing.JButton();
        klearklient = new javax.swing.JButton();
        delS = new javax.swing.JButton();
        delD = new javax.swing.JButton();
        deljanr = new javax.swing.JButton();
        delcas = new javax.swing.JButton();
        delkli = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBox11 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        Caset = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox22 = new javax.swing.JComboBox<>();
        jComboBox33 = new javax.swing.JComboBox<>();

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        jTextField1.setText("45325435435");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        nobyisotrydnik.setText("Новый сотрудник");
        nobyisotrydnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nobyisotrydnikActionPerformed(evt);
            }
        });

        novayadoljnost.setText("Новая долджность");
        novayadoljnost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novayadoljnostActionPerformed(evt);
            }
        });

        newjanr.setText("Новый жанр");
        newjanr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newjanrActionPerformed(evt);
            }
        });

        newkas.setText("Новая касета");
        newkas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newkasActionPerformed(evt);
            }
        });

        newklient.setText("Новый клиент");
        newklient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newklientActionPerformed(evt);
            }
        });

        clear.setForeground(new java.awt.Color(255, 0, 0));
        clear.setText("Очистить");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        izmena.setText("Изменить");
        izmena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izmenaActionPerformed(evt);
            }
        });

        Obzor.setText("Обзор");
        Obzor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObzorActionPerformed(evt);
            }
        });

        obzor.setText("Обзор");
        obzor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obzorActionPerformed(evt);
            }
        });

        obzorjanr.setText("Обзор");
        obzorjanr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obzorjanrActionPerformed(evt);
            }
        });

        obzorkas.setText("Обзор");
        obzorkas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obzorkasActionPerformed(evt);
            }
        });

        obzorkli.setText("Обзор");
        obzorkli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obzorkliActionPerformed(evt);
            }
        });

        izmenadoljnost.setText("Изменить");
        izmenadoljnost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izmenadoljnostActionPerformed(evt);
            }
        });

        clearD.setForeground(new java.awt.Color(255, 0, 0));
        clearD.setText("Очистить");
        clearD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDActionPerformed(evt);
            }
        });

        izmenajanra.setText("Изменить");
        izmenajanra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izmenajanraActionPerformed(evt);
            }
        });

        clearjanr.setForeground(new java.awt.Color(255, 0, 0));
        clearjanr.setText("Очистить");
        clearjanr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearjanrActionPerformed(evt);
            }
        });

        izmenakas.setText("Изменить");
        izmenakas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izmenakasActionPerformed(evt);
            }
        });

        clearkas.setForeground(new java.awt.Color(255, 0, 0));
        clearkas.setText("Очистить");
        clearkas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearkasActionPerformed(evt);
            }
        });

        izmenakli.setText("Изменить");
        izmenakli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izmenakliActionPerformed(evt);
            }
        });

        klearklient.setForeground(new java.awt.Color(255, 0, 51));
        klearklient.setText("Очистить");
        klearklient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klearklientActionPerformed(evt);
            }
        });

        delS.setText("удалить");
        delS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delSActionPerformed(evt);
            }
        });

        delD.setText("удалить");
        delD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delDActionPerformed(evt);
            }
        });

        deljanr.setText("удалить");
        deljanr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deljanrActionPerformed(evt);
            }
        });

        delcas.setText("удалить");
        delcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delcasActionPerformed(evt);
            }
        });

        delkli.setText("удалить");
        delkli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delkliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Obzor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(obzor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(obzorjanr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(obzorkas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(obzorkli, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(newkas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newjanr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(novayadoljnost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(nobyisotrydnik, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newklient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(izmena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delS))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(izmenakli)
                            .addComponent(izmenakas)
                            .addComponent(izmenajanra)
                            .addComponent(izmenadoljnost))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(delcas)
                                .addComponent(delkli)
                                .addComponent(deljanr))
                            .addComponent(delD))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(clear)
                        .addComponent(clearD)
                        .addComponent(clearkas, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(klearklient)
                    .addComponent(clearjanr))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Obzor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nobyisotrydnik, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(izmena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(obzor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(novayadoljnost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearD, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(delD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(izmenadoljnost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newjanr, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(obzorjanr, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(izmenajanra, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(deljanr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearjanr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(delcas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(izmenakas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(obzorkas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newkas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearkas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(obzorkli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(klearklient, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(delkli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(izmenakli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newklient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ввод", jPanel1);

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Нет фильтра", "Сотрудники отдельных должностей" }));

        jButton1.setText("Отдел кадров");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Caset.setText("Кассеты");
        Caset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CasetActionPerformed(evt);
            }
        });

        jButton3.setText("Кассеты");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox22.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Нет фильтра", "Отображение кассет отдельных жанров", "Отображение кассет за отдельные годы", "отображение с определенными актерами" }));

        jComboBox33.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Нет фильтра", "отображения кассет на руках определнных клиентов", "отбражение оплаченных и не оплаченных кассет", "отображение сданных и не сданных кассет" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Caset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox11, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox22, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox33, 0, 336, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Caset, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Запросы", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ObzorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObzorActionPerformed
        new SimpleTableTest("сотрудники.txt", "Код сотрудника;ФИО;Возраст;Пол;Адрес;Телефон;Паспортные данные;Код должности", "Список сотрудников", 8);
    }//GEN-LAST:event_ObzorActionPerformed

    private void izmenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izmenaActionPerformed
        new Izmena("сотрудники.txt", "изменение данных о сотруднике", 8, "Введите код сотрудника");

    }//GEN-LAST:event_izmenaActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        new Clear("сотрудники.txt");

    }//GEN-LAST:event_clearActionPerformed

    private void nobyisotrydnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nobyisotrydnikActionPerformed
        new dobavlenie("сотрудники.txt", "Код сотрудника;ФИО;Возраст;Пол;Адрес;Телефон;Паспортные данные;Код должности", "Добавление сотрудника", 8);
    }//GEN-LAST:event_nobyisotrydnikActionPerformed

    private void novayadoljnostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novayadoljnostActionPerformed
        new dobavlenie("должности.txt", "Код должности;Наименование должности;Оклад;Обязанности;Требования", "добавление должности", 5);
    }//GEN-LAST:event_novayadoljnostActionPerformed

    private void obzorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obzorActionPerformed
        new SimpleTableTest("должности.txt", "Код должности;Наименование должности;Оклад;Обязанности;Требования", "Должности", 5);
    }//GEN-LAST:event_obzorActionPerformed

    private void clearDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDActionPerformed
        new Clear("должности.txt");
    }//GEN-LAST:event_clearDActionPerformed

    private void izmenadoljnostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izmenadoljnostActionPerformed
        new Izmena("должности.txt", "изменение данных о должности", 5, "Введите код должности");
    }//GEN-LAST:event_izmenadoljnostActionPerformed

    private void delDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delDActionPerformed
        new del("должности.txt", 5, "Код должности");
    }//GEN-LAST:event_delDActionPerformed

    private void delSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delSActionPerformed
        new del("сотрудники.txt", 8, "Код сотрудника");
    }//GEN-LAST:event_delSActionPerformed

    private void clearjanrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearjanrActionPerformed
        new Clear("жанры.txt");
    }//GEN-LAST:event_clearjanrActionPerformed

    private void clearkasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearkasActionPerformed
        new Clear("кассеты.txt");
    }//GEN-LAST:event_clearkasActionPerformed

    private void klearklientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klearklientActionPerformed
        new Clear("клиенты.txt");
    }//GEN-LAST:event_klearklientActionPerformed

    private void newjanrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newjanrActionPerformed
        new dobavlenie("жанры.txt", "Код жанра;Наименование жанра;Описание", "добавление жанра", 3);
    }//GEN-LAST:event_newjanrActionPerformed

    private void newkasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newkasActionPerformed
        new dobavlenie("кассеты.txt", "Код кассеты;Наименование фильма;Год создания;Производителя;Страну;Главного актера;Дату записи;Код жанра;Цену", "добавление кассеты", 9);
    }//GEN-LAST:event_newkasActionPerformed

    private void newklientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newklientActionPerformed
        new dobavlenie("клиенты.txt", "ФИО;Адрес;Телефон;Паспортные данные;Дату взятия;Дату возврата;Отметку об оплате(Оплачено,Не оплачено);Отметку о возврате(Возвращено,Не возращено);Код кассеты 1;Код кассеты 2;Код кассеты 3;Код сотрудника", "добавление клиента", 12);
    }//GEN-LAST:event_newklientActionPerformed

    private void obzorjanrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obzorjanrActionPerformed
        new SimpleTableTest("жанры.txt", "Код жанра;Наименоваие жанра;Описание", "жанры", 3);
    }//GEN-LAST:event_obzorjanrActionPerformed

    private void obzorkasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obzorkasActionPerformed
        new SimpleTableTest("кассеты.txt", "Код кассеты;Наименование фильма;Год создания;Производитель;Страна;Главный актер;Дата записи;Код жанра;Цена", "Кассеты", 9);
    }//GEN-LAST:event_obzorkasActionPerformed

    private void obzorkliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obzorkliActionPerformed
        new SimpleTableTest("клиенты.txt", "ФИО;Адрес;Телефон;Паспортные данные;Дата взятия;Дата возврата;Отметка об оплате;Отметка о возврате;Код кассеты 1;Код кассеты 2;Код кассеты 3;Код сотрудника", "добавление клиента", 12);
    }//GEN-LAST:event_obzorkliActionPerformed

    private void izmenajanraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izmenajanraActionPerformed
        new Izmena("жанры.txt", "изменение данных о жанрах", 3, "Введите код жанра");
    }//GEN-LAST:event_izmenajanraActionPerformed

    private void izmenakasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izmenakasActionPerformed
        new Izmena("кассеты.txt", "изменение данных о кассете", 9, "Введите код кассеты");
    }//GEN-LAST:event_izmenakasActionPerformed

    private void izmenakliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izmenakliActionPerformed
        new Izmena("клиенты.txt", "изменение данных о клиенте", 12, "Введите Фио  клиента");
    }//GEN-LAST:event_izmenakliActionPerformed

    private void deljanrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deljanrActionPerformed
        new del("жанры.txt", 3, "Код жанра");
    }//GEN-LAST:event_deljanrActionPerformed

    private void delcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delcasActionPerformed
        new del("кассеты.txt", 9, "Код кассеты");
    }//GEN-LAST:event_delcasActionPerformed

    private void delkliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delkliActionPerformed
        new del("клиенты.txt", 12, "фИО");
    }//GEN-LAST:event_delkliActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String Name = "Код сотрудника;ФИО;Возраст;Пол;Адресс;Телефон;Паспортные данные;Наименование должности;Оклад;Обязанности;Требования";
        String[] mass = new String[12];
        Vector<String> ozag = new Vector<String>();
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        JFrame frame = new JFrame();
        String In = null;
        mass = Name.split(";");
        if (jComboBox11.getSelectedIndex() == 1) {
            In = JOptionPane.showInputDialog("Введите код должности");
            if (In == null || "".equals(In)) {
                JOptionPane.showMessageDialog(clear, "неправильный ввод");
                return;
            }
            for (int i = 0; i < In.length(); i++) {
                if (In.charAt(i) < '0' || In.charAt(i) > '9') {
                    JOptionPane.showMessageDialog(clear, "неправильный ввод");
                    return;
                }
            }
        }
        for (int i = 0; i < mass.length; i++) {
            ozag.add(mass[i]);
        }
        try {
            FileReader sot = new FileReader("сотрудники.txt");
            Scanner Sc1 = new Scanner(sot);
            while (Sc1.hasNextLine()) {
                Vector<String> row = new Vector<String>();
                String Str = null;
                Str = Sc1.nextLine();
                String[] massiv1 = new String[8];
                massiv1 = Str.split(";");
                for (int i = 0; i < 7; i++) {
                    row.add(massiv1[i]);
                }
                FileReader dol = new FileReader("должности.txt");
                Scanner Sc2 = new Scanner(dol);
                while (Sc2.hasNextLine()) {
                    String Str1 = null;
                    Str1 = Sc2.nextLine();
                    String[] massiv2 = new String[5];
                    massiv2 = Str1.split(";");
                    if (Integer.parseInt(massiv1[7]) == Integer.parseInt(massiv2[0])) {
                        for (int i = 1; i < 5; i++) {
                            row.add(massiv2[i]);
                            ;
                        }
                    }
                }
                if (jComboBox11.getSelectedIndex() == 1) {

                    if (Integer.parseInt(massiv1[7]) == Integer.parseInt(In)) {

                        data.add(row);
                    }
                } else {
                    data.add(row);
                }
            }
            JTable table = new JTable(data, ozag);

            JScrollPane scrollPane = new JScrollPane(table);
            frame.setTitle("отдел кадров");
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setSize(650, 300);
            frame.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CasetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CasetActionPerformed
        if (jComboBox22.getSelectedIndex() == 0) {
            String Name = "Код жанра;Наименование жанра;Описание жанра;Код кассеты;Наименование фильма;Год создания;Производитель;Страна;Главный актер;Дата записи;Цена";
            String[] mass = new String[10];
            mass = Name.split(";");
            Vector<String> ozag = new Vector<String>();
            for (int i = 0; i < mass.length; i++) {
                ozag.add(mass[i]);
            }
            Vector<Vector<String>> data = new Vector<Vector<String>>();
            JFrame frame = new JFrame();
            try {
                FileReader janr = new FileReader("жанры.txt");
                Scanner Sc1 = new Scanner(janr);
                while (Sc1.hasNextLine()) {
                    String Str;
                    Str = Sc1.nextLine();
                    String[] massiv1 = new String[3];
                    massiv1 = Str.split(";");
                    FileReader cas = new FileReader("кассеты.txt");
                    Scanner Sc2 = new Scanner(cas);
                    while (Sc2.hasNextLine()) {
                        String Str1;
                        Str1 = Sc2.nextLine();
                        String[] massiv2 = new String[9];
                        massiv2 = Str1.split(";");
                        if (Integer.parseInt(massiv1[0]) == Integer.parseInt(massiv2[7])) {
                            Vector<String> row = new Vector<String>();
                            for (int i = 0; i < 3; i++) {
                                row.add(massiv1[i]);
                            }
                            for (int i = 0; i < 9; i++) {
                                if (i != 7) {
                                    row.add(massiv2[i]);
                                }
                            }
                            data.add(row);
                        }
                    }
                }
                JTable table = new JTable(data, ozag);

                JScrollPane scrollPane = new JScrollPane(table);
                frame.setTitle("Кассеты");
                frame.add(scrollPane, BorderLayout.CENTER);
                frame.setSize(650, 300);
                frame.setVisible(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (jComboBox22.getSelectedIndex() == 1) {
            new janrpoisk();
        }
        if (jComboBox22.getSelectedIndex() == 2) {
            new yearpoisk();
        }
        if (jComboBox22.getSelectedIndex() == 3) {
            new actorpoisk();
        }
    }//GEN-LAST:event_CasetActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jComboBox33.getSelectedIndex() == 0) {
            String Name = "ФИО к;Адрес к;Телефон к;отметка об оплате;отметка о возврате;Имя фильма;Цена;ФИО с;Должность";
            String[] mass = new String[15];
            mass = Name.split(";");
            Vector<String> ozag = new Vector<String>();
            for (int i = 0; i < mass.length; i++) {
                ozag.add(mass[i]);
            }
            Vector<Vector<String>> data = new Vector<Vector<String>>();
            JFrame frame = new JFrame();
            try {
                FileReader kli = new FileReader("клиенты.txt");
                Scanner Sc1 = new Scanner(kli);
                while (Sc1.hasNextLine()) {
                    String Str;
                    Str = Sc1.nextLine();
                    String[] massiv1 = new String[12];
                    massiv1 = Str.split(";");
                    FileReader cas = new FileReader("кассеты.txt");
                    Scanner Sc2 = new Scanner(cas);
                    while (Sc2.hasNextLine()) {
                        String Str1;
                        Str1 = Sc2.nextLine();
                        String[] massiv2 = new String[9];
                        massiv2 = Str1.split(";");
                        if (Integer.parseInt(massiv1[8]) == Integer.parseInt(massiv2[0]) || Integer.parseInt(massiv1[9]) == Integer.parseInt(massiv2[0]) || Integer.parseInt(massiv1[10]) == Integer.parseInt(massiv2[0])) {
                            Vector<String> row = new Vector<String>();
                            for (int i = 0; i < 8; i++) {
                                if (i != 5 && i != 4 && i != 3) {
                                    row.add(massiv1[i]);
                                }
                            }
                            for (int i = 0; i < 9; i++) {
                                if (i == 1 || i == 8) {
                                    row.add(massiv2[i]);
                                }
                            }
                            FileReader sot = new FileReader("сотрудники.txt");
                            Scanner Sc3 = new Scanner(sot);
                            while (Sc3.hasNextLine()) {
                                String Str3;
                                Str3 = Sc3.nextLine();
                                String[] massiv3 = new String[9];
                                massiv3 = Str3.split(";");
                                if (Integer.parseInt(massiv1[11]) == Integer.parseInt(massiv3[0])) {
                                    row.add(massiv3[1]);
                                    FileReader dol = new FileReader("должности.txt");
                                    Scanner Sc4 = new Scanner(dol);
                                    while (Sc4.hasNextLine()) {
                                        String Str4;
                                        Str4 = Sc4.nextLine();
                                        String[] massiv4 = new String[9];
                                        massiv4 = Str4.split(";");
                                        if (Integer.parseInt(massiv3[7]) == Integer.parseInt(massiv4[0])) {
                                            row.add(massiv4[1]);

                                        }
                                    }

                                }
                            }

                            data.add(row);
                        }
                    }
                }
                JTable table = new JTable(data, ozag);

                JScrollPane scrollPane = new JScrollPane(table);
                frame.setTitle("Кассеты на руках");
                frame.add(scrollPane, BorderLayout.CENTER);
                frame.setSize(650, 300);
                frame.setVisible(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Inter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (jComboBox33.getSelectedIndex() == 1) {
            new klientpoisk();
        }
        if (jComboBox33.getSelectedIndex() == 2) {
            new oplatapoisk();
        }
        if (jComboBox33.getSelectedIndex() == 3) {
            new vozvratpoisk();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inter().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Caset;
    private javax.swing.JButton Obzor;
    private javax.swing.JButton clear;
    private javax.swing.JButton clearD;
    private javax.swing.JButton clearjanr;
    private javax.swing.JButton clearkas;
    private javax.swing.JButton delD;
    private javax.swing.JButton delS;
    private javax.swing.JButton delcas;
    private javax.swing.JButton deljanr;
    private javax.swing.JButton delkli;
    private javax.swing.JButton izmena;
    private javax.swing.JButton izmenadoljnost;
    private javax.swing.JButton izmenajanra;
    private javax.swing.JButton izmenakas;
    private javax.swing.JButton izmenakli;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox22;
    private javax.swing.JComboBox<String> jComboBox33;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton klearklient;
    private javax.swing.JButton newjanr;
    private javax.swing.JButton newkas;
    private javax.swing.JButton newklient;
    private javax.swing.JButton nobyisotrydnik;
    private javax.swing.JButton novayadoljnost;
    private javax.swing.JButton obzor;
    private javax.swing.JButton obzorjanr;
    private javax.swing.JButton obzorkas;
    private javax.swing.JButton obzorkli;
    // End of variables declaration//GEN-END:variables

}
