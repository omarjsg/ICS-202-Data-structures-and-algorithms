public class Patient implements Comparable<Patient> {
    String name;
    int emergencyLevel = 5;

    public Patient(String name, int emergencyLevel) {
        setName(name);
        setEmergencyLevel(emergencyLevel);
    }

    @Override // We flip the conditions because the most urgent starts from 0.
    public int compareTo(Patient o) {
        if (emergencyLevel > o.emergencyLevel) {
            return 1;
        } else if (emergencyLevel < o.emergencyLevel) {
            return -1;
        } else {
            return name.compareTo(o.name);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmergencyLevel() {
        return this.emergencyLevel;
    }

    public void setEmergencyLevel(int emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }
}
