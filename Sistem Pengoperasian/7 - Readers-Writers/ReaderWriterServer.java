public class ReaderWriterServer {
    public static void main(String args[]) {
        Database server = new Database();

        Reader[] readerArray = new Reader[NUM_OF_READERS];
        Writer[] writerArray = new Writer[NUM_OF_WRITERS];

        for (int i=0 ; i<NUM_OF_READERS ; i++) {
            readerArray[i] = new Reader(i, server);
            readerArray[i].start();
        }

        for (int i=0 ; i<NUM_OF_WRITERS ; i++) {
            writerArray[i] = new Writer(i, server);
            writerArray[i].start();
        }
    }

    private static final int NUM_OF_WRITERS = 1;
    private static final int NUM_OF_READERS = 1;
}

class Reader extends Thread {
    public Reader(int r, Database db) {
        readerNum = r;
        server = db;
    }

    public void run() {
        int c;
        while (true) {
            Database.tunggu();
            System.out.println("Reader " + readerNum + " wants to read.");
            c = server.mulaiBaca();
            System.out.println("Reader " + readerNum + " is reading. Reader count = " + c);
            Database.tunggu();
            c = server.selesaiBaca();
            System.out.println("Reader " + readerNum + " is done reading. Reader count = " + c);
        }
    }

    private Database server;
    private int readerNum;
}

class Writer extends Thread {
    public Writer(int w, Database db) {
        writerNum = w;
        server = db;
    }

    public void run() {
        while (true) {
            System.out.println("Writer " + writerNum + " is sleeping.");
            Database.tunggu();
            System.out.println("Writer " + writerNum + " wants to write.");
            server.mulaiTulis();
            System.out.println("Writer " + writerNum + " is writing.");
            Database.tunggu();
            System.out.println("Writer " + writerNum + " is done writing.");
            server.selesaiTulis();
        }
    }

    private Database server;
    private int writerNum;
}

final class Semaphore {
    public Semaphore() {
        name = "";
        value = 0;
    }

    public Semaphore(String s, int v) {
        name = s;
        value = v;
    }

    public synchronized void tutup() {
        System.out.println(name + " awal : " + value);
        while (value <= 0) {
            try {
                wait();
            }
            catch (InterruptedException e) {}
        }
        value--;
        System.out.println(name + " akhir : " + value);
    }

    public synchronized void buka() {
        System.out.println(name + " awal : " + value);
        value++;
        System.out.println(name + " akhir: " + value);
        notify();
    }

    private int value;
    private String name;
}

class Database {
    public Database() {
        banyakReader = 0;
        mutex = new Semaphore("mutex", 1);
        db = new Semaphore("db", 1);
    }

    public static void tunggu() {
        int sleepTime = (int) (NAP_TIME * Math.random());
        try {
            System.out.println("tunggu.....");
            Thread.sleep(sleepTime * 1000);
        }
        catch (InterruptedException e) {}
    }

    public int mulaiBaca() {
        mutex.tutup();
        banyakReader++;

        if (banyakReader == 1) {
            db.tutup();
        }

        mutex.buka();
        return banyakReader;
    }

    public int selesaiBaca() {
        mutex.tutup();
        banyakReader--;
        if (banyakReader == 0) {
            db.buka();
            mutex.buka();
        }
        System.out.println("db reader count = " + banyakReader);
        return banyakReader;
    }

    public void mulaiTulis() {
        db.tutup();
    }

    public void selesaiTulis() {
        db.buka();
    }

    private int banyakReader;
    Semaphore mutex;
    Semaphore db;

    private static final int NAP_TIME = 5;
}







