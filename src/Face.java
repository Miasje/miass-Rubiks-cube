import java.util.Arrays;

import static java.lang.Math.sqrt;

public class Face {
    //attributes
    private final int size;
    private final int sqrtSize;

    private char[][] face;

    //constructors
    public Face(int size, char colour){
        this.size = size;
        int sqrtSize = (int) sqrt(size);
        this.sqrtSize = sqrtSize;
        char[] row = new char[sqrtSize];
        char[][] face = new char[sqrtSize][];
        Arrays.fill(row, colour);
        Arrays.fill(face, row);
        this.face = face;
    }

    //methods
    //get methods
    public char[][] getFace(){
        return face;
    }

    public char[] getRow(int n){
        return face[n];
    }

    public char[] getColumn(int n){
        char[] column = new char[sqrtSize];
        for (int i = 0; i < sqrtSize; i++){
            column[i] = face[i][n];
        }
        return column;
    }

    public char[] getReverseColumn(int n){
        char[] column = new char[sqrtSize];
        for (int i = 0; i < sqrtSize; i++){
            column[i] = face[sqrtSize-1-i][n];
        }
        return column;
    }

    //set methods
    public void setRow(int n, char[] newRow){
        face[n] = newRow;
    }

    public void setColumn(int n, char[] newColumn){
        for(int i = 0; i < sqrtSize; i++){
            face[i][n] = newColumn[i];
        }
    }

    private void setFace(char[][] newFace){
        face = newFace;
    }

    //other methods

    public void rotateClockwise(){
        char[][] newFace = new char[sqrtSize][sqrtSize];
        for(int i = 0; i < sqrtSize; i++){
            newFace[i] = getReverseColumn(i);
        }
        setFace(newFace);
    }

    public void rotateAntiClockwise(){
        char[][] newFace = new char[sqrtSize][sqrtSize];
        for(int i = 0; i < sqrtSize; i++){
            newFace[i] = getColumn(sqrtSize-i-1);
        }
        setFace(newFace);
    }

    public String[] toListOfStrings(){
        String[] stringFace = new String[sqrtSize];
        for (int j = 0; j < sqrtSize; j++) {
            for (int i = 0; i < sqrtSize; i++) {
                if (i == 0) {
                    stringFace[j] = "[ " + face[j][i] + " ";
                } else if (i == sqrtSize - 1) {
                    stringFace[j] += face[j][i] + " ]\n";
                } else {
                    stringFace[j] += face[j][i] + ", ";
                }
            }
        }
        return stringFace;
    }

    public String toString(){
        String[] list = toListOfStrings();
        StringBuilder string = new StringBuilder();
        for(String str : list){
            string.append(str);
        }
        return string.toString();
    }
}

























