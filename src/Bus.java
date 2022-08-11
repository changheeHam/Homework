    public class Bus extends Transit {
        int max_cus = 30;           //최대 승객
        int current_cus = 0;        //현재 승객
        int fare = 1000;            //버스 요금

        public Bus() {
            this.num = (int)(Math.random()*100+1);
            System.out.println("버스 번호 : "+num);
        }
        boolean busStatus(boolean change) {
            if(change == true)
                status = "운행중";
            else{
                status = "차고지행";
                current_cus = 0;
                max_cus = 30;
            }
            return change;
        }

            void currentBus () {
                System.out.println("상태 = " + status);
                System.out.println("주유량 = " + currentOil);
                if (!oilLeft())
                    System.out.println("주유 필요");
            }

        void drive(){
            if (oilLeft()) {
                System.out.println("남은 기름 : "+ currentOil );
                System.out.println("운행 가능");
            }
            if(!oilLeft()){
                System.out.println("주유가 필요합니다");
                System.out.println("운행 불가 = 차고지행");
                status = "차고지행";
            }
        }


        int refuel(int oil) {
            currentOil += oil;
            if(!oilLeft()) {
                status = "차고지행";
            }
            return currentOil;
        }

        boolean available() {
            return max_cus >= current_cus;
        }

        int board(int cus) {
            if(cus >= (max_cus-current_cus))
                System.out.println("최대 승객 수 초과");
            else{
                if(available()) {
                    current_cus += cus;
                    System.out.println("탑승 승객 수 = "+cus+"명");
                    System.out.println("잔여 승객 수 = "+(max_cus-current_cus)+"명");
                    System.out.println("요금 확인 = "+(fare*cus));
                }
                if(!available()) {
                    System.out.println("최대 승객 수 초과");
                }
            }
            return current_cus;
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



