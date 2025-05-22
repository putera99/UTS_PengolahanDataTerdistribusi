
import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<DoubleWritable, DoubleWritable, Text, DoubleWritable> {
    public void reduce(DoubleWritable key, Iterable<DoubleWritable> values, Context context)
            throws IOException, InterruptedException {
        // Implementasi logika Reduce di sini
    }
}
