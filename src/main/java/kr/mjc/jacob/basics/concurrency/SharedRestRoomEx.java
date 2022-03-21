package kr.mjc.jacob.basics.concurrency;

/**
 * 한개의 화장실을 여러개의 스레드가 사용하는 예
 *
 * @author Jacob
 */
public class SharedRestRoomEx {
	public static void main(String[] args) {

		final RestRoom restRoom = new RestRoom();

		new Thread(() -> restRoom.use(1000, 1000)).start();
		new Thread(() -> restRoom.use(1000, 2000)).start();
		new Thread(() -> restRoom.use(2000, 1000)).start();
	}
}
