/**
 * Created by iurii on 3/10/15.
 * It's me
 */

class Convertors {
    public static byte[] int2byte(int x) { return new byte[]{ (byte)(x & 0xff), (byte)(x>>8 & 0xff), (byte)(x>>16 & 0xff), (byte)(x>>24 & 0xff)}; }
    public static byte[] long2byte(long x) { return new byte[]{ (byte)(x & 0xff), (byte)(x>>8 & 0xff), (byte)(x>>16 & 0xff), (byte)(x>>24 & 0xff)}; }
    public static byte[] short2byte(short x) { return new byte[]{ (byte)(x & 0xff), (byte)(x>>8 & 0xff)}; }
    public static byte[] bool2byte(boolean x) { return new byte[]{ (byte)(x?0xff:0x00) }; }
    public static byte[] char2byte(char x) { return new byte[]{ (byte)x }; }

    public static int byte2int(byte[] bytes, int offset) { return bytes[offset] | bytes[offset+1]<<8 | bytes[offset+2]<<16 | bytes[offset+3]<<24; }
    public static long byte2long(byte[] bytes, int offset) { return bytes[offset] | bytes[offset+1]<<8 | bytes[offset+2]<<16 | bytes[offset+3]<<24; }
    public static short byte2short(byte[] bytes, int offset) { return (short) (bytes[offset] | bytes[offset+1]<<8); }
    public static boolean byte2bool(byte[] bytes, int offset) { return bytes[offset] == (byte)0xff; }
    public static char byte2char(byte[] bytes, int offset) { return (char)bytes[offset]; }
}
