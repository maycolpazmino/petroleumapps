package PVT.goes;

public interface IDensityFactorZ {

    float CONST_FSK_1 = 120;
    float CONST_FSK_2 = 15;
    float CONST_FSK_3 = 0.9f;
    float CONST_FSK_4 = 1.6f;
    float CONST_FSK_5 = 0.5f;
    float CONST_FSK_6 = 4;
    float CONST_FAHTORAN = 549.67f;
    float CONST_ESPECIF_GRAVITY_MIX = 28.96f;
    float CONST_UNIVER_GAS_R = 10.73159f;
    float CONST_VOL_FACTOR = 0.02829f;

    float sumar(float a, float b);

    float resta(float a, float b);

    float multiplicacion(float a, float b);

    float division(float a, float b);

    float fahrenheitToRankine(float a, float CONST_FAHTORAN);

    float densidadLbPerFt3(float presion, float apparentMolecularWeight,
            float factorZ, float CONST_UNIVER_GAS_R, float temperature);

    float volumetricFactor(float CONST_VOL_FACTOR, float factorZ,
            float temperature, float presion);

    double factorFSK(float CONST_FSK_1, float a, float CONST_FSK_3,
            float CONST_FSK_4, float CONST_FSK_2, float b, float CONST_FSK_5,
            float CONST_FSK_6);
}
