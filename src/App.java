public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Javaリカレント学習 実行開始 ===");

        printSeparator(1, "DataTypeBasics (型とデータ定義)");
        DataTypeBasics.run();

        printSeparator(2, "DataProcessing (処理と日付)");
        DataProcessing.run();

        printSeparator(3, "SafetyAndEquality (安全性と等価性)");
        SafetyAndEquality.run();

        printSeparator(4, "ErrorHandling (例外とリソース)");
        ErrorHandling.run();
        
        System.out.println("\n=== 全工程終了 ===");
    }

    private static void printSeparator(int hour, String title) {
        System.out.println("\n--------------------------------------------------");
        System.out.println("【Hour " + hour + "】" + title);
        System.out.println("--------------------------------------------------");
    }
}
