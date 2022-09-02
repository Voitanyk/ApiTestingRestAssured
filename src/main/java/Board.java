public class Board {String id;
    public String name;
    public String key;
    public String token;
    public boolean defaultLabels;
    public boolean defaultLists;
    public String desc;
    public String idOrganization;
    public String idBoardSource;
    public String keepFromSource;
    public String powerUps;
    public String prefs_permissionLevel;
    public String prefs_voting;
    public String prefs_comments;
    public String prefs_invitations;
    public boolean prefs_selfJoin;
    public boolean prefs_cardCovers;
    public String prefs_background;
    public String prefs_cardAging;



    public Board(String id, String name, String key, String token) {
        this.id = id;
        this.name = name;
        this.key = key;
        this.token = token;
    }
    public Board(String name, String key, String token) {
        this.name = name;
        this.key = key;
        this.token = token;
    }


    public Board(String key, String token) {
        this.key = key;
        this.token = token;
    }

    public Board(String id, String name, String key, String token, boolean defaultLabels, boolean defaultLists, String desc, String idOrganization, String idBoardSource, String keepFromSource, String powerUps, String prefs_permissionLevel, String prefs_voting, String prefs_comments, String prefs_invitations, boolean prefs_selfJoin, boolean prefs_cardCovers, String prefs_background, String prefs_cardAging) {
        this.id = id;
        this.name = name;
        this.key = key;
        this.token = token;
        this.defaultLabels = defaultLabels;
        this.defaultLists = defaultLists;
        this.desc = desc;
        this.idOrganization = idOrganization;
        this.idBoardSource = idBoardSource;
        this.keepFromSource = keepFromSource;
        this.powerUps = powerUps;
        this.prefs_permissionLevel = prefs_permissionLevel;
        this.prefs_voting = prefs_voting;
        this.prefs_comments = prefs_comments;
        this.prefs_invitations = prefs_invitations;
        this.prefs_selfJoin = prefs_selfJoin;
        this.prefs_cardCovers = prefs_cardCovers;
        this.prefs_background = prefs_background;
        this.prefs_cardAging = prefs_cardAging;
    }


    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\''+
                "name='" + name + '\'' +
                ", defaultLabels=" + defaultLabels +
                ", defaultLists=" + defaultLists +
                ", idBoardSource='" + idBoardSource + '\'' +
                ", keepFromSource='" + keepFromSource + '\'' +
                ", powerUps='" + powerUps + '\'' +
                ", prefs_permissionLevel='" + prefs_permissionLevel + '\'' +
                ", prefs_voting='" + prefs_voting + '\'' +
                ", prefs_comments='" + prefs_comments + '\'' +
                ", prefs_invitations='" + prefs_invitations + '\'' +
                ", prefs_selfJoin=" + prefs_selfJoin +
                ", prefs_cardCovers=" + prefs_cardCovers +
                ", prefs_background='" + prefs_background + '\'' +
                ", prefs_cardAging='" + prefs_cardAging + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (defaultLabels != board.defaultLabels) return false;
        if (defaultLists != board.defaultLists) return false;
        if (prefs_selfJoin != board.prefs_selfJoin) return false;
        if (prefs_cardCovers != board.prefs_cardCovers) return false;
        if (!name.equals(board.name)) return false;
        if (idBoardSource != null ? !idBoardSource.equals(board.idBoardSource) : board.idBoardSource != null)
            return false;
        if (keepFromSource != null ? !keepFromSource.equals(board.keepFromSource) : board.keepFromSource != null)
            return false;
        if (powerUps != null ? !powerUps.equals(board.powerUps) : board.powerUps != null) return false;
        if (prefs_permissionLevel != null ? !prefs_permissionLevel.equals(board.prefs_permissionLevel) : board.prefs_permissionLevel != null)
            return false;
        if (prefs_voting != null ? !prefs_voting.equals(board.prefs_voting) : board.prefs_voting != null) return false;
        if (prefs_comments != null ? !prefs_comments.equals(board.prefs_comments) : board.prefs_comments != null)
            return false;
        if (prefs_invitations != null ? !prefs_invitations.equals(board.prefs_invitations) : board.prefs_invitations != null)
            return false;
        if (prefs_background != null ? !prefs_background.equals(board.prefs_background) : board.prefs_background != null)
            return false;
        return prefs_cardAging != null ? prefs_cardAging.equals(board.prefs_cardAging) : board.prefs_cardAging == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (defaultLabels ? 1 : 0);
        result = 31 * result + (defaultLists ? 1 : 0);
        result = 31 * result + (idBoardSource != null ? idBoardSource.hashCode() : 0);
        result = 31 * result + (keepFromSource != null ? keepFromSource.hashCode() : 0);
        result = 31 * result + (powerUps != null ? powerUps.hashCode() : 0);
        result = 31 * result + (prefs_permissionLevel != null ? prefs_permissionLevel.hashCode() : 0);
        result = 31 * result + (prefs_voting != null ? prefs_voting.hashCode() : 0);
        result = 31 * result + (prefs_comments != null ? prefs_comments.hashCode() : 0);
        result = 31 * result + (prefs_invitations != null ? prefs_invitations.hashCode() : 0);
        result = 31 * result + (prefs_selfJoin ? 1 : 0);
        result = 31 * result + (prefs_cardCovers ? 1 : 0);
        result = 31 * result + (prefs_background != null ? prefs_background.hashCode() : 0);
        result = 31 * result + (prefs_cardAging != null ? prefs_cardAging.hashCode() : 0);
        return result;
    }

    public Board() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public String getToken() {
        return token;
    }
}
