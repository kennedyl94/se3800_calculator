import org.junit.*;
import static org.junit.Assert.*;
public class CalculatorTest {
	@Test
	//DJS
	public void story1Test() throws Exception{
		assertEquals(3,Calculator.add(new double[]{1,2}),0);
		assertEquals(1,Calculator.add(new double[]{-1,2}),0);
		assertEquals(-3,Calculator.add(new double[]{-1,-2}),0);
		assertEquals(6,Calculator.add(new double[]{1,2,3}),0);
	}
	//DJS
	@Test
	public void story2Test() throws Exception{
		assertEquals(-1,Calculator.sub(new double[]{1,2}),0);
		assertEquals(-2,Calculator.sub(new double[]{-1,2}),0);
		assertEquals(1,Calculator.sub(new double[]{-1,-2}),0);
	}
	//DJS
	@Test
	public void story3Test() throws Exception{
		assertEquals(6,Calculator.mul(new double[]{-3,-2}),0);
		assertEquals(-6,Calculator.mul(new double[]{-3,2}),0);
		assertEquals(6,Calculator.mul(new double[]{-3,-3}),0);	
		assertEquals(0,Calculator.mul(new double[]{3,0}),0);
		assertEquals(6,Calculator.mul(new double[]{1,2,3}),0);
	}
	//DJS
	@Test
	public void story4Test() throws Exception{
		assertEquals(2,Calculator.div(new double[]{4,2}),0);
		assertEquals(-2,Calculator.div(new double[]{-4,2}),0);
		assertEquals(2,Calculator.div(new double[]{-4,-2}),0);
		assertEquals(1,Calculator.div(new double[]{8,4,2}),0);
	}
	
	
	//DJS
	@Test
	public void story8Test() throws Exception{	
		assertEquals(8,Calculator.exp(new double[]{2,3}),0);		
		assertEquals(1,Calculator.exp(new double[]{4,0}),0);
		assertEquals(0,Calculator.exp(new double[]{4,-1}),0);
	}
	

}
