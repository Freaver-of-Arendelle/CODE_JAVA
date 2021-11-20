package model.bean;

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

    private Coffee() {

    }

    public static final class Builder {
        private String code;
        private String description;
        private float price;
        private int number;
        private String originCountry;
        private String roast;
        private String flavor;
        private String aroma;
        private String acidity;
        private String body;

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder price(float price) {
            this.price = price;
            return this;
        }

        public Builder number(int number) {
            this.number = number;
            return this;
        }

        public Builder originCountry(String originCountry) {
            this.originCountry = originCountry;
            return this;
        }

        public Builder roast(String roast) {
            this.roast = roast;
            return this;
        }

        public Builder flavor(String flavor) {
            this.flavor = flavor;
            return this;
        }

        public Builder aroma(String aroma) {
            this.aroma = aroma;
            return this;
        }

        public Builder acidity(String acidity) {
            this.acidity = acidity;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder() {

        }

        public Coffee build() {
            return new Coffee(this);
        }
    }

    private Coffee(Builder builder) {
        this.code = builder.code;
        this.description = builder.code;
        this.price = builder.price;
        this.number = builder.number;
        this.originCountry = builder.originCountry;
        this.roast = builder.roast;
        this.flavor = builder.flavor;
        this.aroma = builder.aroma;
        this.acidity = builder.acidity;
        this.body = builder.body;
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
        return "Coffee{" +
                "originCountry='" + originCountry + '\'' +
                ", roast='" + roast + '\'' +
                ", flavor='" + flavor + '\'' +
                ", aroma='" + aroma + '\'' +
                ", acidity='" + acidity + '\'' +
                ", body='" + body + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
