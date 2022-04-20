package primitiveWrapperClass;

public class Distance {
    private String distance;

    public Distance( String distance ) {
        this.validateDistanceRule( distance );
        this.distance = distance;
    }

    private void validateDistanceRule( String distance ) {

    }

    public void carMoved(){
        distance += "-";
    }

    public String totalDistance(){
        return this.distance;
    }
}
