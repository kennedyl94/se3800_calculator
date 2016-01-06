import org.junit.*;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
public class CalculatorTest {
	
	Calculator calc;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	PrintStream oldOut;
	InputStream oldIn;
	
	
	//Use outContent.toString() to assert output equal to expected value. 
	@Before
	public void before(){
		calc = new Calculator();
		oldOut = System.out;
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void after(){
		System.setOut(oldOut);
	}
	
	@Test
	public void story8Test() throws Exception{
		
		Calculator.exp(new int[]{2,3});
		assertEquals("8",outContent.toString().trim());
		
		outContent.reset();
		
		Calculator.exp(new int[]{4,0});
		assertEquals("1",outContent.toString().trim());
		
		outContent.reset();
		
		Calculator.exp(new int[]{4,-1});
		assertEquals("0",outContent.toString().trim());
		
	}
	

}
