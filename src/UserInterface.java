import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class UserInterface {
    private final Adventure adventure;
    private final BufferedReader reader;
    private final PrintWriter writer;

    // Fleksibel konstruktør baseret på I/O streams
    public UserInterface(InputStream in, OutputStream out) {
        this.adventure = new Adventure();
        this.reader = new BufferedReader(new InputStreamReader(in));
        // autoFlush = true sørger for, at teksten sendes med det samme
        this.writer = new PrintWriter(out, true);
    }

    // Standard konstruktør der bruger System.in / System.out som fallback
    public UserInterface() {
        this(System.in, System.out);
    }

    public void start() {
        writer.println("Welcome to the Adventure Game!");
        writer.println("Type 'help' for instructions.\n");

        printCurrentRoom();

        boolean running = true;
        while (running) {
            writer.print("> ");
            writer.flush(); // Sikrer at prompten vises før input læses

            try {
                String line = reader.readLine();
                if (line == null) {
                    break; // Slut på stream (EOF)
                }

                String input = line.trim().toLowerCase();

                switch (input) {
                    case "go north", "north", "n" -> processMove("north");
                    case "go east", "east", "e"   -> processMove("east");
                    case "go south", "south", "s" -> processMove("south");
                    case "go west", "west", "w"   -> processMove("west");
                    case "look"                   -> printCurrentRoom();
                    case "help"                   -> printHelp();
                    case "exit"                   -> {
                        writer.println("Goodbye!");
                        running = false;
                    }
                    default -> writer.println("Unknown command. Type 'help' for available commands.");
                }
            } catch (IOException e) {
                writer.println("An error occurred reading input: " + e.getMessage());
                running = false;
            }
        }
    }

    private void processMove(String direction) {
        boolean moved = adventure.movePlayer(direction);
        if (moved) {
            printCurrentRoom();
        } else {
            writer.println("You cannot go that way");
        }
    }

    private void printCurrentRoom() {
        writer.println(adventure.getCurrentRoomDescription());
    }

    private void printHelp() {
        writer.println("--- Commands ---");
        writer.println("go north / north / n - Move north");
        writer.println("go east / east / e   - Move east");
        writer.println("go south / south / s - Move south");
        writer.println("go west / west / w   - Move west");
        writer.println("look                 - Repeat the description of your current room");
        writer.println("help                 - Display this help menu");
        writer.println("exit                 - Quit the game");
    }
}