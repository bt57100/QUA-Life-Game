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
		assertTrue("NOK isAlive", cell.IsNeighbor(cell1));
		assertTrue("NOK isAlive", cell.IsNeighbor(cell2));
		assertTrue("NOK isAlive", cell.IsNeighbor(cell3));
		assertTrue("NOK isAlive", cell.IsNeighbor(cell4));
	}

	@Test
	public void testIsNeighborFalse() {
		Cell cell2 = new Cell(5,5);
		assertFalse("NOK isAlive", cell.IsNeighbor(cell2));
	}

	@Test
	public void testIsAlive() {
		assertTrue("NOK isAlive", cell.isAlive());
	}

	@Test
	public void testIsAliveFalse() {
		deadCell.setAlive(false);
		assertFalse("NOK isAlive", deadCell.isAlive());
	}

}
