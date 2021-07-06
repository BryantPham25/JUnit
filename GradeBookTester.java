import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester2 {

		private GradeBook g1;
		private GradeBook g2;
		
		@BeforeEach
		void setUp() throws Exception {
			g1= new GradeBook(5);
			g1.addScore(50.0);
			g1.addScore(75.0);
			g1.addScore(95.0);
			g1.addScore(85.0);
			g1.addScore(90.0);
			
			g2= new GradeBook(5);
			g2.addScore(50.0);
			g2.addScore(75.0);
			g2.addScore(80.0);
			g2.addScore(60.0);
			g2.addScore(90.0);
			
		}

		@AfterEach
		void tearDown() throws Exception {
			g1=null;
			g2=null;
		}

		@Test
		void test() {
			addScoreTest();
			testSum();
			testMinimum();
			testfinalScore();	
		}
		
		public void addScoreTest()
		{
			assertTrue(g1.toString().equals("50.0 75.0 95.0 85.0 90.0 "));
			//System.out.println(g1.toString());
			assertTrue(g2.toString().equals("50.0 75.0 80.0 60.0 90.0 "));
			//System.out.println(g2.toString());

			assertEquals(5, g1.getScoresSize(), 2);
			assertEquals(5, g2.getScoresSize(), 2);	
		}
		
		public void testSum() {
			assertEquals(395, g1.sum(), .0001);
			assertEquals(355, g2.sum(), .0001);
		}
		
		public void testMinimum() {
			assertEquals(50, g1.minimum(), .001);
			assertEquals(50, g2.minimum(), .001);
		}
		
		public void testfinalScore() {
			if(g1.getScoresSize() >= 2)
			{
				assertEquals(345.0, g1.finalScore(), .001);
				
			}
			else
			{
				assertEquals(0.0, g1.finalScore(), .001);
				
			}
			
			if(g2.getScoresSize() >= 2)
			{
				assertEquals(305.0, g2.finalScore(), .001);
				
			}
			else
			{
				assertEquals(0.0, g2.finalScore(), .001);
				
			}
		}
}
