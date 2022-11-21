import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class Filter {
    private final HashMap<Integer, HashSet<Integer>> filters;

    public Filter(ArrayList<Laptop> laptops) {
        filters = new HashMap<>();

        HashSet<Integer> RAMs = new HashSet<>();
        HashSet<Integer> HDDSizes = new HashSet<>();
        HashSet<Integer> colors = new HashSet<>();
        HashSet<Integer> operationSystems = new HashSet<>();

        for(Laptop laptop : laptops) {
            RAMs.add(laptop.getRAM());
            HDDSizes.add(laptop.getHDDSize());
        }

        for(OperatingSystem os : OperatingSystem.values()) {
            operationSystems.add(os.ordinal());
        }

        for(Filters color : Filters.values()) {
            colors.add(color.ordinal());
        }

        filters.put(Filters.RAM.ordinal(), RAMs);
        filters.put(Filters.COLOR.ordinal(), colors);
        filters.put(Filters.HDD_SIZE.ordinal(), HDDSizes);
        filters.put(Filters.OS.ordinal(), operationSystems);
    }

    public void String() {
        System.out.println("Filters: ");

        int i = 1, j = 1;
        for(Entry<Integer, HashSet<Integer>> entry: filters.entrySet()) {
            System.out.print(" " + i + ") " + Filters.values()[entry.getKey()] + ": ");

            for(Integer filters : entry.getValue()) {
                if(entry.getKey() == Filters.COLOR.ordinal()) {
                    System.out.print(j + ")" + Color.values()[j-1].toString() + " ");
                } else if(entry.getKey() == Filters.OS.ordinal()) {
                    System.out.print(j + ")" + OperatingSystem.values()[j-1].toString() + " ");
                } else {
                    System.out.print(j + ")" + filters + " ");
                }
                j++;
            }

            i++;
            j = 1;
            System.out.println();
        }
    }

    public ArrayList<Laptop> getLaptopsByFilter(ArrayList<Laptop> laptops, HashMap<Integer, ArrayList<Integer>> filters) {
        for(Entry<Integer, ArrayList<Integer>> entry1 : filters.entrySet()) {
            Iterator<Laptop> it = laptops.iterator();

            while(it.hasNext()) {
                Laptop laptop = it.next();
                int key = entry1.getKey()-1;
                if(key == Filters.RAM.ordinal()) {
                    if(!compare(entry1.getValue(), laptop.getRAM())) {
                        it.remove();
                    }
                } else if(key == Filters.COLOR.ordinal()) {
                    if(!compare(entry1.getValue(), laptop.getColor().ordinal())) {
                        it.remove();
                    }
                } else if(key == Filters.HDD_SIZE.ordinal()) {
                    if(!compare(entry1.getValue(), laptop.getHDDSize())) {
                        it.remove();
                    }
                } else if(key == Filters.OS.ordinal()) {
                    if(!compare(entry1.getValue(), laptop.getOs().ordinal())) {
                        it.remove();
                    }
                }
            }

        }

        return laptops;
    }

    public boolean compare(ArrayList<Integer> values, int value) {
        int i = 1;

        for(Integer val : values) {
            for(Entry<Integer, HashSet<Integer>> entry: filters.entrySet()) {
                for(Integer filter : entry.getValue()) {
                    if(i == val && value == filter) {
                        return true;
                    }
                    i++;
                }
                i = 1;
            }
        }
        return false;
    }
}
