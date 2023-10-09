public class Lego implements Comparable<Lego>{

    private String code;
    private String name;
    private String theme;
    private int pieces;

    public Lego(String code, String name, String theme, int pieces) {
        this.code = code;
        this.name = name;
        this.theme = theme;
        this.pieces = pieces;
    }

    @Override
    public int compareTo(Lego o) {
        if(this.pieces != o.pieces) {
            return -Integer.compare(this.pieces, o.pieces);
        }
        if (!this.theme.equals(o.theme)) {
            return this.theme.compareTo(o.theme);
        }
        if(!this.name.equals(o.name)) {
            return this.name.compareTo(o.name);
        }
        return this.code.compareTo(o.code);
    }

    @Override
    public String toString() {
        return String.format("%s (%s): %d - %s",
                name, code, pieces, theme);
    }
}
