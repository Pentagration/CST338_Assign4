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
	   if (checkSize(strData) == true)
	   {
	      //convert each letter to ascii then binary and set appropriately
	      //1s are *, 0s are blank
	      for (int i = 0; i < strData.length; i++) // columns
	      {
	         //converts letter to binary
	         int temp = Integer.toBinaryString(strData[i]); 
	         
	         //add *s to the rows where binary = 1
	         while (temp > 0)
	         {
	            int row = 0;
	            int lastDigit = temp % 10; 
	            if (lastDigit == 1)
	               {
	               this.imageData[strData[i]][row] = true;
	               }
	            temp = temp/10;
	         }
	      }
	   }
	}
	//Constructors END

	//Individual Pixel getter
	// return is actual value and error flag. Error returns false
	boolean getPixel(int row, int col)
	{
	   if (row <= MAX_WIDTH && col <= MAX_HEIGHT)
	   {
	      return imageData[row][col];
	   }
	   else
	   {
	      return false;
	   }
	}

	//Individual Pixel setter
	 boolean setPixel(int row, int col, boolean value)
	 {
		 // No input control listed in documentation?
		 imageData[row][col] = value;
		 
		 return value;
	 }


	 // Optional function
	 // Checks incoming data for "very conceivable size or null error"
	 private boolean checkSize(String[] data)
	 {
	    if(data.length > MAX_WIDTH || data == null) //should this be -1?
	    {
	       return false;
	    }
	    else
	    {
	       return true;
	    }
	 }

	 // Optional Testing method
	 displayToConsole()
	 {

	 }

	 // clone() overwrite cloneable method
	 public Object clone()
	 {
	    try
	    {
	       return super.clone(); //simple version since type is boolean right?
	    }
	    catch(CloneNotSupportedException e)
	    {
	       return null;
	    }
	 }
}

class DataMatrix implements BarcodeIO
{
	public static final char BLACK_CHAR = '*';
	public static final char WHITE_CHAR = ' ';

	private BarcodeImage image;

	private String text;

	private int actualWidth, actualHeight;

	//defaut constructor
	DataMatrix()
	{
	   
	}
	
	//barcode constructor
	DataMatrix(BarcodeImage image)
	{
	   
	}
	
	//string constructor
	DataMatrix(String text)
	{
	   
	}
}
