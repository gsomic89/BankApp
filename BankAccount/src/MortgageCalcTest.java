import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MortgageCalcTest {

    //Test to check if exception thrown for bad input, 0 for principle amount
    @Test(expected=IllegalArgumentException.class)
    public void testPrincipleLimitZero(){
        MortgageCalculator calc1 = new MortgageCalculator(0,5,30);
    }
    //Test to check if exception thrown for bad input, -1 for principle amount--BOUNDARY TEST
    @Test(expected=IllegalArgumentException.class)
    public void testPrincipleLimitNegative(){
        MortgageCalculator calc1 = new MortgageCalculator(-1,5,30);
    }
    //Test to check if exception thrown for bad input, 0.5 for years--BOUNDARY TEST
    @Test(expected=IllegalArgumentException.class)
    public void testYearLimitOne(){
        MortgageCalculator calc1 = new MortgageCalculator(500000,5,0.5);
    }
    //Test to check if exception thrown for bad input, 0 for years
    @Test(expected=IllegalArgumentException.class)
    public void testYearLimitZero(){
        MortgageCalculator calc1 = new MortgageCalculator(500000,5,0);
    }
    //Test to check if exception thrown for bad input, -1 for years amount--BOUNDARY TEST
    @Test(expected=IllegalArgumentException.class)
    public void testYearLimitNegative(){
        MortgageCalculator calc1 = new MortgageCalculator(500000,5,-1);
    }



    //First test done with pre chosen values: (princ:500,000 rate:5 years:30)
    @Test
    public void testMortgageCalc(){
        MortgageCalculator calc1 = new MortgageCalculator(500000,5,30);
        String answer = calc1.calculate();
        assertEquals("2684.11", answer);
    }

    //Next Five tests ran from 5 randomly selected loan amounts from $300,000 to $600,000;
    // Five randomized rates from 4$ to 6% at 15 or 30 year loan terms
    // 5 principle amounts: 1.)383487  2.)472429  3.)457388  4.)541443  5.)582831
    // 5 rates are: 1.)4.19   2.)4.15   3.)4.10   4.)4.33   5.)4.85
    @Test
    public void testMortgageCalcRandom1(){
        MortgageCalculator calc1 = new MortgageCalculator(383487,4.19,15);
        String answer = calc1.calculate();
        assertEquals("2873.26", answer);
    }
    @Test
    public void testMortgageCalcRandom2(){
        MortgageCalculator calc1 = new MortgageCalculator(472429,4.15,30);
        String answer = calc1.calculate();
        assertEquals("2296.49", answer);
    }
    @Test
    public void testMortgageCalcRandom3(){
        MortgageCalculator calc1 = new MortgageCalculator(457388,4.10,15);
        String answer = calc1.calculate();
        assertEquals("3406.21", answer);
    }
    @Test
    public void testMortgageCalcRandom4(){
        MortgageCalculator calc1 = new MortgageCalculator(541443,4.33,30);
        String answer = calc1.calculate();
        assertEquals("2688.99", answer);
    }

    /**
     *
     */
    @Test
    public void testMortgageCalcRandom5(){
        MortgageCalculator calc1 = new MortgageCalculator(582831,4.85,15);
        String answer = calc1.calculate();
        assertEquals("4563.58", answer);
    }
}