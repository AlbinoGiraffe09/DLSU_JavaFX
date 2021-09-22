package dlsu.module7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class PokedexController {
    @FXML public BorderPane mainBorderPane;
    @FXML public AnchorPane MenuPane;
    @FXML public AnchorPane CanvasPane;
    @FXML public ImageView pokemonImage;
    @FXML public Image image;
    @FXML public Text pokemonNameField;
    private final Timer timer = new Timer();
    public Rectangle staminaBar;
    public Rectangle attackBar;
    public Rectangle defenseBar;
    public TextField pokemonSearchField;
    public Text pokemonTypeField;
    public Text pokemonHeightField;
    public Text pokemonWeightField;
    public Rectangle attackBarFill;
    public Rectangle defenseBarFill;
    public Rectangle staminaBarFill;
    private TimerTask timerTask;
    private void setPokemon(String inputName){
        Pokemon pokemon = Pokedex.pokemonHashMap.get(inputName);
        String filepath = "pokemon/" + inputName.toLowerCase(Locale.ROOT) + ".png";
        image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(filepath)));
        // Change image to given image file.
        pokemonImage.setImage(image);
        // Set Text Fields to given input Strings.
        pokemonNameField.setText(inputName);
        pokemonTypeField.setText(pokemon.getType());
        pokemonHeightField.setText(pokemon.getPokeHeight());
        pokemonWeightField.setText(pokemon.getPokeWeight());
        // Set Text Fields' alignments.
        pokemonNameField.setTextAlignment(TextAlignment.CENTER);
        pokemonTypeField.setTextAlignment(TextAlignment.CENTER);
        pokemonHeightField.setTextAlignment(TextAlignment.CENTER);
        pokemonWeightField.setTextAlignment(TextAlignment.CENTER);
        // Set width of rectangle fills.
        attackBarFill.setWidth(pokemon.getPokeAttack() * attackBar.getWidth());
        defenseBarFill.setWidth(pokemon.getPokeDefense() * defenseBar.getWidth());
        staminaBarFill.setWidth(pokemon.getPokeStamina() * staminaBar.getWidth());
    }
    public void exitButton(ActionEvent actionEvent) {
        System.exit(0);
    }
    public void viewAllButton(ActionEvent actionEvent) {
        if (timerTask != null) {timerTask.cancel();}
        long delay = 2500;
        timerTask = new TimerTask() {
            @Override
            public void run() {
                setPokemon(Pokedex.getRandomName());
            }
        };
        timer.schedule(timerTask,0,delay);
    }
    public void viewOneButton(ActionEvent actionEvent){
        if (timerTask != null) {timerTask.cancel();}
        setPokemon(Pokedex.getRandomName());
    }
    public void searchButton(ActionEvent actionEvent) {
        if (timerTask != null) {timerTask.cancel();}
        String pokemonToSearch = pokemonSearchField.getCharacters().toString();
        pokemonToSearch = toTitleCase( pokemonToSearch);
        if (Pokedex.pokemonNames.contains(pokemonToSearch)){
            setPokemon(pokemonToSearch);
        } else {
            pokemonSearchField.setText(null);
            pokemonSearchField.setPromptText("Pokemon not found!");
        }
    }
    public void removeButton(ActionEvent actionEvent) {
        if (timerTask != null) {timerTask.cancel();}
        String pokemonToDelete = pokemonSearchField.getCharacters().toString();
        pokemonToDelete = toTitleCase(pokemonToDelete);
        if (Pokedex.pokemonNames.contains(pokemonToDelete)){
            Pokedex.removePokemon(pokemonToDelete);
            pokemonSearchField.setText(null);
            pokemonSearchField.setPromptText("Pokemon removed!");
        } else {
            pokemonSearchField.setText(null);
            pokemonSearchField.setPromptText("Pokemon not found!");
        }
    }
    public static String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder(input.length());
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }
}
