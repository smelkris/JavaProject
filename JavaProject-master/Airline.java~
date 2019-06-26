import java.util.ArrayList;
import java.util.List;

public class Airline extends AirlineAbstract {
    private static List<Airline> __flightList;
    private static List<Airplane> __airplanes;

    private String flightNumber;

    public Airline(String number) {
        flightNumber = number;
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
            if (airline.getAirplaneName().equals(name)) {
                Airline.__flightList.remove(index);
                return;
            }
            index++;
        }
    }

    public static void printFlightList() {
        for (Airline airline : Airline.__flightList) {
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
        
        
      

    }
}


class Alaska extends Airline {
    
    public Alaska(String flightNumber) {
        super(flightNumber);
    }
}

class American extends Airline {
   
    public American(String flightNumber) {
        super(flightNumber);
    }
}

class United extends Airline {
 
    public United(String flightNumber) {
        super(flightNumber);
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

    public void removeFlightTime(String flightTime) {
        int index = 0;
        for (String time : flightTimes) {
            if (time.equals(flightTime)) {
                flightTimes.remove(index);
                return;
            }
            index++;
        }
    }

    public void displayFlightTimes() {
        for (String time : flightTimes) {
            System.out.print(time+" ");
        }
        System.out.println();
    }



}
