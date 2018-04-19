package pixlab;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test keepOnlyBlue */
  public static void testKeepOnlyBlue(){
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.keepOnlyBlue();
	  beach.explore();
  }
  
  public static void testNegate(){
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.negate();
	  beach.explore();
  }
  
  public static void testGrayscale(){
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.grayscale();
	  beach.explore();
  }
  
  public static void testFixUnderwater(){
	  Picture water = new Picture("water.jpg");
	  water.explore();
	  water.fixUnderwater();
	  water.explore();
  }
  
  public static void testMirrorVerticalRightToLeft(){
	  Picture moto = new Picture("redMotorcycle.jpg");
	  moto.mirrorVerticalRightToLeft();
	  moto.explore();
  }
  
  public static void testMirrorHorizontal(){
	  Picture moto = new Picture("redMotorcycle.jpg");
	  moto.mirrorHorizontal();
	  moto.explore();
  }
  
  public static void testMirrorHorizontalBotToTop(){
	  Picture moto = new Picture("redMotorcycle.jpg");
	  moto.mirrorHorizontalBotToTop();
	  moto.explore();
  }
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorDiagonal(){
	  Picture beach = new Picture("beach.jpg");
	  beach.mirrorDiagonal();
	  beach.explore();
  }
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
	  Picture temple = new Picture("temple.jpg");
	  temple.explore();
	  temple.mirrorTemple();
	  temple.explore();
  }
  
  public static void testMirrorArms(){
	  Picture snow = new Picture("snowman.jpg");
	  snow.mirrorArms();
	  snow.explore();
  }
  
  public static void testMirrorGull(){
	  Picture gull = new Picture("seagull.jpg");
	  gull.mirrorGull();
	  gull.explore();
  }
  
  public static void testCopy(Picture fromPic, 
          int startRow, int startCol){
	  Picture gull = new Picture("seagull.jpg");
	  gull.copy(gull, 500, 500);
	  gull.explore();	  
  }
  
  public static void testSpecificCopy(){
	  Picture gull = new Picture("seagull.jpg");
	  Picture moto = new Picture("redMotorcycle.jpg");
	  gull.specificCopy(moto, 331, 234, 600, 600);
	  gull.explore();	  
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  public static void testMyCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.myCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
	//testMirrorVerticalRightToLeft();
	//testMirrorHorizontal();
	//testMirrorHorizontalBotToTop();
	//testMirrorDiagonal();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
	//testSpecificCopy();
	//testMyCollage();
    testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}