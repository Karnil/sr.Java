import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Created by root on 3/13/15.
 */
class ShortField extends CustomField {
    ShortField(Field field) {
        super(field);
    }

    short getValue(Object instance) {
        short i = 0;
        try { i = short.class.cast(f.get(instance)); } catch (IllegalAccessException e) { e.printStackTrace(); }
        return i;
    }

    public byte[] get(Object instance) { return Convertors.short2byte(getValue(instance)); }
    public byte[] getPrefix(Objects instance) { return null; }
    public byte[] getPostfix(Objects instance) { return null; }

    public int set(Object instance, byte[] bytes, int offset) {
        short value = Convertors.byte2short(bytes, offset);
        try {
            f.set(instance,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        }
        return 4;
    }
}
