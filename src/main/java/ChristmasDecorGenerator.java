import ChristmasDecorType.ChristmasDecor;
import ChristmasDecorType.DecorationType;
import ChristmasDecorType.Location;
import java.util.Random;

public class ChristmasDecorGenerator {
    static final DecorationType[] decorTypes = {
            new DecorationType(1,"Ornament", "A beautiful glass ornament for your tree."),
            new DecorationType(2,"Tinsel", "Shiny tinsel to add sparkle to your decorations."),
            new DecorationType(3,"Lights", "Twinkling fairy lights to brighten up your holiday."),
            new DecorationType(4,"Tree Topper", "A majestic tree topper to crown your Christmas tree."),
            new DecorationType(5,"Garland", "Elegant garland to drape around your home."),
            new DecorationType(6,"Candy Cane", "Delicious candy cane-shaped decorations."),
            new DecorationType(7,"Snowflake", "Delicate snowflake ornaments for a wintry touch."),
            new DecorationType(8,"Gingerbread", "Sweet gingerbread-themed decorations."),
            new DecorationType(9,"Reindeer", "Charming reindeer decorations for a festive touch."),
            new DecorationType(10,"Sleigh", "Miniature sleigh decorations to adorn your tree."),
            new DecorationType(11,"Stocking", "Adorable stocking-shaped ornaments."),
//            new DecorationType(1,"Baubles", "Colorful bauble decorations for your tree."),
//            new DecorationType(1,"Holly", "Holly and berries-themed decorations."),
//            new DecorationType(1,"Poinsettia", "Elegant poinsettia decorations for a classic look."),
//            new DecorationType(1,"Nutcracker", "Whimsical nutcracker-themed ornaments."),
//            new DecorationType(1,"Snowman", "Friendly snowman decorations for your tree."),
//            new DecorationType(1,"Star", "A shining star decoration to top your tree."),
//            new DecorationType(1,"Angel", "Angelic angel ornaments to watch over your home."),
//            new DecorationType(1,"Ribbon", "Festive ribbon decorations to add flair."),
//            new DecorationType(1,"Bell", "Jingling bell-shaped ornaments for a cheerful sound."),
    };

    private static final Location[] locations = {
            new Location("Santa's Workshop"),
            new Location("Winter Wonderland Emporium"),
            new Location("Gingerbread House Boutique"),
            new Location("Jane's Store"),
            new Location("Candy Cane Corner"),
            new Location("Frosty's Frostings"),
            new Location("Toyland Treasures"),
            new Location("Holiday Harmonies"),
            new Location("North Pole Novelties"),
            new Location("Starlight Souvenirs"),
            new Location("Fairy Lights Emporium"),
    };

    private static final String[] adjectives = {
            "Incredible",
            "Sparkling",
            "Shimmering",
            "Delightful",
            "Glistening",
            "Radiant",
            "Enchanting",
            "Festive",
            "Glittering",
            "Joyful",
            "Magical",
            "Whimsical",
            "Dazzling",
            "Charming",
            "Elegant",
            "Vibrant",
            "Spectacular",
            "Gleaming",
            "Merry",
            "Splendid"
    };

    private static final String[] colors = {
            "Red",
            "Green",
            "Gold",
            "Silver",
            "Blue",
            "White",
            "Purple",
            "Pink",
            "Yellow",
            "Orange",
            "Crimson",
            "Turquoise",
            "Lavender",
            "Magenta",
            "Teal",
            "Navy",
            "Sapphire",
            "Emerald",
            "Ruby",
            "Amber",
            "Copper",
            "Bronze",
            "Platinum",
            "Rose",
            "Pearl",
            "Ivory",
            "Indigo",
            "Maroon",
            "Violet"
    };


    public static ChristmasDecor[] generateRandomDecorations(int numberOfDecorations) {
        ChristmasDecor[] decorations = new ChristmasDecor[numberOfDecorations];
        Random random = new Random();

        for (int i = 0; i < numberOfDecorations; i++) {
            int randomTypeIndex = random.nextInt(decorTypes.length);
            int randomLocationIndex = random.nextInt(locations.length);
            int randomAdjectiveIndex = random.nextInt(adjectives.length);
            int randomColorIndex = random.nextInt(colors.length);

            DecorationType decorationType = decorTypes[randomTypeIndex];
            Location location = locations[randomLocationIndex];
            String adjective = adjectives[randomAdjectiveIndex];
            String color = colors[randomColorIndex];

            String decorationName = adjective + " " + color + " " + decorationType.getTypeName();

            float randomPrice = Float.parseFloat(String.format("%.2f", random.nextFloat() * 100)); // Adjust 100 for your desired range

            decorations[i] = new ChristmasDecor(i + 1, decorationName, decorationType, randomPrice, location);
        }

        return decorations;
    }
}
