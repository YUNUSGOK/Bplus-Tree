import java.util.ArrayList;

public class CengTreeNodeLeaf extends CengTreeNode
{
    private ArrayList<CengVideo> videos;
    // TODO: Any extra attributes

    public CengTreeNodeLeaf(CengTreeNode parent)
    {
        super(parent);

        // TODO: Extra initializations
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

}
