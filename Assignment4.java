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
	
}

class DataMatrix implements BarcodeIO
{
	
}