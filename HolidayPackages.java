package com.nmit;

import java.util.Arrays;
import java.util.List;

public class HolidayPackage {

    //These are static strings for holiday packages based on city name
    final static String commonDescription = "Following things are included under this package:\n";
    final static String currencyUnit = "₹";

    final static double DELHI_PRICE = 11000.00;
    final static double GOA_PRICE = 6000.00;
    final static double BANGALORE_PRICE = 9000.00;

    final static List<String> listOfCitiesSupported = Arrays.asList("DELHI","GOA","BANGALORE");
    final static String PACKAGE_YES = "YES";

    final static String CITY_NOT_SUPPORTED_MESSAGE = "### We don't have holiday packages for this city yet ###";

    final static String DELHI_HOLIDAY_DATA = String.format("%s1) 4 days and 3 nights atay in Hotel Emperor Palms. \n2) 2 days site visiting  to The RedFort, Quitb Minar, India Gate, Lotus Temple, Akshardham and Chandni Chowk. \n3) 2 days vehicle for personal visiting.",commonDescription);
    final static String GOA_HOLIDAY_DATA = String.format("%s1) 3 days and 3 nights stay in Hotel Nagoa Grande Resort & Spa. \n2) 2 day site visiting to Dudhsagar Falls, Fort Aguada, Wax World Muesum, Church of St Cajetan.\n3) 1 day vehicle for personal visiting.",commonDescription);
    final static String BANGALORE_HOLIDAY_DATA = String.format("%s1) 5 days and 4 nights stay in Hotel Country Inn & Suites \n2) 3 day site visiting to Lal Bagh, Bangalore Palace, Cubbon Park, ISSCON Temple, Arkavati, Bannerghatta National Park.\n3) 2 days vehicle for personal visiting.",commonDescription);

    // These are member variables of class holiday package
    final String cityName;
    final boolean isCityCorrect;
    double packagePrice;
    String packageDescription;

    public HolidayPackage(final String cityName)
    {
        //Sanitizing city name
        this.cityName = cityName.toUpperCase();
        System.out.println(String.format("City name selected: %s",cityName));
        isCityCorrect = isCitySupported(this.cityName);
        if(isCityCorrect)
        {
            System.out.println("We do have holiday packages for this city");
            this.packagePrice = getPrice(this.cityName);
            this.packageDescription = getPackageDescription(this.cityName);
        }
        else
        {
            System.out.println(CITY_NOT_SUPPORTED_MESSAGE);
        }
    }

    //To view details of package
    public void viewPackage()
    {
        if(isCityCorrect)
        {
            System.out.println(String.format("**** The package description for the package selected by you is: ****\n%s",packageDescription));
            System.out.println(String.format("**** The price for the package selected by you is: ****\n%s %s",currencyUnit,packagePrice));
        }
        else
        {
            System.out.println(CITY_NOT_SUPPORTED_MESSAGE);
        }
    }

    //To accept or reject package
    public void confirmPackage(final String confirmation)
    {
        if(isCityCorrect) {
            if (confirmation.equalsIgnoreCase(PACKAGE_YES)) {
                System.out.println(String.format("**** Thanks for choosing our holiday package. ****\n**** %s %s has been debited from your wallet ****", currencyUnit, packagePrice));
            } else {
                System.out.println("**** Sorry you did not like our offers. Please come back soon! ****");
            }
        }
        else
        {
            System.out.println(CITY_NOT_SUPPORTED_MESSAGE);
        }
    }

    //To check if City is supported or not
    private boolean isCitySupported(final String cityName)
    {
        if (listOfCitiesSupported.contains(cityName))
        {
            return true;
        }
        System.out.println(String.format("Holiday packages for city: %s are not available",cityName));
        return false;
    }

    //To get price for the selected city
    private double getPrice(final String cityName)
    {
        double price;
        switch (cityName)
        {
            case "DELHI": price = DELHI_PRICE;break;
            case "GOA": price = GOA_PRICE;break;
            case "BANGALORE": price = BANGALORE_PRICE;break;
            default: price = 0;
        }
        return price;
    }

    //To get package description for the selected city
    private String getPackageDescription(final String cityName)
    {
        String packageDesc;
        switch (cityName)
        {
            case "DELHI": packageDesc = DELHI_HOLIDAY_DATA;break;
            case "GOA": packageDesc = GOA_HOLIDAY_DATA;break;
            case "BANGALORE": packageDesc = BANGALORE_HOLIDAY_DATA;break;
            default: packageDesc = "";
        }
        return packageDesc;
    }

//    public static void main(String[] args) {
//        HolidayPackage delhiHolidayPackage = new HolidayPackage("Bangalore");
//        delhiHolidayPackage.viewPackage();
//        delhiHolidayPackage.confirmPackage("no");
//    }
}
