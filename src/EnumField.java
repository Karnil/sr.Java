import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Created by root on 3/13/15.
 */
class EnumField extends CustomField {
    EnumField(Field field) {
        super(field);
    }

    Enum getValue(Object instance) {
        Enum i = null;
        try {
            i = Enum.class.cast(f.get(instance));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return i;
    }

    public byte[] get(Object instance) {
        return Convertors.int2byte(getValue(instance).ordinal());
    }

    public byte[] getPrefix(Objects instance) {
        return null;
    }

    public byte[] getPostfix(Objects instance) {
        return null;
    }

    public int set(Object instance, byte[] bytes, int offset) {
        int ordinary = Convertors.byte2int(bytes, offset);
        Class enumClass = f.getType();
        Enum value = (Enum)(enumClass.getEnumConstants()[ordinary]);
        try {
            f.set(instance, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        }
        return 4;
    }
}
