import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Created by root on 3/13/15.
 */
class LongField extends CustomField {
    LongField(Field field) {
        super(field);
    }

    long getValue(Object instance) {
        long i = 0;
        try { i = long.class.cast(f.get(instance)); } catch (IllegalAccessException e) { e.printStackTrace(); }
        return i;
    }

    public byte[] get(Object instance) { return Convertors.long2byte(getValue(instance)); }
    public byte[] getPrefix(Objects instance) { return null; }
    public byte[] getPostfix(Objects instance) { return null; }

    public int set(Object instance, byte[] bytes, int offset) {
        long value = Convertors.byte2long(bytes, offset);
        try {
            f.set(instance,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        }
        return 4;
    }
}
