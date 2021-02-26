package domain.service;

public enum ServiceVariation {

    ONE("1"),
    TWO("2"),
    THREE("3");

    private String variationId;

    ServiceVariation(String variationId) {
        this.variationId = variationId;
    }

    public static ServiceVariation valueOfServiceVariation(String variationId) {
        for(ServiceVariation serviceVariation : values()) {
            if(serviceVariation.variationId.equals(variationId)) {
                return serviceVariation;
            }
        }

        return null;
    }

    public String getVariationId() {
        return variationId;
    }
}
