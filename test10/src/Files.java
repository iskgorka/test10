public class Files {
}
/*
File example 1
//Продемонстрировать применение некоторых методов из класса File
        class FileDemo {
            static void p(String s) {
                System.out.println(s);
            }

            public static void main(String[] args) {
                File f1 = new File("/java/COPYRIGHT");
                p("Имя файла: " + f1.getName());
                p("Путь: " + f1.getPath());
                p("Абсолютный путь: " + f1.getAbsolutePath());
                p("Родительский каталог: " + f1.getParent());
                p(f1.exists() ? "существует" : "не существует");
                p(f1.canWrite() ? "доступен для записи" : "недоступен для записи");
                p(f1.canRead() ? "доступен для чтения" : "недоступен для чтения");
                p(f1.isDirectory() ? "является каталогом" : "не является каталогом");
                p(f1.isFile() ? "является обычным файлом" : "может быть именнованым каналом");
                p(f1.isAbsolute() ? "является абсолютным" : "не является абсолютным");
                p("Последнее изменение в файле: " + f1.lastModified());
                p("Размер: " + f1.length() + " байт");
            }
        }

File example 2
        //В этой версии программы ShowFile
        //оператор try с ресурсами применяется
        //для автоматического закрытия файла
        class ShowFile {
            public static void main(String[] args) {
                int i;
        //сначала убедится, что имя файла указано
                if(args.length != 1) {
                    System.out.println("Использование: ShowFile имя_файла");
                    return;
                }
        //Ниже оператор try с ресурсами применяется
        //сначала для открытия, а затем для автоматического
        //закрытия файла по завершении блока этого оператора
                try(FileInputStream fin = new FileInputStream(args[0])) {
                    do {
                        i = fin.read();
                        if(i != -1) System.out.print((char) i);
                    }
                    while (i != -1);
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не найден");
                } catch (IOException e) {
                    System.out.println("Произошла ошибка ввода-вывода");
                }
            }
        }

File example 3
        //Продемонстрировать применение класса FileWriter
        class FileWriterDemo {
            public static void main(String[] args) throws IOException {
                String source = "Now is the time for all good men\n"
                        + " to come to the aid of their country\n"
                        + " and pay their due taxes.";
                char[] buffer = new char[source.length()];
                source.getChars(0,source.length(),buffer,0);
                try(FileWriter f0 = new FileWriter("file1.txt");
                    FileWriter f1 = new FileWriter("file2.txt");
                    FileWriter f2 = new FileWriter("file3.txt")) {
        //вывести символы в первый файл
                    for (int i = 0; i < buffer.length; i+=2) {
                        f0.write(buffer[i]);
                    }
        //вывести символы во втрой файл
                    f1.write(buffer);
        //вывести символы в третий файл
                    f2.write(buffer, buffer.length - buffer.length / 4, buffer.length / 4);
                } catch (IOException e) {
                    System.out.println("Произошла ошибка ввода-вывода");
                }
            }
        }

Date time example 1
        //Простой пример применения классов LocalDate и LocalTime
        class DateTimeDemo {
            public static void main(String[] args) {
                LocalDate curDate = LocalDate.now();
                System.out.println(curDate);
                LocalTime curTime = LocalTime.now();
                System.out.println(curTime);
            }
        }

Date time example 2
        //Продемонстрировать применение класса DateTimeFormatter
        class DateTimeDemo2 {
            public static void main(String[] args) {
                LocalDate curDate = LocalDate.now();
                System.out.println(curDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
                LocalTime curTime = LocalTime.now();
                System.out.println(curTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
            }
        }

Date time example 3
        //Пример синтаксического анализа даты и времени
        class DateTimeDemo {
            public static void main(String[] args) {
                //получить объект типа LocalDateTime, выполнив
                //синтаксический анализ символьной строки даты и времени
                LocalDateTime curDateTime = LocalDateTime.parse("21 июля 2021 г. 12:18",
                        DateTimeFormatter.ofPattern("dd MMMM yyyy г. HH':'mm"));
                //а теперь отобразить проанализированные дату и время
                System.out.println(curDateTime.format(
                        DateTimeFormatter.ofPattern("HH:mm, dd MMMM yyyy")));
            }
        }

Date time example 4
        class Demo2 {
            public static void main(String[] args) {
                LocalDateTime date = LocalDateTime.of(2002, Month.JANUARY, 10, 22, 56);
                LocalDateTime sameDate = LocalDateTime.of(2002, Month.JANUARY, 10, 22, 56);
                LocalDateTime dateMinusOneMinute = sameDate.minusMinutes(1);
                LocalDateTime datePlusOneMinute = sameDate.plusMinutes(1);
                ZonedDateTime zonedDate = ZonedDateTime.of(date, ZoneId.of("Brazil/East"));

                System.out.println("date:" + date);
                System.out.println("sameDate:" + sameDate);
                System.out.println("dateMinusOneMinute:" + dateMinusOneMinute);
                System.out.println("datePlusOneMinute:" + datePlusOneMinute);
                System.out.println("zonedDate:" + zonedDate);
                System.out.println();

                System.out.println("compareTo #1: " + date.compareTo(sameDate));
                System.out.println("compareTo #2: " + date.compareTo(dateMinusOneMinute));
                System.out.println("compareTo #3: " + date.compareTo(datePlusOneMinute));
                System.out.println();

                System.out.println("isAfter #1: " + date.isAfter(sameDate));
                System.out.println("isAfter #2: " + date.isAfter(dateMinusOneMinute));
                System.out.println("isAfter #3: " + date.isAfter(datePlusOneMinute));
                System.out.println();

                System.out.println("isBefore #1: " + date.isBefore(sameDate));
                System.out.println("isBefore #2: " + date.isBefore(dateMinusOneMinute));
                System.out.println("isBefore #3: " + date.isBefore(datePlusOneMinute));
                System.out.println();

                System.out.println("isEqual #1: " + date.isEqual(sameDate));
                System.out.println("isEqual #2: " + date.isEqual(dateMinusOneMinute));
                System.out.println("isEqual #3: " + date.isEqual(datePlusOneMinute));
                System.out.println();

                System.out.println("equals #1: " + date.equals(sameDate));
                System.out.println("equals #2: " + date.equals(zonedDate));
            }
        }
*/
