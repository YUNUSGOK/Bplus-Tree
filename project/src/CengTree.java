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

        ArrayList<CengTreeNode> path = new ArrayList<>();
        if(root.find(key, path, 0)){
            for(int i=0; i<path.size(); i++){
                if(path.get(i).getType()==CengNodeType.Internal){
                    CengTreeNodeInternal n = (CengTreeNodeInternal) path.get(i);
                    n.printCurrent(i);
                }
                else {
                    CengTreeNodeLeaf n = (CengTreeNodeLeaf) path.get(i);
                    for(int j=0; j<n.videoCount();j++){
                        if(n.videoKeyAtIndex(j).equals(key)){
                            n.printVideo(j,i);
                            break;
                        }
                    }
                }
            }
            return path;
        }
        else{
            System.out.println("Could not find "+ key.toString()+"." );
        }
        return null;
    }

    public void printTree()
    {
        root.print(0);
    }

    // Any extra functions...
}
