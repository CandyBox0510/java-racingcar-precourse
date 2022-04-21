package racingcar;

import camp.nextstep.edu.missionutils.Console;
import firstClass.Cars;
import org.junit.jupiter.api.Test;
import primitiveWrapperClass.TryCount;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main( String[] args ) {
        initGame();
    }

    public static void initGame(){
        List<Car> carList = new ArrayList<>();
        boolean notYetMakedCars = true;
        while(notYetMakedCars){
            notYetMakedCars = makedCar( carList );
        }
        Cars cars = new Cars( carList );

        TryCount tryCount = null;
        while(tryCount == null){
            tryCount = validCount();
        }

        gameStart( cars, tryCount );
    }

    public static boolean makedCar( List<Car> carList ){
        boolean notYetMakedCars = true;
        try{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String[] carNamesArray = Console.readLine().split( "," );
            setEachCar( carNamesArray, carList );
            notYetMakedCars = false;
        } catch ( IllegalArgumentException | IllegalStateException e) {
            e.printStackTrace();
        } catch ( Exception e){
            e.printStackTrace();
        } finally {
            return notYetMakedCars;
        }
    }

    private static void setEachCar(String[] carNamesArray, List<Car> carList) throws Exception {
        for(int i = 0 ; i < carNamesArray.length; i ++){
            Car car = new Car( carNamesArray[i], "" );
            carList.add( car );
        }
    }
    
    private static TryCount validCount(){
        TryCount tryCount = null;
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            tryCount = new TryCount( Console.readLine() );
        } catch ( IllegalArgumentException | IllegalStateException e) {
            e.printStackTrace();
        } catch ( Exception e){
            e.printStackTrace();
        } finally {
            return tryCount;
        }
    }

    public static void gameStart(Cars cars, TryCount tryCount){
        System.out.println("실행 결과");
        Game game = new Game(cars);
        game.startCarRacing(tryCount.showGameTryCount());
    }
}
