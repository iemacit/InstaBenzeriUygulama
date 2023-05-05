package com.example.socialmedyauygylamas;

public class GonderiDetay {
    private int logo;
    private String paylasan;

    public GonderiDetay(int logo,String paylasan) {
        this.logo = logo;
        this.paylasan=paylasan;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getPaylasan() {
        return paylasan;
    }

    public void setPaylasan(String paylasan) {
        this.paylasan = paylasan;
    }
}
