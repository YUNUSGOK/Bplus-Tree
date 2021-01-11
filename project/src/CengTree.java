import java.util.ArrayList;

public class CengTree
{
    public CengTreeNode root;
    // Any extra attributes...

    public CengTree(Integer order)
    {
        CengTreeNode.order = order;
        // TODO: Initialize the class
        root = new CengTreeNodeLeaf(null);

    }

    public void addVideo(CengVideo video)
    {
        // TODO: Insert Video to Tree

        root.add(video);
        if( root.isFull()){
            CengTreeNodeInternal newRoot = new CengTreeNodeInternal(null);
            int mid = root.keyAtMid();
            CengTreeNode newChild = root.split();
            newRoot.addKey(mid);
            newRoot.addChild(root);
            newRoot.addChild(newChild);
            root = newRoot;
        }
    }

    public ArrayList<CengTreeNode> searchVideo(Integer key)
    {
        // TODO: Search within whole Tree, return visited nodes.
        // Return null if not found.

        return null;
    }

    public void printTree()
    {
        // TODO: Print the whole tree to console
    }

    // Any extra functions...
}
