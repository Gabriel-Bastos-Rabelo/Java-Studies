import java.util.Calendar;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {

        HeartRates heartRates = new HeartRates("gabriel", "bastos rabelo", 07, 05, 2003);
        System.out.println(heartRates.getIdade());
        Menu menu = new Menu(heartRates);
        menu.mostrarMenu();
        // menu.mostrarMenu();

    }
}
