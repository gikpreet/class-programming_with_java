public class DeviceExample {
    public static void showDeviceInformation(Device device) {
        System.out.println("Type : " + device.getType());
        System.out.println("Model : " + device.getModel());
    }

    public static void main(String[] args) {
        Device device = new Device();

        DeviceExample.showDeviceInformation(device);
    }
}
