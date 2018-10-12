package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.FileParser;

@RunWith(JUnit4.class)
public class FileParserTest {
	
	@Test
	public void containsSumZeroesNoElements(){
		assertEquals(false, FileParser.containsSumZeroes(Collections.emptyList()));
	}
	
	@Test
	public void containsSumZeroesOneElement(){
		assertEquals(false, FileParser.containsSumZeroes(Arrays.asList(1)));
	}
	
	@Test
	public void containsSumZeroesTwoElements(){
		assertEquals(true, FileParser.containsSumZeroes(Arrays.asList(3, -3)));
	}
	
	@Test
	public void containsSumZeroesMultipleElements(){
		assertEquals(true, FileParser.containsSumZeroes(Arrays.asList(0, 0, 3, -3)));
	}

}
