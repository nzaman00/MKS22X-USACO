import java.util.*;
import java.io.*;

public class USACO{
  public static int bronze(String filename) throws FileNotFoundException{
    File file = new File(filename);
    Scanner scan = new Scanner(file);

    String[] RCEN = scan.nextLine().split(" ");
    int r = Integer.parseInt(RCEN[0]);
    int c = Integer.parseInt(RCEN[1]);
    int e = Integer.parseInt(RCEN[2]);
    int n = Integer.parseInt(RCEN[3]);

    int[][] lake = new int[r][c];
    for(int i = 0; i < r; i++){
      for (int j = 0; j < c; j++){
        lake[i][j] = scan.nextInt();
      }
    }

    int[][] directions = new int[n][3];
    for(int i = 0; i < n; i++){
      for (int i2 = 0; i2 < 3; i2++){
        directions[i][i2] = scan.nextInt();
        System.out.println(directions[i][i2]);
      }
    }

    for (int dir = 0; dir < directions.length; dir++){
      int row = directions[dir][0] - 1;
      int col = directions[dir][1] - 1;
      int subtract = directions[dir][2];
      int max = 0;

      for (int i = row; i-row < 3 && i < r; i++){
        for (int j = col; j-col < 3 && j < c; j++){
          if (lake[i][j] > max){
            max = lake[i][j];
          }
        }
      }

      max -= subtract;

      for (int i = row; i-row < 3 && i < r; i++){
        for (int j = col; j-col < 3 && j < c; j++){
          if (lake[i][j] > max){
            lake[i][j] = max;
          }
        }
      }

      for (int r1 = 0; r1 < lake.length; r1++){
        for (int c1 = 0; c1 < lake[0].length; c1++){
          System.out.print(lake[r1][c1] + " ");
        }
        System.out.print("\n");
      }
    }


    int totDepth = 0;
    for (int row = 0; row < lake.length; row++){
      for (int col = 0; col < lake[0].length; col++){
        if (e - lake[row][col] > 0){
          totDepth += e - lake[row][col];
        }
      }
    }

    return totDepth * 72 * 72;
  }

  public static int silver(String filename) throws FileNotFoundException{
     int[] moves = new int[] {1, 0, 0, 1, -1, 0, 0, -1};
     File file = new File(filename);
     Scanner scanner = new Scanner(file);
     int rows = scanner.nextInt();
     int cols = scanner.nextInt();
     int time = scanner.nextInt();
     scanner.nextLine();
     int[][] map = new int[rows][cols];
     for (int i = 0; i < rows; i++) {
       String line = scanner.nextLine();
       for (int j = 0; j < cols; j++) {
         if (line.charAt(j) == '*') {
           map[i][j] = -1;
         }
         if (line.charAt(j) == '.') {
           map[i][j] = 0;
         }
       }
     }
     int startR = scanner.nextInt()-1;
     int startC = scanner.nextInt()-1;
     int endR = scanner.nextInt()-1;
     int endC = scanner.nextInt()-1;
     for (int i = 0; i < moves.length; i+=2) {
       try {
         if (map[startR + moves[i]][startC + moves[i+1]] != -1) {
           map[startR + moves[i]][startC + moves[i+1]] += 1;
         }
       }
       catch(Exception e) {}
     }
     time--;
     boolean go;
     if (startR + startC % 2 == 0) {
       go = false;
     }
     else {
       go = true;
     }
     while (time > 0) {
       for (int r = 0; r < rows; r++) {
         for (int c = 0; c < cols; c++) {
           if (go) {
             if (map[r][c] > 0) {
               for (int i = 0; i < moves.length; i+=2) {
                 try{
                   if (map[r + moves[i]][c + moves[i+1]] != -1) {
                     map[r + moves[i]][c + moves[i+1]] += map[r][c];
                   }
                 }
                 catch(Exception e) {}
               }
               map[r][c] = 0;
             }
             go = false;
           }
           else {
             go = true;
           }
         }
         if (cols % 2 == 0) {
           if (go) {
             go = false;
           }
           else{
             go = true;
           }
         }
       }
       time--;
       if (!(rows % 2 == 1 && cols % 2 == 0)) {
         if (go) {
           go = false;
         }
         else{
           go = true;
         }
       }
     }
     return map[endR][endC];
 }
}
