import ChristmasDecorType.ChristmasDecor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;

public class ChristmasDecorManager {
    private ChristmasDecor[] decorations;

    public ChristmasDecorManager(int count) {
        this.decorations = ChristmasDecorGenerator.generateRandomDecorations(count);
    }

    public ChristmasDecor[] getDecorations() {
        return decorations;
    }

    public void sortDecorations(int[] sortingChoices, boolean reverse) {
        Arrays.sort(decorations, getComparator(sortingChoices, reverse));
    }

    public ChristmasDecor[] findDecorationsByType(Set<Integer> selectedIndices) {
        return Arrays.stream(decorations)
                .filter(decor -> selectedIndices.contains(decor.getType().getID()))
                .toArray(ChristmasDecor[]::new);
    }

    private Comparator<ChristmasDecor> getComparator(int[] sortingChoices, boolean reverse) {
        Comparator<ChristmasDecor> result = null;
        Comparator<ChristmasDecor> tempComp;
        for (int choice : sortingChoices) {
            tempComp = null;
            tempComp = switch (choice) {
                case 1 -> ComparatorsFactory.byName();
                case 2 -> ComparatorsFactory.byDecorType();
                case 3 -> ComparatorsFactory.byLocation();
                case 4 -> ComparatorsFactory.byPrice();
                default -> tempComp;
            };
            if (result != null) {
                result = ComparatorsFactory.byTwoComparators(result,tempComp);
            }
            else{
                result = tempComp;
            }
        }
        if (reverse) {
            assert result != null;
            result = result.reversed();
        }
        return result;
    }
}
