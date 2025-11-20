import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class DataProcessing {

    record Staff(String name, int age) {}

    public static void run() {
        var staffList = List.of(
            new Staff("Sato", 25),
            new Staff("Suzuki", 40),
            new Staff("Takahashi", 32)
        );

        System.out.println("[1] Stream API (filter & map)");
        List<String> result = staffList.stream()
            .filter(s -> s.age() >= 30)         // 30歳以上を抽出
            .map(s -> s.name().toUpperCase())   // 名前を大文字に変換
            .toList();
        System.out.println(" - 対象者: " + result);


        System.out.println("[2] Date and Time API");
        LocalDate today = LocalDate.now();
        LocalDate joinDate = LocalDate.of(2020, 4, 1);

        long days = ChronoUnit.DAYS.between(joinDate, today);
        System.out.println(" - 今日: " + today);
        System.out.println(" - 入社経過日数: " + days + "日");
    }
}