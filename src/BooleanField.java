import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Created by root on 3/13/15.
 */
class BooleanField extends CustomField {
    BooleanField(Field field) {
        super(field);
    }

    Boolean getValue(Object instance) {
        Boolean i = false;
        try { i = Boolean.class.cast(f.get(instance)); } catch (IllegalAccessException e) { e.printStackTrace(); }
        return i;
    }

    public byte[] get(Object instance) { return Convertors.bool2byte(getValue(instance)); }

    public byte[] getPrefix(Objects instance) { return null; }
    public byte[] getPostfix(Objects instance) { return null; }

    public int set(Object instance, byte[] bytes, int offset) {
        boolean value = Convertors.byte2bool(bytes, offset);
        try {
            f.set(instance,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
