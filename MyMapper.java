
import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable, Text, DoubleWritable, IntWritable> {
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        // Implementasi logika Map di sini
    }
}
