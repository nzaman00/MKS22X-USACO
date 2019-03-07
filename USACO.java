public class USACO{
  public static int bronze(String filename){
    int r, c, e, n;
    File lake = new File(filename);
    Scanner lakeler = new Scanner(lake);
    r = lakeler.nextInt();
    c = lakeler.nextInt();
    e = lakeler.nextInt();
    n = lakeler.nextInt();
    lakeler = new Scanner(lake);
    lakeler.nextLine();
    String n = lakeler.nextLine();
    lakeler = new Scanner(lake);
    int a = 0;
    while (lakeler.hasNextLine()){
      lakeler.nextLine();
      a++;
    }
    lakeler = new Scanner(lake);
    int[][] elevations = new int[n.length()][a - 1 - n];
    int[][] directions;
    private int[][] stomp(int r, int c, int inches){
     private int[]gridElevations = new int[9];
       gridElevations[0] = elevations[r][c];
        gridElevations[1] = elevations[r+1][c];
        gridElevations[2] = elevations[r+2][c];
        gridElevations[3] = elevations[r+1][c+1];
        gridElevations[4]= elevations[r+1][c+2];
        gridElevations[5] = elevations[r+2][c+1];
        gridElevations[6] = elevations[r+2][c+2];
        gridElevations[7] = elevations[r][c+1];
        gridElevations[8] = elevations[r][c+2];
      int max = gridElevations[0];
      for(int i = 0; i < gridElevations.length;i++){
        if(gridElevations[i] > max)
          max = gridElevations[i];
      }
      int height = max - inches;
      
    }
 }

  public static int silver(String filename){
    
  }

}
