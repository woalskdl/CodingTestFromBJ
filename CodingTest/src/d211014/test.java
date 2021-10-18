package d211014;

public class test {
    public static void main(String[] args) {
        String a = " a\"b.0cd-e f   g   -";
        System.out.println(a.replaceAll("-", "").replaceAll("\\.0", "").replaceAll("\"", "").trim());
        System.out.println(" ".equals(" "));
    }
}
