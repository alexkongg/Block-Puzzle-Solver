import junit.framework.TestCase;
import org.junit.Test;


public class SolverTest extends TestCase {

	@Test
	public void testMain() {
		
		InputSource data = new InputSource("easy/big.block.1");
		String input;
		input = data.readLine();
		Tray testTray = new Tray(Integer.parseInt(input.substring(2, 3)),
				Integer.parseInt(input.substring(0, 1)));
		while (true) {
			input = data.readLine();
			if (input == null) {
				break;
			}
			testTray.addBlock(input);
			
		}
		assertEquals(testTray.toString(), "1 2 0 01 2 0 21 2 2 01 2 2 2");
		
		
		
		
	}

}
