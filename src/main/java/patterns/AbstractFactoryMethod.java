package patterns;

public class AbstractFactoryMethod {

}

class Pattern {

    private Pattern() {
    }

    public Pattern create(){
        return new Pattern();
    }
}
