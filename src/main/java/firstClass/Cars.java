package firstClass;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List< Car > cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    };

    public void randomMove( int tryCount ){
        for(Car car : cars){
            car.goAhead();
            System.out.println(car.myTotalDistance());
        }
    }

    public void checkWinner(int tryCount){
        String totalWin = "최종우승 : ";
        List<String> winner = new ArrayList<>();
        for(Car car : cars){
            this.setWinner( car, winner, car.maxMoved(), tryCount);
        }
        System.out.println("최종 우승자: " + String.join( ", ", winner ));
    }

    private void setWinner(Car car, List<String> winner, int maxMoved, int tryCount){
        if(maxMoved == tryCount){
            winner.add( car.myName() );
        }
    }
}
