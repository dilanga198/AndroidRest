package sun.com;

/**
 * Created with IntelliJ IDEA.
 * User: nimantha
 * Date: 10/9/13
 * Time: 11:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class Permission {

    private String pName;
    private String description;

    public Permission (String name,String des){
        pName =name ;
        description =des ;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
