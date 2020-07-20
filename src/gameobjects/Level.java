package gameobjects;

public class Level extends Thing {

    private int n, s, w, e;

    public Level(String aName, String aDescription, int aN, int aS, int aW, int aE) {
        super(aName, aDescription); //CB- init superclass

        this.n = aN;
        this.s = aS;
        this.w = aW;
        this.e = aE;

    }

    //CB- accessor methods
    //n
    public int getN() {
        return n;
    }
    public void setN(int aN){
        this.n = aN;
    }

    //s
    public int getS() {
        return s;
    }
    public void setS(int aS){
        this.s = aS;
    }

    //e
    public int getE() {
        return e;
    }
    public void setE(int aE){
        this.e = aE;
    }

    //w
    public int getW() {
        return w;
    }
    public void setW(int aW){
        this.n = aW;
    }


    }
