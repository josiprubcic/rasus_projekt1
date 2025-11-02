import io.grpc.ManagedChannel;
import java.util.Random;
import java.util.logging.Logger;


/**
 * The type Simple unary rpc client.
 */
public class sensorClient {
    private static final Logger logger = Logger.getLogger(sensorClient.class.getName());
    private final ManagedChannel channel;

    double sensorPositionLatitude = 0;
    double sensorPositionLongitude = 0;

    double minLatitude = 45.75;
    double maxLatitude = 48.85;

    double minLongitude = 15.87;
    double maxLongitude = 16;

    public sensorClient(ManagedChannel channel) {
        this.channel = channel;
        double random_lat = new Random().nextDouble();
       double random_long = new Random().nextDouble();

       this.sensorPositionLatitude = minLatitude + (random_lat * (maxLatitude - minLatitude));
       this.sensorPositionLongitude = minLongitude + (random_long * (maxLongitude - minLongitude));
    }

    public void pozicijaSenzora() {
        System.out.println("Pozicija Senzora: " + sensorPositionLatitude + " " + sensorPositionLongitude);
    }

    public void findNearestNeighbour() {
        //implementirati gRPC
        logger.info("Looking for nearest neighbour...");
    }

    public double[] calibrateReading(double[] ownReading, double[] neighbourReading) {
        if(ownReading == null || neighbourReading == null) { return ownReading;}

        double[] calibratedData = new double[ownReading.length];

        for(int i = 0; i < ownReading.length; i++) {
            calibratedData[i] = (ownReading[i] + neighbourReading[i]) / 2.0;
        }

        return calibratedData;
    }


    public ManagedChannel getChannel() {
        return channel;
    }

    public double getSensorPositionLatitude() {
        return sensorPositionLatitude;
    }

    public void setSensorPositionLatitude(double sensorPositionLatitude) {
        this.sensorPositionLatitude = sensorPositionLatitude;
    }

    public double getSensorPositionLongitude() {
        return sensorPositionLongitude;
    }

    public void setSensorPositionLongitude(double sensorPositionLongitude) {
        this.sensorPositionLongitude = sensorPositionLongitude;
    }

    public double getMinLatitude() {
        return minLatitude;
    }

    public void setMinLatitude(double minLatitude) {
        this.minLatitude = minLatitude;
    }

    public double getMaxLatitude() {
        return maxLatitude;
    }

    public void setMaxLatitude(double maxLatitude) {
        this.maxLatitude = maxLatitude;
    }

    public double getMinLongitude() {
        return minLongitude;
    }

    public void setMinLongitude(double minLongitude) {
        this.minLongitude = minLongitude;
    }

    public double getMaxLongitude() {
        return maxLongitude;
    }

    public void setMaxLongitude(double maxLongitude) {
        this.maxLongitude = maxLongitude;
    }
}
