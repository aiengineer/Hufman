
public class Node {
    private char name;
    private int wieght;
    private int code;
    private Node left;
    private Node right;
    private Node parent;
    public Node(){
    }
    public char getName() {
        return name;
    }
    public void setName(char name) {
        this.name = name;
    }
    public int getWieght() {
        return wieght;
    }
    public void setWieght(int wieght) {
        this.wieght = wieght;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public Node getParent() {
        return parent;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
}
