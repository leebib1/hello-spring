package hello.core.singletone;

public class StatefulService { //ctrl+shift+T로 테스트 만들 수 있음

//    private int price; //상태 유지 필드
//    -->문제 발생 시점을 만들지 않기 위해서 공유되는 필드가 없게 만든다.

    public int order(String name, int price) {
        System.out.println("name : " + name + ", price : " + price);
//        this.price=price; //문제 발생 시점 >지역 변수로 사용하면서 문제가 해결됨
        return price;
    }

    /*public int getPrice() {
        return price;
    }*/
}
