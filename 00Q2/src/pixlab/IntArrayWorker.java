package pixlab;
public class IntArrayWorker
{
  /** two dimensional matrix */
  private int[][] matrix = null;
  
  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
  }
  
  public int getCount(int seek){
	  int count = 0;
	  for(int i = 0; i < matrix.length; i++){
		  for(int h = 0; h < matrix[0].length; h++){
			  if (matrix[i][h] == seek){
				  count++;
			  }
		  }
	  }
	  return count;
  }
  
  /*returns the largest value
  in the matrix. There is already a method to test this in IntArrayWorkerTester. Just
  uncomment the method testGetLargest() and the call to it in the main method of
  IntArrayWorkerTester.*/
  public int getLargest(){
	  int largest = Integer.MIN_VALUE;
	  for(int i = 0; i < matrix.length; i++){
		  for(int h = 0; h < matrix[0].length; h++){
			  if (matrix[i][h] > largest){
				  largest = matrix[i][h];
			  }
		  }
	  }
	  return largest;
  }
  
  /*Write a getColTotal method in the IntArrayWorker class that returns the total of all
integers in a specified column. There is already a method to test this in
IntArrayWorkerTester. Just uncomment the method testGetColTotal() and the
call to it in the main method of IntArrayWorkerTester.*/
  
  public int getColTotal(int column){
	  int total = 0;
	  for(int a = 0; a < matrix.length; a++){
		  total += matrix[a][column];
	  }
	  return total;
  }
  /**
   * Method to return the total 
   * @return the total of the values in the array
   */
  public int getTotal()
  {
    int total = 0;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        total = total + matrix[row][col];
      }
    }
    return total;
  }
  
  /**
   * Method to return the total using a nested for-each loop
   * @return the total of the values in the array
   */
  public int getTotalNested()
  {
    int total = 0;
    for (int[] rowArray : matrix)
    {
      for (int item : rowArray)
      {
        total = total + item;
      }
    }
    return total;
  }
  
  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }
  
  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        System.out.print( matrix[row][col] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }
  
  
  /** 
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; 
           col++)
      {
        if (row < col)
          matrix[row][col] = 1;
        else if (row == col)
          matrix[row][col] = 2;
        else
          matrix[row][col] = 3;
      }
    }
  }
 
}