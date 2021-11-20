package MothBalls.Randistrictr.object;

public class ClientAlgorithmParameters {

    private int minMinorityMajorityDistricts;
    private int maxMinorityMajorityDistricts;
    private double minThreshold;
    private double minPopulationScore;
    private double efficiencyGapMeasure;
    private double polsbyPopperScore;
    private int numIterations;

    public ClientAlgorithmParameters(int minMinorityMajorityDistricts, int maxMinorityMajorityDistricts, double minThreshold,
                                     double minPopulationScore, double efficiencyGapMeasure, double polsbyPopperScore, int numIterations) {
        this.minMinorityMajorityDistricts = minMinorityMajorityDistricts;
        this.maxMinorityMajorityDistricts = maxMinorityMajorityDistricts;
        this.minThreshold = minThreshold;
        this.minPopulationScore = minPopulationScore;
        this.efficiencyGapMeasure = efficiencyGapMeasure;
        this.polsbyPopperScore = polsbyPopperScore;
        this.numIterations = numIterations;
    }

    public int getMinMinorityMajorityDistricts() {
        return minMinorityMajorityDistricts;
    }

    public void setMinMinorityMajorityDistricts(int minMinorityMajorityDistricts) {
        this.minMinorityMajorityDistricts = minMinorityMajorityDistricts;
    }

    public int getMaxMinorityMajorityDistricts() {
        return maxMinorityMajorityDistricts;
    }

    public void setMaxMinorityMajorityDistricts(int maxMinorityMajorityDistricts) {
        this.maxMinorityMajorityDistricts = maxMinorityMajorityDistricts;
    }

    public double getMinThreshold() {
        return minThreshold;
    }

    public void setMinThreshold(double minThreshold) {
        this.minThreshold = minThreshold;
    }

    public double getMinPopulationScore() {
        return minPopulationScore;
    }

    public void setMinPopulationScore(double minPopulationScore) {
        this.minPopulationScore = minPopulationScore;
    }

    public double getEfficiencyGapMeasure() {
        return efficiencyGapMeasure;
    }

    public void setEfficiencyGapMeasure(double efficiencyGapMeasure) {
        this.efficiencyGapMeasure = efficiencyGapMeasure;
    }

    public double getPolsbyPopperScore() {
        return polsbyPopperScore;
    }

    public void setPolsbyPopperScore(double polsbyPopperScore) {
        this.polsbyPopperScore = polsbyPopperScore;
    }

    public int getNumIterations() {
        return numIterations;
    }

    public void setNumIterations(int numIterations) {
        this.numIterations = numIterations;
    }
}
