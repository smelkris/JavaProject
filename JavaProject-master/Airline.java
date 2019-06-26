import java.util.ArrayList;
import java.util.List;

public class Airline extends AirlineAbstract {
    private static List<Airline> airlinesList;

    private String airlineName;

    public Airline(String name) {
        Airline.airlinesList = new ArrayList<Airline>();
        airlineName = name;
    }

    private static void addToAirlinesList(Airline...airlines) {
        for (Airline airline : airlines) {
            if (!(Airline.airlinesList.contains(airline))) {
                Airline.airlinesList.add(airline);
            }
        }
    }

    private static void removeFromAirlinesList(String name) {
        int index = 0;
        for (Airline airline : Airline.airlinesList) {
            if (airline.getAirlineName().equals(name)) {
                Airline.airlinesList.remove(index);
                return;
            }
            index++;
        }
    }

    public String getAirlineName() {
        return airlineName;
    }

    public static void main(String[] args) {
        
    }
}
