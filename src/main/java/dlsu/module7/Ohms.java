package dlsu.module7;

public class Ohms {
    double I, V, R;
    double solveAmps(double V, double R){
        return V / R;
    }
    double solveResistance(double V, double I){
        return V / I;
    }
    double solveVoltage(double I, double R){
        return I * R;
    }
}
