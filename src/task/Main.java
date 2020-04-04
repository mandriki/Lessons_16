package task;

import java.io.*;
public class Main {

    public static void main(String[] args) {
       /** Сравнить скорость чтения и записи 5 МБ символов при использовании классов
                * буфиризированого и не буфиризированого символьного ввода вывода.*/
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("c:\\1\\text.txt"));
            Reader reader2 = new FileReader("c:\\1\\text.txt");
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("c:\\1\\text1.txt"));
            Writer writer2 = new FileWriter("c:\\1\\text1.txt");

            int noBuffer;
            StringBuilder noBuf = new StringBuilder();
            long timeStartReading = System.currentTimeMillis();
                while ((noBuffer = reader2.read()) >= 0) {
                     noBuf.append(noBuffer);
                }
            long timeStopReading = System.currentTimeMillis();
            long timeReading = timeStopReading - timeStartReading;
            System.out.println("Время чтения без буффера - " + timeReading);

            String yesBuffer;
            StringBuilder yesBuf = new StringBuilder();
            long timeStartReadingBuff = System.currentTimeMillis();
                while ((yesBuffer = reader1.readLine()) != null) {
                     yesBuf.append(yesBuffer);
                }
            long timeStopReadingBuff = System.currentTimeMillis();
            long timeReadingBuff = timeStopReadingBuff - timeStartReadingBuff;
            System.out.println("Время чтения с буффером - " + timeReadingBuff);

            long timeStartWriting = System.currentTimeMillis();
            writer2.write(noBuf.toString());

            long timeStopWriting = System.currentTimeMillis();
            long timeWriting = timeStopWriting - timeStartWriting;
            System.out.println("Время записи без буффера - " + timeWriting);

            long timeStartWritingBuff = System.currentTimeMillis();
            writer1.write(yesBuf.toString());

            long timeStopWritingBuff = System.currentTimeMillis();
            long timeWritingBuff = timeStopWritingBuff - timeStartWritingBuff;
            System.out.println("Время записи с буффера - " + timeWritingBuff);

            reader1.close();
            reader2.close();
            writer1.close();
            writer2.close();

        } catch (IOException e) {
            System.out.println("Нет файла");
        }
      /**  2.	Создать класс Computer. Добавить ему несколько полей, создать объект этого класса, сериализовать в файл.
        Десериализовать объект из того же файла, вывести значения полей в консоль.*/

        Computer comp = new Computer("ASUS", "i5",  1024, 256);
        try (ObjectOutputStream list1 = new ObjectOutputStream(new FileOutputStream("c:\\1\\text.txt"));
             ObjectInputStream list2 = new ObjectInputStream(new FileInputStream("c:\\1\\text.txt"));
        ) {
            list1.writeObject(comp);
            Computer computer = (Computer) list2.readObject();
            System.out.println("Комп - " + computer.name + "\nПроц - " + computer.cpu);
            System.out.println("Оператива - " + computer.ram + "\nВеник - " + computer.hdd);
        } catch (Exception e) {
            System.out.println("Нет файла");
        }

        /**3.	Создать класс Notebook - наследник Computer. В этом классе должно быть поле типа Touchpad - также созданного класса со своими полями.
                Добавить в класс Notebook transient-поле. Создать объект класса Notebook, сериализовать в файл.
        Десериализовать объект из файла, продемонстрировать, что transient-поля не сериализуются.*/

        Notebook book = new Notebook("HP", "i5", 4, 500, 5,3);
        try (ObjectOutputStream list1 = new ObjectOutputStream(new FileOutputStream("c:\\1\\text.txt"));
             ObjectInputStream list2 = new ObjectInputStream(new FileInputStream("c:\\1\\text.txt"));
        ) {
            list1.writeObject(book);
            Notebook notebook = (Notebook) list2.readObject();
            System.out.println(book.name + " "
                    + book.weight + " "
                    + book.buttons+ " "
                    + book.touchPad.buttons);
            System.out.println(notebook.name + " "
                    + notebook.weight + " "
                    + notebook.buttons+ " "
                    + notebook.touchPad.buttons);
        } catch (Exception e) {
            System.out.println("Нет файла");
        }

    }
}
/** 1.	Сравнить скорость чтения и записи 5 МБ символов при использовании классов
 * буфиризированого и не буфиризированого символьного ввода вывода.

        2.	Создать класс Computer. Добавить ему несколько полей, создать объект этого класса, сериализовать в файл.
        Десериализовать объект из того же файла, вывести значения полей в консоль.

        3.	Создать класс Notebook - наследник Computer. В этом классе должно быть поле типа Touchpad - также созданного класса со своими полями.
        Добавить в класс Notebook transient-поле. Создать объект класса Notebook, сериализовать в файл.
        Десериализовать объект из файла, продемонстрировать, что transient-поля не сериализуются.


        При написании кода придерживайтесь соглашений по написанию кода. (see docs/CodeConventions.pdf)*/
