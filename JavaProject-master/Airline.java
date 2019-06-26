import java.util.ArrayList;
import java.util.List;

public class Airline extends AirlineAbstract {
    private static List<Airline> __airplaneList;

    private String flightNumber;

    public Airline(String number) {
        if (Airline.__airplaneList == null) {
            Airline.__airplaneList = new ArrayList<Airline>();
        }
        flightNumber = number;
    }

    private static void addToAirlinesList(Airline...airlines) {
        for (Airline airline : airlines) {
            if (!(Airline.__airplaneList.contains(airline))) {
                Airline.__airplaneList.add(airline);
            }
        }
    }

    private static void removeFromAirlinesList(String name) {
        int index = 0;
        for (Airline airline : Airline.__airplaneList) {
            if (airline.getAirplaneName().equals(name)) {
                Airline.__airplaneList.remove(index);
                return;
            }
            index++;
        }
    }

    public static void printAirlinesList() {
        for (Airline airline : Airline.__airplaneList) {
            System.out.print(airline.getAirplaneName()+" ");
        }
        System.out.println();
    }

    public String getAirplaneName() {
        return flightNumber;
    }

    public static void main(String[] args) {
       Airline alaska1 = new Alaska("1000");
       Airline alaska2 = new Alaska("1001");
       Airline alaska3 = new Alaska("1002");
       Airline american1 = new American("1003");
       Airline united1 = new United("1004");
       

       Airline.addToAirlinesList(alaska1, alaska2, alaska3, american1, united1);
       Airline.printAirlinesList();

       Airline.removeFromAirlinesList("1003");
       Airline.printAirlinesList();

    }
}


class Alaska extends Airline {
    private static List<Airplane> __airplanes;

    public Alaska(String flightNumber) {
        super(flightNumber);
        if (__airplanes == null) {
            __airplanes = new ArrayList<Airplane>();
        }
    }
    public void addAirplanes(Airplane...airplaneList) {
        for (Airplane airplane : airplaneList) {
            if (!(Alaska.__airplanes.contains(airplane))) {
                Alaska.__airplanes.add(airplane);
            }
        }
    }
}

class American extends Airline {
    private static List<Airplane> __airplanes;

    public American(String flightNumber) {
        super(flightNumber);
        if (__airplanes == null) {
            __airplanes = new ArrayList<Airplane>();
        }
    }
    public void addAirplanes(Airplane...airplaneList) {
        for (Airplane airplane : airplaneList) {
            if (!(American.__airplanes.contains(airplane))) {
                American.__airplanes.add(airplane);
            }
        }
    }
}

class United extends Airline {
    private static List<Airplane> __airplanes;

    public United(String flightNumber) {
        super(flightNumber);
        if (__airplanes == null) {
            __airplanes = new ArrayList<Airplane>();
        }
    }

    public void addAirplanes(Airplane...airplaneList) {
        for (Airplane airplane : airplaneList) {
            if (!(United.__airplanes.contains(airplane))) {
                United.__airplanes.add(airplane);
            }
        }
    }
}

class Airplane {
    private String airplaneName;
    private List<String> flightTimes;

    public Airplane(String name) {
        airplaneName = name;
        flightTimes = new ArrayList<String>();

    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void addFlightTimes(String...times) {
        for (String time: times) {
            if (!(flightTimes.contains(time))) {
                flightTimes.add(time);
            }
        }
    }



}
