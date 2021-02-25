package domain.service;

public class Service {

    private ServiceType serviceType;
    private ServiceVariation serviceVariation;

    public Service(String id) {
        String arr[] = id.split("\\.");

        if(arr.length > 0) {
            serviceType = ServiceType.valueOfServiceType(arr[0]);
        }

        if(arr.length > 1) {
            serviceVariation = ServiceVariation.valueOfServiceVariation(arr[1]);
        }
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public ServiceVariation getServiceVariation() {
        return serviceVariation;
    }
}
