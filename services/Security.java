package services;
import java.util.ArrayList;
import java.util.List;

public class Security {
    private final List<String> emergencyPlates = new ArrayList<>();
    private final List<String> blacklist = new ArrayList<>();
    private final List<String> stolenVehicles = new ArrayList<>();
    private final List<String> subscriptionPlates = new ArrayList<>();

    public void insertBlacklist(String plate) {
        if (!blacklist.contains(plate)) blacklist.add(plate);
    }

    public void removeBlacklist(String plate) {
        blacklist.remove(plate);
    }

    public void addEmergencyPlate(String plate) {
        if (!emergencyPlates.contains(plate)) emergencyPlates.add(plate);
    }

    public boolean isStolen(String plate) {
        return stolenVehicles.contains(plate);
    }

    public boolean isInBlacklist(String plate) {
        return blacklist.contains(plate);
    }

    public boolean isEmergency(String plate) {
        return emergencyPlates.contains(plate);
    }

    public boolean isInSubs(String plate) {
        return subscriptionPlates.contains(plate);
    }

    public void addSubscriptionPlate(String plate) {
        if (!subscriptionPlates.contains(plate)) subscriptionPlates.add(plate);
    }
}
