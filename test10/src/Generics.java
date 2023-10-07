import java.util.SplittableRandom;

public class Generics {
}
/*
Lec10 example 1
        //продемонстрировать автоупаковку/автораспаковку
        class AutoBox {
            public static void main(String[] args) {
                Integer iOb = 100; //автоупаковка значения типа int
                int i = iOb; //автораспаковка значения типа int
                System.out.println(i + " " + iOb); //выводит значения 100 и 100
            }
        }

Generic example 1
        // Простой обобщенный класс.
        // Здесь T обозначает параметр типа,
        // который будет заменен реальным типом
        // при создании объекта типа Gen
        class Gen<T> {
            T ob; //объявить объект типа Т

            //передать конструктору ссылку на объект типа Т
            Gen(T o) {
                ob = o;
            }

            //возвратить объект ob;
            T getOb() {
                return ob;
            }

            //показать тип T
            void showType() {
                System.out.println("Типом T является " + ob.getClass().getName());
            }
        }

        // Продемонстрировать применение обобщенного класса
        class GenDomo {
            public static void main(String[] args) {
        //Создать ссылку типа Gen для целых чисел
                Gen<Integer> iOb;
        //Создать объект типа Gen<Integer> и присвоить
        //ссылку на него переменно iOb. Обратите внимание на
        //применение автоупаковки для инкапсуляции значения 88
        //в объекте типа Integer
                iOb = new Gen<Integer>(88);
        //показать тип данных, хранящихся в переменной iOb
                iOb.showType();
        //получить значение переменной iOb. Обратите
        //внимание на то, что для этого не требуется
        //никакого приведения типов
                int v = iOb.getOb();
                System.out.println("Значение: " + v);
                System.out.println();
        //создать объект типа Gen для символьных строк
                Gen<String> strOb = new Gen<String>("Тест обобщений");
        //показать тип данных, хранящихся в переменной strOb
                strOb.showType();
        //получить значение переменной strOb. И в этом
        //случае приведение типов не требуется
                String str = strOb.getOb();
                System.out.println("Значение: " + str);
            }
        }

Generic example 2
        //Простой обобщённый класс с двумя параметрами типа: T и V
        class TwoGen<T, V> {
            T ob1;
            V ob2;

            //передать конструктору ссылки на объекты типа T и V
            TwoGen(T o1, V o2) {
                ob1 = o1;
                ob2 = o2;
            }

            //возвратить объект ob;
            T getOb1() {
                return ob1;
            }

            V getOb2() {
                return ob2;
            }

            //показать тип T и V
            void showTypes() {
                System.out.println("Типом T является " + ob1.getClass().getName());
                System.out.println("Типом V является " + ob2.getClass().getName());
            }
        }

        //Продемонстрировать применение класса TwoGen
        class SimpGen {
            public static void main(String[] args) {
                TwoGen<Integer, String> tgObj = new TwoGen<Integer, String>(88, "Обобщения");
        //показать типы
                tgObj.showTypes();
        //получить и показать значения
                int v = tgObj.getOb1();
                System.out.println("Значение: " + v);
                String str = tgObj.getOb2();
                System.out.println("Значение: " + str);
            }
        }

Generic example 3
        //Класс Stats - пример безуспешной попытки создать
        //обобщенный класс для вычисления среднего значения
        //массива чисел заданого типа.
        //этот класс содержит ОШИБКУ!
        class Stats<T> {
            T[] nums; // nums - это массив элементов типа Т
            //передать конструктору ссылку на массив значений типа Т
            Stats(T[] o) {
                nums = o;
            }
            //возвратить значение типа double в любом случае
            double average() {
                double sum = 0.0;
                for (int i = 0; i < nums.length; i++)
                    sum += nums[i].doubleValue(); // ОШИБКА!!!
                return sum / nums.length;
            }
        }

Generic example 4
        //В этой версии класса Stats аргумент типа Т должен
        //быть классом Number или наследуемым от него классом
        class Stats<T extends Number> {
            T[] nums; //массив класса Number или его подкласса

            //передать конструктору ссылку на массив элементов
        //класса Number или его подкласса
            Stats(T[] o) {
                nums = o;
            }

            //возвратить значение типа double в любом случае
            double average() {
                double sum = 0.0;
                for (int i = 0; i < nums.length; i++)
                    sum += nums[i].doubleValue();
                return sum / nums.length;
            }
        }

        //продемонстрировать применение класса Stats
        class BoundsDemo {
            public static void main(String[] args) {
                Integer inums[] = {1, 2, 3, 4, 5};
                Stats<Integer> iOb = new Stats<Integer>(inums);
                double v = iOb.average();
                System.out.println("Среднее значение iOb равно " + v);
                Double dnums[] = {1.1, 2.2, 3.3, 4.4, 5.5};
                Stats<Double> dOb = new Stats<Double>(dnums);
                double w = dOb.average();
                System.out.println("Среднее значение dOb равно " + w);
        //Этот код не скомпилируется, так как класс String
        //не является производным от класса Number
        //String[] strs = {"1", "2", "3", "4", "5"};
        //Stats<String> strOb = new Stats<String>(strs);
        //double x = strOb.average();
        //System.out.println("Среднее значение strOb равно " + v);
            }
        }

Generic example 5
        interface MyInt {
            int c = 0;
        }
        class A {
            int a;

            A(int a) {
                this.a = a;
            }
        }
        class B extends A implements MyInt {
            int b;

            B(int a, int b) {
                super(a);
                this.b = b;
            }
        }
        class D extends B {
            int d;

            D(int a, int b, int d) {
                super(a, b);
                this.d = d;
            }
        }
        class Gen<T extends B & MyInt> {
            T ob;
            Gen(T o) {
                ob = o;
            }
        }
        class Demo1 {
            public static void main(String[] args) {
                Gen<B> ob = new Gen<B>(new B(1,2));
                System.out.println("Значение b: " + ob.ob.b);
                System.out.println("Значение c: " + ob.ob.c);
                Gen<D> ob1 = new Gen<D>(new D(11,22,33));
                System.out.println("Значение b: " + ob1.ob.b);
                System.out.println("Значение d: " + ob1.ob.d);
                //Gen<A> ob2 = new Gen<A>(new A(111));
                //System.out.println("Значение b: " + ob2.ob.a);
                //System.out.println("Значение d: " + ob2.ob.c);
            }
        }

Generic example 6
        //применение метасимвола
        class Stats<T extends Number> {
            T[] nums; //массив класса Number или его подкласса

            //передать конструктору ссылку на массив элементов
            //класса Number или его подкласса
            Stats(T[] o) {
                nums = o;
            }
            //возвратить значение типа double в любом случае
            double average() {
                double sum = 0.0;
                for (int i = 0; i < nums.length; i++)
                    sum += nums[i].doubleValue();
                return sum / nums.length;
            }
            //определить равенство двух средних значений
            //Обратите внимание на применение метасимвола
            boolean sameAvg(Stats<?> ob) {
                if (average() == ob.average())
                    return true;
                return false;
            }
        }
        //Продемонстрировать применение метасимвола
        class WildcardDemo {
            public static void main(String[] args) {
                Integer inums[] = {1, 2, 3, 4, 5};
                Stats<Integer> iOb = new Stats<Integer>(inums);
                double v = iOb.average();
                System.out.println("Среднее значение iOb равно " + v);
                Double dnums[] = {1.1, 2.2, 3.3, 4.4, 5.5};
                Stats<Double> dOb = new Stats<Double>(dnums);
                double w = dOb.average();
                System.out.println("Среднее значение dOb равно " + w);
                Float fnums[] = {1.0F, 2.0F, 3.0F, 4.0F, 5.0F};
                Stats<Float> fOb = new Stats<Float>(fnums);
                double x = fOb.average();
                System.out.println("Среднее значение fOb равно " + x);
                //выяснить какие массивы имеют одинаковые средние значения
                System.out.print("Средние значения iOb и dOb");
                if(iOb.sameAvg(dOb))
                    System.out.println(" равны.");
                else
                    System.out.println(" отличаются");
                System.out.print("Средние значения iOb и fOb");
                if(iOb.sameAvg(fOb))
                    System.out.println(" равны.");
                else
                    System.out.println(" отличаются");
            }
        }

Generic example 7
*/