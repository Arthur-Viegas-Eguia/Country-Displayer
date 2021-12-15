import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;
/**
 * CountryDisplayer class models a list of countries.
 * It has methods to show the indicators of specific countries
 * or return the countries which have the maximum/minimum value in 
 * a certain indicator
 * @author Arthur Viegas Eguia
 */
public class CountryDisplayer {
    /**
     * countries is an ArrayList which represents the list of all countries
     * used in the program. 
     */
    ArrayList<Country> countries;
    /**
     * Constructs the class. Initializes the variable countries.
     * Reads information from a list of countries provided by the user
     * processes this data, and stores it.
     * @param fileName a String representing the path to a file containing a list of countries
     */
    public CountryDisplayer(String fileName) {
        /**
         * Variable filePath represents the path of the file sent by the user.
         * Here the variable is initialized as an instance of File.
         */
        File filePath = new File(fileName);
        /**
         * fileInput is the variable which will hold the scanner. This variable
         * will be responsible to read each line of the file and return the
         * data for it to be processed by the program.
         */
        Scanner fileInput = null;
        /**
         * line variable is going to receive a line of the file from the
         * scanner.
         */
        String line;
        /**
         * splitLine is going to be an array where the data of the file is
         * stored after being processed. 
         */
        String[] splitLine;
        countries = new ArrayList<>();
        try{
            fileInput = new Scanner(filePath);
        } catch (FileNotFoundException e){
            System.out.println("The path to the file is wrong, or there may be a typo");
            System.exit(1);
        } //end try catch
        /**
         * Now let's skip the file header, which says the order each piece
         * of information goes. This was already modeled in the Country class
         */
        fileInput.nextLine();
        if(!fileInput.hasNextLine()){
            /**
             * If there are 0 countries in the file, the code prints a message
             * and stops running.
             */
            System.out.println("There are no lines in the file, just a header.");
            System.exit(1);
        } else{
            /**
             * This part is where the data is tprocessed, it gets each of the
             * indicators and, as they are already in order in the file,
             * adds them to the variable countries
             */
            while(fileInput.hasNextLine()){
                line = fileInput.nextLine();
                splitLine = line.split(",");
                countries.add(new Country(splitLine[0], splitLine[1], splitLine[2], splitLine[3], splitLine[4], splitLine[5], splitLine[6], splitLine[7]));
            } //end while
        } //end if and else chain
    } //end CountryDisplayer
    /**
     * Gets the instance of a country with the name specified by the user.
     * @param name a String representing the name of the country
     * @return an instance the country with the specified name or null if the country is not found
     */
    public Country getCountryByName(String name) {
        Country countryFound = null;
        for(Country currentCountry : countries){
            String currentCountryName = currentCountry.getName();
            if(currentCountryName.equals(name)){
                countryFound = currentCountry;
                break;
            } //end if
        } //end for
        if(countryFound == null){
            System.out.println("Country not found, make sure you insert the name correctly?");
        } //end if
        return countryFound;
    } //end getCountryByName
    /**
     * Gets the instance of country which has the largest value in the
     * indicator specified by the user.
     * @param indicator a String representing an indicator present in country
     * @return an instance of the country which has the largest value in the specified indicator
     */
    public Country getCountryMaxIndicator(String indicator) {
        Country getIndicatorMax = countries.get(0);
        double maxValue = getIndicatorMax.getIndicator(indicator);
        for(Country valueToCompare : countries){
            if(maxValue < valueToCompare.getIndicator(indicator)){
                maxValue = valueToCompare.getIndicator(indicator);
                getIndicatorMax = valueToCompare;
            } //end if
        } //end for
        return getIndicatorMax;
    } //end getCountryMaxIndicator
    /**
     * Gets the instance of country which has the smallest value in the
     * indicator specified by the user.
     * @param indicator a String representing an indicator present in country
     * @return an instance of the country which has the smallest value in the specified indicator
     */
    public Country getCountryMinIndicator(String indicator) {
        Country getIndicatorMin = countries.get(0);
        double minValue = getIndicatorMin.getIndicator(indicator);
        for(Country valueToCompare : countries){
            if(minValue > valueToCompare.getIndicator(indicator)){
                minValue = valueToCompare.getIndicator(indicator);
                getIndicatorMin = valueToCompare;
            } //end if
        } //end for
        return getIndicatorMin;
    } //end getCountryMinIndicator
    /**
     * Models a menu which asks a user to type the name of a country.
     * Handles problems if input is not in the list.
     * Prints all the indicators of a country in an organized way
     */
    public void findByNameMenu(){
         Scanner userInput = new Scanner(System.in);
         String name;
         Country countryToDisplay;
         while(true){
            System.out.println("Type the name of the country");
            name = userInput.nextLine();
            countryToDisplay = getCountryByName(name);
             if(countryToDisplay != null){
                break;
            } //end if
         } //end while
         userInput.close();
         System.out.println("Country Name => " + countryToDisplay.getName());
         System.out.println("Population total (in millions) => " + countryToDisplay.getIndicator("population"));
         System.out.println("CO2 emissions (metric tons per capita) => " + countryToDisplay.getIndicator("co2"));
         System.out.println("Access to electricity (% of population) => " + countryToDisplay.getIndicator("electricity"));
         System.out.println("Renewable energy consumption (% of total final energy consumption) => " + countryToDisplay.getIndicator("renewableEnergy"));
         System.out.println("Terrestrial protected areas (% of total land area) => " + countryToDisplay.getIndicator("protectedAreas"));
         System.out.println("Population growth (annual %) " + countryToDisplay.getIndicator("populationGrowth"));
         System.out.println("Urban population growth (annual %) => " + countryToDisplay.getIndicator("urbanPopulationGrowth"));
     } //end findByNameMenu
     /**
     * Models a menu which asks a user to type the indicator they wish.
     * Handles problems if input is not valid.
     * Prints the name of the country which has the maximum value
     * of the desired indicator.
     */
    public void findByMaxMenu(){
        Scanner userInput = new Scanner(System.in);
        String indicator;
        Country maxIndicator;
        while(true){
            printOptions();
            indicator = userInput.nextLine();
            if(indicator.equals("population")){
                maxIndicator = getCountryMaxIndicator("population");
            } else if(indicator.equals("co2")){
                maxIndicator = getCountryMaxIndicator("co2");
            } else if(indicator.equals("electricity")){
                maxIndicator = getCountryMaxIndicator("electricity");
            } else if(indicator.equals("renewable")){
	    	    maxIndicator = getCountryMaxIndicator("renewableEnergy");
	        } else if(indicator.equals("protected")){
		        maxIndicator = getCountryMaxIndicator("protectedAreas");
	        } else if(indicator.equals("growth")){
	    	    maxIndicator = getCountryMaxIndicator("populationGrowth");
	        } else if(indicator.equals("urban")){
		        maxIndicator = getCountryMaxIndicator("urbanPopulationGrowth");
	        } else{
	    	    System.out.println("Indicator not found, make sure you are typing the name correctly and that the indicator that you are looking for is in the options");
		        continue;
	        } //end if and else chain
            userInput.close();
	  	    System.out.println("The country with the maximum indicator is " + maxIndicator.getName());
            break;
         } //end while
     } //end findByMaxMenu
     /**
     * Models a menu which asks a user to type the indicator they wish.
     * Handles problems if input is not valid.
     * Prints the name of the country which has the minimum value
     * of the desired indicator.
     */
    public void findByMinMenu(){
        Scanner userInput = new Scanner(System.in);
        String indicator;
        Country minIndicator;
        while(true){
            printOptions();
            indicator = userInput.nextLine();
            if(indicator.equals("population")){
                minIndicator = getCountryMinIndicator("population");
            } else if(indicator.equals("co2")){
                minIndicator = getCountryMinIndicator("co2");
            } else if(indicator.equals("electricity")){
                minIndicator = getCountryMinIndicator("electricity");
            } else if(indicator.equals("renewable")){
	    	    minIndicator = getCountryMinIndicator("renewableEnergy");
	        } else if(indicator.equals("protected")){
		        minIndicator = getCountryMinIndicator("protectedAreas");
	        } else if(indicator.equals("growth")){
	    	    minIndicator = getCountryMinIndicator("populationGrowth");
	        } else if(indicator.equals("urban")){
		        minIndicator = getCountryMinIndicator("urbanPopulationGrowth");
	        } else{
	    	    System.out.println("Indicator not found, make sure you are typing the name correctly and that the indicator that you are looking for is in the options");
		        continue;
	        } //end if and else chain
            userInput.close();
	  	    System.out.println("The country with the minimum indicator is " + minIndicator.getName());
            break;
        } //end while
     } //end findByMinMenu
     /**
      * Prints out the possible indicators and the keys to access them in an organized way
      */
     public void printOptions(){
        System.out.println("Population total (in millions) => type population");
        System.out.println("CO2 emissions (metric tons per capita) => type co2");
        System.out.println("Access to electricity (% of population) => type electricity");
        System.out.println("Renewable energy consumption (% of total final energy consumption) => type renewable");
        System.out.println("Terrestrial protected areas (% of total land area) => type protected");
        System.out.println("Population growth (annual %) type growth");
        System.out.println("Urban population growth (annual %) => type urban");
        System.out.print("Type the indicator you want: ");
     } //end printOptions
     /**
     * Models a menu which asks a user to type the country and indicator they wish
     * Handles problems if the input is not valid.
     * Prints the name of the country followed by the
     * desired indicator in an organized way.
     */
    public void findByNameAndIndicator(){
        Scanner userInput = new Scanner(System.in);
        String name;
        String indicator;
        Country countryToDisplay;
        //Block of code to read the name of the country:
        while(true){
           System.out.println("Type the name of the country");
           name = userInput.nextLine();
           countryToDisplay = this.getCountryByName(name);
            if(countryToDisplay != null){
                break;
            } //end if
        } //end while
        //Block of code to read the desired indicators
        while(true){
            printOptions();
            indicator = userInput.nextLine();
            if(indicator.equals("population")){
                System.out.println(name + " Has " + countryToDisplay.getIndicator("population") + " as its total Population (in millions)");
            } else if(indicator.equals("co2")){
                System.out.println(name + " Has " + countryToDisplay.getIndicator("co2") + " in CO2 emissions (metric tons per capita)");
            } else if(indicator.equals("electricity")){
                System.out.println(name + " Has " + countryToDisplay.getIndicator("electricity") + "%  Access to electricity (% of population)");
            } else if(indicator.equals("renewable")){
	    	    System.out.println(name + " Has " + countryToDisplay.getIndicator("renewableEnergy") + "% Renewable energy consumption (% of total final energy consumption)");
	        } else if(indicator.equals("protected")){
		        System.out.println(name + " Has " + countryToDisplay.getIndicator("protectedAreas") + "% Terrestrial protected areas (% of total land area)");
	        } else if(indicator.equals("growth")){
	    	    System.out.println(name + " Has " + countryToDisplay.getIndicator("populationGrowth") + "% Population growth (annual %)");
	        } else if(indicator.equals("urban")){
		        System.out.println(name + " Has " + countryToDisplay.getIndicator("urbanPopulationGrowth") + "% Urban population growth (annual %)");
	        } else{
	    	    System.out.println("Indicator not found, make sure you are typing the name correctly and that the indicator that you are looking for is in the options");
		        continue;
	        } ////end if and else chain
            userInput.close();
            break; 
        } //end while
    } //end findByNameAndIndicator
    /**
     * Creates an instance of CountryDisplayer, sets its dataset as the input
     * received by command line.
     * provides the user with some options of operations, and executes them. 
     * @param args the path to the file containing the dataset for the program.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
           System.out.println("Please make sure to type the path of the file with a list of countries!");
           System.exit(1);
        } //end if
        String filePath = args[0];
        CountryDisplayer test = new CountryDisplayer(filePath);
        Scanner userInput = new Scanner(System.in);
        boolean run = true;
        int menu;
        while(run){
            System.out.println("Type 1 to get information from a country based on name");
            System.out.println("Type 2 to get the country which has a certain maximum indicator (Returns Only name)");
            System.out.println("Type 3 to get the country which has a certain minumum indicator (Returns only name)");
            System.out.println("Type 4 to get the indicator you choose from a country you choose");
            menu = userInput.nextInt();
            switch(menu){
                case 1:
                test.findByNameMenu();
                run = false;
                break;
                case 2:
                test.findByMaxMenu();
                run = false;
                break;
                case 3:
                test.findByMinMenu();
                run = false;
                break;
                case 4:
                test.findByNameAndIndicator();
                run = false;
                break;
                default:
                System.out.println("Invalid option, please type only 1, 2, 3, and 4 based on what you want");
                break;
            } //end switch
        } //end while
        userInput.close();
    } //end main
} //end CountryDisplayer

