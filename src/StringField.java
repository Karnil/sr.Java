import java.lang.reflect.Field;
import java.util.Objects;

class StringField extends CustomField {
    StringField(Field field) {
        super(field);
    }

    String getValue(Object instance) {
        String i = "";
        try { i = String.class.cast(f.get(instance)); } catch (IllegalAccessException e) { e.printStackTrace(); }
        return i;
    }

    public byte[] get(Object instance) { return getValue(instance).getBytes(); }
    public byte[] getPrefix(Objects instance) { return Convertors.int2byte(getValue(instance).length()); }
    public byte[] getPostfix(Objects instance) { return null; }

    public int set(Object instance, byte[] bytes, int offset) {
        int size = Convertors.byte2int(bytes, offset);
        String value = new String(bytes, offset + 4, size);
        try {
            f.set(instance,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        }
        return 4 + size;
    }
}

