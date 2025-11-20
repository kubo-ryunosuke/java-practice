import java.util.List;

public class DataTypeBasics {
    public static void run() {
        System.out.println("[1] varによる型推論");
        var language = "Modern Java"; // ここでStringに型推論される
        // language = 1; // コンパイルエラー: 型不一致
        System.out.println(" - Language: " + language);


        System.out.println("[2] Record（不変データクラス）");
        record Employee(String name, Integer id) {}

        // Recordは
        var emp = new Employee("Tanaka", 101);
        System.out.println(" - " + emp);
        // getter/setterなどが自動生成
        System.out.println(" - " + emp.name());
        System.out.println(" - " + emp.id());
        System.out.println(" - " + emp.equals(null));
        System.out.println(" - " + emp.hashCode());
        System.out.println(" - " + emp.toString());


        System.out.println("[3] List.of (不変リスト)");
        List<String> list = List.of("A", "B", "C");
        System.out.println(" - List: " + list);


        System.out.println("[4] プリミティブ vs ラッパー");
        Integer wrapperNum = null;
        try {
            int primitiveNum = wrapperNum; // Auto-boxing error
        } catch (NullPointerException e) {
            System.out.println("- ★NPE検出: nullのIntegerをintには変換できません");
        }
    }
}
