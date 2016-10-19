package _1._1._1;

public class ConcurrencyTest {

	private static final long count = 10000000000l;

	public static void main(String[] args) throws InterruptedException {
		concurrency();
		serial();
	}

	private static void concurrency() throws InterruptedException {
		long start = System.currentTimeMillis();

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {

				int a = 0;
				for (long i = 0; i < count; i++) {
					a += 5;
				}
			}
		});

		t.start();

		int b = 0;

		for (long i = 0; i < count; i++) {
			b--;
		}

		long time = System.currentTimeMillis() - start;

		t.join();

		System.out.println("concurrency : " + time + " ms, b = " + b);

	}

	private static void serial() {
		long start = System.currentTimeMillis();

		int a = 0;
		for (long i = 0; i < count; i++) {
			a += 5;
		}

		int b = 0;
		for (long i = 0; i < count; i++) {
			b--;
		}

		long time = System.currentTimeMillis() - start;

		System.out.println("serial : " + time + " ms, b = " + b);

	}
}
