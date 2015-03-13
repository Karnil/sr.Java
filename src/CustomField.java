import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Created by root on 3/13/15.
 */
abstract class CustomField implements iCustomField{
    Field f = null;
    CustomField(Field field) { f = field; }

    public int get(Objects instance, byte[] bytes, int offset) {
        byte[] values;
        int returLength = 0;

        while((values = getPrefix(instance)) != null) {
            System.arraycopy(bytes, 0, values, offset + returLength, values.length);
            returLength += values.length;
        }

        if ((values = get(instance)) != null) {
            System.arraycopy(bytes, 0, values, offset + returLength, values.length);
            returLength += values.length;
        }

        if ((values = getPostfix(instance)) != null) {
            System.arraycopy(bytes, 0, values, offset + returLength, values.length);
            returLength += values.length;
        }

        return returLength;
    }

    public abstract byte[] get(Object instance);
    public abstract int set(Object instance, byte[] bytes, int offset);
    public abstract byte[] getPrefix(Objects instance);
    public abstract byte[] getPostfix(Objects instance);
}
