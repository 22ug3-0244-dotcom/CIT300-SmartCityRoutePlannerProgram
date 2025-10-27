public class AVLNode {
    Location data;     
    AVLNode left;     
    AVLNode right;      
    int height;         

    public AVLNode(Location data) {
        this.data = data;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}