package kr.mjc.jacob.spring.day1.class04;

public class TVUserWithoutSpring {
  public static void main(String[] args) {

    Speaker sonySpeaker = new SonySpeaker();
    Speaker appleSpeaker = new AppleSpeaker();

    // 컨스트럭터를 사용한 의존성 주입
    SamsungTV samsungTV = new SamsungTV(sonySpeaker);
    samsungTV.volumeUp();
    samsungTV.volumeDown();

    // 세터를 사용한 의존성 주입
    LgTV lgTV = new LgTV();
    lgTV.setSpeaker(appleSpeaker);
    lgTV.volumeUp();
    lgTV.volumeDown();
  }
}
