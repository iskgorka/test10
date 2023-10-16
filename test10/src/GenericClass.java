public class GenericClass<T extends Number> {
    private T x, y, z;

    GenericClass(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    T getX() {
        return x;
    }

    T getY() {
        return y;
    }

    T getZ() {
        return z;
    }

    public <T> double getSum(T x, T y, T z) {
        return this.x.doubleValue() + this.y.doubleValue() + this.z.doubleValue();
    }
}

class Main {
    public static void main(String[] args) {
        double summa;
        GenericClass<?> g1 = new GenericClass<>(1, 2.4, 3f);
        GenericClass<?> g2 = new GenericClass<>(2.0, 10f, 5);
        GenericClass<?> g3 = new GenericClass<>(4.3, 5f, 16);
        System.out.println("x: " + g2.getX() + "\ny: " + g2.getY() + "\nz: " + g2.getZ());
        summa = g1.getSum(g1.getX(), g1.getY(), g1.getZ());
        System.out.println("Сумма g1: " + summa);
        summa = g2.getSum(g2.getX(), g2.getY(), g2.getZ());
        System.out.println("Сумма g2: " + summa);
        summa = g3.getSum(g3.getX(), g3.getY(), g3.getZ());
        System.out.println("Сумма g3: " + summa);
    }
}
