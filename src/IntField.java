import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Created by root on 3/13/15.
 */
class IntField extends CustomField {
    IntField(Field field) {
        super(field);
    }

    int getValue(Object instance) {
        int i = 0;
        try { i = int.class.cast(f.get(instance)); } catch (IllegalAccessException e) { e.printStackTrace(); }
        return i;
    }

    public byte[] get(Object instance) {
        return Convertors.int2byte(getValue(instance));
    }
    public byte[] getPrefix(Objects instance) { return null; }
    public byte[] getPostfix(Objects instance) { return null; }

    public int set(Object instance, byte[] bytes, int offset) {
        int value = Convertors.byte2int(bytes, offset);
        try {
            f.set(instance,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        }
        return 4;
    }
}
