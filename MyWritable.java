
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;

public class MyWritable implements Writable {
    private String stringParam;
    private int intParam;
    private float floatParam;
    private double doubleParam;

    // Getters
    public String getStringParam() {
        return stringParam;
    }

    public int getIntParam() {
        return intParam;
    }

    public float getFloatParam() {
        return floatParam;
    }

    public double getDoubleParam() {
        return doubleParam;
    }

    // Setters
    public void setStringParam(String stringParam) {
        this.stringParam = stringParam;
    }

    public void setIntParam(int intParam) {
        this.intParam = intParam;
    }

    public void setFloatParam(float floatParam) {
        this.floatParam = floatParam;
    }

    public void setDoubleParam(double doubleParam) {
        this.doubleParam = doubleParam;
    }

    // Serialization
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(stringParam);
        out.writeInt(intParam);
        out.writeFloat(floatParam);
        out.writeDouble(doubleParam);
    }

    // Deserialization
    @Override
    public void readFields(DataInput in) throws IOException {
        stringParam = in.readUTF();
        intParam = in.readInt();
        floatParam = in.readFloat();
        doubleParam = in.readDouble();
    }
}
