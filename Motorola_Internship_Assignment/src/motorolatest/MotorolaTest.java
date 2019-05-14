package motorolatest;

public class MotorolaTest {

    public static String testMotorola(String s) {
        String lines[] = s.split("\\r?\\n");
        int byteMusic = 0, byteImage = 0, byteMovie = 0, byteOther = 0;
        for (String line : lines) {
            if (line.substring(line.lastIndexOf(".") + 1).substring(0, 3).equals("mp3") || line.substring(line.lastIndexOf(".")).substring(0, 4).equals("flat")) {
                try {
                    byteMusic += Integer.parseInt(line.substring(line.lastIndexOf(" "), line.lastIndexOf("b")).trim());
                } catch (NumberFormatException e) {
                    byteMusic += 0;
                }
            }
            if (line.substring(line.lastIndexOf(".") + 1).substring(0, 3).equals("mp4") || line.substring(line.lastIndexOf(".")).substring(0, 3).equals("avi")) {
                try {
                    byteImage += Integer.parseInt(line.substring(line.lastIndexOf(" "), line.lastIndexOf("b")).trim());
                } catch (NumberFormatException e) {
                    byteImage += 0;
                }
            }
            if (line.substring(line.lastIndexOf(".") + 1).substring(0, 3).equals("jpg") || line.substring(line.lastIndexOf(".")).substring(0, 3).equals("png")) {
                try {
                    byteMovie += Integer.parseInt(line.substring(line.lastIndexOf(" "), line.lastIndexOf("b")).trim());
                } catch (NumberFormatException e) {
                    byteMovie += 0;
                }
            }
            if (line.substring(line.lastIndexOf(".") + 1).substring(0, 3).equals("zip") || line.substring(line.lastIndexOf(".")).substring(0, 2).equals("7z")) {
                try {
                    byteOther += Integer.parseInt(line.substring(line.lastIndexOf(" "), line.lastIndexOf("b")).trim());
                } catch (NumberFormatException e) {
                    byteOther += 0;
                }
            }
        }
        s = "Music " + byteMusic + "b \n" + "Image " + byteImage + "b \n" + "Movie " + byteMovie + "b \n" + "Other " + byteOther + "b \n";
        return s;
    }

    public static void main(String[] args) {
        String S = "Muzyka.mp3 1101b\nMuzyka2.flat 101b\nMuzyka3.version2.mp3 1121b\nImage1.jpg 10b\nothers.ver2.zip 1906b\n";
        System.out.println(S);
        System.out.println(testMotorola(S));
    }
}
