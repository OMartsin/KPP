package ChristmasDecorType;

public class DecorationType{

    private final int ID;
    private String typeName;
    private String typeDescription;

    public DecorationType(int ID,String typeName, String typeDescription) {
        this.ID = ID;
        this.typeName = typeName;
        this.typeDescription = typeDescription;
    }

    public int getID() {
        return ID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

}
