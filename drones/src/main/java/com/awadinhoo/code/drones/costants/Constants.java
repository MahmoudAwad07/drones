package com.awadinhoo.code.drones.costants;

public class Constants {

    // status messages
    public static class StatusMessages {
        public static final String INVALID_REQUEST_MESSAGE = "Invalid Request, URI doesn't match body";
        public static final String ZONE_NOT_FOUND_MESSAGE = "Zone is not found for this id :: ";
        public static final String ZONE_IS_FOUND_WITH_THE_SAME_NAME_MESSAGE = "Zone is already found with the same name :: ";
        public static final String CITIES_MUST_BE_UNIQUE_MESSAGE = "Cities Must be unique in the zone";
        public static final String CITY_IS_ALREADY_SERVED_IN_ANOTHER_ZONE_MESSAGE = "City is already served oin another zone with the name :: ";
        public static final String ZONES_NOT_FOUND_MESSAGE = "There is no zones in the system ";
        public static final String ZONE_DELETED_SUCCESSFULLY_MESSAGE = "Zone successfully deleted!";

    }


}
