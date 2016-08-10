package cn.youye.back.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by pc on 2016/7/25.
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
