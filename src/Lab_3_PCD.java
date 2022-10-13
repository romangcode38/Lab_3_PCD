class Counter extends Thread {
    private int from, to, step;
    private int[]tablou;
    public String nume = "Grib";
    public String prenume = "Roman";

    public Counter(int from, int to, int step, int[] tablou) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.tablou = tablou;
    }
    Thread cnt1 = new Thread() {
        public void run() {
            int s1 = 0, s2 = 0, s = 0, sum = 0;
            int count = 0;
            int i = from;

            for (i = 0; i < tablou.length; i++) {
                if (tablou[i] % 2 != 0) {
                    s1 = tablou[i];
                    System.out.print(getName() + " Primul element impar: " + s1 + " pozitia: " + i + " \n");
                    for (int j = i += step; j < tablou.length; j++) {
                        if (tablou[j] % 2 != 0) {
                            s2 = tablou[j];
                            count++;
                            System.out.print(getName() + " Al doilea elem impar: " + s2 + " pozitia: " + j + "\n");
                            i = j;
                            s = s1 * s2;

                            System.out.print(getName() + " Produsul: " + s + "\n");
                            if (count == 1) {
                                sum = s;
                            }
                            if (count == 2) {
                                sum = s + sum;
                                System.out.println(getName() + "--Suma produselor este: " + sum);
                                count = 0;

                            }

                            System.out.print("\n");
                            break;
                        }
                    }
                }
            }
            int c = i - (tablou.length-1);
            if (i-c == tablou.length-1) {
                Thread.currentThread().suspend();
                System.out.print("\n"+getName() + ":");
                for (int z = 0; z < prenume.length(); z++) {
                    try {
                        Thread.sleep(100);
                        System.out.print(prenume.charAt(z));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    };
    Thread cnt2 = new Thread() {
        public void run () {
            int s1 = 0, s2 = 0, s = 0, sum = 0;
            int count = 0;
            int i = from;
            try {
                Thread.currentThread().join(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (i = tablou.length-1; i >= 0; i--) {
                if (tablou[i] % 2 != 0) {
                    s1 = tablou[i];
                    System.out.print(getName() + " Primul element impar: " + s1 + " pozitia: " + i + " \n");
                    for (int j = i - step; j >= 0; j--) {
                        if (tablou[j] % 2 != 0) {
                            s2 = tablou[j];
                            count++;
                            System.out.print(getName() + " Al doilea elem impar: " + s2 + " pozitia: " + j + "\n");
                            i = j;
                            s = s1 * s2;
                            System.out.print(getName() + " Produsul: " + s + "\n");

                            if (count == 1) {
                                sum = s;
                            }
                            if (count == 2) {
                                sum = s + sum;
                                System.out.println(getName() + "--Suma produselor este: " + sum);
                                count = 0;
                            }
                            System.out.print("\n");
                            break;
                        }
                    }
                }
            }
            try {
                Thread.currentThread().join(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int c = i - (tablou.length-1);
            if (i - c == tablou.length-1) {
                System.out.print("\n"+getName() + ":");
                for (int z = 0; z < nume.length(); z++) {
                    try {
                        Thread.sleep(100);
                        System.out.print(nume.charAt(z));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }
    };


}

class Counter1 extends Thread {
    public int from, to, step;

    public Counter1(int from, int to, int step) {
        this.from = from;
        this.to = to;
        this.step = step;
    }

    private String disc = "PCD";

    public void run() {
        try {
            Thread.currentThread().join(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("\n"+getName() + ":");
        for (int i = from; i < to; i++) {
            System.out.print(i + ", ");
        }
        System.out.print("\n");

        Thread.currentThread().suspend();
            System.out.print("\n"+getName() + ":");
            for (int z = 0; z < disc.length(); z++) {
                try {
                    Thread.sleep(100);
                    System.out.print(disc.charAt(z));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        System.out.print("\n");
    }

}

class Counter2 extends Thread {
    public int from, to, step;

    public Counter2(int from, int to, int step) {
        this.from = from;
        this.to = to;
        this.step = step;
    }

    private String grupa = "CR-201";

    public void run() {
        try {
            Thread.currentThread().join(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("\n"+getName() + ":");
        for (int i = from; i >= to - 1; i--) {
            System.out.print(i + ", ");
        }
        System.out.print("\n");

            Thread.currentThread().suspend();
            System.out.print("\n"+getName() + ":");
            for (int z = 0; z < grupa.length(); z++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print(grupa.charAt(z));
            }
    }
}
public class Lab_3_PCD {

    public static void main(String[] args) throws InterruptedException {
        int k;
        int[] tablou = new int[106];
        for (k = 0; k < tablou.length; k++) {
            tablou[k] = (int) (Math.random() * 100);
            if (k == 20) {
                System.out.println("");
            }
            if (k == 40) {
                System.out.println("");
            }
            if (k == 60) {
                System.out.println("");
            }
            if (k == 80) {
                System.out.println("");
            }
            if (k == 90) {
                System.out.println("");
            }
            System.out.print(tablou[k] + ":" + k + ", ");
        }
        System.out.println(" \n");
        Thread tred1 = new Counter(0, 101, 1, tablou).cnt1;
        Thread tred2 = new Counter(106, 6, 1, tablou).cnt2;
        Thread tred3 = new Counter1(126, 927, 1);
        Thread tred4 = new Counter2(889, 231, 1);

        tred1.setName("Th1");
        tred2.setName("Th2");
        tred3.setName("Th3");
        tred4.setName("Th4");

        tred1.start();
        tred2.start();
        tred3.start();
        tred4.start();
        try {
            Thread.currentThread().join(1100);
            tred2.stop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(!tred2.isAlive()) {
            tred4.resume();
            try {
                Thread.sleep(800);
                tred4.stop();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(!tred4.isAlive()){
            tred1.resume();
            try {
                Thread.sleep(800);
                tred1.stop();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(!tred1.isAlive()){
            tred3.resume();
            try {
                Thread.sleep(800);
                tred3.stop();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

