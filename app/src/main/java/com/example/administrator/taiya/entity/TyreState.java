package com.example.administrator.taiya.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/21.
 */
public class TyreState implements Serializable
{
    boolean isHighPressure;
    boolean isHighTemp;
    boolean isLeak;
    boolean isLowPressure;
    boolean isLowVoltage;
    boolean isNoSignal;
    String pressure;
    String pressureUnit;
    String temp;
    String tempUnit;

    public TyreState()
    {
    }

    public TyreState(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString3, String paramString4)
    {
        this.pressure = paramString1;
        this.temp = paramString2;
        this.isNoSignal = paramBoolean1;
        this.isLowVoltage = paramBoolean2;
        this.isHighTemp = paramBoolean3;
        this.isHighPressure = paramBoolean4;
        this.isLowPressure = paramBoolean5;
        this.isLeak = paramBoolean6;
        this.tempUnit = paramString3;
        this.pressureUnit = paramString4;
    }

    public String getPressure()
    {
        return this.pressure;
    }

    public String getPressureUnit()
    {
        return this.pressureUnit;
    }

    public String getTemp()
    {
        return this.temp;
    }

    public String getTempUnit()
    {
        return this.tempUnit;
    }

    public boolean isHighPressure()
    {
        return this.isHighPressure;
    }

    public boolean isHighTemp()
    {
        return this.isHighTemp;
    }

    public boolean isLeak()
    {
        return this.isLeak;
    }

    public boolean isLowPressure()
    {
        return this.isLowPressure;
    }

    public boolean isLowVoltage()
    {
        return this.isLowVoltage;
    }

    public boolean isNoSignal()
    {
        return this.isNoSignal;
    }

    public void setHighPressure(boolean paramBoolean)
    {
        this.isHighPressure = paramBoolean;
    }

    public void setHighTemp(boolean paramBoolean)
    {
        this.isHighTemp = paramBoolean;
    }

    public void setLeak(boolean paramBoolean)
    {
        this.isLeak = paramBoolean;
    }

    public void setLowPressure(boolean paramBoolean)
    {
        this.isLowPressure = paramBoolean;
    }

    public void setLowVoltage(boolean paramBoolean)
    {
        this.isLowVoltage = paramBoolean;
    }

    public void setNoSignal(boolean paramBoolean)
    {
        this.isNoSignal = paramBoolean;
    }

    public void setPressure(String paramString)
    {
        this.pressure = paramString;
    }

    public void setPressureUnit(String paramString)
    {
        this.pressureUnit = paramString;
    }

    public void setTemp(String paramString)
    {
        this.temp = paramString;
    }

    public void setTempUnit(String paramString)
    {
        this.tempUnit = paramString;
    }

    public String toString()
    {
        return "TyreState{pressure=" + this.pressure + ", temp=" + this.temp + ", isNoSignal=" + this.isNoSignal + ", isLowVoltage=" + this.isLowVoltage + ", isHighTemp=" + this.isHighTemp + ", isHighPressure=" + this.isHighPressure + ", isLowPressure=" + this.isLowPressure + ", isLeak=" + this.isLeak + ", tempUnit='" + this.tempUnit + '\'' + ", pressureUnit='" + this.pressureUnit + '\'' + '}';
    }
}