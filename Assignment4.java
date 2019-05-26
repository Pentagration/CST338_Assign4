/*
 * STUDENTS: Jason Pettit, Sergio Quiroz, Marcus Gonzalez,
 *           Adam Houser, Colin Reed
 * COURSE: CST 338-30_SU19
 * EXERCISE: Module 4 Optical Barcode
 */

public class Module4
{
    public static void main(String[] args)
    {
        String[] testString = new String[]
                {"This ", "is ", "a ", "good ", "SAMPLE ", "to ", "look ", "at."};
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
    public static final int MAX_HEIGHT = 30;    //number of rows
    public static final int MAX_WIDTH = 65;     //number of columns
    //If inbound matrix is smaller than max size, instantiate to false (blank)

    private boolean[][] imageData ;
    // White -> false
    // Black -> true


    // Constructors (2 minimum)

    // Default Constructor
    // Instantiates Max size array and fills with all blanks
    public BarcodeImage()
    {
        this.imageData = new boolean[MAX_HEIGHT][MAX_WIDTH];

        for(int x = 0; x < MAX_HEIGHT; x++)
        {
            for(int y = 0; y < MAX_WIDTH; y++)
            {
                if(y == 0 || x == MAX_HEIGHT - 1)
                {
                    this.setPixel(x, y, true);
                }
                else
                {
                    this.setPixel(x, y, false);
                }
            }
        }
    }

    // Takes 1d string array. Converts to "the internal 2d array of booleans"
    public BarcodeImage(String[] strData)
    {
        this.imageData = new boolean[MAX_HEIGHT][MAX_WIDTH];

        if (checkSize(strData) == true)
        {
            int column = 1;
            int row = 0;

            //convert each letter to ascii then binary and set appropriately
            //1s are *, 0s are blank
            for (int i = 0; i < strData.length; i++) // columns
            {
                //pull word into character array
                char[] chars = strData[i].toCharArray();

                for (int j = 0; j < chars.length; j++)
                {
                    //converts letter to binary
                    int temp = (int) chars[j];
                    String temp2 = Integer.toBinaryString(temp);

                    //add *s to the rows where binary = 1
                    char[] binary = temp2.toCharArray();

                    if (binary.length > row)
                    {
                        row = binary.length;
                    }

                    for (int k = 0; k < binary.length; k++)
                    {
                        if (binary[k] == '1')
                        {
                            this.setPixel((MAX_HEIGHT - (binary.length - k) - 1), column, true);
                        }
                        else
                        {
                            this.setPixel((MAX_HEIGHT - (binary.length - k) - 1),  column,  false);
                        }
                    }

                    column++;
                }

            }
            //bottom spine
            for (int x = 0; x <= column; x++)
            {
                this.setPixel(MAX_HEIGHT - 1, x, true);
            }

            //leftside spine
            for (int y = 0; y <= row + 2; y++)
            {
                this.setPixel((MAX_HEIGHT - y - 1), 0, true);
            }

            //top spine
            for (int x = 0; x <= column; x++)
            {
                if (x % 2 == 0)
                {
                    this.setPixel(MAX_HEIGHT - (row + 3), x, true);
                }
            }

            //rightside spine
            for (int y = 0; y <= row + 2; y++)
            {
                if (y % 2 == 0) {
                    this.setPixel((MAX_HEIGHT - y - 1), column, true);
                }
            }
        }
    }
    //Constructors END

    //Individual Pixel getter
    // return is actual value and error flag. Error returns false
    public boolean getPixel(int row, int col)
    {
        if (row <= MAX_HEIGHT && col <= MAX_WIDTH)
        {
            return imageData[row][col];
        }
        else
        {
            return false;
        }
    }

    //Individual Pixel setter
    public boolean setPixel(int row, int col, boolean value)
    {
        if (row <= MAX_HEIGHT && col <= MAX_WIDTH)
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
        for(int i = 0; i < MAX_HEIGHT; i++)
        {
            for(int j = 0; j < MAX_WIDTH; j++)
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

            System.out.print("\n");
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

    }

    //string constructor
    DataMatrix(String text)
    {

    }

    @Override
    public boolean scan(BarcodeImage bc)
    {
        // TODO Auto-generated method stub
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
