import org.junit.*;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
public class CalculatorTest {
	
	Calculator calc;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	PrintStream oldOut;
	
	
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
	public void story8Test(){
		
		
	}
	
	public void simulateInput(String exp){
		InputStream stdin = System.in;
		try{
			System.setIn(new ByteArrayInputStream(exp.getBytes()));
		}finally{
			System.setIn(stdin);
		}
	}

}
