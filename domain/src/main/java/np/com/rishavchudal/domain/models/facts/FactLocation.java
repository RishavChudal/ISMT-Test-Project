package np.com.rishavchudal.domain.models.facts;

/**
 * Created by Rishav Chudal on 21/03/2022.
 */
public class FactLocation {
    private final String latitude;
    private final String longitude;
    private final String address;

    public FactLocation(String latitude, String longitude, String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }
}
