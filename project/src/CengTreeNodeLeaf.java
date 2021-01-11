import java.util.ArrayList;

public class CengTreeNodeLeaf extends CengTreeNode
{
    private ArrayList<CengVideo> videos;
    // TODO: Any extra attributes

    public CengTreeNodeLeaf(CengTreeNode parent)
    {
        super(parent);

        // TODO: Extra initializations
        videos = new ArrayList<>();
        type = CengNodeType.Leaf;
    }

    // GUI Methods - Do not modify
    public int videoCount()
    {
        return videos.size();
    }
    public Integer videoKeyAtIndex(Integer index)
    {
        if(index >= this.videoCount()) {
            return -1;
        } else {
            CengVideo video = this.videos.get(index);

            return video.getKey();
        }
    }

    // Extra Functions

    /**
     * Method add the current leaf new video given in parameters
     * @param video: video to added to leaf
     */
    public void add(CengVideo video){
        int n = videos.size();
        int index = 0;


        while(index < n && videos.get(index).getKey() < video.getKey() ){
            index++;
        }
        videos.add(index,video);

    }

    public CengTreeNode split(){
        int n = videos.size();
        int mid = videos.size()/2;

        CengTreeNode rightNode = new CengTreeNodeLeaf(null);
        ArrayList<CengVideo> rightVideos = new ArrayList<>();
        for(int i=mid; i<n; i++ ){
            rightNode.add(videos.get(i));
            rightVideos.add(videos.get(i));
        }
        videos.removeAll(rightVideos);

        return rightNode;
    }

    @Override
    public int keyAtZero() {
        return this.videoKeyAtIndex(0);
    }

    @Override
    public int keyAtMid() {
        return this.videoKeyAtIndex(videos.size()/2);
    }

    @Override
    public boolean find(Integer key, ArrayList<CengTreeNode> path, int level) {
        path.add(this);
        String tabs = "\t";
        for(CengVideo v : videos){
            if(v.getKey()== key){
                return true;
            }
        }
        return false;
    }

    @Override
    public void print(int level) {
        String tabs = "\t";
        if(videos.isEmpty()) return;
        System.out.println(tabs.repeat(level) + "<data>");
        for(int i=0; i<videos.size();i++){
            printVideo(i,level);
        }
        System.out.println(tabs.repeat(level) + "</data>");
    }
    public void printVideo(int index,int level){
        String tabs = "\t";
        CengVideo v = videos.get(index);
        System.out.print(tabs.repeat(level));
        System.out.print("<record>");
        System.out.print(v.getKey()+"|");
        System.out.print(v.getVideoTitle()+"|");
        System.out.print(v.getChannelName()+"|");
        System.out.print(v.getCategory());
        System.out.print("</record>"+"\n");
    }
    @Override
    public boolean isFull() {
        return  videos.size() > CengTreeNode.order * 2;
    }
}
