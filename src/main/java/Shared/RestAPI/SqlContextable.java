package Shared.RestAPI;

import java.sql.SQLException;

public interface SqlContextable {

    /***
     * registers a new account to the database
     * @param username username of the account
     * @param password hashed password to put in database
     * @throws SQLException when the username is already taken
     */
    void register(String username, String password) throws  SQLException;

    /***
     * gets the id of the used username and password, if they match
     * @param username username of the account
     * @param password hashed password of the account
     * @return id
     * @throws SQLException when the combination is incorrect
     */
    int loginPlayer(String username, String password) throws SQLException;

    /***
     * gets the current balance of the player
     * @param id the id of the player
     * @return the total current balance of the selected player
     * @throws SQLException when the given id is not in the database
     */
}
