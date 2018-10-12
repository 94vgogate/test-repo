package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import main.RootedTree;

@RunWith(JUnit4.class)
public class RootedTreeTest {
		
		@Test
		public void getPreorder(){
			RootedTree rt = new RootedTree(null, null, null, "C");
			assertEquals("C", rt.getPreorder());
		}
		
		@Test
		public void getPreorderMult(){
			RootedTree C = generateSampleTree();
			assertEquals("C E H B F S P D", C.getPreorder());
		}
		
		@Test
		public void getLevelOrder(){
			RootedTree C = generateSampleTree();
			assertEquals("C E F S H B P D", C.getLevelOrder());
		}
		
		@Test
		public void getHeight(){
			RootedTree C = generateSampleTree();
			assertEquals(2, C.getHeight());
			
		}
		
		@Test
		public void getLevelZeroSample(){
			RootedTree C = generateSampleTree();
			assertEquals("C", C.getLevel(0));
		}
		
		@Test
		public void getLevelOneSample(){
			RootedTree C = generateSampleTree();
			assertEquals("E F S", C.getLevel(1));
		}
		
		@Test
		public void getLevelTwoSample(){
			RootedTree C = generateSampleTree();
			assertEquals("H B P D", C.getLevel(2));
		}
		
		private RootedTree generateSampleTree(){
			RootedTree H = new RootedTree("H");
			RootedTree B = new RootedTree("B");
			RootedTree P = new RootedTree("P");
			RootedTree D = new RootedTree("D");
			RootedTree E = new RootedTree(H, null, B, "E");
			RootedTree F = new RootedTree("F");
			RootedTree S = new RootedTree(P, null, D, "S");
			RootedTree C = new RootedTree(E,F,S, "C");
			return C;
		}
		
}
