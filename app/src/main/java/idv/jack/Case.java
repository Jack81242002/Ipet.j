package idv.jack;


import android.widget.TextView;

import java.io.Serializable;
import java.sql.Date;

public class Case implements Serializable {

    private Integer petNo; // 動物編號 PK
    private Integer memNo; // 送養人 FK
    private Integer breedNo; // 品種編號 FK
    private String status; // 狀態
    private String petName; // 動物暱稱
    private String petAge; // 動物年紀
    private String petSize; // 動物體型
    private String petColor; // 動物顏色
    private String petPosition; // 送養地點
    private String petIc; // 有無IC
    private String TNR; // 有無節育
    private String situation; // 動物狀況
    private Date petDate; // 發文日
    private Integer memNo2; // 領養人
    //private byte[] petFilm; // 動物影片
    private String petTitle; // 送養標題
    private Double petLongitude; // 經度
    private Double petLatitude; // 緯度
    private String petSex; // 動物性別

    public Case() {
        super();

    }

    public String getPetSex(TextView petSex) {
        return this.petSex;
    }

    public void setPetSex(String petSex) {
        this.petSex = petSex;
    }

    public Integer getPetNo() {
        return petNo;
    }

    public void setPetNo(Integer petNo) {
        this.petNo = petNo;
    }

    public Integer getMemNo() {
        return memNo;
    }

    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }

    public Integer getBreedNo() {
        return breedNo;
    }

    public void setBreedNo(Integer breedNo) {
        this.breedNo = breedNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetAge() {
        return petAge;
    }

    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }

    public String getPetSize() {
        return petSize;
    }

    public void setPetSize(String petSize) {
        this.petSize = petSize;
    }

    public String getPetColor() {
        return petColor;
    }

    public void setPetColor(String petColor) {
        this.petColor = petColor;
    }

    public String getPetPosition() {
        return petPosition;
    }

    public void setPetPosition(String petPosition) {
        this.petPosition = petPosition;
    }

    public String getPetIc() {
        return petIc;
    }

    public void setPetIc(String petIc) {
        this.petIc = petIc;
    }

    public String getTNR() {
        return TNR;
    }

    public void setTNR(String tNR) {
        TNR = tNR;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public Date getPetDate() {
        return petDate;
    }

    public void setPetDate(Date petDate) {
        this.petDate = petDate;
    }

    public Integer getMemNo2() {
        return memNo2;
    }

    public void setMemNo2(Integer memNo2) {
        this.memNo2 = memNo2;
    }

//    public byte[] getPetFilm() {
//        return petFilm;
//    }
//
//    public void setPetFilm(byte[] petFilm) {
//        this.petFilm = petFilm;
//    }

    public String getPetTitle() {
        return petTitle;
    }

    public void setPetTitle(String petTitle) {
        this.petTitle = petTitle;
    }

    public Double getPetLongitude() {
        return petLongitude;
    }

    public void setPetLongitude(Double petLongitude) {
        this.petLongitude = petLongitude;
    }

    public Double getPetLatitude() {
        return petLatitude;
    }

    public void setPetLatitude(Double petLatitude) {
        this.petLatitude = petLatitude;
    }



}
