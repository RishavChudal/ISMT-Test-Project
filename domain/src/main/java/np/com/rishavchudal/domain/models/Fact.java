package np.com.rishavchudal.domain.models;

/**
 * Created by Rishav Chudal on 21/03/2022.
 */
public class Fact {
    private final String title;
    private final String description;
    private final String imagePath;
    private final String webLink;
    private final FactLocation factLocation;

    public Fact(String title,
                String description,
                String imagePath,
                String webLink,
                FactLocation factLocation) {
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
        this.webLink = webLink;
        this.factLocation = factLocation;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getWebLink() {
        return webLink;
    }

    public FactLocation getFactLocation() {
        return factLocation;
    }
}
