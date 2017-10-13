package model;

public class Cell {

	private Coord coord;
	private boolean alive;
	
	public Cell(int x, int y) {
		this.coord = new Coord(x,y);
		this.alive = true;
	}

	public boolean IsNeighbor(Cell cell1) {
		boolean neighbor = false;
		if((this.getCoord().getX() + 1 == cell1.getCoord().getX() 
				&& this.getCoord().getY() == cell1.getCoord().getY())
			|| (this.getCoord().getX() - 1 == cell1.getCoord().getX()
				&& this.getCoord().getY() == cell1.getCoord().getY())
			|| (this.getCoord().getY() + 1 == cell1.getCoord().getY()
				&& this.getCoord().getX()==cell1.getCoord().getX())
			|| this.getCoord().getY() - 1 == cell1.getCoord().getY()
				&& this.getCoord().getX() == cell1.getCoord().getX()) {
			neighbor = true;
		}
		return neighbor;
	}

	public boolean isAlive() {
		return alive;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
