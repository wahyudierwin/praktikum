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

	private static final int NUM_OF_WRITERS = 3;
	private static final int NUM_OF_READERS = 2;
}

class Reader extends Thread {
	public Reader(int r, Database db) {
		readerNum = r;
		server = db;
	}

	public void run() {
		int c;
		while (true) {
			server.tunggu();
			System.out.println("Reader " + readerNum + " wants to read.");
			c = server.mulaiBaca();
			System.out.println("Reader " + readerNum + " is reading. Reader count = " + c);
			server.tunggu();
			System.out.println("Reader " + readerNum + " is done reading.");
			c = server.selesaiBaca();
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
		int c;
		while (true) {
			System.out.println("Writer " + writerNum + " is sleeping.");
			server.tunggu();
			System.out.println("Writer " + writerNum + " wants to write.");
			server.mulaiTulis();
			System.out.println("Writer " + writerNum + " is writing.");
			server.tunggu();
			System.out.println("Writer " + writerNum + " is done writing.");
			server.selesaiTulis();
		}
	}

	private Database server;
	private int writerNum;
}

final class Semaphore {
	public Semaphore() {
		value = 0;
	}

	public Semaphore(int v) {
		value = v;
	}

	public synchronized void tutup() {
		while (value <= 0) {
			try {
				wait();
			}
			catch (InterruptedException e) {}
		}
		value--;
	}

	public synchronized void buka() {
		value++;
		notify();
	}

	private int value;
}

class Database {
	public Database() {
		banyakReader = 0;
		mutex = new Semaphore(1);
		db = new Semaphore(1);
	}

	public static void tunggu() {
		int sleepTime = (int) (NAP_TIME * Math.random());
		try {
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
		System.out.println("reader count = " + banyakReader);
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

	private static final int NAP_TIME = 15;
}







