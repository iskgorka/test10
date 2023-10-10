public class Generics {
}

/*
Example 1
//Простое обобщение классов
        class Point<T, V> {
            public V id;
            public T x, y;
            Point(T x, T y) {
                this.x = x;
                this.y = y;
            }
            V getId() {return id;}
            T getCoordX() {return x;}
            T getCoordY() {return y;}
            Object[] getCoords() { return new Object[]{x, y};}
        }

        class Main {
            public static void main(String[] args) {
                Point<Float, Integer> pt = new Point<>(1f, 2f);
                Point<Double, String> ptD = new Point<>(10.5, 22.6);
                pt.id = 1;
                ptD.id = "point_1";
                //pt.x = 10;
                //pt.y = 20;
                //ptD.x = 20.5;
                System.out.println(pt.getCoordX() + " " + pt.getCoordY());
                for (Object coord : pt.getCoords()) {
                    System.out.println((Float) coord);
                }
            }
        }

Example 2
        //Ограничение типов, метасимвольные аргументы, обобщенные методы и конструкторы
        //class Numbers<T> {}
        //class Point<T extends Numbers<Integer>> {}
        //interface I1 (){}
        //interface I2 (){}
        //class Point<T extends Number & I1, I2>> {}
        class Point<T extends Number> {
            public T x, y;
            Point(T x, T y) {
                this.x = x;
                this.y = y;
            }
            double getMax() {
                double xd = x.doubleValue();
                double yd = y.doubleValue();
                return (xd < yd) ? yd : xd;
            }
            boolean equalsPoint(Point<? extends Number> pt) {  //метасимвольный аргумент с ограничением
                return (this.x.doubleValue() == pt.x.doubleValue() &&
                        this.y.doubleValue() == pt.y.doubleValue());
            }
        }
        class Math {
            public static <T> boolean isIn(T val, T[] ar) { //обобщенный метод
                for (T v : ar)
                    if(v.equals(val)) return true;
                return false;
            }
        }
        class Digit {
            public double value;
            <T extends Number>Digit(T value){ //обобщенный конструктор
                this.value = value.doubleValue();
            }
        }
        class Main {
            public static void main(String[] args) {
                Point<Integer> pt = new Point<>(1,2);
                Point<Double> pt2 = new Point<>(1.0,2.0);
                double max = pt.getMax();
                System.out.println(max);
                System.out.println(pt.equalsPoint(pt2));

                Short ar[] = {1,2,3,4};
                Short val = 5;
                boolean flIn = Math.<Short>isIn(val, ar);
                System.out.println(flIn);

                Digit d1 = new Digit(10);
                Digit d2 = new Digit(10.5);
                Digit d3 = new Digit(10.5f);
                System.out.println(d1.value + " " + d2.value + " " + d3.value);

            }
        }

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
                System.out.print("Средние iOb и fOb");
                if(iOb.sameAvg(fOb))
                    System.out.println(" одинаковы.");
                else
                    System.out.println(" отличаются");
            }
        }

Generic example 7
        // Ограниченные метасимвольные аргументы
        // Двумерные координаты
        class TwoD {
            int x, y;

            TwoD(int a, int b) {
                x = a;
                y = b;
            }
        }

        // Трехмерные координаты
        class ThreeD extends TwoD {
            int z;

            ThreeD(int a, int b, int c) {
                super(a, b);
                z = c;
            }
        }

        // Четырехмерные координаты
        class FourD extends ThreeD {
            int t;

            FourD(int a, int b, int c, int d) {
                super(a, b, c);
                t = d;
            }
        }

        class FiveD extends FourD {
            int g;

            FiveD(int a, int b, int c, int d, int g) {
                super(a, b, c, d);
                this.g = g;
            }
        }

        //Этот класс хранит массив координатных объектов
        class Coords<T extends TwoD> {
            T[] coords;

            Coords(T[] o) {
                coords = o;
            }
        }

        //Продемонстрировать применение ограниченных метасимволов
        class BoundedWildcard {
            static void showXY(Coords<?> c) {
                System.out.println("Координаты X Y:");
                for (int i = 0; i < c.coords.length; i++)
                    System.out.println(c.coords[i].x + " " + c.coords[i].y);
                System.out.println();
            }

            static void showXYZ(Coords<? extends ThreeD> c) {
                System.out.println("Координаты X Y Z:");
                for (int i = 0; i < c.coords.length; i++)
                    System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z);
                System.out.println();
            }

            static void showAll(Coords<? super FourD> c) {
                System.out.println("Координаты X Y:");
                for (int i = 0; i < c.coords.length; i++)
                    System.out.println(c.coords[i].x + " " + c.coords[i].y);
                System.out.println();
            }

            public static void main(String[] args) {
                TwoD[] td = {
                        new TwoD(0, 0),
                        new TwoD(7, 9),
                        new TwoD(18, 4),
                        new TwoD(-1, -23),
                };
                Coords<TwoD> tdlocs = new Coords<TwoD>(td);
                System.out.println("Содержимое объекта tdlocs.");
                showXY(tdlocs); // Верно, это тип TwoD
                ///showXYZ(tdlocs); // ОШИБКА!!! Это не тип ThreeD
                showAll(tdlocs);
        //а теперь создать несколько объектов типа FourD
                FourD[] fd = {
                        new FourD(1, 2, 3, 4),
                        new FourD(6, 8, 14, 8),
                        new FourD(22, 9, 4, 9),
                        new FourD(3, -2, -23, 17),
                };
                Coords<FourD> fdlocs = new Coords<FourD>(fd);
                System.out.println("Содержимое объекта fdlocs.");
        //Здесь всё верно
                showXY(fdlocs);
                showXYZ(fdlocs);
                showAll(fdlocs);
                FiveD[] fd1 = {new FiveD(1, 2, 3, 4, 5)};
                Coords<FiveD> fd1locs = new Coords<FiveD>(fd1);
                showXY(fd1locs);
                showXYZ(fd1locs);
                //showAll(fd1locs);
            }
        }

Generic example 8
        //Продемонстировать простой обобщенный метод
        class GenMethDemo {
            //определить, содержится ли объект в массиве
            static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
                for (int i = 0; i < y.length; i++)
                    if (x.equals(y[i])) return true;
                return false;
            }

            public static void main(String[] args) {
                //применить метод isIn() для целых чисел
                Integer[] nums = {1, 2, 3, 4, 5};
                if (isIn(2, nums))
                    System.out.println("Число 2 содержится в массиве nums.");
                if (!isIn(7, nums))
                    System.out.println("Число 7 отсутствует в массиве nums.");
                System.out.println();
        //применить метод isIn() для символьных строк
                String[] strs = {"один", "два", "три", "четыре", "пять"};
                if (isIn("два", strs))
                    System.out.println("два содержится в массиве strs");
                if (!isIn("семь", strs))
                    System.out.println("семь отсутствует в массиве strs");
        //НЕ СКОМПИЛИРУЕТСЯ! Типы должны быть совместимы
                //if (isIn("два", nums))
                //    System.out.println("два содержится в массиве strs");
            }
        }

Generic example 9
        //Использовать обобщенный конструктор
        class GenCons {
            private double val;

            <T extends Number> GenCons(T arg) {
                val = arg.doubleValue();
            }

            void showAll() {
                System.out.println("val: " + val);
            }
        }

        class GenConsDemo {
            public static void main(String[] args) {
                GenCons test = new GenCons(100);
                GenCons test2 = new GenCons(123.5F);
                test.showAll();
                test2.showAll();
            }
        }

Generic example 10
        //Пример применения обобщенного интерфейса
        //Обобщенный интерфейс MinMax для определения
        //минимального и максимального значений
        interface MinMax<T extends Comparable<T>> {
            T min();
            T max();
        }

        //реализовать обобщенный интерфейс MinMax
        class MyClass<T extends Comparable<T>> implements MinMax<T> {
            T[] vals;

            MyClass(T[] o) {
                vals = o;
            }

            //возвратить минимальное значение из массива vals
            public T min() {
                T v = vals[0];
                for (int i = 1; i < vals.length; i++)
                    if (vals[i].compareTo(v) < 0) v = vals[i];
                return v;
            }

            //возвратить максимальное значение из массива vals
            public T max() {
                T v = vals[0];
                for (int i = 1; i < vals.length; i++)
                    if (vals[i].compareTo(v) > 0) v = vals[i];
                return v;
            }
        }

        class GenIfDemo {
            public static void main(String[] args) {
                Integer[] inums = {3, 6, 2, 8, 6};
                Character[] chs = {'b', 'r', 'p', 'v'};
                MyClass<Integer> iob = new MyClass<Integer>(inums);
                MyClass<Character> cob = new MyClass<Character>(chs);
                System.out.println("Максимальное значение в массиве inums: " + iob.max());
                System.out.println("Минимальное значение в массиве inums: " + iob.min());
                System.out.println("Максимальное значение в массиве chs: " + cob.max());
                System.out.println("Минимальное значение в массиве chs: " + cob.min());
            }
        }

File example 1
*/