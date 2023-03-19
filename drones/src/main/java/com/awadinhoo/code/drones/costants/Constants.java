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
        public static final String MEDICATION_ALREADY_EXIST_BY_NAME_MESSAGE = "Another Medication already exist by this name ::";
        public static final String MEDICATION_ALREADY_EXIST_BY_CODE_MESSAGE = "Another Medication already exist by this code ::";
        public static final String MEDICATION_NOT_FOUND_MESSAGE = "Medication is not found for this id :: ";
        public static final String MEDICATION_DELETED_SUCCESSFULLY_MESSAGE = "Medication successfully deleted!";
        public static final String MEDICATIONS_NOT_FOUND_MESSAGE = "There is no medications in the system ";
        public static final String FLEET_IS_FOUND_WITH_THE_SAME_NAME_MESSAGE = "Fleet is already found with the same name :: ";
        public static final String FLEET_MUST_CONTAIN_AT_LEAST_ONE_DRONE_MESSAGE = "Fleet must contain at least one drone ";
        public static final String NUMBER_OF_DRONES_EXCEEDS_FLEET_LIMIT_MESSAGE = "Number of drones exceeds the fleet limit ";
        public static final String FLEET_NOT_FOUND_MESSAGE = "Fleet is not found for this id :: ";
        public static final String FLEETS_NOT_FOUND_MESSAGE = "There is no fleets in the system ";
        public static final String FLEET_DELETED_SUCCESSFULLY_MESSAGE = "Fleet successfully deleted!";
        public static final String DRONE_IS_NOT_ON_INITIAL_STATE_MESSAGE = "Drone is not on its initial state ";
        public static final String FLEET_MUST_BE_IN_ACTIVE_STATE_MESSAGE = "Fleet must be in active state :: ";
        public static final String DRONE_IS_FOUND_WITH_THE_SAME_SERIAL_NUMBER_MESSAGE = "Drone is already found with the same serial number :: ";



    }


}
