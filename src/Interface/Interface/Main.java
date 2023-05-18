package Interface.Interface;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        animal.move();

        inFlight(flier);
        Trackable truck = new Truck();
        inFlight(new Jet());
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck traveled %.2f km or %.2f miles%n", kmsTraveled, milesTraveled);

        LinkedList<FlightEnabled> fliers = new LinkedList<>();
        fliers.add(bird);

        List<FlightEnabled> betterFliers = new LinkedList<>();
        betterFliers.add(bird);

        trigerFliers(fliers);
        flyFliers(fliers);
        landFliers(fliers);

        trigerFliers(betterFliers);
        flyFliers(betterFliers);
        landFliers(betterFliers);

    }

    private static void inFlight(FlightEnabled flier){
        flier.takeOff();
        flier.fly();
        if(flier instanceof Trackable tracked){
            tracked.track();
        }
        flier.land();
    }
    private static void trigerFliers (List<FlightEnabled> fliers){
        for(var flier : fliers){
            flier.fly();
        }
    }
    private static void flyFliers (List<FlightEnabled> fliers){
        for(var flier : fliers){
            flier.fly();
        }
    }
    private static void landFliers (List<FlightEnabled> fliers){
        for(var flier : fliers){
            flier.land();
        }
    }
}
