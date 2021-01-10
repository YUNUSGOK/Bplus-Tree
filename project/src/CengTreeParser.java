import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CengTreeParser
{
    public static ArrayList<CengVideo> parseVideosFromFile(String filename)
    {
        ArrayList<CengVideo> videoList = new ArrayList<CengVideo>();

        // You need to parse the input file in order to use GUI tables.
        // TODO: Parse the input file, and convert them into CengVideos
        String record;
        String[] recordFields;

        Integer key;
        String videoTitle;
        String channelName;
        String category;

        CengVideo video;

        File file = new File(filename);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(sc.hasNext()){
            record  = sc.nextLine(); // read file line by line
            recordFields = record.split("\\|"); // split a record to its fields by | delimiter
            key = Integer.parseInt(recordFields[0]);
            videoTitle = recordFields[1];
            channelName = recordFields[2];
            category = recordFields[3];
            video = new CengVideo(key,videoTitle,channelName,category); //video object from readed record
            videoList.add(video);
        }
        return videoList;
    }

    public static void startParsingCommandLine() throws IOException
    {
        // TODO: Start listening and parsing command line -System.in-.
        // There are 4 commands:
        // 1) quit : End the app, gracefully. Print nothing, call nothing, just break off your command line loop.
        // 2) add : Parse and create the video, and call CengVideoRunner.addVideo(newlyCreatedVideo).
        // 3) search : Parse the key, and call CengVideoRunner.searchVideo(parsedKey).
        // 4) print : Print the whole tree, call CengVideoRunner.printTree().

        // Commands (quit, add, search, print) are case-insensitive.
    }
}
