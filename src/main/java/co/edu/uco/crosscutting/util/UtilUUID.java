package co.edu.uco.crosscutting.util;

import co.edu.uco.crosscutting.exception.CrossCuttingException;
import co.edu.uco.crosscutting.exception.GeneralException;

import java.util.UUID;

import static co.edu.uco.crosscutting.util.UtilObject.getDefaultIsNull;
import static co.edu.uco.crosscutting.util.UtilObject.isNull;
import static co.edu.uco.crosscutting.util.UtilText.*;

public final class UtilUUID {
    public static final String DEFAULT_UUID_STRING = "00000000-0000-0000-0000-000000000000";
    private static final UUID DEFAULT_UUID = getStringToUUID(DEFAULT_UUID_STRING);
    private UtilUUID() {}
    public static UUID getDefaultUUID(final UUID uuid) {
        return getDefaultIsNull(uuid, DEFAULT_UUID);
    }
    public static boolean isEqual(final UUID uuidOne, final UUID uuidTwo) {
        return getDefaultUUID(uuidOne).equals(getDefaultUUID(uuidTwo));
    }
    public static UUID getNewUUID() {
        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        } while (isEqual(uuid, DEFAULT_UUID));
        return uuid;
    }
    public static UUID getUUIDFromString(final String uuidString) {
        UUID uuid = DEFAULT_UUID;
        if(!isEmpty(trim(uuidString))) {
            try {
                uuid = UUID.fromString(uuidString);
            } catch (IllegalArgumentException exception) {
                throw CrossCuttingException.build("The UUID to be converted has no valid format.",exception);
            } catch (Exception exception){
                throw GeneralException.build("An unexpected error trying converted", exception);
            }
        }
        return uuid;
    }
    public static String getStringFromUUID(final UUID uuid) {
        String uuidString = DEFAULT_UUID_STRING;
        if(!isNull(uuid)) {
            uuidString = uuid.toString();
        }
        return uuidString;
    }
    public static UUID getStringToUUID(final String uuid){
        return UUID.fromString(uuid);
    }
}