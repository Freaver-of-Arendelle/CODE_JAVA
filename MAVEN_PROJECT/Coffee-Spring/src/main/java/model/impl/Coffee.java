package model.impl;

import model.Product;

/**
 * @author Freaver
 */
public class Coffee extends Product {
    private String originCountry;
    private String roast;
    private String flavor;
    private String aroma;
    private String acidity;
    private String body;

    public Coffee(String code, String description, float price, int number, String originCountry, String roast, String flavor, String aroma, String acidity, String body) {
        super(code, description, price, number);
        this.originCountry = originCountry;
        this.roast = roast;
        this.flavor = flavor;
        this.aroma = aroma;
        this.acidity = acidity;
        this.body = body;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getRoast() {
        return roast;
    }

    public void setRoast(String roast) {
        this.roast = roast;
    }

    public String getAroma() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getAcidity() {
        return acidity;
    }

    public void setAcidity(String acidity) {
        this.acidity = acidity;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "coffee{" +
                super.toString();
    }

    public String allToString() {
        return "coffee{" +
                super.toString() +
                "originCountry='" + originCountry + '\'' +
                ", roast='" + roast + '\'' +
                ", flavor='" + flavor + '\'' +
                ", aroma='" + aroma + '\'' +
                ", acidity='" + acidity + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
