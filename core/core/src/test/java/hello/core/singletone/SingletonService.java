package hello.core.singletone;

public class SingletonService {

    private static final SingletonService instance=new SingletonService(); //static 영역에 하나의 인스턴스만 만들 수 있게 한다.

    public static SingletonService getInstance() {
        //SingletonService의 인스턴스가 필요하면 getInstance() 메소드를 통해서만 조회할 수 있다. ->항상 같은 인스턴스를 반환
        return instance;
    }

    private SingletonService() {
        //private 생성자를 만들어서 외부에서 SingletonService를 생성할 수 없게 한다.
        
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
