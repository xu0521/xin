package com.xuxin.xl050224.dto.in;

public class AdministratorResetPedInDTO {

    private String email;

    private String resetCode;

    private String newPed;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResetCode() {
        return resetCode;
    }

    public void setResetCode(String resetCode) {
        this.resetCode = resetCode;
    }

    public String getNewPed() {
        return newPed;
    }

    public void setNewPed(String newPed) {
        this.newPed = newPed;
    }
}
