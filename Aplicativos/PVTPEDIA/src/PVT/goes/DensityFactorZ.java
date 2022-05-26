package PVT.goes;

public class DensityFactorZ implements IDensityFactorZ {

    @Override
    public float sumar(float a, float b) {
        return a + b;
    }
    @Override
    public float resta(float a, float b) {
        return a - b;
    }
    @Override
    public float multiplicacion(float a, float b) {
        return a * b;
    } 
    @Override
    public float division(float a, float b) {
        return a / b;
    } 
    @Override
    public float fahrenheitToRankine(float a, float CONST_FAHTORAN) {
        return a + CONST_FAHTORAN;
    }
    @Override
    public float densidadLbPerFt3(float presion, float apparentMolecularWeight, 
            float factorZ, float CONST_UNIVER_GAS_R, float temperature) {
        return (presion*apparentMolecularWeight)/
                (factorZ*CONST_UNIVER_GAS_R*temperature);
    } 
    @Override
    public float volumetricFactor(float CONST_VOL_FACTOR, float factorZ, 
            float temperature, float presion) {
        return (CONST_VOL_FACTOR*factorZ*temperature)/presion;
    }
    @Override
    public double factorFSK(float CONST_FSK_1, float a, float CONST_FSK_3, 
            float CONST_FSK_4, float CONST_FSK_2, float b, float CONST_FSK_5, 
            float CONST_FSK_6) {
        return (CONST_FSK_1*(Math.pow(a, CONST_FSK_3)-Math.pow(a, CONST_FSK_4))
                +(CONST_FSK_2*(Math.pow(b, CONST_FSK_5)-Math.pow(b, CONST_FSK_6))));
    }
}
