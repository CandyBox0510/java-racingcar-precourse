package racingcar;

public class Move {
    private final int move;

    public Move( int move ){
        this.validateMoveRule( move );
        this.move = move;
    }

    private void validateMoveRule(int move){
        if(move < 0){
            throw new IllegalArgumentException("[ERROR] 움직임은 최소 0이상이여야 합니다.");
        }
    }
}
