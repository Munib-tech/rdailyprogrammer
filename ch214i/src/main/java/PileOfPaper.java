import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mramos on 9/17/2015.
 */
public class PileOfPaper {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        Sheet[][] coords = new Sheet[y][x];
        for (int i = 0; i < coords.length; i++) {
            for (int j = 0; j < coords[i].length; j++) {
                coords[i][j] = new Sheet(0, new Point(i, j));
            }
        }

        display(putSheet(coords, 1, new Point(5, 5), 10, 3));
        display(putSheet(coords, 2, new Point(0, 0), 7, 7));
        areaByColor(coords);
    }

    public static Sheet[][] putSheet(Sheet[][] coords, int color, Point point, int width, int height){
        for (int i = point.y; i < point.y+height ; i++) {
            for (int j = point.x; j < point.x+width; j++) {
                coords[i][j].setColor(color);
            }
        }
        return coords;
    }

    public static void areaByColor(Sheet[][] coords){
        Map<Integer, Integer> areasByColor = new HashMap<>();
        for (Sheet[] coord : coords) {
            for (Sheet sheet : coord) {
                if(areasByColor.containsKey(sheet.getColor())){
                    areasByColor.put(sheet.getColor(), areasByColor.get(sheet.getColor())+1);
                }else{
                    areasByColor.put(sheet.getColor(), 1);
                }
            }
        }

        //print map
        areasByColor.forEach((k,v)-> System.out.println(k+" "+v));
    }
    public static void display(Sheet[][] coords){
        for (Sheet[] coord : coords) {
            for (Sheet sheet : coord) {
                System.out.print(sheet.getColor());
            }
            System.out.println("");
        }
    }
}

class Sheet{
    private int color;
    private Point point;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Sheet(int color, Point point) {
        this.color = color;
        this.point = point;
    }
}
