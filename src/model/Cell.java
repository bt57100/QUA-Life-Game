package model;

public class Cell {

	private Coord coord;
	private boolean alive;
	private int nbNeighbor;
	
	public Cell(int x, int y) {
		this.coord = new Coord(x,y);
		this.alive = true;
		this.nbNeighbor = 0;
	}

	public boolean IsNeighbor(Cell cell1) {
		int neighbor = Math.abs(this.getCoord().getX() - cell1.getCoord().getX()) 
				+ Math.abs(this.getCoord().getY() - cell1.getCoord().getY());
		return neighbor == 1;
	}

	public boolean isAlive() {
		this.alive = moreThanOneNeighbor()&&lessThanFourNeighbor();
		return this.alive;
	}

	public Coord getCoord() {
		return coord;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getNbNeighbor() {
		return nbNeighbor;
	}

	public void setNbNeighbor(int nbNeighbor) {
		this.nbNeighbor = nbNeighbor;
	}
	
	public boolean moreThanOneNeighbor() {
		return this.nbNeighbor > 1;
	}
	
	public boolean lessThanFourNeighbor() {
		return this.nbNeighbor < 4;
	}
	
	public boolean revive() {
		if(this.alive == false && this.nbNeighbor == 3) {
			this.alive = true;
		}
		return this.alive;
	}
	
	public int countNeighbor() {
		this.nbNeighbor = 0;
		if(new Cell(this.getCoord().getX() + 1,this.getCoord().getY()).isAlive()) {
			this.nbNeighbor++;
		}
		if(new Cell(this.getCoord().getX() - 1,this.getCoord().getY()).isAlive()) {
			this.nbNeighbor++;
		}
		if(new Cell(this.getCoord().getX(), this.getCoord().getY() + 1).isAlive()) {
			this.nbNeighbor++;
		}
		if(new Cell(this.getCoord().getX(), this.getCoord().getY() - 1).isAlive()) {
			this.nbNeighbor++;
		}
		return this.nbNeighbor;
	}
}
