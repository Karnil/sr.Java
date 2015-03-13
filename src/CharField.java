import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Created by root on 3/13/15.
 */
class CharField extends CustomField {
    CharField(Field field) {
        super(field);
    }

    char getValue(Object instance) {
        char i = 0;
        try {
            i = char.class.cast(f.get(instance));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return i;
    }

    public byte[] get(Object instance) {
        return Convertors.char2byte(getValue(instance));
    }

    public byte[] getPrefix(Objects instance) {
        return null;
    }

    public byte[] getPostfix(Objects instance) {
        return null;
    }

    public int set(Object instance, byte[] bytes, int offset) {
        char value = Convertors.byte2char(bytes, offset);
        try {
            f.set(instance, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
