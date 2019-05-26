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
      String[] testString = new String[]
            {"This", "is", "a", "good", "SAMPLE", "to", "look", "at."};
      BarcodeImage test1 = new BarcodeImage();
      BarcodeImage test2 = new BarcodeImage(testString);

      test1.displayToConsole();
      test2.displayToConsole();
      }
}

interface BarcodeIO
{
   // All Implimentations expected to store img and text

   //BarcodeImage img;
   //String text;

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
   public BarcodeImage()
   {
     this.imageData = new boolean[MAX_WIDTH][MAX_HEIGHT];

       for(int x=0;x<MAX_WIDTH;x++)
     {
        for(int y=0;y<MAX_HEIGHT;y++)
        {
           this.setPixel(x, y, false);
        }
     }
   }

   // Takes 1d string array. Converts to "the internal 2d array of booleans"
   public BarcodeImage(String[] strData)
   {
     this.imageData = new boolean[MAX_WIDTH][MAX_HEIGHT];

     if (checkSize(strData) == true)
     {
        //convert each letter to ascii then binary and set appropriately
        //1s are *, 0s are blank
        for (int i = 0; i < strData.length; i++) // columns
        {
           //pull word into character array
           char[] chars = strData[i].toCharArray();

           for (int j = 0; j < chars.length; j++)
           {
              //converts letter to binary
              int temp = Character.getNumericValue(chars[j]);
              String temp2 = Integer.toBinaryString(temp);

              //add *s to the rows where binary = 1
              char[] binary = temp2.toCharArray();
              for (int k = 0; k < binary.length; k++)
              {
                 if (binary[k] == '1')
                 {
                    this.setPixel((binary.length - k - 1),  i,  true);
                 }
                 else
                 {
                    this.setPixel((binary.length - k - 1),  i,  false);
                 }
              }
           }

        }
     }
  }
   //Constructors END

   //Individual Pixel getter
   // return is actual value and error flag. Error returns false
   public boolean getPixel(int row, int col)
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
   // Does this need to be strictly less than?
   //
    public boolean setPixel(int row, int col, boolean value)
    {
       if (row <= MAX_WIDTH && col <= MAX_HEIGHT)
         {
             imageData[row][col] = value;
             return true;
         }
         else
         {
            return false;
         }
    }


    // Optional function
    // Checks incoming data for "very conceivable size or null error"
    private boolean checkSize(String[] data)
    {
       int size = 0;

       for (int i = 0; i < data.length; i++)
       {
           size = size + data[i].length();
       }

       if(size > MAX_WIDTH || data == null) //should this be -1?
       {
          return false;
       }
       else
       {
          return true;
       }
    }

    // Optional Testing method
    public void displayToConsole()
    {
       for(int i = 0; i < MAX_WIDTH; i++)
       {
          for(int j = 0; j < MAX_HEIGHT; j++)
          {
             if (this.imageData[i][j] == true)
             {
                System.out.print("*");
             }
             else
             {
                System.out.print(" ");
             }
          }
       }
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

   // Declare in BarcodeIO or here?
   private BarcodeImage image;
   private String text;

   private int actualWidth, actualHeight;

   //defaut constructor
   DataMatrix()
   {
      this.text = "";
      this.actualHeight = 0;
      this.actualWidth = 0;
      this.image = new BarcodeImage();
   }

   //barcode constructor
   DataMatrix(BarcodeImage image)
   {
     // Call scan()
     scan(image);

   }

   //string constructor
   DataMatrix(String text)
   {

   }


   //Accessors
   public getText()
   {

   }

   @Override
   public boolean scan(BarcodeImage bc)
   {
     // Mutator for img. Calls Barcode clone, cleanImage, set ActualWidth and height
     // deal with CloneNotSupportedException. CLONE CALL IN TRY CATCH BLOCK. Catches clause empty.

     try
     {
      DataMatrix clone = (DataMatrix)BarCodeIO.clone();
     }
     catch(CloneNotSupportedException e)
     {
       //Intentionally Empty
     }


      return false;
   }

   @Override
   public boolean readText(String text)
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean generateImageFromText()
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean translateImageToText()
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public void displayTextToConsole()
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void displayImageToConsole()
   {
      // TODO Auto-generated method stub

   }
}
