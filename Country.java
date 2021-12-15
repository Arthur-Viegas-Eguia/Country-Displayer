import java.util.HashMap;
import java.util.HashMap;
/**
 *  Country class contains information about a country and its indicators,
 * and has methods for an user to access them.
 */
public class Country{
    private HashMap<String, String> country;
    /**
     * Creates the HashMap and adds to it the name of the country and
     * and all its indicators.
     * @param name a String representing the name of the country
     * @param population a real number >= 0, representing the population of the country in millions of inhabitants
     * @param emission a real number >= 0 representing the metric tons of Co2 emitted per capita
     * @param electricity a real number >= 0 and <=100, representing the percentage of the population with access to electrivity
     * @param renewableEnergy a real number >= 0 and <=100 representing the percentage of energy consumed which is renewable
     * @param protectedAreas  a real number >= 0 and <=100 representing the percentage of the territory covered by Terrestrial protected areas.
     * @param growth a real number representing the annual population growth percentage
     * @param urbanPopulationGrowth a real number representing the annual urban population growth
     */
    public Country(String name, String population, String emission, String electricity, String renewableEnergy, String protectedAreas, String growth, String urbanPopulationGrowth){
        country = new HashMap<>();
        country.put("name", name);
        country.put("population", population);
        country.put("co2", emission);
        country.put("electricity", electricity);
        country.put("renewableEnergy", renewableEnergy);

        country.put("protectedAreas", protectedAreas);

        country.put("populationGrowth", growth);
        country.put("urbanPopulationGrowth", urbanPopulationGrowth);
    } //end Country
    /**
     * Gets the name of the country.
     * @return a String representing the name of the country
     */
    public String getName(){
        return country.get("name");
    } //end getName
    /**
     * Returns to the user the selected indicator of the country
     * @param key a String representing the name of an indicator
     * @return a float, representing the inicator chosen
     */
    public float getIndicator(String key){
        return Float.parseFloat(country.get(key));
    } //end getIndicator
    /**
     * Runs the code. Creates an instance of the class and tests the
     * getName and getIndicator methods
     */
    public static void main(String[] args) {
        Country test = new Country("Name", "200", "300", "400", "500", "550", "700", "80000");
        System.out.println(test.getName());
        System.out.println(test.getIndicator("population"));
        System.out.println(test.getIndicator("electricity"));
        System.out.println(test.getIndicator("protectedAreas"));
        System.out.println(test.getIndicator("populationGrowth"));
    } //end main
} //end Country
