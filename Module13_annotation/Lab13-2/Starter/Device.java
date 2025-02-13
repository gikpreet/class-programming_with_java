import java.lang.annotation.Annotation;

public class Device {
    Device() {
    }

    private DeviceInformation getDeviceInformation() {
        Annotation[] annotations = this.getClass().getAnnotations();
        for(Annotation annotation : annotations) {
            if (annotation instanceof DeviceInformation) {
                return  (DeviceInformation) annotation;
            }
        }
        throw new UnsupportedOperationException("No Device Information");
    }

    public String getType() {
        try {
            return this.getDeviceInformation().type();
        }
        catch(Exception e) {
            return "unknown";
        }
    }

    public String getModel() {
        try {
            return  this.getDeviceInformation().model();
        }
        catch(Exception e) {
            return "unknown";
        }
    }
}

