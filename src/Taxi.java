public class Taxi extends Transit{
    String goal;                    //목적지
    int distance;                   //이동거리
    int max_cus = 4;                //최대 승객
    int basicDistance = 1;          //기본 거리
    int basicFare = 3000;           //기본 요금
    int perDistance = 1000;         //거리당 요긍
    static String status = "일반";   //상태
    int speed = 0;                  //속도
    int total = 0;                  //누적금액
    int fare;                       //지불할 금액


    public Taxi() {
        this.num = (int)(Math.random()*100+1);
        System.out.println("택시 번호 : "+num);
        Taxi.drive();
    }

    static boolean drive() {
        if(!oilLeft()) {
            status = "운행 불가";
            System.out.println("주유 필요");
            return false;
        }
        return true;

    }
    void board(int cus, String goal, int distance) {
        if(status == "일반") {
            if (cus > 4)
                System.out.println("최대 승객 수 초과");
            else{
                if(distance == 1)
                    fare = basicFare + (perDistance*distance);
                else
                    fare = basicFare + (perDistance*(distance-1));
                status = "운행중";
                System.out.println("탑승 승객 수 = "+cus);
                System.out.println("잔여 승객 수 = "+ (max_cus-cus));
                System.out.println("기본 요금 확인 = "+basicFare);
                System.out.println("목적지 = "+goal);
                System.out.println("목적지까지 거리 = "+ distance+"km");
                System.out.println("지불할 요금 = "+fare);
                total += fare;
            }
        }
    }
    int refuel(int oil) {
        currentOil += oil;
        if(!oilLeft()) {
            status = "운행 불가";
        }
        return currentOil;
    }
    int pay(){
        status = "일반";
        max_cus = 4;
        System.out.println("누적 요금 = "+ total);
        if(!oilLeft())
            System.out.println("주유 필요");
        fare = 0;
        return total;
    }

    void customer(int cus) {
        if(cus > 4)
            System.out.println ("최대 승객 수 초과");
    }

    int change_speed(int acceleration) {
        if(oilLeft()) {
            this.acceleration = acceleration;
            current_speed += acceleration;
            System.out.println("현재 속도는 "+ current_speed+"입니다.");
        }
        System.out.println("주유량을 확인해주세요."+currentOil);
        return currentOil;
    }
}
