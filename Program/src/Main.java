import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Laptop> laptops = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        laptops.add(new Laptop("Prestigio SmartBoo", OperatingSystem.WINDOWS, Color.BLUE, 8, 500, 1200));
        laptops.add(new Laptop("Digma Eve", OperatingSystem.WINDOWS, Color.GRAY, 4, 300, 500));
        laptops.add(new Laptop("Echips Lite2", OperatingSystem.LINUX, Color.BLUE, 8, 300, 900));
        laptops.add(new Laptop("Asus", OperatingSystem.LINUX, Color.RED, 16, 500, 2000));
        laptops.add(new Laptop("Mac Book Pro", OperatingSystem.MAC, Color.GRAY, 16, 1000, 3500));

        HashMap<Integer, ArrayList<Integer>> filters = new HashMap<>();

        Filter filter = new Filter(laptops);
        filter.String();

        String filterNumber;

        while(true) {
            ArrayList<Integer> numbers = new ArrayList<>();
            System.out.println("Enter a number of filter or q:");
            filterNumber = scanner.nextLine();

            if(filterNumber.equals("q")) {
                break;
            }

            String filterItem;
            while(true) {
                System.out.println("Enter a number of item filter or q: ");
                filterItem = scanner.nextLine();

                if(filterItem.equals("q")) {
                    break;
                }
                numbers.add(Integer.parseInt(filterItem));
            }

            filters.put(Integer.parseInt(filterNumber), numbers);
        }

        ArrayList<Laptop> filteredLaptops = filter.getLaptopsByFilter(laptops, filters);
        for(Laptop laptop : filteredLaptops) {
            laptop.String();
        }
    }
}