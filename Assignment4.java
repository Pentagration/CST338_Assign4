/*
 * STUDENTS: Jason Pettit, Sergio Quiroz, Marcus Gonzalez,
 *           Adam Houser, Colin Reed
 * COURSE: CST 338-30_SU19
 * EXERCISE: Module 4 Optical Barcode
 */

public class Assign4
{
	public static void main(String[] args)
	   {
	   }
}

interface BarcodeIO
{
	// All Implimentations expected to store img and text
	BarcodeImage img;

	String text;

	public boolean scan(BarcodeImage bc);

	public boolean readText(String text);

	public boolean generateImageFromText();

	public boolean translateImageToText();

	public void displayTextToConsole();

	public void displayImageToConsole();

}

class BarcodeImage implements Cloneable
{
	public static final int MAX_HEIGHT = 30;
	public static final int MAX_WIDTH = 65;
	//If inbound matrix is smaller than max size, instantiate to false (blank)

	private boolean[][] imageData ;
	// White -> false
	// Black -> true


	// Constructors (2 minimum)

	// Default Constructor
	// Instantiates Max size array and fills with all blanks
	BarcodeImage()
	{
		for(int x=0;x<MAX_WIDTH;x++) {
			for(int y=0;y<MAX_HEIGHT;y++) {
				imageData[x][y] = false;
			}
		}
	}

	// Takes 1d string array. Converts to "the internal 2d array of booleans"
	BarcodeImage(String[] strData)
	{

	}
<<<<<<< HEAD

	//Individual Pixel getter
=======
	//Constructors END
	
	//Individual Pixel getter 
>>>>>>> 371155a97c37c7e53807ef206d0ac78ce9d8cbc7
	// return is actual value and error flag. Error returns false
	boolean getPixel(int row, int col)
	{

	}

	//Individual Pixel setter
	 boolean setPixel(int row, int col, boolean value)
	 {
		 // No input control listed in documentation?
		 imageData[row][col] = value;
	 }


	 // Optional function
	 // Checks incoming data for "very conceivable size or null error"
	 private boolean checkSize(String[] data)
	 {

	 }

	 // Optional Testing method
	 displayToConsole()
	 {

	 }

	 // clone() overwrite cloneable method
}

class DataMatrix implements BarcodeIO
{
<<<<<<< HEAD
	//
private String text;
private int actualWidth;
private int actualHeight;
private BarcodeImage image;
public static final char BLACK_CHAR = '*';
public static final char WHITE_CHAR = ' ';
public static final char boarderHorizontal = '-';
public static final char boarderVertical = "|";

}

//Constructors 3 of them
//default
public DataMatrix ()
{
	this.text = " ";
	this.actualHeight = 0;
	this.actualWidth = 0;
	this.image = new BarcodeImage();
}
// sets the image but leaves the text at its default value.
// Call scan() and avoid duplication of code here.
public DataMatrix(BarcodeImage image)
{
	scan(image);
}

//sets the text but leaves the image at its default value.
//Call readText() and avoid duplication of code here.
public DataMatrix(String text)
{
	readText(text);
}

//mutator for text
public boolean readText(String text)
{
	if(text == null || text.equals(""))
		return false;
	this.text = text;
	return true;
}

public scan(BarcodeImage image)
{

}
=======
	public static final char BLACK_CHAR = '*';
	public static final char WHITE_CHAR = ' ';  
	
	private BarcodeImage image;
	
	private String text;
	
	private int actualWidth, actualHeight;
	
	
}
>>>>>>> 371155a97c37c7e53807ef206d0ac78ce9d8cbc7
