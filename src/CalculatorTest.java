import org.junit.*;
import static org.junit.Assert.*;
public class CalculatorTest {
	
	Calculator calc;
	@Before
	public void setUp(){
		calc = new Calculator();
	}
	@Test
	//DJS
	public void story1Test() throws Exception{
		assertEquals(3,calc.add(new double[]{1,2}),0);
		assertEquals(1,calc.add(new double[]{-1,2}),0);
		assertEquals(-3,calc.add(new double[]{-1,-2}),0);
		assertEquals(6,calc.add(new double[]{1,2,3}),0);
	}
	//DJS 
	@Test
	public void story2Test() throws Exception{
		assertEquals(-1,calc.sub(new double[]{1,2}),0);
		assertEquals(-3,calc.sub(new double[]{-1,2}),0);
		assertEquals(1,calc.sub(new double[]{-1,-2}),0);
	}
	//DJS
	@Test
	public void story3Test() throws Exception{
		assertEquals(6,calc.mul(new double[]{-3,-2}),0);
		assertEquals(-6,calc.mul(new double[]{-3,2}),0);
		assertEquals(9,calc.mul(new double[]{-3,-3}),0);	
		assertEquals(0,calc.mul(new double[]{3,0}),0);
		assertEquals(6,calc.mul(new double[]{1,2,3}),0);
	}
	//DJS
	@Test
	public void story4Test() throws Exception{
		assertEquals(2,calc.div(new double[]{4,2}),0);
		assertEquals(-2,calc.div(new double[]{-4,2}),0);
		assertEquals(2,calc.div(new double[]{-4,-2}),0); 
		assertEquals(1,calc.div(new double[]{8,4,2}),0);
	}
	
	//DJS
	@Test
	public void story5Test() throws Exception{
		assertTrue(calc.hist().equals(""));
		System.out.println(calc.hist());
		calc.add(new double[]{1,2});
		calc.add(new double[]{3,4});
		assertTrue(calc.hist().equals("0: add 1.0,2.0 = 3.0\n1: add 3.0,4.0 = 7.0\n"));
	}
	//DJS
	@Test
	public void story6Test() throws Exception{
		calc.add(new double[]{1,2});
		calc.clear();
		assertTrue(calc.hist().equals(""));
		//Not sure how to test for clear console Acceptance Criteria
	}
	
	//DJS
	@Test
	public void story7Test() throws Exception{
		calc.add(new double[]{1,1});
		calc.add(new double[]{1,1});
		calc.add(new double[]{10,5});
		assertTrue(calc.next("add 1,!2").equals("16.0"));
		calc.clear();
		assertTrue(calc.next("add 1,!2").equals("ERR"));
	}
	
	//DJS
	@Test
	public void story8Test() throws Exception{	
		assertEquals(8,calc.exp(new double[]{2,3}),0);		
		assertEquals(1,calc.exp(new double[]{4,0}),0);
		assertEquals(0,calc.exp(new double[]{4,-1}),0);
	}
	

}
