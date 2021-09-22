package dlsu.module7;

public class ThermalConductivity {
    double solveForK(double Q, double L, double A, double T){
        // K = (QL)/(AT)
        return (Q*L) / (A*T);
    }
    double solveForQ(double A, double T, double K, double L){
        // Q = (A * T * K) / L
        return (A*T*K) / (L);
    }
    double solveForL(double A, double T, double K, double Q){
        // L = (A * T * K) / Q
        return (A*T*K) / (Q);
    }
    double solveForA(double Q, double L, double K, double T){
        // A = Q * L / K * T
        return (Q*L) / (K*T);
    }
    double solveForT(double Q, double L, double K, double A){
        // T = (QL)/(KA)
        return (Q*L) / (K*A);
    }
}
