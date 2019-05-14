package pkg01.codility_binary_gap_java;

public class Codility_Binary_Gap_Java {

    static public int binaryGap(int N) {
        if (N > 0) {
            int max = 0;
            int z;
            String binary = Integer.toBinaryString(N);
            String[] zeroGroups = binary.split("1");
            if (N % 2 == 1) {
                z = zeroGroups.length;
            } else {
                z = zeroGroups.length - 1;
            }
            for (int i = 0; i < z; i++) {
                if (zeroGroups[i].length() > max) {
                    max = zeroGroups[i].length();
                }
            }
            return max;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(999));
        System.out.println(binaryGap(999));
        System.out.println(Integer.toBinaryString(81));
        System.out.println(binaryGap(81));
        System.out.println(Integer.toBinaryString(777));
        System.out.println(binaryGap(777));
        System.out.println(Integer.toBinaryString(513));
        System.out.println(binaryGap(513));
        System.out.println(Integer.toBinaryString(821));
        System.out.println(binaryGap(821));
    }

}
