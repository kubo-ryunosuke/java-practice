import java.io.FileWriter;
import java.io.IOException;

public class ErrorHandling {
    public static void run() {
        System.out.println("[1] 独自例外と検査例外");
        try {
            checkValue(-1);
        } catch (BusinessException e) {
            System.out.println(" - Catch成功: " + e.getMessage());
        }

        System.out.println("[2] try-with-resources (自動close)");
        writeFile();
    }

    // 独自例外クラス
    static class BusinessException extends Exception {
        public BusinessException(String message) {
            super(message);
        }
    }

    // 例外を投げるメソッド
    static void checkValue(int val) throws BusinessException {
        if (val < 0) throw new BusinessException("値がマイナスです");
    }

    static void writeFile() {
        try (FileWriter writer = new FileWriter("test_output.txt")) {
            writer.write("Hello form ErrorHandling.java");
            System.out.println(" - ファイル書き込み完了");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
