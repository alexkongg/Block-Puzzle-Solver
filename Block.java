import java.lang.StringBuilder;

/**
 * The Block class represents the Blocks in the game. Its instance
 * variables are immutable. If one desires to move a Block on a Tray
 * from one position to another, one must create a reference to a
 * different Block with the desired dimensions/position rather than
 * changing the characteristics of this existing Block.
 *
 *@author cs61bl-db (Suk Kyu Kong), cs61bl-dc (Anthony Joel Castro), cs61bl-eq (Gerald Park), cs61bl-er (Monica Wang)
 */
public class Block {
	protected final int myRow; // row of block's top-left position
	protected final int myCol; // column of block's top-left position
	protected final int myHeight; // height of block
	protected final int myWidth; // width of block
	
	// The String representation of a Block; contains the Block's
	// dimensions, followed by its position.
	protected final String mySignature;
	protected final int myHash;
	
	
	/**
	 * Initialize a copy of a Block object setting the new Block's
	 * attributes to the original one's.
	 * 
	 * @param copy
	 * 							the Block to be copied
	 */
	public Block(Block copy) {
		
		myRow = copy.myRow;
		myCol = copy.myCol;
		myHeight = copy.myHeight;
		myWidth = copy.myWidth;	
		mySignature = copy.mySignature;
		myHash = mySignature.hashCode();
	}
	
	/**
	 * Initialize a new Block object of a given height and width
	 * and set at the given row, column.
	 * 
	 * @param height
	 * 							the height of the new Block
	 * @param width
	 * 							the width of the new Block
	 * @param row
	 * 							the row which the new Block's upper left corner will be placed at
	 * @param col
	 * 							the column which the new Block's upper left corner will be placed at
	 */
	public Block (int height, int width, int row, int col) {
		myRow = row;
		myCol = col;
		myHeight = height;
		myWidth = width;

		// Create new empty StringBuilder
		StringBuilder blockInfo = new StringBuilder();
		// Append each attribute into the StringBuilder
		blockInfo.append(myHeight);
		blockInfo.append(" ");
		blockInfo.append(myWidth);
		blockInfo.append(" ");
		blockInfo.append(myRow);
		blockInfo.append(" ");
		blockInfo.append(myCol);
		// Return String representation of data in the StringBuilder
		mySignature = blockInfo.toString();
		myHash = mySignature.hashCode();
	}

	/**
	 * Creates and returns a String representation of a Block. The String is 
	 * comprised of each of the Block's attributes. Uses the StringBuilder
	 * class and appends each attribute and returns using StringBuilder.toString()
	 * 
	 * Example: "5 6 7 8" represents a Block with height of 5, 
	 * 			width of 6 located at row 7, column 8
	 */
	@Override
	public String toString() {
		return mySignature;
	}
	
	/**
	 * Returns the hashCode of a Block by turning it into a String and using
	 * the String.hashCode()
	 */
	@Override
	public int hashCode() {
		return myHash;
	}
	
	
	/**
	 * Returns true if this Block object equals another Block by comparing hashCodes.
	 * In other words, they have the same dimension and position.
	 * 
	 * @param otherBlock
	 * 							the Block to be compared to
	 */
	@Override
	public boolean equals(Object otherBlock) {
		return this.mySignature.equals(otherBlock.toString());
	}
	
	public boolean occupiesPosition(int row, int col){
		if (col >= this.myCol && col < this.myCol + this.myWidth
				&& row >= this.myRow && row < this.myRow + this.myHeight) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
