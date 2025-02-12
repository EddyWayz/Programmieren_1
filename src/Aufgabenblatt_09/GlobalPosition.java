package Aufgabenblatt_09;

/**
 * @author Eduard Wayz (193123)
 * @version 1.0
 *
 * The record class GlobalPosition represents a geographical position defined by latitude and longitude.
 * Latitude values range from -90 to 90 degrees, and longitude values range from -180 to 180 degrees.
 */

public record GlobalPosition(double latitude, double longitude) {
    /**
     * Constructs a GlobalPosition record.
     * If the provided latitude or longitude values are out of valid ranges, both are set to 0.0.
     *
     * @param latitude  The latitude of the position (-90.0 to 90.0).
     * @param longitude The longitude of the position (-180.0 to 180.0).
     */
    public GlobalPosition {
        if(latitude < -90.0 || latitude > 90.0 || longitude < -180.0 || longitude > 180) {
            latitude = 0.0;
            longitude = 0.0;
        }
    }
    /**
     * Determines if this position is north of another position.
     *
     * @param other The {@code GlobalPosition} to compare with.
     * @return true if this position's latitude is greater than the other position's latitude; false otherwise.
     */
    public boolean isNorthOf(GlobalPosition other) {
        return latitude > other.latitude;
    }

    /**
     * Determines if this position is east of another position.
     * If one latitude value is -90.0 or 90.0 no one is east. Or if the one longitude value is 180.0 and the other is -180.0.
     *
     * @param other The {@code GlobalPosition} to compare with.
     * @return true, if the position's longitude ist greater than the other position's longitude; fasle otherwise.
     */
    public boolean isEastOf(GlobalPosition other){
        if((latitude == -90.0) || (other.latitude == -90.0) || (latitude == 90.0) || (other.latitude == 90.0)){
            return false; // problem: that means that other (p2) is east of p1. That ist false in this case.
        }

        if((longitude == 180.0) && (other.longitude == -180.0)){
            return false; // problem: that means that other (p2) is east of p1. That ist false in this case.
        }

       return longitude > other.longitude;
    }

    /**
     * Compares this position with another position for equality.
     * Two positions are considered equal if neither is north of or east of the other.
     *
     * @param other   The object to compare with.
     * @return true if the other object is a {@code GlobalPosition} with the same latitude and longitude; false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if(other instanceof GlobalPosition){
            GlobalPosition otherGlobalPosition = (GlobalPosition) other;
            if(!this.isNorthOf(otherGlobalPosition) && !otherGlobalPosition.isNorthOf(this)){
                return true;
            }
            if(!this.isEastOf(otherGlobalPosition) && !otherGlobalPosition.isEastOf(this)){
                return true;
            }
            return false;
        }
        return false;
    }
}
