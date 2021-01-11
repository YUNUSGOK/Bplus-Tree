import java.util.ArrayList;

public class CengTreeNodeInternal extends CengTreeNode
{
    private ArrayList<Integer> keys;
    public ArrayList<CengTreeNode> children;

    public CengTreeNodeInternal(CengTreeNode parent)
    {
        super(parent);

        // TODO: Extra initializations, if necessary.
        keys = new ArrayList<>();
        children = new ArrayList<>();
        type = CengNodeType.Internal;
    }

    // GUI Methods - Do not modify
    public ArrayList<CengTreeNode> getAllChildren()
    {
        return this.children;
    }
    public Integer keyCount()
    {
        return this.keys.size();
    }
    public Integer keyAtIndex(Integer index)
    {
        if(index >= this.keyCount() || index < 0)
        {
            return -1;
        }
        else
        {
            return this.keys.get(index);
        }
    }

    @Override
    public void add(CengVideo video) {
        Integer key = video.getKey();
        int index = 0;

        for(Integer k: keys){
            if(k<key){
                index ++;
            }
            else{
                break;
            }
        }
        CengTreeNode child = children.get(index);
        child.add(video);
        if(child.isFull()){
            CengTreeNode newChild = child.split();
            this.addKey(newChild.keyAtZero());
            this.addChild(newChild);
        }

    }

    @Override
    public boolean isFull() {
        return  keys.size() > CengTreeNode.order * 2;
    }

    @Override
    public CengTreeNode split() {
        int n = children.size();
        int m = keys.size();
        int mid = n/2;

        CengTreeNodeInternal rightNode = new CengTreeNodeInternal(null);
        ArrayList<CengTreeNode> rightChildren = new ArrayList<>();
        ArrayList<Integer> rightKeys = new ArrayList<>();
        for(int i=mid; i<n; i++ ){
            rightNode.addChild(children.get(i));
            rightChildren.add(children.get(i));
        }
        mid = m/2;
        for(int i=mid+1; i<m; i++ ){

            rightNode.addKey(keys.get(i));
            rightKeys.add(keys.get(i));
        }
        keys.removeAll(rightKeys);
        keys.remove(mid);
        children.removeAll(rightChildren);

        return rightNode;
    }

    @Override
    public int keyAtZero() {
        return this.keyAtIndex(0);
    }

    @Override
    public int keyAtMid() {
        return this.keyAtIndex(keys.size()/2);
    }

    public void addKey(Integer key){
        int n = keys.size();
        int index = 0;
        for(int i=0; i < n ; i++ ){
            if(keys.get(i) > key) {
                break;
            }
            index++;
        }
        keys.add(index, key);

    }
    public void addChild(CengTreeNode newChild){
        int key = newChild.keyAtZero();
        int n = children.size();
        int index = 0;
        for(int i=0; i < n ; i++ ){
            if(children.get(i).keyAtZero() > key) {
                break;
            }
            index++;
        }
        children.add(index,newChild);

        newChild.setParent(this);

    }
}
