package com.ceshiren.entity;

/**
 * @author wyl
 * @create 2022-02-13 14:59
 */
public class AData {
    private int a;
    private int b;
    private int result;
    private String message;

    public AData() {
    }

    public AData(int a, int b, int result, String message) {
        this.a = a;
        this.b = b;
        this.result = result;
        this.message = message;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AData{" +
                "a=" + a +
                ", b=" + b +
                ", result=" + result +
                ", message='" + message + '\'' +
                '}';
    }
}


