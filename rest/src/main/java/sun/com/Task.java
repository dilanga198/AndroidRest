package sun.com;

/**
 * Created with IntelliJ IDEA.
 * User: nimantha
 * Date: 10/9/13
 * Time: 11:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class Task {

    private String id;
    private String tName;
    private String tType;
    private String srartedAt;
    private String expire;
    private String status;
    private String descrioion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettType() {
        return tType;
    }

    public void settType(String tType) {
        this.tType = tType;
    }

    public String getSrartedAt() {
        return srartedAt;
    }

    public void setSrartedAt(String srartedAt) {
        this.srartedAt = srartedAt;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescrioion() {
        return descrioion;
    }

    public void setDescrioion(String descrioion) {
        this.descrioion = descrioion;
    }
}
