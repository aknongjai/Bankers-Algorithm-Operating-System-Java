import java.util.Scanner;
class data{
    Scanner scan=new Scanner(System.in);
    public void getMatrix(int[][] matrix,int matrixRow,int matrixCol) {
       // matrix = new int[matrixRow][matrixCol];
        System.out.println("Enter Matrix Data");
        for (int i = 0; i < matrixRow; i++)
        {
            for (int j = 0; j < matrixCol; j++)
            {
                matrix[i][j] = scan.nextInt();
            }
        }

    }
    public void printMatrix(int[][] mat,int matrixRow,int matrixCol){
        System.out.println("Your Matrix is : ");
        for (int i = 0; i < matrixRow; i++)
        {
            for (int j = 0; j < matrixCol; j++)
            {
                System.out.print(mat[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
public class BankersAlgm {
    static int row=5;
    static int col=4;
    static int sum[]={0,0,0,0};
    private static int available[]={1,5,2,0};
    private static int[][] allocation=new int[row][col];
    private static int[][] max=new int[row][col];
    private static int[][] need=new int[row][col];
    private static void setTheMatrices(data ex){
        ex.getMatrix(allocation,row,col);
        ex.getMatrix(max,row,col);
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                need[i][j] =(max[i][j]-allocation[i][j]);
                sum[j]+=allocation[i][j];
            }
        }
        for (int j = 0; j < col; j++){
            sum[j]+=available[j];//sum completed;
        }
        ex.printMatrix(allocation,row,col);
        ex.printMatrix(max,row,col);
        ex.printMatrix(need,row,col);
    }
    public static int chekAlloc(int i){
        int q=0;
        for(int j=0;j<col;j++){
            if(allocation[i][j]==0){
                q=1;
            }
            else {
                q=0;
                break;
            }
        }
        if(q==1)
            return 1;
        else
            return 0;

    }
    public static void main(String[] args) {
        int flag = 0;
        data d = new data();
        setTheMatrices(d);
        for (int x=0;x<2;x++){
        for (int i = 0; i < row; i++) {
            if(chekAlloc(i)==0){
            for (int j = 0; j < col; j++) {

                if (need[i][j] == 0) {
                    flag = 1;
                } else {
                    System.out.println("No chance this time ");
                    flag = 0;
                    break;
                }
            }
            }
            if (flag == 0) {
                if(chekAlloc(i)==0){
                for (int j = 0; j < col; j++) {
                    if (need[i][j] < available[j]) {
                        flag = 2;
                    } else {
                        System.out.println("No chance this time too");
                        flag = 0;
                        break;
                    }
                }
                }
            }
            if (flag == 1) {
                flag=100;
                System.out.println("The process "+i+" was holding enough resources so executed and the rescources are now freed");
                for (int j = 0; j < col; j++) {
                    available[j] = available[j] + allocation[i][j];
                    allocation[i][j]=0;
                }
            }
            if (flag == 2) {
                flag=100;
                System.out.println("The process "+i+" gets the needed rescource from the available and the rescources are now freed");
                for (int j = 0; j < col; j++) {
                    available[j] = available[j] + allocation[i][j];
                    allocation[i][j]=0;
                }
            }
        }
    }
        for (int i=0;i<col;i++){
            if(sum[i]==available[i]){
                flag=5;
            }
            else flag=9;
        }
        if(flag==5)
            System.out.println("yea safe sequence");
        else
            System.out.println("Nah no safe sequence");
    }
}
/*All Rights Reserved
Nongjaimayum Annas khan
Husband of Ph Tabasum Sahani
*/