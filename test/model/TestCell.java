package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCell {

	Cell cell;
	Cell deadCell;
	
	@Before
	public void setUp() throws Exception {
		this.cell = new Cell(1,0);
		this.deadCell = new Cell(1,0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsNeighbor() {
		Cell cell1 = new Cell(1,1);
		Cell cell2 = new Cell(0,0);
		Cell cell3 = new Cell(1,-1);
		Cell cell4 = new Cell(2,0);
		Cell cell5 = new Cell(2,1);
		Cell cell6 = new Cell(0,1);
		Cell cell7 = new Cell(2,-1);
		Cell cell8 = new Cell(2,1);
		assertTrue("NOK isAlive", cell.IsNeighbor(cell1));
		assertTrue("NOK isAlive", cell.IsNeighbor(cell2));
		assertTrue("NOK isAlive", cell.IsNeighbor(cell3));
		assertTrue("NOK isAlive", cell.IsNeighbor(cell4));
		assertFalse("NOK isAlive", cell.IsNeighbor(cell5));
		assertFalse("NOK isAlive", cell.IsNeighbor(cell6));
		assertFalse("NOK isAlive", cell.IsNeighbor(cell7));
		assertFalse("NOK isAlive", cell.IsNeighbor(cell8));
	}

	@Test
	public void testIsNeighborFalse() {
		Cell cell2 = new Cell(5,5);
		assertFalse("NOK isAlive", cell.IsNeighbor(cell2));
	}

	@Test
	public void testIsAlive() {
		cell.setNbNeighbor(2);
		assertTrue("NOK isAlive", cell.isAlive());
		cell.setNbNeighbor(1);
		assertFalse("NOK isAlive", cell.isAlive());
		cell.setNbNeighbor(5);
		assertFalse("NOK isAlive", cell.isAlive());
	}

	@Test
	public void testIsAliveFalse() {
		deadCell.isAlive();
		assertFalse("NOK isAlive", deadCell.isAlive());
	}

	@Test
	public void testSetNbNeighbor() {
		cell.setNbNeighbor(3);
		assertEquals("NOK setNbNeighbor", 3, cell.getNbNeighbor());
	}

	@Test
	public void testMoreThanOneNeighbor() {
		cell.setNbNeighbor(2);
		assertTrue("NOK moreThanOneNeighbor", cell.moreThanOneNeighbor());
	}

	@Test
	public void testMoreThanOneNeighborFalse() {
		cell.setNbNeighbor(1);
		assertFalse("NOK moreThanOneNeighbor", cell.moreThanOneNeighbor());
	}

	@Test
	public void testLessThanFourNeighbor() {
		cell.setNbNeighbor(3);
		assertTrue("NOK lessThanFourNeighbor", cell.lessThanFourNeighbor());
	}

	@Test
	public void testLessThanFourNeighborFalse() {
		cell.setNbNeighbor(5);
		assertFalse("NOK lessThanFourNeighbor", cell.lessThanFourNeighbor());
	}

	@Test
	public void testRevive() {
		cell.setAlive(true);
		cell.setNbNeighbor(3);
		assertTrue("NOK revive", cell.revive());
		
		cell.setAlive(false);
		cell.setNbNeighbor(2);
		assertFalse("NOK revive", cell.revive());
		cell.setNbNeighbor(3);
		assertTrue("NOK revive", cell.revive());
	}

	@Test
	public void testCountNeighbor() {
		assertEquals("NOK countNeighbor", 0, cell.countNeighbor());
		//TODO Set cell so that there are 4 neighbors
		//assertEquals("NOK countNeighbor", 4, cell.countNeighbor());
	}
	
}
