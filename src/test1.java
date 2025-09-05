public class test1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Face red = new Face(9, 'r');
        red.setRow(0, new char[]{'b', 'b', 'g'});
        red.setRow(2, new char[]{'y', 'y', 'w'});
        System.out.println(red.toString());
        red.rotateClockwise();
        System.out.println(red.toString());
        red.rotateAntiClockwise();
        System.out.println(red.toString());
    }
}

