package racingcar;

import camp.nextstep.edu.missionutils.Console;
import firstClass.Cars;
import primitiveWrapperClass.TryCount;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main( String[] args ) {
        initGame();
    }

    public static void initGame(){
        List<Car> carList = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNamesArray = Console.readLine().split( "," );
        Cars cars = new Cars(makeCars( carNamesArray, carList ));
        System.out.println("시도할 회수는 몇회인가요?");
        TryCount tryCount = new TryCount( Console.readLine() );
        gameStart( cars, tryCount );
    }

    public static List<Car> makeCars( String[] carNamesArray, List<Car> carList ){
        for(int i = 0 ; i < carNamesArray.length; i ++){
            Car car = new Car( carNamesArray[i], 0, "" );
            carList.add( car );
        }
        return carList;
    }

    public static void gameStart(Cars cars, TryCount tryCount){
        System.out.println("실행 결과");
        Game game = new Game(cars);
        for(int i = 0; i < tryCount.showGameTryCount(); i ++){
            game.startCarRacing(tryCount.showGameTryCount());
            System.out.println("");
        }
    }
}
