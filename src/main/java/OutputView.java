public class OutputView {
    public void printLadder(String[][] ladder) {
        for (String[] strings : ladder) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}