import Calculator.BigIntegerSeriesSumCalculator;
import Calculator.IHarmonicSeriesSumCalculator;
import Calculator.IntSeriesSumCalculator;

public class Main {
    public static void main(String[] arg){
        IHarmonicSeriesSumCalculator calculator;
        int count = new ScannerInputUtility().getNumOfIterations();
        if( count <= Constants.HARMONIC_SERIES_INT_USING_LIMIT){
            calculator = new BigIntegerSeriesSumCalculator();
        }
        else{
            calculator = new IntSeriesSumCalculator();
        }
        System.out.println(calculator.calculate(count).toString());
    }
}
