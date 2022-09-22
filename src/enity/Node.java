package enity;


import javafx.scene.text.Text;

public class Node {
    private  Text Index ;
    private  Text lex ;
    private  Text statue ;

    public Text getIndex() {
        return Index;
    }

    public void setIndex(Text index) {
        Index = index;
    }

    public Text getLex() {
        return lex;
    }

    public void setLex(Text lex) {
        this.lex = lex;
    }

    public Text getStatue() {
        return statue;
    }

    public void setStatue(Text statue) {
        this.statue = statue;
    }
}