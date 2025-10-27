public class LocationAVLTree {
    private AVLNode root;

    
    private int height(AVLNode n) {
        return (n == null) ? 0 : n.height;
    }

    
    private int getBalance(AVLNode n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }


    private AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    
    private AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        AVLNode t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    
    public void insert(Location loc) {
        root = insertRec(root, loc);
        System.out.println("✅ Added location to tree: " + loc.getName());
    }

    private AVLNode insertRec(AVLNode node, Location loc) {
        if (node == null) return new AVLNode(loc);

        
        if (loc.getName().compareToIgnoreCase(node.data.getName()) < 0)
            node.left = insertRec(node.left, loc);
        else if (loc.getName().compareToIgnoreCase(node.data.getName()) > 0)
            node.right = insertRec(node.right, loc);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);
        if (balance > 1 && loc.getName().compareToIgnoreCase(node.left.data.getName()) < 0)
            return rotateRight(node);
        if (balance < -1 && loc.getName().compareToIgnoreCase(node.right.data.getName()) > 0)
            return rotateLeft(node);
        if (balance > 1 && loc.getName().compareToIgnoreCase(node.left.data.getName()) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && loc.getName().compareToIgnoreCase(node.right.data.getName()) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }
    public void displayAll() {
        System.out.println("\n--- Locations (In-Order) ---");
        displayRec(root);
        System.out.println();
    }

    private void displayRec(AVLNode node) {
        if (node != null) {
            displayRec(node.left);
            System.out.println(node.data.toString());
            displayRec(node.right);
        }
    }
}