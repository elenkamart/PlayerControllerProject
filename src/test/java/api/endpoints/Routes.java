package api.endpoints;

public class Routes {
    public static String base_url = "http://3.68.165.45/swagger-ui.html#/player-controller";

    // user module
    public static String post_url = base_url + "getPlayerByPlayerIdUsingPOST";
    public static String get_url = base_url + "createPlayerUsingGET";
    public static String get_all_url = base_url + "getAllPlayersUsingGET";
    public static String patch_url = base_url + "updatePlayerUsingPATCH";
    public static String delete_url = base_url + "deletePlayerUsingDELETE";
}
