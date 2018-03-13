package cn.yingchuang.jboa.sys_positions.entity;

/**
 * Created by Administrator on 2018\3\13 0013.
 */
public class SysPositions {
    private Integer id;
    private String nameCn;
    private String nameEn;

    @Override
    public String toString() {
        return "SysPositions{" +
                "id=" + id +
                ", nameCn='" + nameCn + '\'' +
                ", nameEn='" + nameEn + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
}
