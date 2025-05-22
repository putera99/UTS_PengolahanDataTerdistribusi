
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class LeftJoinReducer extends Reducer<Text, Text, NullWritable, Text> {
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        String leftRecord = null;
        List<String> rightRecords = new ArrayList<>();

        for (Text val : values) {
            String value = val.toString();
            if (value.startsWith("left:")) {
                leftRecord = value.substring(5);
            } else if (value.startsWith("right:")) {
                rightRecords.add(value.substring(6));
            }
        }

        if (leftRecord != null) {
            if (rightRecords.isEmpty()) {
                context.write(NullWritable.get(), new Text(leftRecord + ",null,null"));
            } else {
                for (String right : rightRecords) {
                    String[] rightParts = right.split(",");
                    String result = leftRecord + "," + rightParts[1] + "," + rightParts[2];
                    context.write(NullWritable.get(), new Text(result));
                }
            }
        }
    }
}
