import java.util.ArrayList;
import java.util.List;

public class Airline extends AirlineAbstract {
    private static List<Airline> __airlinesList;

    private String airlineName;

    public Airline(String name) {
        if (Airline.__airlinesList == null) {
            Airline.__airlinesList = new ArrayList<Airline>();
        }
        airlineName = name;
    }

    private static void addToAirlinesList(Airline...airlines) {
        for (Airline airline : airlines) {
            if (!(Airline.__airlinesList.contains(airline))) {
                Airline.__airlinesList.add(airline);
            }
        }
    }

    private static void removeFromAirlinesList(String name) {
        int index = 0;
        for (Airline airline : Airline.__airlinesList) {
            if (airline.getAirlineName().equals(name)) {
                Airline.__airlinesList.remove(index);
                return;
            }
            index++;
        }
    }

    public static void printAirlinesList() {
        for (Airline airline : Airline.__airlinesList) {
            System.out.print(airline.getAirlineName()+" ");
        }
        System.out.println();
    }

    public String getAirlineName() {
        return airlineName;
    }

    public static void main(String[] args) {
       Airline alaska = new Alaska("Alaska");
       Airline american = new American("American");
       Airline united = new United("United");
       

       Airline.addToAirlinesList(alaska, american, united);
       Airline.printAirlinesList();

       Airline.removeFromAirlinesList("American");
       Airline.printAirlinesList();

    }
}


class Alaska extends Airline {
    public Alaska(String name) {
        super(name);
    }
}

class American extends Airline {
    public American(String name) {
        super(name);
    }
}

class United extends Airline {
    public United(String name) {
        super(name);
    }
}
