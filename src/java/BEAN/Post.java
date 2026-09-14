package BEAN;
public class Post {
    private int id;
    private String tieude, batdau, ketthuc, diadiem, noidung, imgURL;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTieude() {
        return tieude;
    }
    public void setTieude(String tieude) {
        this.tieude = tieude;
    }
    public String getBatdau() {
        return batdau;
    }
    public void setBatdau(String batdau) {
        this.batdau = batdau;
    }
    public String getKetthuc() {
        return ketthuc;
    }
    public void setKetthuc(String ketthuc) {
        this.ketthuc = ketthuc;
    }
    public String getDiadiem() {
        return diadiem;
    }
    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }
    public String getNoidung() {
        return noidung;
    }
    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
    public String getImgURL() {
        return imgURL;
    }
    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
