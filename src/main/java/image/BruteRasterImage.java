package image;
import javafx.scene.paint.Color;
import util.Matrices;


public class BruteRasterImage implements Image{

    private int width;
    private int height;
    private Color[][] matrice;

    public BruteRasterImage(Color color, int width, int height){

        this.width = width;
        this.height = height;
        matrice = new Color[this.width][this.height];
        for(int i = 0;i<this.width;i++){
            for(int j = 0;j<this.height;j++){
                matrice[i][j]=color;
            }
        }
    }
    public BruteRasterImage(Color[][] colors){
        Matrices.requiresRectangularMatrix(colors);
        Matrices.requiresNonZeroDimensions(colors);
        Matrices.requiresNonNull(colors);
        this.width = Matrices.getColumnCount(colors);
        this.height = Matrices.getRowCount(colors);
        this.matrice = colors;
    }

    public void createRepresentation(){
        matrice = new Color[width][height];
    }
    public  void setPixelColor(Color color,int x,int y){

    }
}
