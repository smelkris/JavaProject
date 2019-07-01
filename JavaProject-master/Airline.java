import java.util.ArrayList;
import java.util.List;

public class Airline extends AirlineAbstract {
    private static List<Airline> __flightList;
    private static List<Airplane> __airplanes;

    private String flightNumber;
    private String flightTime;
    private Airplane airplane;
    private boolean matchedStatus;

    public Airline(String number, String time) {
        flightNumber = number;
        flightTime = time;
        matchedStatus = false;
    }

    private static void addToFlightList(Airline...airlines) {
        if (Airline.__flightList == null) {
            Airline.__flightList = new ArrayList<Airline>();
        }
        for (Airline airline : airlines) {
            if (!(Airline.__flightList.contains(airline))) {
                Airline.__flightList.add(airline);
            }
        }
    }

    private static void removeFromFlightList(String name) {
        int index = 0;
        for (Airline airline : Airline.__flightList) {
            if (airline.getFlightNumber().equals(name)) {
                Airline.__flightList.remove(index);
                return;
            }
            index++;
        }
    }

    private static void addToAirplaneList(Airplane...airplanes) {
        if (Airline.__airplanes == null) {
            Airline.__airplanes = new ArrayList<Airplane>();
        }
        for (Airplane airplane : airplanes) {
            if (!(Airline.__airplanes.contains(airplane))) {
                Airline.__airplanes.add(airplane);
            }
        }
    }

    private static void removeAirplaneFromList(String name) {
        int index = 0;
        for (Airplane airplane : Airline.__airplanes) {
            if (airplane.getAirplaneName().equals(name)) {
                Airline.__airplanes.remove(index);
                return;
            }
            index++;
        }
    }

    private static List<Airline> matchFlightToAirplane() {
        int flightIndex = 0;
        int airplaneIndex = 0;
        int flightTimeIndex = 0;
        List<Airline> unmatchedFlights = new ArrayList<Airline>();

        for (Airline flight : Airline.__flightList) {
            airplaneIndex = 0;
            for (Airplane airplane : Airline.__airplanes) {
                flightTimeIndex = 0;
                for (String flightTime : airplane.getFlightTimes()) {
                    if (flight.getFlightTime().equals(flightTime) && flight.matchedStatus == false) {
                        Airline flightToUpdate = Airline.__flightList.get(flightIndex);
                        flightToUpdate.flightTime = flightTime;
                        flightToUpdate.airplane = airplane;
                        Airline.__flightList.set(flightIndex, flightToUpdate);
                        //Airline.__flightList.get(flightIndex).flightTime = flightTime;
                        //Airline.__flightList.get(flightIndex).airplane = airplane;
                        Airplane airplaneToUpdate =  Airline.__airplanes.get(airplaneIndex);
                        airplaneToUpdate.removeFlightTime(flightTimeIndex);
                        Airline.__airplanes.set(airplaneIndex, airplaneToUpdate);
                        flight.matchedStatus = true;
                    }
                    flightTimeIndex++;
                }
                airplaneIndex++;
            }
            if (flight.matchedStatus == false) {
                unmatchedFlights.add(flight);
            }
            flightIndex++;
        }
        return unmatchedFlights;
    }

    public static void printFlightList() {
        for (Airline airline : Airline.__flightList) {
            System.out.print(airline.getFlightNumber()+" ");
        }
        System.out.println();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getFlightTime() {
        return flightTime;
    }



    public static void main(String[] args) {
       Airline alaska1 = new Alaska("1000", "9:30-12:30");
       Airline alaska2 = new Alaska("1001", "12:45-15:45");
       Airline alaska3 = new Alaska("1002", "3:30-5:30");
       Airline american1 = new American("1003", "16:45-17:45");
       Airline united1 = new United("1004", "19:00-24:00");
       
       Airplane ap1 = new Airplane("Boeing737-1");
       Airplane ap2 = new Airplane("Boeing737-2");
       Airplane ap3 = new Airplane("Boeing737-3");
       Airplane ap4 = new Airplane("Boeing737-4");
       Airplane ap5 = new Airplane("Boeing777-1");
       Airplane ap6 = new Airplane("Boeing777-2");
       Airplane ap7 = new Airplane("Boeing777-3");
       Airplane ap8 = new Airplane("AirbusA320-1");
       Airplane ap9 = new Airplane("AirbusA320-2");
       Airplane ap10 = new Airplane("AirbusA320-3");

       ap1.addFlightTimes("8:30-10:30", "15:30-18:30", "22:00-23:00");
       ap2.addFlightTimes("9:30-11:30", "12:45-15:45", "18:00-20:00");
       ap3.addFlightTimes("9:30-12:30", "13:45-16:45", "19:00-21:00");
       ap4.addFlightTimes("2:30-4:30", "12:45-15:45", "18:00-20:00");
       ap5.addFlightTimes("6:30-10:30", "12:45-15:45", "18:00-20:00");
       ap6.addFlightTimes("9:30-11:30", "12:45-15:45", "18:00-20:00");
       ap7.addFlightTimes("10:30-11:30", "16:45-17:45", "18:00-20:00");
       //ap8.addFlightTimes("9:30-11:30", "12:45-15:45", "18:00-20:00");
       //ap9.addFlightTimes("9:30-11:30", "12:45-15:45", "18:00-20:00");
       //ap10.addFlightTimes("9:30-11:30", "12:45-15:45", "18:00-20:00");

       Airline.addToFlightList(alaska1, alaska2, alaska3, american1, united1);
       Airline.addToAirplaneList(ap1, ap2, ap3, ap4, ap5, ap6, ap7);
        
       /*for (Airplane airplane : Airline.__airplanes) {
           System.out.println(airplane.getFlightTimes());
           for (String flightime : airplane.getFlightTimes()) {
               System.out.println(flightime);
           }
       }*/

       System.out.println(Airline.matchFlightToAirplane());

        
      

    }
}


class Alaska extends Airline {
    
    public Alaska(String flightNumber, String flightTime) {
        super(flightNumber, flightTime);
    }
}

class American extends Airline {
   
    public American(String flightNumber, String flightTime) {
        super(flightNumber, flightTime);
    }
}

class United extends Airline {
 
    public United(String flightNumber, String flightTime) {
        super(flightNumber, flightTime);
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

    public List<String> getFlightTimes() {
        return flightTimes;
    }

    public void addFlightTimes(String...times) {
        for (String time: times) {
            if (!(flightTimes.contains(time))) {
                flightTimes.add(time);
            }
        }
    }

    public void removeFlightTime(int flightTimeIndex) {
        flightTimes.set(flightTimeIndex, null);
    }

    public void displayFlightTimes() {
        for (String time : flightTimes) {
            System.out.print(time+" ");
        }
        System.out.println();
    }



}
