import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public class BonusCalculator {
    // 社員レコード
    record Employee(String name, LocalDate joinDate, Integer departmentId, Integer baseAllowance) {}
    // 集計対象部署ID
    private static final List<Integer> TARGET_DEPTS = List.of(10, 20);

    public static void run() {
        // テストデータ（不完全なデータや対象外を含む）
        List<Employee> employees = List.of(
            new Employee("佐藤", LocalDate.of(2015, 4, 1), 10, 5000),  // 対象：営業(10)
            new Employee("鈴木", LocalDate.of(2020, 10, 1), 20, null), // 対象：開発(20), 手当null
            new Employee("高橋", LocalDate.of(2023, 4, 1), 10, 3000),  // 対象：営業(10), 新人
            new Employee("田中", LocalDate.of(2010, 1, 1), 99, 10000), // 対象外：役員(99)
            new Employee("伊藤", LocalDate.of(2018, 6, 1), null, 5000) // 対象外：部署未定(null)
        );

        // 勤続特別手当を計算
        List<String> report = calcAllowanceReport(employees, LocalDate.now());

        // 結果出力
        report.forEach(System.out::println);
    }

    static List<String> calcAllowanceReport(List<Employee> list, LocalDate targetDate) {
        record AllowanceResult(String name, long years, int totalAmount) {}

        return list.stream()
            .filter(e -> e.departmentId() != null && TARGET_DEPTS.contains(e.departmentId()))
            .map(e -> {
                long years = ChronoUnit.YEARS.between(e.joinDate(), targetDate);
                var baseAllowance = Optional.ofNullable(e.baseAllowance());
                int amount = (int) years * 10000 + baseAllowance.orElse(0); // note: 勉強でなら強引にキャストで許容
                return new AllowanceResult(e.name(), years, amount);
            })
            .map(r -> "名前: %s / 年数: %d / 支給額: %d円".formatted(r.name(), r.years(), r.totalAmount()))
            .toList();
    }
}
