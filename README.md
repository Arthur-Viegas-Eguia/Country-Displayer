# Country-Displayer
Adaptation of code originally developed as Homework 2 for the Data Structure class taught by Anya Vostinar
## Overview
The program provides the user with methods to see indicators of specific countries or a the country which has the maximum/minimum value at a certain indicator
With this program you can:
-Specify your own dataset by providing the program with a text file with a list of countries
and their indicators
- See all indicators of a certain country by searching for the country’s name
- See one specific indicator of a specific country, by providing the name of the country and
the indicator you wish to see
- See the country which has the maximum/minimum value of an indicator, by providing the name of the
indicator you want

## Usage

To use the program, you have to compile and run the code after downloading. To do this, simply
type in the terminal:
``` 
javac *.java
java CountryDisplayer value

```
Where value represents the path of the external file which contains a list of countries and their
indicators. value should be a comma separated list, with a header containing the name of the
indicators followed by a list of 0 or many countries. The list must contain the following
indicators in the following order: Country Name, Population (total), CO2 emissions (metric tons
per capita), Access to electricity (% of population), Renewable energy consumption (% of total
final energy consumption), Terrestrial protected areas (% of total land area), Population growth
(annual %), Urban population growth (annual %). All Operations of the program depend on the
list of countries and its indicators. So it is important that the file provided has the format
specified and the path to it is correct.
