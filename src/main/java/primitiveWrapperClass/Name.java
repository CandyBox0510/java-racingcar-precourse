package primitiveWrapperClass;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Name {
    private final String name;

    public Name( final String name ) {
        this.validateNamingRule( name );
        this.name = name;
    }

    @Test
    @ParameterizedTest
    @ValueSource ( strings = { "12345", "123456", "12345 " } )
    private void validateNamingRule( String name ) {
        if ( name.length() <= 0 ) {
            throw new IllegalArgumentException( "[ERROR] 이름은 최소 1글자 이상이여야 합니다." );
        }

        if ( name.length() > 5 ) {
            throw new IllegalArgumentException( "[ERROR] 이름은 5글자까지만 가능합니다." );
        }

        if ( name.indexOf( " " ) > -1 ) {
            throw new IllegalArgumentException( "[ERROR] 이름은 공백이 포함될 수 없습니다." );
        }
    }

    public String showName(){
        return this.name;
    }
}
