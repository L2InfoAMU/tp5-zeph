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
    private void checkMatrix(Color[][] colors){
        Matrices.requiresRectangularMatrix(colors);
        Matrices.requiresNonZeroDimensions(colors);
        Matrices.requiresNonNull(colors);
    }
    public BruteRasterImage(Color[][] colors){
        checkMatrix(colors);
        this.width = Matrices.getColumnCount(colors);
        this.height = Matrices.getRowCount(colors);
        this.matrice = colors;
    }


    public void createRepresentation(){
        matrice = new Color[width][height];
    }
    public  void setPixelColor(Color color,int x,int y){
        checkMatrix(matrice);
        matrice[x][y] = color;
    }
    public Color getPixelColor(int x, int y){
        return matrice[x][y];
    }
    private void setPixelsColor(Color[][] pixels){
        checkMatrix(pixels);
        checkMatrix(matrice);
        if(width != Matrices.getColumnCount(pixels) || height != Matrices.getRowCount(pixels))
            throw new IllegalArgumentException("Both Matrix must have the same size");
        for(int i = 0;i<this.width;i++){
            for(int j = 0;j<this.height;j++){
                matrice[i][j]=pixels[i][j];
            }
        }
    }
    private void setPixelsColor(Color color){
        checkMatrix(matrice);
        for(int i = 0;i<this.width;i++){
            for(int j = 0;j<this.height;j++){
                matrice[i][j]=color;
            }
        }

    }
    public int getWidth(){
        return width;
    }
    public  int getHeight(){
        return height;
    }
    protected void setWidth(int width){
        this.width = width;
    }
    protected void setHeight(int height){
        this.height = height;
    }

}
