package domain.service;

public enum ServiceType {

    ALL("*"),
    ONE("1"),
    Two("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10");

    private String serviceTypeId;

    ServiceType(String serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public static ServiceType valueOfServiceType(String serviceTypeId) {
        for(ServiceType s : values()) {
            if(s.serviceTypeId.equals(serviceTypeId)) {
                return s;
            }
        }

        return null;
    }

    public String getServiceTypeId() {
        return serviceTypeId;
    }
}
