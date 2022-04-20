package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(
            () -> {
                runException("pobi,javaji");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @ParameterizedTest
    @ValueSource (strings = { "31245", "123412312313 21356", "12345 "})
    void validateNamingRule(String name){
        assertThat( name.length() ).isGreaterThanOrEqualTo( 1 );

        assertThatThrownBy(() -> {
            if(name.length() > 5){
                throw new IllegalArgumentException("[ERROR] 이름은 5글자까지만 가능합니다.");
            }
        }).isInstanceOf( IllegalArgumentException.class ).hasMessageContaining( "[ERROR]");

        assertThatThrownBy(() -> {
            if(name.indexOf( " " ) > -1){
                throw new IllegalArgumentException("[ERROR] 이름은 5글자까지만 가능합니다.");
            }
        }).isInstanceOf( IllegalArgumentException.class ).hasMessageContaining( "[ERROR]");
//
//
//        assertThatExceptionOfType( IllegalArgumentException.class ).isThrownBy( () ->{
//
//        } ).withMessageMatching( "[ERROR] 이름은 5글자까지만 가능합니다." );

//        if(name.indexOf( " " ) > -1){
//            throw new IllegalArgumentException("[ERROR] 이름은 공백이 포함될 수 없습니다.");
//        }
    }
}
