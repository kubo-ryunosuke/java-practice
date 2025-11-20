import java.util.Optional;

public class SafetyAndEquality {
    public static void run() {
        System.out.println("[1] Optional (Null安全)");
        Optional<String> emptyData = Optional.empty();

        // 値がない場合のフォールバック
        String value = emptyData.orElse("デフォルト値");
        System.out.println(" - 結果: " + value);


        System.out.println("[2] 等価性の比較 (== vs equals)");
        String s1 = "Java";
        String s2 = new String("Java");

        // 参照比較(NG)
        if (s1 == s2) {
            System.out.println(" - [×] == で一致しました");
        } else {
            System.out.println(" - [○] == は不一致 (別インスタンスのため)");
        }

        // 内容比較(OK)
        if (s1.equals(s2)) {
            System.out.println(" - [○] equals は一致 (中身が同じため)");
        }


        System.out.println("[3] StringBuilder (文字列結合)");
        StringBuilder sb = new StringBuilder();
        sb.append("User:").append("Admin").append(", Role: ").append("Manager");
        System.out.println(" - " + sb.toString());
    }
}
