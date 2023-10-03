package stackExample;

public interface IntStack {
    void push(int item);

    int pop();
}

class Stack {
    public void push(int item) {
        System.out.println("Push");
    }

    public int pop() {
        System.out.println("Pop");
        return 0;
    }
}

class DynStack extends Stack implements IntStack {
    private int[] stck;
    private int tos;

    DynStack(int size) {
        stck = new int[size];
        tos = -1;
    }

    public void push(int item) {
        if (tos == stck.length - 1) {
            int temp[] = new int[stck.length * 2];
            for (int i = 0; i < stck.length; i++) temp[i] = stck[i];
            stck = temp;
            stck[++tos] = item;
        } else
            stck[++tos] = item;
    }

    public int pop() {
        if (tos < 0) {
            System.out.println("Стек не загружен.");
            return 0;
        } else
            return stck[tos--];
    }
}

class FixedStack extends Stack implements IntStack {
    private int[] stck;
    private int tos;

    FixedStack(int size) {
        stck = new int[size];
        tos = -1;
    }

    public void push(int item) {
        if (tos == stck.length - 1) System.out.println("Стек заполнен.");
        else stck[++tos] = item;
    }

    public int pop() {
        if (tos < 0) {
            System.out.println("Стек не загружен.");
            return 0;
        } else
            return stck[tos--];
    }
}

class Test {
    public static void main(String[] args) {
        IntStack mystack;
        DynStack ds = new DynStack(5);
        FixedStack fs = new FixedStack(8);
        mystack = ds;
        for (int i = 0; i < 12; i++) mystack.push(i);
        mystack = fs;
        for (int i = 0; i < 8; i++) mystack.push(i);
        mystack = ds;
        System.out.println("Значения в динамическом стеке:");
        for (int i = 0; i < 12; i++) System.out.println(mystack.pop());
        mystack = fs;
        System.out.println("Значения в фиксированном стеке:");
        for (int i = 0; i < 8; i++) System.out.println(mystack.pop());
    }
}
