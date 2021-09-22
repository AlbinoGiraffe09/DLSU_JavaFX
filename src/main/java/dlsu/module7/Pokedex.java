package dlsu.module7;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Pokedex extends Application {
    public static Parent root;
    public static Scene scene;
    protected static HashMap<String, Pokemon> pokemonHashMap;
    protected static final List<String> pokemonNames = new ArrayList<>();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pokedex-view.fxml")));

        scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Pokedex");
        primaryStage.show();

        setPokemons();
    }
    public static String getRandomName(){
        Random rand = new Random();
        int index = rand.nextInt(pokemonNames.size());
        return pokemonNames.get(index);
    }
    private void setPokemons() throws Exception {
        String filepath = "src/main/resources/dlsu/module7/pokemon/pokemon.csv";
        BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
        String csvRow;

        pokemonHashMap = new HashMap<>();
        List<String[]> pokemonData = new ArrayList<>();

        csvReader.readLine(); // Skips header row in .csv file
        /* Adds an array of Strings created by splitting line by commas to pokemonData ArrayList. */
        while ((csvRow = csvReader.readLine()) != null)
        {pokemonData.add(csvRow.split(","));}
        /* Add names of Pokémon to pokemonNames list. */
        for (String[] fileData: pokemonData)
        {pokemonNames.add(fileData[0]);}
        /* Instantiates Pokémon objects using Pokémon data from pokemonData ArrayList
           and assigns them to key denoted by their name */
        for (int i = 0; i < pokemonNames.size(); i++)
        {pokemonHashMap.put(pokemonNames.get(i),new Pokemon(pokemonData.get(i)));}
    }
    protected static void removePokemon(String pokemonToRemove){
        pokemonHashMap.remove(pokemonToRemove);
    }
}
